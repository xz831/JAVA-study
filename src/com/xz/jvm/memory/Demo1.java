package com.xz.jvm.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: com.xz.jvm.memory
 * @ClassName: Demo1
 * @Author: xz
 * @Date: 2020/3/3 13:56
 * @Version: 1.0
 */
public class Demo1 {

    public static void main(String[] args) {
        List<Demo1> list = new ArrayList<>();
        while (true){
            list.add(new Demo1());
            System.gc();
        }
    }
}
