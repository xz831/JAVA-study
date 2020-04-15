package com.xz.jvm.bytecode;

import org.junit.Test;

import java.util.regex.Pattern;

/**
 * @Package: com.xz.jvm.bytecode
 * @ClassName: Demo2
 * @Author: xz
 * @Date: 2020/3/1 14:42
 * @Version: 1.0
 */
public class Demo2 {

    public void test(GrandPa grandPa){
        System.out.println("grandPa");
    }

    public void test(Parent parent){
        System.out.println("parent");
    }

    public void test(Son son){
        System.out.println("son");
    }

    public static void main(String[] args) {
        GrandPa p1 = new Parent();
        GrandPa p2 = new Son();
        Demo2 demo2 = new Demo2();
        demo2.test(p1);
        demo2.test(p2);
    }
}
class GrandPa{

}
class Parent extends GrandPa{

}
class Son extends Parent{

}