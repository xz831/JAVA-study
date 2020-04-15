package com.xz.concurrent;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Package: com.xz.concurrent
 * @ClassName: Demo5
 * @Author: xz
 * @Date: 2020/3/14 21:45
 * @Version: 1.0
 */
public class Demo5 {

    private LinkedList<String> list = new LinkedList<>();
    private static final int max = 10;
    private int count;

    public synchronized void put(String s){
        while (count == max){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add(s);
        count++;
        System.out.println("生产了 "+s);
        notifyAll();
    }

    public synchronized String get(){
        while(count == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String s = list.removeFirst();
        count--;
        System.out.println("消费了 "+s);
        notifyAll();
        return s;
    }

    public static void main(String[] args) {
        Demo5 demo5 = new Demo5();
        for(int i =0;i<100;i++){
            new Thread(demo5::get).start();
        }
        for(int i =0;i<100;i++){
            int finalI = i;
            new Thread(()->demo5.put(finalI +"")).start();
        }
    }
}
