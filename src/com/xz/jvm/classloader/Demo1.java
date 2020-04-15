package com.xz.jvm.classloader;

/**
 * @Package: com.xz.jvm.classloader
 * @ClassName: Demo1
 * @Author: xz
 * @Date: 2020/2/18 22:42
 * @Version: 1.0
 *
 * 对于静态字段来说，只有直接定义了该字段的类才会被初始化
 * 当一个类在初始化时，要求其父类全部都已经初始化完毕了
 */
public class Demo1 {

    public static void main(String[] args) {
        System.out.println(Child1.str);
    }
}

class Parent1{
    public static String str = "hello world";
    static {
        System.out.println("Parent1 static block");
    }
}

class Child1 extends Parent1{

    public static String str2 = "welcome";
    static {
        System.out.println("Child1 static block");
    }
}
