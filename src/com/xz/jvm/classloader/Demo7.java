package com.xz.jvm.classloader;

/**
 * @Package: com.xz.jvm.classloader
 * @ClassName: Demo7
 * @Author: xz
 * @Date: 2020/2/20 21:54
 * @Version: 1.0
 */
public class Demo7 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("java.lang.String");
        System.out.println(aClass.getClassLoader());//根类加载器
        Class<C> cClass = C.class;
        System.out.println(cClass.getClassLoader());//系统类加载器
    }
}
class C{

}
