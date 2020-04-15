package com.xz.jvm.classloader;

/**
 * @Package: com.xz.jvm.classloader
 * @ClassName: Demo10
 * @Author: xz
 * @Date: 2020/2/21 14:59
 * @Version: 1.0
 */
public class Demo10 {
    static {
        System.out.println("Demo10 static block");
    }
    public static void main(String[] args) {
        Parent10 parent10;
        System.out.println("-");
        parent10 = new Parent10();
        System.out.println("-");
        System.out.println(Parent10.a);
        System.out.println("-");
        System.out.println(Child10.b);
        //Demo10 static block
        //-
        //Parent10 static block
        //-
        //3
        //-
        //Child10 static block
        //4
    }
}
class Parent10{
    static int a = 3;
    static {
        System.out.println("Parent10 static block");
    }
}
class Child10 extends Parent10{
    static int b = 4;
    static {
        System.out.println("Child10 static block");
    }
}
