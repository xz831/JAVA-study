package com.xz.designPattern.singleton;


/**
 * @Package: com.xz.designPattern.singleton
 * @ClassName: Singleton3
 * @Author: xz
 * @Date: 2020/4/10 18:21
 * @Version: 1.0
 */
public class Singleton3 {

    private Singleton3(){
    }

    private static class Inner{
        private final static Singleton3 INSTANCE = new Singleton3();
    }

    public static Singleton3 getInstance(){
        return Inner.INSTANCE;
    }
}
