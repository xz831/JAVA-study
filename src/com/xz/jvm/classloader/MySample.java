package com.xz.jvm.classloader;

/**
 * @Package: com.xz.jvm.classloader
 * @ClassName: MySample
 * @Author: xz
 * @Date: 2020/2/22 17:48
 * @Version: 1.0
 */
public class MySample {
    public MySample() {
        System.out.println("MySample: "+this.getClass().getClassLoader());
        new MyCat();
    }
}
