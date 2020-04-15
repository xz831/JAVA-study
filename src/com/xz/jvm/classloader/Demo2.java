package com.xz.jvm.classloader;

import java.util.HashMap;
import java.util.Map;

/**
 * @Package: com.xz.jvm.classloader
 * @ClassName: Demo2
 * @Author: xz
 * @Date: 2020/2/19 11:40
 * @Version: 1.0
 */
public class Demo2 {

    public static void main(String[] args) {
        System.out.println(Parent2.m);
    }
}

class Parent2{

    public static final String str = "hello world";

    public static final Map<String,String> map = new HashMap<>();

    public static final long l = 123;

    public static final short s = 5;

    public static final int i = 1222;

    public static final int j = 1;

    public static final int m = 2<<20;

    static {
        System.out.println("Parent2 static block");
    }
}
