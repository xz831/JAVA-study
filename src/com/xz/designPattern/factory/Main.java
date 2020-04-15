package com.xz.designPattern.factory;

/**
 * @Package: com.xz.designPattern.factory
 * @ClassName: Main
 * @Author: xz
 * @Date: 2020/4/11 12:41
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
//        Car car = SimpleTransportFactory.getCar();
//        car.drive();
//        Plane plane = SimpleTransportFactory.getPlane();
//        plane.fly();
        AbstractFactory factory = new ModernFactory();
//        AbstractFactory factory = new MagicFactory();
        Food food = factory.createFood();
        food.eat();
        Weapon weapon = factory.createWeapon();
        weapon.use();
    }
}
