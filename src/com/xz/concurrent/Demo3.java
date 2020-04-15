package com.xz.concurrent;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Package: com.xz.concurrent
 * @ClassName: Demo3
 * @Author: xz
 * @Date: 2020/3/14 12:37
 * @Version: 1.0
 */
public class Demo3 {

    AtomicInteger atomicInteger = new AtomicInteger(0);
    int count = 0;
    void test(){
        for(int i=0;i<1000;i++){
            atomicInteger.incrementAndGet();
        }
    }
    synchronized void test2(){
        for(int i=0;i<1000;i++){
            count++;
        }
    }

    public static void main(String[] args) {
        Demo3 demo3 = new Demo3();
        List<Thread> threads = new LinkedList<>();
        for(int i= 0;i<10000;i++){
            threads.add(new Thread(demo3::test));
        }
        long s1 = System.currentTimeMillis();
        threads.forEach(Thread::start);
        threads.forEach(i->{
            try {
                i.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long e1 = System.currentTimeMillis();
        System.out.println("atom:"+(e1-s1));
        System.out.println(demo3.atomicInteger);

        List<Thread> threads2 = new LinkedList<>();
        for(int i= 0;i<10000;i++){
            threads2.add(new Thread(demo3::test2));
        }
        long s2 = System.currentTimeMillis();
        threads2.forEach(Thread::start);
        threads2.forEach(i->{
            try {
                i.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long e2 = System.currentTimeMillis();
        System.out.println("sync:"+(e2-s2));
        System.out.println(demo3.count);
    }

}
