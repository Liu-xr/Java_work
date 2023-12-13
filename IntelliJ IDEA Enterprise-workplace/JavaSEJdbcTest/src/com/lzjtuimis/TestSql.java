package com.lzjtuimis;

import java.sql.*;

public class TestSql {
    public static void main(String[] args) {
        // 扩大变量作用域
        String url = "jdbc:mysql://localhost:3306/s_c_db?characterEncoding=utf-8";
        String user = "root";
        String password = "mysql2022!";
        Connection conn = null;
        PreparedStatement pstate = null;
        ResultSet result = null;
        String selectSql = "select * from student where sdept= ?";
        String insertSql = "insert into student values('20200105164',?,?,?,'信息管理与信息系统');";

        try {
            conn = DriverManager.getConnection(url, user, password);
            // select 查询语句
            pstate = conn.prepareStatement(selectSql);
            pstate.setString(1, "信息管理与信息系统");
            result = pstate.executeQuery();
            System.out.println("学号\t\t\t姓名\t\t性别\t年龄\t专业");
            while(result.next()){   // set集合中包含每一行记录
                System.out.print(result.getString(1) + "\t");
                System.out.print(result.getString(2) + "\t");
                System.out.print(result.getString(3) + "\t");
                System.out.print(result.getString(4) + "\t");
                System.out.print(result.getString(5) + "\n");
            }
            result.close();
            pstate.close();

/*
            // insert插入语句
            pstate = conn.prepareStatement(insertSql);
            pstate.setNString(1, "兴瑞刘");
            pstate.setNString(2, "男");
            pstate.setInt(3, 19);
            int affected = pstate.executeUpdate();
            System.out.println("向student表中插入数据后的影响行数：" + affected);
            pstate.close();
*/

        } catch (Exception e) {
            e.printStackTrace();
        }
        // 关闭数据库连接，释放资源
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
