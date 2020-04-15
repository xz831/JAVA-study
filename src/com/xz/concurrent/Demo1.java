package com.xz.concurrent;

import java.io.IOException;
import java.nio.CharBuffer;

/**
 * @Package: com.xz.concurrent
 * @ClassName: Demo1
 * @Author: xz
 * @Date: 2020/3/13 21:41
 * @Version: 1.0
 */
public class Demo1{

    public synchronized void test1() {
        System.out.println("test1 开始");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test1 结束");
    }

    public synchronized void test2() {
        System.out.println("test2 开始");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test2 结束");
    }

    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        new Thread(demo1::test1).start();
        new Thread(demo1::test2).start();
    }
}
