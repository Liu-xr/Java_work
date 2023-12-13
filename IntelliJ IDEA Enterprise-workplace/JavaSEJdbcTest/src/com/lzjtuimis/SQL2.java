package com.lzjtuimis;

import java.sql.*;
import java.util.Arrays;

public class SQL2 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/s_c_db?characterEncoding=utf-8";
        String user = "root";
        String password = "mysql2022!";
        Connection conn = null;
        PreparedStatement pstate = null;
        ResultSet result = null;
        String s1 = "insert into student value('20200105155','张三斤','男',20,'imis')";
        String s2 = "insert into student value('20200105156','王五六','女',19,'imis')";

        try {
            conn = DriverManager.getConnection(url, user, password);
            Statement state = conn.createStatement();
            //批处理
            state.addBatch(s1);
            state.addBatch(s2);
            int[] account = state.executeBatch();
            System.out.println("受影响行数：" + account.length);


        } catch (Exception e) {
            e.printStackTrace();
        }



        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    }

