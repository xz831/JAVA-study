package com.xz.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Package: com.xz.concurrent
 * @ClassName: Demo26
 * @Author: xz
 * @Date: 2020/4/4 14:19
 * @Version: 1.0
 */
public class Demo26 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        CompletableFuture<Integer> c1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        });
        CompletableFuture<Integer> c2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 2;
        });
        CompletableFuture<Integer> c3 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 3;
        });
        CompletableFuture.allOf(c1, c2, c3).join();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(c1.get());
        System.out.println(c2.get());
        System.out.println(c3.get());
        c3.thenApply(String::valueOf).thenApply(item->"price "+item).thenAccept(System.out::println);
    }
}
