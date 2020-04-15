package com.xz.jvm.bytecode;

import sun.plugin2.message.GetAppletMessage;

/**
 * @Package: com.xz.jvm.bytecode
 * @ClassName: Demo1
 * @Author: xz
 * @Date: 2020/2/27 15:33
 * @Version: 1.0
 */
public class Demo1 {

    private int a = 1;
    {
        this.a=2;
        this.a=3;
    }
    {
        this.a=4;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public Demo1() {
    }

    private void test(){
        getA();
    }
}
