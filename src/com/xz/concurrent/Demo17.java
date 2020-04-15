package com.xz.concurrent;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * @Package: com.xz.concurrent
 * @ClassName: Demo17
 * @Author: xz
 * @Date: 2020/3/30 21:50
 * @Version: 1.0
 */
public class Demo17 {

    public static void main(String[] args) {
        PartyPhaser partyPhaser = new PartyPhaser();
        partyPhaser.bulkRegister(5);
        for(int i= 0;i<5;i++){
            new Thread(new Person("person"+i,partyPhaser)).start();
        }
    }
}
class PartyPhaser extends Phaser{

    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        switch (phase){
            case 0:
                System.out.println("所有人到齐" + registeredParties);
                System.out.println();
                return false;
            case 1:
                System.out.println("所有人吃饭" + registeredParties);
                System.out.println();
                return false;
            case 2:
                System.out.println("所有人离开" + registeredParties);
                System.out.println();
                return false;
            case 3:
                System.out.println("开车" + registeredParties);
                System.out.println();
                return true;
            default:
                return true;
        }
    }
}
class Person implements Runnable{
    private String name;
    private Phaser phaser;
    private Random random = new Random();

    public Person(String name,Phaser phaser) {
        this.name = name;
        this.phaser = phaser;
    }

    private void come(){
        try {
            TimeUnit.SECONDS.sleep(random.nextInt(5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name+"来了");
        phaser.arriveAndAwaitAdvance();
    }
    private void eat(){
        try {
            TimeUnit.SECONDS.sleep(random.nextInt(5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name+"吃饭");
        phaser.arriveAndAwaitAdvance();
    }
    private void leave(){
        try {
            TimeUnit.SECONDS.sleep(random.nextInt(5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name+"离开");
        phaser.arriveAndAwaitAdvance();
    }

    private void car(){
        if(name.equals("person3")){
            try {
                TimeUnit.SECONDS.sleep(random.nextInt(5));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name+"开车");
            phaser.arriveAndAwaitAdvance();
        }else {
            phaser.arriveAndDeregister();
        }
    }

    @Override
    public void run() {
        come();
        eat();
        leave();
        car();
    }
}
