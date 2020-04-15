package com.xz.designPattern.factory;

/**
 * @Package: com.xz.designPattern.factory
 * @ClassName: StaticFactory
 * @Author: xz
 * @Date: 2020/4/11 22:56
 * @Version: 1.0
 */
public class StaticFactory {
    public static Car createCar(){
        return new Car();
    }
    public static Plane createPlane(){
        return new Plane();
    }
}
