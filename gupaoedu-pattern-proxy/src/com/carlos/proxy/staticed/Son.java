package com.carlos.proxy.staticed;

/**
 * @author Solrsky
 * @date 2018/12/18
 */
public class Son implements Person{

    public Son() {
    }

    @Override
    public void findJob(){
        System.out.println("毕业了，开始找工作~~~");
    }

    @Override
    public void findLove() {

    }
}
