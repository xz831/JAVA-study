package com.xz.designPattern.factory;

/**
 * @Package: com.xz.designPattern.factory
 * @ClassName: AbstractFactory
 * @Author: xz
 * @Date: 2020/4/11 22:25
 * @Version: 1.0
 */
public abstract class AbstractFactory {
    abstract Food createFood();
    abstract Weapon createWeapon();
}
