package com.xz.designPattern.iterator;

/**
 * @Package: com.xz.designPattern.iterator
 * @ClassName: MyList
 * @Author: xz
 * @Date: 2020/4/21 20:41
 * @Version: 1.0
 */
public class MyList {

    private Object[] objects = new Object[10];

    private int size = 0;

    public void add(Object o){
        if(size == objects.length){
            Object[] newObjects = new Object[objects.length*2];
            System.arraycopy(objects,0,newObjects,0,size);
            objects = newObjects;
        }
        objects[size] = o;
        size++;
    }
    public int size(){
        return size;
    }

    public MyListIterator iterator(){
        return new MyListIterator();
    }

    public class MyListIterator{
        private int index = 0;

        public boolean hasNext(){
            return index < size;
        }

        public Object next(){
            return objects[index++];
        }
    }
}
