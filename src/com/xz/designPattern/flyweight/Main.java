package com.xz.designPattern.flyweight;

/**
 * @Package: com.xz.designPattern.flyweight
 * @ClassName: Main
 * @Author: xz
 * @Date: 2020/4/14 20:51
 * @Version: 1.0
 * 这是一个主函数
 */
public class Main {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        String s4 = new String("abc");
        System.out.println(s1==s2);
        System.out.println(s1==s3);
        System.out.println(s3==s4);
        System.out.println(s1 == s3.intern());
        System.out.println(s3.intern() == s4.intern());
    }
}
