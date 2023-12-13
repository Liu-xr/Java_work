package com.test;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class 集结类_集合_数据库_io流 {
    public static void main(String[] args) throws SQLException, IOException {
        List<Student> list = new ArrayList<Student>();
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/s_c_db", "root", "mysql2022!");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select sno, sname, sage, ssex from student");
        while(resultSet.next()){
            String name = resultSet.getString("sname");
            String sno = resultSet.getString("sno");
            int age = resultSet.getInt("sage");
            String sex = resultSet.getString("ssex");
            Student student = new Student(name, sno, sex, age);
            list.add(student);
        }
        resultSet.close();
        statement.close();
        connection.close();

        System.out.println("共存储了" + list.size() + "名学生");
        for ( int i =0; i< list.size();i++
        ) {
            System.out.print(list.get(i).getSno() + "\t");
            System.out.print(list.get(i).getName() + "\t");
            System.out.print(list.get(i).getSex() + "\t");
            System.out.println(list.get(i).getAge() + "\t");
        }

        OutputStream outputStream = new FileOutputStream("集结类_集合_数据库_io流.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        for (Student student : list) {
            objectOutputStream.writeObject(student);
        }
        objectOutputStream.close();
        outputStream.close();
    }
}


class Student implements Serializable{
    private String sno;
    private String name;
    private int age;
    private String sex;

    Student(String name, String sno, String sex, int age){
        this.sno = sno;
        this.name = name;
        this.age = age;
        this.sex= sex;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

}
