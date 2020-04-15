package com.xz.designPattern.factory;

/**
 * @Package: com.xz.designPattern.factory
 * @ClassName: Wand
 * @Author: xz
 * @Date: 2020/4/11 22:30
 * @Version: 1.0
 */
public class Wand extends Weapon {
    @Override
    void use() {
        System.out.println("挥动魔法杖");
    }
}
