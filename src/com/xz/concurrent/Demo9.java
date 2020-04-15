package com.xz.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @Package: com.xz.concurrent
 * @ClassName: Demo9
 * @Author: xz
 * @Date: 2020/3/15 12:52
 * @Version: 1.0
 */
public class Demo9 {

    private static BlockingQueue<MyTask> blockingQueue = new DelayQueue<>();

    static class MyTask implements Delayed{
        private long running;
        private long start = System.currentTimeMillis();
        MyTask(long running) {
            this.running = running;
        }
        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert((running+start)-System.currentTimeMillis(),TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            return Long.compare(this.getDelay(TimeUnit.MILLISECONDS), o.getDelay(TimeUnit.MILLISECONDS));
        }

        @Override
        public String toString(){
            return running+"";
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Demo9.blockingQueue.put(new MyTask(1000));
        Demo9.blockingQueue.put(new MyTask(1200));
        Demo9.blockingQueue.put(new MyTask(2000));
        Demo9.blockingQueue.put(new MyTask(5000));
        Demo9.blockingQueue.put(new MyTask(1500));

        while(true){
            System.out.println(blockingQueue.take());
            if(blockingQueue.size()==0)break;
        }
    }
}
