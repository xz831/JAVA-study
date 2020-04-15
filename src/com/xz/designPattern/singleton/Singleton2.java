package com.xz.designPattern.singleton;

/**
 * @Package: com.xz.designPattern.singleton
 * @ClassName: Singleton2
 * @Author: xz
 * @Date: 2020/4/10 18:18
 * @Version: 1.0
 */
public class Singleton2 {

    private static volatile Singleton2 singleton2;
    private Singleton2(){

    }
    public static Singleton2 getInstance(){
        if(singleton2 == null){
            synchronized (Singleton2.class){
                if(singleton2 == null) {
                    singleton2 = new Singleton2();
                }
            }
        }
        return singleton2;
    }
}
