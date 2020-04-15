package com.xz.concurrent;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @Package: com.xz.concurrent
 * @ClassName: Demo25
 * @Author: xz
 * @Date: 2020/4/4 12:11
 * @Version: 1.0
 */
public class Demo25 {

    public static void main(String[] args) {
        lockSupport();
        sync();
    }

    private static Thread t1;
    private static Thread t2;

    private static void lockSupport() {
        t1 = new Thread(() -> {
            for (int i = 1; i <= 26; i++) {
                System.out.print(i);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        }, "t1");
        t2 = new Thread(() -> {
            for (int i = 1; i <= 26; i++) {
                LockSupport.park();
                System.out.print((char) (i + 96));
                LockSupport.unpark(t1);
            }
        }, "t2");
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    private static void sync() {
        SynchronousQueue<Integer> sq = new SynchronousQueue<>();
        new Thread(() -> {
            for (int i = 1; i <= 26; i++) {
                try {
                    System.out.print(sq.take());
                    sq.put(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            try {
                for (int i = 1; i <= 26; i++) {
                    sq.put(i);
                    System.out.print((char) (sq.take() + 96));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
