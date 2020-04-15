package com.xz.jvm.classloader;

/**
 * @Package: com.xz.jvm.classloader
 * @ClassName: Demo8
 * @Author: xz
 * @Date: 2020/2/21 11:10
 * @Version: 1.0
 */
public class Demo8 {
    public static void main(String[] args) {
        System.out.println(FinalTest.x);
    }
}
class FinalTest{
    public static final int x = 3;
    static {
        System.out.println("FinalTest static block");
    }
}
