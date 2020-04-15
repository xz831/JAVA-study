package com.xz.jvm.classloader;

/**
 * @Package: com.xz.jvm.classloader
 * @ClassName: Demo4
 * @Author: xz
 * @Date: 2020/2/19 21:01
 * @Version: 1.0
 */
public class Demo4 {
    public static void main(String[] args) {
//        Parent4 parent4 = new Parent4();
        Parent4[] parent4s = new Parent4[1];
        System.out.println(parent4s.getClass());
        System.out.println(parent4s.getClass().getSuperclass());
        int[] i = new int[1];
        System.out.println(i.getClass());
        System.out.println(i.getClass().getSuperclass());
    }
}

class Parent4{
    static {
        System.out.println("Parent4 static block");
    }
}
