package com.xz.designPattern.memento;

import java.io.*;

/**
 * @Package: com.xz.designPattern.memento
 * @ClassName: Main
 * @Author: xz
 * @Date: 2020/4/27 21:48
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try {
            File f = new File("d://person.data");
            oos = new ObjectOutputStream(new FileOutputStream(f));
            oos.writeObject(new Person());
            ois = new ObjectInputStream(new FileInputStream(f));
            Person person = (Person) ois.readObject();
            System.out.println(person);
        }finally {
            if(oos != null){
                oos.close();
            }
            if(ois != null){
                ois.close();
            }
        }
    }
}
class Person implements Serializable{
    String name  = "张伟";
    int age = 24;
    Dog dog = new Dog("旺财");

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dog=" + dog +
                '}';
    }

    static class Dog implements Serializable{
        String name;

        public Dog(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Dog{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
