package com.carlos.proxy.staticed;

/**
 * @author Solrsky
 * @date 2018/12/18
 */
public class Test {
    public static void main(String[] args) {
        Son son = new Son();
        Father father = new Father(son);
        father.findJob();
    }
}
