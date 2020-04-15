package com.xz.jvm.classloader;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Package: com.xz.jvm.classloader
 * @ClassName: Demo17
 * @Author: xz
 * @Date: 2020/2/23 13:46
 * @Version: 1.0
 */
public class Demo17 {
    public static void main(String[] args) {
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);
    }
}
