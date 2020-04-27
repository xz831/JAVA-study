package com.xz.designPattern.prototype;

/**
 * @Package: com.xz.designPattern.prototype
 * @ClassName: Main
 * @Author: xz
 * @Date: 2020/4/27 21:14
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person p = new Person();
        Person clone = (Person)p.clone();
        System.out.println(clone);
        System.out.println(p.location == clone.location);
        p.location.city="北京";
        System.out.println(clone.location.city);
    }
}
class Person implements Cloneable{
    int age = 10;
    String name = "王富贵";
    Location location = new Location("天津市", "第一大道");

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person clone = (Person)super.clone();
        clone.location = (Location) clone.location.clone();
        return clone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", location=" + location +
                '}';
    }

    static class Location implements Cloneable{
        String city;
        String address;

        public Location(String city, String address) {
            this.city = city;
            this.address = address;
        }

        @Override
        public String toString() {
            return "Location{" +
                    "city='" + city + '\'' +
                    ", address='" + address + '\'' +
                    '}';
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}
