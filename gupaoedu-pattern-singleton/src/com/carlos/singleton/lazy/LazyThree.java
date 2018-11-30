package com.carlos.singleton.lazy;

/**
 * @author Solrsky
 * @date 2018/11/28
 */
// 懒汉式单例
    // 特点：在外部类被调用的时候内部类才会被加载

public class LazyThree {

    // 使用LazyThree的时候，会先初始化内部类
    // 没有使用的情况下，内部类不会加载

    private static boolean initialized = false;

    private LazyThree() {

        // 防止反射入侵
        synchronized (LazyThree.class){
            // 只有第一次初始化的时候才能成功。第二次开始就
            if (initialized == false){
                initialized = !initialized;
            }else{
                throw new RuntimeException("单例被侵犯！");
            }
        }
    }

    // 每个关键字都是必要的
    // static 共享单例实例
    // final 保证不会被重写、重载
    public static final LazyThree getInstance(){
        // 在返回结果前，会先加载LazyHolder，同时也已经创建了LazyThree实例。
        return LazyHolder.lazyThree;
    }

    // 内部静态类，在外部类被调用时，才会加载，同时会将LazyThree实例化为静态值。
    private static class LazyHolder{
        private static final LazyThree lazyThree = new LazyThree();
    }
}
