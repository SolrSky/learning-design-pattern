package com.carlos.singleton.test;

import com.carlos.singleton.lazy.LazyOne;

import java.util.concurrent.CountDownLatch;

/**
 * @author Solrsky
 * @date 2018/11/28
 */
public class ThreadSafeTest {

    public static void main(String[] args) {
        int count = 2000;
        CountDownLatch latch = new CountDownLatch(count);
        for (int i = 0; i < count; i++){
            new Thread(){
                @Override
                public void run() {
                    try{
                        latch.await();
                        LazyOne lazyOne = LazyOne.GetInstance();
                        System.out.println(lazyOne.toString());
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }.start();
            latch.countDown();

        }
    }
}
