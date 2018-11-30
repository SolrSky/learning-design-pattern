package com.carlos.singleton.test;

import com.carlos.singleton.lazy.LazyThree;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @author Solrsky
 * @date 2018/11/28
 */
public class LazyThreeTest {
    public static void main(String[] args) {
        try{
            Class<?> clazz = LazyThree.class;
            // 通过反射拿到私有的构造方法
            Constructor c = clazz.getDeclaredConstructor(null);
            // 暴力访问
            c.setAccessible(true);
            // 创建实例
            Object obj1 = c.newInstance();
            System.out.println(obj1.toString());


            Field field = clazz.getDeclaredField("initialized");
            field.setAccessible(true);
            field.setBoolean(obj1,false);

            Object obj2 = c.newInstance();
            System.out.println(obj2.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
