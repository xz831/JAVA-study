package com.xz.designPattern.factory;

/**
 * @Package: com.xz.designPattern.factory
 * @ClassName: MordenFactory
 * @Author: xz
 * @Date: 2020/4/11 22:31
 * @Version: 1.0
 */
public class ModernFactory extends AbstractFactory{
    @Override
    Food createFood() {
        return new Bread();
    }

    @Override
    Weapon createWeapon() {
        return new M24();
    }
}
