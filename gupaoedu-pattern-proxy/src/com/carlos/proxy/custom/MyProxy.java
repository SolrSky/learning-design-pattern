package com.carlos.proxy.custom;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Solrsky
 * @date 2018/12/28
 */
public class MyProxy {

    private static final String ln = "\r\n";

    public static Object newProxyInstance(MyClassLoader loader, Class<?>[] interfaces, MyInvocationHandler myInvocationHandler) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 1、动态生成.java文件
        String src = generateSrc(interfaces);

        // 2、将.java文件输出到磁盘
        String path = MyProxy.class.getResource("").getPath();
        System.out.println(path);
        File file = new File(path + "$Proxy0.java");
        FileWriter fw = new FileWriter(file);
        fw.write(src);
        fw.flush();
        fw.close();

        // 3、将生成的.java文件编译为.class文件
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
        Iterable iterable  = manager.getJavaFileObjects(file);
        JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
        task.call();
        manager.close();
        //4、编译生成的.class文件加载到JVM中来
        Class proxyClass =  loader.findClass("$Proxy0");
        Constructor c = proxyClass.getConstructor(MyInvocationHandler.class);
        file.delete();

        //5、返回字节码重组以后的新的代理对象
        return c.newInstance(myInvocationHandler);
    }

    private static String generateSrc(Class<?>[] interfaces){
        StringBuffer sb = new StringBuffer();
        sb.append("package com.carlos.proxy.custom;" + ln);
        sb.append("import com.carlos.proxy.staticed.Person;" + ln);
        sb.append("import java.lang.reflect.Method;" + ln);
        sb.append("public class $Proxy0 implements " + interfaces[0].getName() + "{" + ln);
            sb.append("MyInvocationHandler h;" + ln);
            sb.append("public $Proxy0(MyInvocationHandler h){" + ln);
                sb.append("this.h = h;" + ln);
            sb.append("}" + ln);
            for (Method method : interfaces[0].getMethods()) {
                sb.append("@Override" + ln);
                sb.append("public " + method.getReturnType().getName() + " " + method.getName() + "() {" + ln);
                    sb.append("try{" + ln);
                        sb.append("Method m = " + interfaces[0].getName() + ".class.getMethod(\"" + method.getName() + "\", new Class[]{});" + ln);
                        sb.append("this.h.invoke(this, m, null);" + ln);
                    sb.append("}catch(Throwable e){" + ln);
                    sb.append("e.printStackTrace();" + ln);
                    sb.append("}" + ln);
                sb.append("}" + ln);
            }
        sb.append("}" + ln);
        return sb.toString();
    }

}
