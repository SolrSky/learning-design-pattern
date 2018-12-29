package com.carlos.proxy.custom;

import java.lang.reflect.Method;

/**
 * @author Solrsky
 * @date 2018/12/28
 */
public interface MyInvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
