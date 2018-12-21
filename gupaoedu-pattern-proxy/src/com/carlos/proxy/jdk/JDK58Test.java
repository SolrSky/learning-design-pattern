package com.carlos.proxy.jdk;

import com.carlos.proxy.staticed.Person;

import javax.sound.midi.Soundbank;

/**
 * @author Solrsky
 * @date 2018/12/18
 */
public class JDK58Test {

    public static void main(String[] args) {
        XiaoMing xiaoMing = new XiaoMing();
        try {
            Person person = (Person) new JDK58().getInstance(xiaoMing);
            System.out.println(person.getClass());
            person.findJob();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
