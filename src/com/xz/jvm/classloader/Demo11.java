package com.xz.jvm.classloader;

/**
 * @Package: com.xz.jvm.classloader
 * @ClassName: Demo11
 * @Author: xz
 * @Date: 2020/2/21 15:13
 * @Version: 1.0
 */
public class Demo11 {
    public static void main(String[] args) {
        System.out.println(Child11.a);
        Child11.doSomething();
    }
}
class Parent11{
    static int a = 3;
    static {
        System.out.println("Parent11 static block");
    }
    static void doSomething(){
        System.out.println("do something");
    }
}
class Child11 extends Parent11{
    static {
        System.out.println("Child11 static block");
    }
}
