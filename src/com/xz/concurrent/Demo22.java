package com.xz.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Package: com.xz.concurrent
 * @ClassName: Demo22
 * @Author: xz
 * @Date: 2020/3/31 22:16
 * @Version: 1.0
 */
public class Demo22 {
    //交替打印1a2b3c……26z
//    static boolean flag = false;
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition num = lock.newCondition();
        Condition abc = lock.newCondition();
        Thread thread = new Thread(() -> {
            try {
                lock.lock();
                for (int i = 1; i <= 26; i++) {
                    System.out.print(i);
                    abc.signal();
                    num.await();
                }
                abc.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });
        Thread thread1 = new Thread(() -> {
            try {
                lock.lock();
                for (int i = 1; i <= 26; i++) {
                    abc.await();
                    System.out.print((char) (i + 64));
                    num.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });
        thread1.start();
        thread.start();
    }
}
