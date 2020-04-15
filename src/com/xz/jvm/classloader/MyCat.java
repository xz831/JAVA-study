package com.xz.jvm.classloader;

/**
 * @Package: com.xz.jvm.classloader
 * @ClassName: MyCat
 * @Author: xz
 * @Date: 2020/2/22 17:47
 * @Version: 1.0
 */
public class MyCat {

    public MyCat() {
        System.out.println("MyCat: "+this.getClass().getClassLoader());
    }
}
