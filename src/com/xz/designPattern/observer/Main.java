package com.xz.designPattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: com.xz.designPattern.observer
 * @ClassName: Main
 * @Author: xz
 * @Date: 2020/4/14 17:55
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        child.addObservers(new Dad());
        child.addObservers(new Mum());
        child.weakUp();
    }
}
//抽象事件
abstract class Event<T>{
    abstract T getResource();
}
//具体事件
class WeakUpEvent extends Event<Child>{

    long timestamp;
    String msg;
    Child child;

    public WeakUpEvent(long timestamp, String msg, Child child) {
        this.timestamp = timestamp;
        this.msg = msg;
        this.child = child;
    }

    @Override
    Child getResource() {
        return child;
    }
}
//抽象观察者
abstract class Observer{
    abstract void eventHandler(Event t);
}
//被观察者
class Child{

    private List<Observer> observers = new ArrayList<>();

    public void addObservers(Observer observer) {
        observers.add(observer);
    }

    public void weakUp(){
        System.out.println("孩子醒了");
        WeakUpEvent weakUpEvent = new WeakUpEvent(System.currentTimeMillis(),"孩子醒了",this);
        for (Observer observer : observers) {
            observer.eventHandler(weakUpEvent);
        }
    }
}
class Dad extends Observer{

    @Override
    void eventHandler(Event t) {
        if(t instanceof WeakUpEvent){
            WeakUpEvent event = (WeakUpEvent) t;
            System.out.println(event.msg+",爸爸抱");
        }
    }
}
class Mum extends Observer{

    @Override
    void eventHandler(Event t) {
        if(t instanceof WeakUpEvent){
            WeakUpEvent event = (WeakUpEvent) t;
            System.out.println(event.msg+",妈妈喂");
        }
    }
}
