package com.xz.designPattern.strategy;

import java.util.Collections;

/**
 * @Package: com.xz.designPattern.strategy
 * @ClassName: Main
 * @Author: xz
 * @Date: 2020/4/10 21:37
 * @Version: 1.0
 */
public class Main {

    public static void main(String[] args) {
        M4A1 m4A1 = new M4A1();
        AK47 ak47 = new AK47();
        Shoot.shoot(m4A1,t-> System.out.println(t.getClass().getSimpleName()+"射击"));
        Shoot.shoot(m4A1,t-> System.out.println(t.getClass().getSimpleName()+"狠狠地射击"));
        Shoot.shoot(ak47,t-> System.out.println(t.getClass().getSimpleName()+"射击"));
        Shoot.shoot(ak47,t-> System.out.println(t.getClass().getSimpleName()+"轻轻地射击"));
    }
}
