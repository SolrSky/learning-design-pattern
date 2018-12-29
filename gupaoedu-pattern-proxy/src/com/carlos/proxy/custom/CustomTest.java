package com.carlos.proxy.custom;

import com.carlos.proxy.jdk.JDKMeiPo;
import com.carlos.proxy.jdk.XiaoMing;
import com.carlos.proxy.staticed.Person;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

/**
 * @author Solrsky
 * @date 2018/12/29
 */
public class CustomTest {

    public static void main(String[] args) {
        XiaoMing xiaoMing = new XiaoMing();
        try {
            Person obj = (Person) new CustomMeiPo().getInstance(xiaoMing);
            obj.findLove();

            System.out.println(obj.getClass());
            //字节码重组原理：
            //1.拿到被代理对象的引用，并且获取他的所有接口（反射获取）
            //2.JDK Proxy类重新生成一个新的类，同时新的类要实现被代理类所有实现的接口
            //3.动态生成Java代码，把新加的业务逻辑方法由一定的逻辑代码去调用（在代码中体现）
            //4.编译新生成的Java代码.class
            //5.再重新加载到JVM中运行

            byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Person.class});
            FileOutputStream os = new FileOutputStream("D://proxy0.class");
            os.write(bytes);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
