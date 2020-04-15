package com.xz.other;

import sun.java2d.SurfaceDataProxy;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Package: com.xz.other
 * @ClassName: Demo2
 * @Author: xz
 * @Date: 2020/3/25 17:14
 * @Version: 1.0
 */
public class Demo2 {

    private static AtomicInteger count = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CountDownLatch latch = new CountDownLatch(10000);
        for(int i = 0 ;i <10000;i++){
                executorService.execute(()->{
                    synchronized (o){
                        count.incrementAndGet();
                        latch.countDown();
                    }
                });
        }
        latch.await();
        executorService.shutdown();
        System.out.println(count.get());
    }
}
