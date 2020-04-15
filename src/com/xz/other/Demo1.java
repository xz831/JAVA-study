package com.xz.other;

/**
 * @Package: com.xz.other
 * @ClassName: Demo1
 * @Author: xz
 * @Date: 2020/3/1 22:31
 * @Version: 1.0
 */
public class Demo1 {

    public static void main(String[] args) {
        int i =1;
        while(true){
            if(i % 3 == 0 && i % 5 == 1 && i % 6 == 3 && i % 7 == 0 && i % 8 == 1){
                System.out.println(i);
                break;
            }
            i++;
        }
    }
}
