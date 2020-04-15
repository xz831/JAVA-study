package com.xz.concurrent;

import java.util.concurrent.*;

/**
 * @Package: com.xz.concurrent
 * @ClassName: Demo11
 * @Author: xz
 * @Date: 2020/3/16 21:10
 * @Version: 1.0
 */
public class Demo11 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<>(() -> {
            System.out.println(Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(2);
            return 1;
        });
        new Thread(task).start();
        System.out.println(task.get());
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<Integer> hello_world = executorService.submit(() -> {
            System.out.println("hello world");
            TimeUnit.SECONDS.sleep(2);
            return 2;
        });
//        System.out.println(hello_world.isDone());
//        System.out.println(hello_world.get());
//        System.out.println(hello_world.isDone());
        executorService.shutdown();
    }
}
