package com.xz.designPattern.singleton;

/**
 * @Package: com.xz.designPattern.singleton
 * @ClassName: Demo1
 * @Author: xz
 * @Date: 2020/4/10 18:14
 * @Version: 1.0
 * 单例模式
 */
public class Singleton1 {
    private static final Singleton1 INSTANCE = new Singleton1();
    private Singleton1(){}
    public static Singleton1 getInstance(){
        return INSTANCE;
    }
}
