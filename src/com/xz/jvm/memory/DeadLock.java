package com.xz.jvm.memory;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Package: com.xz.jvm.memory
 * @ClassName: DeadLock
 * @Author: xz
 * @Date: 2020/3/3 20:29
 * @Version: 1.0
 */
public class DeadLock {

    public static void main(String[] args) {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();
        new Thread(new DeadThread(lock1,lock2),"死锁线程1").start();
        new Thread(new DeadThread1(lock1,lock2),"死锁线程2").start();
    }
}
class DeadThread implements Runnable{
    private Lock lock1;
    private Lock lock2;
    private static int i = 0;

    public DeadThread(Lock lock1, Lock lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        lock1.lock();
        System.out.println(Thread.currentThread().getName()+"我拿到了lock1锁");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock2.lock();
        System.out.println(Thread.currentThread().getName()+ "我拿到了lock2锁");
        System.out.println("DeadThread "+i++);
        lock2.unlock();
        lock1.unlock();
    }
}
class DeadThread1 implements Runnable{
    private Lock lock1;
    private Lock lock2;
    private static int i = 0;

    public DeadThread1(Lock lock1, Lock lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        lock2.lock();
        System.out.println(Thread.currentThread().getName()+"我拿到了lock2锁");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock1.lock();
        System.out.println(Thread.currentThread().getName()+"我拿到了lock1锁");
        System.out.println("DeadThread1 "+i++);
        lock1.unlock();
        lock2.unlock();
    }
}
