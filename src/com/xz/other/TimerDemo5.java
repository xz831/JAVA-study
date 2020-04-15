package com.xz.other;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

/**
 * @Package: com.xz.other
 * @ClassName: Demo5
 * @Author: xz
 * @Date: 2020/4/5 20:56
 * @Version: 1.0
 */
public class TimerDemo5 {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new SynchronousQueue<>(), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        threadPoolExecutor.execute(()->{
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                int count= 0;
                @Override
                public void run() {
                    System.out.println("续命"+count);
                    count++;
                    if(count == 3){
                        timer.cancel();
                        threadPoolExecutor.shutdown();
                    }
                }
            },3000,3000);
        });
    }
}
