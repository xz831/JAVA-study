package com.xz.designPattern.iterator;

/**
 * @Package: com.xz.designPattern.iterator
 * @ClassName: Main
 * @Author: xz
 * @Date: 2020/4/21 20:44
 * @Version: 1.0
 */
public class Main {

    public static void main(String[] args) {
        MyList myList = new MyList();
        for(int i = 0;i<15;i++){
            myList.add(i);
        }
        System.out.println(myList.size());
        MyList.MyListIterator iterator = myList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
