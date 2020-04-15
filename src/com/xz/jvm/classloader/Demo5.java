package com.xz.jvm.classloader;

import java.sql.SQLOutput;
import java.util.Random;

/**
 * @Package: com.xz.jvm.classloader
 * @ClassName: Demo5
 * @Author: xz
 * @Date: 2020/2/19 21:57
 * @Version: 1.0
 */
public class Demo5 {
    public static void main(String[] args) {
        CheckDefault checkDefault = new CheckDefault();
//        checkDefault.hello();
    }
}

interface Parent5{
    long a = System.currentTimeMillis();
    Thread a1 = new Thread(){{
        System.out.println("Parent5 init");
    }};
}

interface Child5 extends Parent5{
    long b = System.currentTimeMillis();
//    default void hello(){
//        System.out.println("hello");
//    }
    Thread b1 = new Thread(){{
        System.out.println("Child5 init");
    }};
}
class CheckDefault implements Child5{

}
