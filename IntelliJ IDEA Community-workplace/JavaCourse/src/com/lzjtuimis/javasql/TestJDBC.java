package com.lzjtuimis.javasql;

import java.sql.*;

public class TestJDBC {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/s_c_db?characterEncoding=utf-8";
        String user = "root";
        String password = "mysql2022!";
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;

        try {
            conn = DriverManager.getConnection(url, user, password);
            state = conn.createStatement();
            String sql = "select * from student;";
            result = state.executeQuery(sql);
            while(result.next()){   // set集合中包含每一行记录
                String sno = result.getString(1); //一行记录中的第一个字段值
                String sname = result.getString(2);
                String ssex = result.getString(3);
                int sage = result.getInt(4);
                String sdept = result.getString(5);
                System.out.println(sno + sname + ssex + sage + sdept);
            }
            result.close();
            state.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        PreparedStatement ps = conn.prepareStatement("update student set ? = ? where name = '刘兴瑞'");
      //  ps.setObject(1, SQL);
        ps.setString(2, "刘兴瑞瑞");
        ps.executeUpdate();

        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
}



