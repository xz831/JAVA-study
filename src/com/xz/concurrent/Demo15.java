package com.xz.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Package: com.xz.concurrent
 * @ClassName: Demo15
 * @Author: xz
 * @Date: 2020/3/29 21:27
 * @Version: 1.0
 */
public class Demo15 {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(20,()-> System.out.println("发车！！"));
        Thread[] t = new Thread[100];
        for(int i = 0;i<18;i++){
            int finalI = i;
            t[i]=new Thread(()->{
                try {
                    barrier.await();
                    System.out.println(finalI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
        for (Thread thread : t) {
            thread.start();
        }
        for (Thread thread : t) {
            thread.interrupt();
        }
    }
}
