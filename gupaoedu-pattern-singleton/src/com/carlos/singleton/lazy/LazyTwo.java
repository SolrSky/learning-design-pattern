package com.carlos.singleton.lazy;

/**
 * @author Solrsky
 * @date 2018/11/28
 */
public class LazyTwo {

    private LazyTwo() {
    }

    // 静态块，公共内存区域
    private static LazyTwo lazyTwo = null;

    // 加锁
    public synchronized static LazyTwo GetInstance(){

        // 线程不安全，可能两个线程都会进入到这个if里
        if (null == lazyTwo){
            lazyTwo = new LazyTwo();
        }

        return lazyTwo;
    }
}
