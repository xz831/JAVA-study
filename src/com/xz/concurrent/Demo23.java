package com.xz.concurrent;

/**
 * @Package: com.xz.concurrent
 * @ClassName: Demo23
 * @Author: xz
 * @Date: 2020/4/2 20:54
 * @Version: 1.0
 */
public class Demo23 {

    public static void main(String[] args) {
        for(;;){
            ThreadLocal<byte[]> s = new ThreadLocal<>();
            s.set(new byte[2*1024*1024]);
//            s.remove();
        }
    }
}
