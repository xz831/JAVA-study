package com.xz.designPattern.proxy;

import java.lang.reflect.Proxy;

/**
 * @Package: com.xz.designPattern.proxy
 * @ClassName: DynamicProxy
 * @Author: xz
 * @Date: 2020/4/14 21:36
 * @Version: 1.0
 */
public class DynamicProxy {
    public static void main(String[] args) {
        Tank t = new Tank();
        Movable movable = (Movable)Proxy.newProxyInstance(t.getClass().getClassLoader(),t.getClass().getInterfaces(),(p,m,a)->{
            System.out.println("前处理");
            Object invoke = m.invoke(t, a);
            System.out.println("后处理");
            System.out.println("git提交");
            return invoke;
        });
        movable.move();
    }
}

