package com.xz.concurrent;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Package: com.xz.concurrent
 * @ClassName: Demo12
 * @Author: xz
 * @Date: 2020/3/16 21:36
 * @Version: 1.0
 */
public class Demo12 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(Runtime.getRuntime().availableProcessors());
        long s1 = System.nanoTime();
        System.out.println(getPrime(1, 200000).size());
        long e1 = System.nanoTime();
        System.out.println(e1-s1);

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        long s2= System.nanoTime();
        Future<List<Integer>> task1 = executorService.submit(() -> getPrime(1, 80000));
        Future<List<Integer>> task2 = executorService.submit(() -> getPrime(80001, 130000));
        Future<List<Integer>> task3 = executorService.submit(() -> getPrime(130001, 170000));
        Future<List<Integer>> task4 = executorService.submit(() -> getPrime(170001, 200000));
        System.out.println(task1.get().size());
        System.out.println(task2.get().size());
        System.out.println(task3.get().size());
        System.out.println(task4.get().size());
        long e2 = System.nanoTime();
        System.out.println(e2-s2);
        executorService.shutdown();
    }

    private static List<Integer> getPrime(int start, int end) {
        List<Integer> list = new ArrayList<>();
        for(int i=start;i<=end;i++){
            if(isPrime(i)) {
                list.add(i);
            }
        }
        return list;
    }

    private static boolean isPrime(int num){
        boolean flag = false;
        for(int i = 2;i<num;i++){
            if(num%i==0){
                flag= true;
                break;
            }
        }
        return !flag;
    }
}
