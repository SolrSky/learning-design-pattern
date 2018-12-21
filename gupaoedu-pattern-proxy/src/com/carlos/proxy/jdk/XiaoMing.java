package com.carlos.proxy.jdk;

import com.carlos.proxy.staticed.Person;

/**
 * @author Solrsky
 * @date 2018/12/18
 */
public class XiaoMing implements Person {


    @Override
    public void findLove(){
        System.out.println("找对象要求");
        System.out.println("肤白貌美");
        System.out.println("温柔如水");
    }

    @Override
    public void findJob() {
        System.out.println("找工作要求");
        System.out.println("it行业");
        System.out.println("月薪20k~50k");
    }

}
