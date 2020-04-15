package com.xz.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Package: com.xz.concurrent
 * @ClassName: Demo7
 * @Author: xz
 * @Date: 2020/3/14 22:09
 * @Version: 1.0
 */
public class Demo7 {
    static ThreadLocal<Object> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        Student object = new Student();
        AtomicReference<Student> s1 = new AtomicReference<>();
        AtomicReference<Student> s2 = new AtomicReference<>();
        new Thread(()->{
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            object.age=1;
            threadLocal.set(object);
            System.out.println(threadLocal.get());
            s1.set(object);
        }).start();
        new Thread(()->{
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            object.age=2;
            threadLocal.set(object);
            System.out.println(threadLocal.get());
            s2.set(object);
        }).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(s1.get()==s2.get());
    }
}
class Student{
    int age;
}
