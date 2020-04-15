package com.xz.concurrent;

import java.util.concurrent.Exchanger;

/**
 * @Package: com.xz.concurrent
 * @ClassName: Demo20
 * @Author: xz
 * @Date: 2020/3/31 14:08
 * @Version: 1.0
 */
public class Demo20 {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger();
        new Thread(()->{
            try {
                String exchange = exchanger.exchange("1");
                System.out.println("1 " + exchange);
                String exchange1 = exchanger.exchange(exchange);
                System.out.println("1 " + exchange1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                String exchange = exchanger.exchange("2");
                System.out.println("2 " + exchange);
                String exchange1 = exchanger.exchange(exchange);
                System.out.println("2 " + exchange1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
