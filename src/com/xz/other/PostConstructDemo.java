package com.xz.other;

import javax.annotation.PostConstruct;

/**
 * @Package: com.xz.other
 * @ClassName: PostConstruDemo
 * @Author: xz
 * @Date: 2020/4/9 13:51
 * @Version: 1.0
 */
public class PostConstructDemo {

    public static void main(String[] args) {
        Post post = new Post();
        System.out.println(post.getStudent());
    }
}
class Post{
    private int a = 1;

    private int b = 2;

    private Student student = new Student(a,b);

    @PostConstruct
    public void init(){
        a = 3;
        b = 4;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
class Student{
    private int age;

    private int id;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student(int age, int id) {
        this.age = age;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", id=" + id +
                '}';
    }
}
