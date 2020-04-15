package com.xz.concurrent;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Package: com.xz.concurrent
 * @ClassName: Demo24
 * @Author: xz
 * @Date: 2020/4/3 17:17
 * @Version: 1.0
 */
public class Demo24 {

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> sq = new ArrayBlockingQueue<>(10);
        sq.add("a");
        sq.offer("b");
        sq.put("c");
        System.out.println(sq.poll());//a
        System.out.println(sq.peek());//b
        System.out.println(sq.take());//b
        System.out.println(sq.element());//c
        System.out.println(sq.remove());//c
        System.out.println(sq);//[]
    }
}
