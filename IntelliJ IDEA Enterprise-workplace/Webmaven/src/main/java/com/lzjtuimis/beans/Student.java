package com.lzjtuimis.beans;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Student  implements HttpSessionBindingListener {
    private String no;
    private String name;
    private String sex;
    private int age;
    private String dept;

    public Student() {
    }

    public Student(String no, String name, String sex) {
        this.no = no;
        this.name = name;
        this.sex = sex;
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("学生对象." + name + "被绑定到session！");
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("学生对象." + name + "被解除绑定session！");
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

}
