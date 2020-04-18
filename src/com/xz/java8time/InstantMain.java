package com.xz.java8time;

import java.time.Instant;

/**
 * @Package: com.xz.java8time
 * @ClassName: InstanceMain
 * @Author: xz
 * @Date: 2020/4/18 21:57
 * @Version: 1.0
 */
public class InstantMain {

    public static void main(String[] args) {
        Instant now = Instant.now();
        System.out.println(now.getEpochSecond());
        System.out.println(now.toEpochMilli());
    }
}
