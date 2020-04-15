package com.xz.designPattern.decorator;

import com.xz.designPattern.factory.Wand;

/**
 * @Package: com.xz.designPattern.decorator
 * @ClassName: Main
 * @Author: xz
 * @Date: 2020/4/12 13:04
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Weapon weapon = new M4A1();
        weapon.use();
        System.out.println("----");
        weapon = new WeaponVoiceDecorator(weapon);
        weapon.use();
        System.out.println("----");
        weapon = new WeaponShapeDecorator(weapon);
        weapon.use();
    }
}
