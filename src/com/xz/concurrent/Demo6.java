package com.xz.concurrent;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Package: com.xz.concurrent
 * @ClassName: Demo5
 * @Author: xz
 * @Date: 2020/3/14 21:45
 * @Version: 1.0
 */
public class Demo6 {

    private LinkedList<String> list = new LinkedList<>();
    private static final int max = 10;
    private int count;

    private Lock lock = new ReentrantLock();
    private Condition producer = lock.newCondition();
    private Condition consumer = lock.newCondition();

    public void put(String s){
        try {
            lock.lock();
            while (count == max){
                try {
                    producer.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(s);
            count++;
            System.out.println("生产了 "+s);
            consumer.signalAll();
        }finally {
            lock.unlock();
        }

    }

    public String get(){
        try {
            lock.lock();
            while(count == 0){
                try {
                    consumer.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String s = list.removeFirst();
            count--;
            System.out.println("消费了 "+s);
            producer.signalAll();
            return s;
        }finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) {
        Demo6 demo5 = new Demo6();
        for(int i =0;i<100;i++){
            new Thread(demo5::get).start();
        }
        for(int i =0;i<100;i++){
            int finalI = i;
            new Thread(()->demo5.put(finalI +"")).start();
        }
    }
}
