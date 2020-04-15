package com.xz.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * @Package: com.xz.concurrent
 * @ClassName: Demo2
 * @Author: xz
 * @Date: 2020/3/14 11:55
 * @Version: 1.0
 */
public class Demo2 implements Runnable{

    volatile boolean running = true;

    @Override
    public void run() {
        System.out.println("start");
        while(running){
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        System.out.println("end");
    }

    public static void main(String[] args) throws InterruptedException {
        Demo2 demo2 = new Demo2();
        new Thread(demo2).start();
        TimeUnit.SECONDS.sleep(3);
        demo2.running=false;
    }
}
