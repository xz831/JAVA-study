package com.xz.designPattern.proxy;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @Package: com.xz.designPattern.proxy
 * @ClassName: StaticProxy
 * @Author: xz
 * @Date: 2020/4/14 21:17
 * @Version: 1.0
 */
public class StaticProxy {
    public static void main(String[] args) {
        new TimeTankProxy(new Tank()).move();
    }
}
interface Movable{
    void move();
}
class Tank implements Movable{

    @Override
    public void move() {
        System.out.println("坦克移动");
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
class TimeTankProxy implements Movable{
    private Movable movable;

    public TimeTankProxy(Movable movable) {
        this.movable = movable;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        movable.move();
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}