package com.carlos.proxy.jdk;

import com.carlos.proxy.staticed.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Solrsky
 * @date 2018/12/18
 */
public class JDK58 implements InvocationHandler {
    // 被代理的对象
    private Person target;

    public Object getInstance(XiaoMing target) throws Exception {
        this.target = target;
        Class<?> clazz = target.getClass();

        // 用来生成被代理的类（底层通过字节码重组来实现）
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("58：拿到简历");
        Object result = method.invoke(this.target, args);
        System.out.println("找到了，你看看合不合适，合适入职");
        return result;
    }
}
