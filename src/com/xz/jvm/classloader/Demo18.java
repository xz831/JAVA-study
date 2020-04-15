package com.xz.jvm.classloader;

/**
 * @Package: com.xz.jvm.classloader
 * @ClassName: Demo18
 * @Author: xz
 * @Date: 2020/2/24 21:02
 * @Version: 1.0
 */
public class Demo18 {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println(Thread.class.getClassLoader());
    }
}
