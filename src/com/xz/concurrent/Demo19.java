package com.xz.concurrent;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Package: com.xz.concurrent
 * @ClassName: Demo19
 * @Author: xz
 * @Date: 2020/3/30 22:54
 * @Version: 1.0
 */
public class Demo19 {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        new Thread(()->{
            try {
                semaphore.acquire();
                System.out.println("T1 running");
                TimeUnit.SECONDS.sleep(3);
                System.out.println("T1 running");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                semaphore.release();
            }
        }).start();
        new Thread(()->{
            try {
                semaphore.acquire();
                System.out.println("T2 running");
                TimeUnit.SECONDS.sleep(3);
                System.out.println("T2 running");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                semaphore.release();
            }
        }).start();
    }
}
