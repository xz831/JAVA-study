package com.xz.designPattern.factory;

/**
 * @Package: com.xz.designPattern.factory
 * @ClassName: Bread
 * @Author: xz
 * @Date: 2020/4/11 22:27
 * @Version: 1.0
 */
public class Bread extends Food {

    @Override
    void eat() {
        System.out.println("吃面包");
    }
}
