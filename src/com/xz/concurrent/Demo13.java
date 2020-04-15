package com.xz.concurrent;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @Package: com.xz.concurrent
 * @ClassName: Demo13
 * @Author: xz
 * @Date: 2020/3/17 11:39
 * @Version: 1.0
 */
public class Demo13 {

    private static final Integer MAX = 50000;
    private static int[] num = new int[1000000];
    private static Random random = new Random();

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        for(int i=0;i<num.length;i++){
            num[i]=random.nextInt(1000);
        }
        long s1 = System.currentTimeMillis();
        System.out.println(Arrays.stream(num).sum());
        long e1 = System.currentTimeMillis();
        System.out.println(e1-s1);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        MyTask myTask = new MyTask(0, num.length);
        long s2 = System.currentTimeMillis();
        forkJoinPool.execute(myTask);
        Integer join = myTask.join();
        long e2 = System.currentTimeMillis();
        System.out.println(join);
        System.out.println(e2-s2);
    }

    static class MyTask extends RecursiveTask<Integer>{

        int start,end;

        public MyTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            Integer sum = 0;
            if(end-start<=MAX){
                for(int i=start;i<end;i++){
                    sum += num[i];
                }
                return sum;
            }else{
                int middle = (start+end)/2;
                MyTask myTask = new MyTask(start, middle);
                MyTask myTask1 = new MyTask(middle, end);
                myTask.fork();
                myTask1.fork();
                return myTask1.join()+myTask.join();
            }
        }
    }
}
