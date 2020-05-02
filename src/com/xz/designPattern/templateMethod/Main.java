package com.xz.designPattern.templateMethod;

/**
 * @Package: com.xz.designPattern.templateMethod
 * @ClassName: Main
 * @Author: xz
 * @Date: 2020/5/1 13:41
 * @Version: 1.0
 */
public class Main {

    public static void main(String[] args) {
        Father father = new Child();
        father.m();
    }
}
abstract class Father{
    void m(){
        op1();
        op2();
    }
    abstract void op1();
    abstract void op2();
}
class Child extends Father{

    @Override
    void op1() {
        System.out.println("op1");
    }

    @Override
    void op2() {
        System.out.println("op2");
    }
}
