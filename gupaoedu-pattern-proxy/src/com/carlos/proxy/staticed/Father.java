package com.carlos.proxy.staticed;

/**
 * @author Solrsky
 * @date 2018/12/18
 */
public class Father {

    private Person person;

    // 难以扩展
    public Father(Person person) {
        this.person = person;
    }

    public void findJob(){
        System.out.println("开始帮儿子找工作~~");
        person.findJob();
        System.out.println("找到了，入职吧~~");
    }
}
