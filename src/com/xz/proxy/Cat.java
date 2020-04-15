package com.xz.proxy;

/**
 * @Package: com.xz.proxy
 * @ClassName: Cat
 * @Author: xz
 * @Date: 2020/3/2 15:20
 * @Version: 1.0
 */
public class Cat implements Animal {
    @Override
    public void eat() {
        System.out.println("吃鱼");
    }
}
