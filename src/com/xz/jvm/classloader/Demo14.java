package com.xz.jvm.classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * @Package: com.xz.jvm.classloader
 * @ClassName: Demo14
 * @Author: xz
 * @Date: 2020/2/21 17:13
 * @Version: 1.0
 */
public class Demo14 {
    public static void main(String[] args) throws IOException {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        String resourceName = "com/xz/jvm/classloader/Demo13.class";
        Enumeration<URL> urls = contextClassLoader.getResources(resourceName);
        while(urls.hasMoreElements()){
            System.out.println(urls.nextElement());
        }
        ClassLoader classLoader = Demo14.class.getClassLoader();
        System.out.println(classLoader);
        Demo14[] demo14s = new Demo14[1];
        System.out.println(demo14s.getClass().getClassLoader());
        String[] strings = new String[1];
        System.out.println(strings.getClass().getClassLoader());
        int[] ints = new int[1];
        System.out.println(ints.getClass().getClassLoader());
    }
}
