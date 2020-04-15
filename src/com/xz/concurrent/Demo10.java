package com.xz.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Package: com.xz.concurrent
 * @ClassName: Demo10
 * @Author: xz
 * @Date: 2020/3/16 20:56
 * @Version: 1.0
 */
public class Demo10 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for(int i =0;i<6;i++){
            executorService.execute(()->{
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }
//        System.out.println(executorService);
        executorService.shutdown();
//        System.out.println(executorService.isShutdown());
//        System.out.println(executorService.isTerminated());
//
//        System.out.println(executorService);
//        try {
//            TimeUnit.SECONDS.sleep(7);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(executorService.isShutdown());
//        System.out.println(executorService.isTerminated());
//        System.out.println(executorService);
    }
}
