package com.xz.designPattern.decorator;

/**
 * @Package: com.xz.designPattern.decorator
 * @ClassName: WeaponDector
 * @Author: xz
 * @Date: 2020/4/12 13:03
 * @Version: 1.0
 */
public class WeaponVoiceDecorator extends Weapon  {

    public Weapon weapon;

    public WeaponVoiceDecorator(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    void use() {
        weapon.use();
        System.out.println("突突突突");
    }
}
