package com.xz.jvm.classloader;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * @Package: com.xz.jvm.classloader
 * @ClassName: Demo19
 * @Author: xz
 * @Date: 2020/2/25 11:05
 * @Version: 1.0
 */
public class Demo19 implements Runnable {
    private Thread thread;

    public Demo19() {
        this.thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        ClassLoader contextClassLoader = thread.getContextClassLoader();
        thread.setContextClassLoader(contextClassLoader);
        System.out.println(contextClassLoader.getClass());
        System.out.println(contextClassLoader.getParent().getClass());
    }

    public static void main(String[] args) {
        new Demo19();
    }
}
