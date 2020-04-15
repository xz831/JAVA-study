package com.xz.jvm.classloader;

public class Demo21{
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.xz.jvm.classloader.A", false, Thread.currentThread().getContextClassLoader());
//        Class.forName("com.xz.jvm.classloader.A");
        System.out.println(A.a);
    }
}
class A{
    static int a;
    static {
        a = 10;
    }
}
