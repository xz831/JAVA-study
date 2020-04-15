package com.xz.designPattern.factory;

/**
 * @Package: com.xz.designPattern.factory
 * @ClassName: TransportFactory
 * @Author: xz
 * @Date: 2020/4/11 12:40
 * @Version: 1.0
 */
public class SimpleTransportFactory {

    public static Car getCar(){
        return new Car();
    }
    public static Plane getPlane(){
        return new Plane();
    }
}
