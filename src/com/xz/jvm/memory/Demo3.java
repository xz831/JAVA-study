package com.xz.jvm.memory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @Package: com.xz.jvm.memory
 * @ClassName: Demo3
 * @Author: xz
 * @Date: 2020/3/4 14:09
 * @Version: 1.0
 */
public class Demo3 {

    public static void main(String[] args) {
        B b = new B();
        List<A> as = new ArrayList<>();
        while (true){
            A a = (A)Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), b.getClass().getInterfaces(), (proxy, method, args1) -> {
                System.out.println("你好");
                b.a();
                System.out.println("再见");
                return null;
            });
            as.add(a);
        }
    }
}
interface A{
    void a();
}
class B implements A{

    @Override
    public void a() {
        System.out.println("我是B");
    }
}
