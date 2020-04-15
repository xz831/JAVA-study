package com.xz.jvm.classloader;

import sun.security.jca.GetInstance;

/**
 * @Package: com.xz.jvm.classloader
 * @ClassName: Singleton
 * @Author: xz
 * @Date: 2020/2/19 22:42
 * @Version: 1.0
 */
public class Demo6{

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(Singleton.a);
        System.out.println(Singleton.b);
    }
}
class Singleton {
    public static int a ;
    private static Singleton singleton = new Singleton();
    public static int b = 0;

    public Singleton() {
        a++;
        b++;
    }
    public static Singleton getInstance(){
        return singleton;
    }
}
