package com.carlos.singleton.lazy;


/**
 * 懒汉式单例
 * 在类加载的时候不会初始化
 * Created by solrSky on 2018/11/27.
 * @author solrSky
 */
public class LazyOne {

    private LazyOne(){
    }

    // 静态块，公共内存区域
    private static LazyOne lazyOne = null;

    public static LazyOne GetInstance(){

        // 线程不安全，可能两个线程都会进入到这个if里
        if (null == lazyOne){
            lazyOne = new LazyOne();
        }

        return lazyOne;
    }

}
