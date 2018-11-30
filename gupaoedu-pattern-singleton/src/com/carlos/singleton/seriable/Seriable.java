package com.carlos.singleton.seriable;

import java.io.Serializable;

/**
 * @author Solrsky
 * @date 2018/11/29
 */
// 反序列化时可能导致破坏单例
public class Seriable implements Serializable {
    // 序列化

    // 反序列化

    public final static Seriable INSTANCE = new Seriable();
    private Seriable(){}

    public static Seriable getInstance(){
        return INSTANCE;
    }

    private Object readResolve(){
        return INSTANCE;
    }
}
