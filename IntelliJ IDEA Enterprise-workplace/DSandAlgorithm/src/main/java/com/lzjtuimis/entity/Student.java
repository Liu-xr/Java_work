package com.lzjtuimis.entity;


import java.io.Serializable;

public class Student implements Comparable<Student>, Serializable {
    String no;
    String name;
    int age;

    public Student() {
    }

    public Student(String no, String name, int age) {
        this.no = no;
        this.name = name;
        this.age = age;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        boolean b = false;
        if(obj instanceof Student) {
            Student s1 = (Student) obj;
            b = getNo().equals(s1.no);
        }
        return b;
    }

    @Override
    public int compareTo(Student s1) {
        return this.no.compareTo(s1.getNo());
    }
}
