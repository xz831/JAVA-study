package com.xz.designPattern.state;

/**
 * @Package: com.xz.designPattern.state
 * @ClassName: Main
 * @Author: xz
 * @Date: 2020/5/1 13:51
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        person.state = new HappyState();
        person.say();
        person.state = new SadState();
        person.say();
    }
}
class Person{
    State state;
    void say(){
        state.say();
    }
}
abstract class State{
    abstract void say();
}
class HappyState extends State{

    @Override
    void say() {
        System.out.println("happy say");
    }
}
class SadState extends State{

    @Override
    void say() {
        System.out.println("sad say");
    }
}
