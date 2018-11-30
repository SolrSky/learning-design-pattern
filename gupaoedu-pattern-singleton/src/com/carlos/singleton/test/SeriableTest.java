package com.carlos.singleton.test;

import com.carlos.singleton.seriable.Seriable;

import java.io.*;

/**
 * @author Solrsky
 * @date 2018/11/29
 */
public class SeriableTest {
    public static void main(String[] args) {
        Seriable s1 = null;
        Seriable s2 = Seriable.getInstance();

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("seriable.obj");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(s2);
            objectOutputStream.flush();
            objectOutputStream.close();

            FileInputStream fileInputStream = new FileInputStream("seriable.obj");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            s1 = (Seriable) objectInputStream.readObject();
            objectInputStream.close();

            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s1 == s2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
