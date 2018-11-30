package com.carlos.singleton.test;

import com.carlos.singleton.hungry.Hungry;
import com.carlos.singleton.lazy.LazyOne;
import com.carlos.singleton.lazy.LazyTwo;

/**
 * Created by dingjunjie on 2018/11/27.
 *
 * @author dingjunjie
 */
public class Test {

    public static void main(String[] args) {
        Hungry hungry = Hungry.getInstance();
        System.out.println(hungry.toString());

        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++){
            LazyOne lazyOne = LazyOne.GetInstance();
        }
        System.out.println("lazyOne耗时：");
        System.out.println(System.currentTimeMillis()-start);

        long start2 = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++){
            LazyTwo lazyTwo = LazyTwo.GetInstance();
        }
        System.out.println("lazyTwo耗时：");
        System.out.println(System.currentTimeMillis()-start2);

    }
}
