package com.xz.designPattern.strategy;

/**
 * @Package: com.xz.designPattern.strategy
 * @ClassName: Shoot
 * @Author: xz
 * @Date: 2020/4/10 21:41
 * @Version: 1.0
 */
public class Shoot<T>{

    public static<T> void shoot(T t,HurtValue<T> hurtValue){
        hurtValue.hurtValue(t);
    }
}
