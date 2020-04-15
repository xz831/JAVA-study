package com.xz.concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @Package: com.xz.concurrent
 * @ClassName: Demo16
 * @Author: xz
 * @Date: 2020/3/29 21:50
 * @Version: 1.0
 */
public class Demo16 {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<String> strings = Arrays.asList("小明", "小红", "小刚");
        Random random = new Random();
        for (String string : strings) {
            executorService.execute(()->{
                try {
                    TimeUnit.SECONDS.sleep(random.nextInt(10));
                    System.out.println(string +"下课啦");
                    System.out.println(string +"到门口啦");
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(string+"一起回家");
            });
        }
        executorService.shutdown();
    }
}
