package com.xz.thread;

import java.beans.SimpleBeanInfo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Package: com.xz.thread
 * @ClassName: ThreadTest
 * @Author: xz
 * @Date: 2020/2/23 13:09
 * @Version: 1.0
 */
public class ThreadTest {
    public static void main(String[] args) {
//        for(int i = 0;i<100;i++){
//            new Thread(new Task()).start();
//        }
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);
        scheduledExecutorService.schedule(() -> System.out.println("1111"), 1, TimeUnit.SECONDS);
    }
}
class Task implements Runnable{

    private ThreadLocal<SimpleDateFormat> simpleDateFormat = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    @Override
    public void run() {
        try {
            Date parse = simpleDateFormat.get().parse("2011-11-11 11:11:11");
            System.out.println(parse);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
