package com.carlos.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Solrsky
 * @date 2018/12/18
 */
public class CGLibMeiPo implements MethodInterceptor {

    public Object getInstance(Class<?> clazz) throws Exception {
        Enhancer enhancer = new Enhancer();
        // 要把哪个类设置为新类的父类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);

        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("媒婆：拿到需求，开始物色人选~~~");
        methodProxy.invokeSuper(o, objects);
        System.out.println("找到了，你看看合不合适，合适就去把事儿办了吧~~");
        return o;
    }
}
