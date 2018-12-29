package com.carlos.proxy.custom;

import com.carlos.proxy.jdk.XiaoMing;
import com.carlos.proxy.staticed.Person;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Solrsky
 * @date 2018/12/29
 */
public class CustomMeiPo implements MyInvocationHandler{

    // 被代理的对象
    private Person target;

    public Object getInstance(XiaoMing target) throws Exception {
        this.target = target;
        Class<?> clazz = target.getClass();

        // 用来生成被代理的类（底层通过字节码重组来实现）
        return MyProxy.newProxyInstance(new MyClassLoader(), clazz.getInterfaces(), this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("媒婆：拿到需求，开始物色人选~~~");
        Object result = method.invoke(this.target, args);
        System.out.println("找到了，你看看合不合适，合适就去把事儿办了吧~~");
        return result;
    }
}
