package com.xz.designPattern.factory;

/**
 * @Package: com.xz.designPattern.factory
 * @ClassName: MagicFactory
 * @Author: xz
 * @Date: 2020/4/11 22:32
 * @Version: 1.0
 */
public class MagicFactory extends AbstractFactory {
    @Override
    Food createFood() {
        return new MagicCookie();
    }

    @Override
    Weapon createWeapon() {
        return new Wand();
    }
}
