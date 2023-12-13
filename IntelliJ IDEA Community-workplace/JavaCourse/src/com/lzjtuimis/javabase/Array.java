package com.lzjtuimis.javabase;

import java.sql.*;

public class Array
{
    public static void main(String[] args) throws SQLException {
        //1. 定义一位数组并打印输出
        int[] a1 = new int[5];
        for (int i =0;i<a1.length;i++)
            a1[i] = i;
        for (int i:a1 )
            System.out.print(i + " ");
        System.out.println();

        //2. 定义二维数组并打印输出
        int[][] a2 = new int[4][6];
        for (int i =0;i<a2.length;i++)
            for (int j = 0;j<a2[i].length;j++)
                a2[i][j] = i * j;
        for (int[] i:a2)
        {
            for (int j:i)
                System.out.print(j + "\t");
            System.out.println();
        }

        //3. 定义对象数组并打印输出（数组存储学生对象属性赋值）
        String[] student_no = {"20200105120","20200105100","20200105150"};
        String[] student_name = {"刘兴瑞","张三","李四"};
        int[] student_age = {19, 20, 18};
        Student[] s = new Student[3];
        for (int i = 0;i<s.length;i++)
        {
            s[i] = new Student(student_no[i],student_name[i],student_age[i]);
            System.out.printf("%1$s\t%2$s\t%3$d",s[i].sname , s[i].sno , s[i].sage);
            System.out.println();
        }

        //4. 连接数据库赋值学生类对象
        //连接DB对象
        String url="jdbc:mysql://localhost:3306/s_c_db?characterEncoding=utf-8";
        String user="root";
        String password="mysql2022!";
        Connection con = DriverManager.getConnection(url,user,password);
        //执行SQL语句
        String sql = "SELECT * FROM student limit 3";
        Statement sta =  con.createStatement();
        ResultSet result = sta.executeQuery(sql);
        int i = 0;
        //结果集赋值
        while (result.next())
        {
            s[i] = new Student(result.getString("sno"),result.getString("sname"),
                    result.getInt("sage"));
            i++;
        }
        //输出显示
        System.out.println("学号\t姓名\t  年龄");
        for ( i = 0;i<s.length;i++)
        {
            System.out.printf("%1$s\t%2$s\t%3$d",s[i].sname , s[i].sno , s[i].sage);
            System.out.println();
        }
        //关闭资源
        result.close();
        sta.close();
        con.close();
    }
}


class Student
{
    public String sno;
    public String sname;
    int sage;

    Student(String sno,String sname, int sage)
    {
        this.sage = sage;
        this.sname = sname;
        this.sno = sno;
    }

    @Override
    public String toString(){
        return "学号：" + sno + " 姓名：" + sname + " 年龄：" + sage;
    }
}

