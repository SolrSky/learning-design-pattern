package com.carlos.proxy.custom;

import java.io.File;

/**
 * @author Solrsky
 * @date 2018/12/28
 */
public class MyClassLoader extends ClassLoader{

    private File classPathFile;

    public MyClassLoader(File classPathFile) {
        String classPath = MyClassLoader.class.getResource("").getPath();
        this.classPathFile = new File(classPath);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className = MyClassLoader.class.getPackage().getName() + "." + name;
        if(classPathFile != null){
            new File(classPathFile, name.replaceAll("\\.", ))
        }
        return null;
    }
}
