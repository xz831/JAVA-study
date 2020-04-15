package com.xz.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.CountDownLatch;

/**
 * @Package: com.xz.proxy
 * @ClassName: Demo1
 * @Author: xz
 * @Date: 2020/3/2 15:20
 * @Version: 1.0
 */
public class Demo1 {

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        Cat cat = new Cat();
        Animal a=(Animal)Proxy.newProxyInstance(Cat.class.getClassLoader(), Cat.class.getInterfaces(), (proxy, method, args1) -> {
            System.out.println("前");
            Object invoke = method.invoke(cat, args1);
            System.out.println("后");
            return invoke;
        });
        a.eat();
        a.hashCode();
        try {
//            Object o = null;
//            assert o!=null;
//            System.out.println(o);
//            test1(1);
        }catch (Exception e){
            System.out.println("我进来了");
        }finally {
            System.out.println("我又进来了");
        }
    }

    private static void test1(int count){
        System.out.println(count ++);
        test1(count);
    }
}
