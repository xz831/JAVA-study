package com.xz.jvm.memory;

/**
 * @Package: com.xz.jvm.memory
 * @ClassName: Demo2
 * @Author: xz
 * @Date: 2020/3/3 20:08
 * @Version: 1.0
 */
public class Demo2 {
    public static void main(String[] args) {
        test(1);
    }
    private static void test(int i){
        System.out.println(i++);
        test(i);
    }
}
