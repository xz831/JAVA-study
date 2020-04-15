package com.xz.other;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: com.xz.other
 * @ClassName: Demo3
 * @Author: xz
 * @Date: 2020/3/27 12:12
 * @Version: 1.0
 */
public class Demo3 {

    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
//        long s1 = System.nanoTime();
//        for(int i = 0 ; i<1000000;i++){
//            Object o = new Object();
//            list.add(o);
//        }
//        long s2 = System.nanoTime();
//        System.out.println(s2-s1);
        long s3 = System.nanoTime();
        Object o;
        for(int i = 0 ; i<1000000;i++){
            o = new Object();
            list.add(o);
        }
        long s4 = System.nanoTime();
        System.out.println(s4-s3);
    }
}
