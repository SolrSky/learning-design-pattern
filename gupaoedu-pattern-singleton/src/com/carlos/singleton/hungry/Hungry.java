package com.carlos.singleton.hungry;

/**
 * 饿汉式单例模式
 *
 * 优点：线程安全，在线程产生前就已经创建
 *      每次调用不用重新创建，执行效率高
 * 缺点：占用资源
 *
 * Created by dingjunjie on 2018/11/27.
 * @author dingjunjie
 */
public class Hungry {

    /**
     私有化的构造方法
     */
    private Hungry(){
    }

    // 类加载的时候就进行实例化
    private static Hungry hungry = new Hungry();

    /**
     * 供使用者调用，直接返回早就创建好的实例
     */
    public static Hungry getInstance(){
        return hungry;
    }

}
