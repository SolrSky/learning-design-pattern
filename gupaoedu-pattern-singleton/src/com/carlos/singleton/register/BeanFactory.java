package com.carlos.singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Solrsky
 * @date 2018/11/28
 */

// spring 中就是用这种注册式单例来实现的
public class BeanFactory {

    private BeanFactory() {
    }

    // 使用ConcurrentHashMap来保证线程安全
    private static Map<String,Object> ioc = new ConcurrentHashMap<>();

    public static Object getBean(String className){
        // 若map已有，则直接返回该实例对象
        if(ioc.containsKey(className)){
            return ioc.get(className);
        }else{
            try {
                // 若map中还没有，则利用反射，获取对象实例，并注册到map中，以便下次使用
                Object obj = Class.forName(className).newInstance();
                ioc.put(className, obj);
                return obj;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
