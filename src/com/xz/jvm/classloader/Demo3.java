package com.xz.jvm.classloader;

import java.util.UUID;

/**
 * @Package: com.xz.jvm.classloader
 * @ClassName: Demo3
 * @Author: xz
 * @Date: 2020/2/19 20:50
 * @Version: 1.0
 */
public class Demo3 {

    public static void main(String[] args) {
        System.out.println(Parent3.str);
    }

}
class Parent3{
    public static final String str = UUID.randomUUID().toString();
    static {
        System.out.println("Parent3 static block");
    }
}

