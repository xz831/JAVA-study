package com.xz.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Package: com.xz.concurrent
 * @ClassName: Demo4
 * @Author: xz
 * @Date: 2020/3/14 13:31
 * @Version: 1.0
 */
public class Demo4 {
    private List<String> list = new ArrayList<>();

    public void add(String s){
        list.add(s);
    }

    public int size(){
        return list.size();
    }

    public static void main(String[] args) {
        Demo4 demo4 = new Demo4();
        final Object o =new Object();
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (o){
                    demo4.add("1");
                    if(demo4.size() == 5){
                       o.notify();
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        Thread thread1 = new Thread(() -> {
            synchronized (o){
                if (demo4.size() != 5) {
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(demo4.size());
                o.notify();
            }
        });
        thread1.start();
        thread.start();
//        thread1.join();
//        thread.join();
    }
}
