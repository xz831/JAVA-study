package com.xz.jvm.gc;

import com.sun.beans.editors.ByteEditor;

/**
 * @Package: com.xz.jvm.gc
 * @ClassName: Demo1
 * @Author: xz
 * @Date: 2020/3/7 13:53
 * @Version: 1.0
 */
public class Demo1 {

    public static void main(String[] args) {
        int size = 1<<20;
        byte[] a = new byte[2*size];
        byte[] b = new byte[2*size];
        byte[] c = new byte[3*size];
        byte[] d = new byte[3*size];
        System.out.println("hello");
    }
}
