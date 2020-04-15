package com.xz.jvm.classloader;

/**
 * @Package: com.xz.jvm.classloader
 * @ClassName: Demo9
 * @Author: xz
 * @Date: 2020/2/21 11:24
 * @Version: 1.0
 */
public class Demo9 {
    static {
        System.out.println("Demo9 static block");
    }

    public static void main(String[] args) {
        System.out.println(Child9.b);
    }
}
class Parent9{
    static int a = 3;
    static {
        System.out.println("Parent9 static block");
    }
}
class Child9 extends Parent9{
    static int b = 4;
    static {
        System.out.println("Child static block");
    }
}
