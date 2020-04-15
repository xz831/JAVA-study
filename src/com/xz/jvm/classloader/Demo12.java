package com.xz.jvm.classloader;

/**
 * @Package: com.xz.jvm.classloader
 * @ClassName: Demo12
 * @Author: xz
 * @Date: 2020/2/21 15:23
 * @Version: 1.0
 */
public class Demo12 {

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        Class<?> aClass = loader.loadClass("com.xz.jvm.classloader.CL");
        System.out.println(aClass);
        System.out.println("-");
        Class<?> aClass1 = Class.forName("com.xz.jvm.classloader.CL");
        System.out.println("-");
        System.out.println(aClass1);
    }
}

class CL{
    static {
        System.out.println("Class CL");
    }
}
