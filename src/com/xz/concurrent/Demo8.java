package com.xz.concurrent;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CountDownLatch;

/**
 * @Package: com.xz.concurrent
 * @ClassName: Demo8
 * @Author: xz
 * @Date: 2020/3/15 11:29
 * @Version: 1.0
 */
public class Demo8 {

//    private static Map<String,String> map = new ConcurrentHashMap();//21316
//    private static Map<String,String> map = new ConcurrentSkipListMap<>();//22547
    private static Map<String,String> map = new Hashtable<>();//18514

    public static void main(String[] args) {
        List<Thread> list = new LinkedList<>();
        CountDownLatch latch = new CountDownLatch(100);
        for(int i= 0;i<100;i++){
            list.add(new Thread(()->{
                for(int j=0;j<100000;j++){
                    map.put(Math.random()+"",Math.random()+"");
                }
                latch.countDown();
            }));
        }
        Long start = System.currentTimeMillis();
        for (Thread thread : list) {
            thread.start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Long end = System.currentTimeMillis();
        System.out.println(end-start);
        System.out.println(map.size());
    }
}
