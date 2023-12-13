package com.lzjtuimis.javasql;

/*
* java普通项目
* 连接数据库包装类
* */

import java.io.*;
import java.sql.*;
import java.util.*;

public class JDBCUtil {
    private static String user;
    private static String password;
    private static String database;
    private static String url;
    private static Connection connection;

    // 构造函数初始化一个user、password和数据库
    public JDBCUtil(FileReader fileReader) throws IOException {
        Properties properties = new Properties();
        properties.load(fileReader);
        JDBCUtil.user = properties.getProperty("user");
        JDBCUtil.password = properties.getProperty("password");
        JDBCUtil.database = properties.getProperty("database");
        JDBCUtil.url = properties.getProperty("url0") + JDBCUtil.database;
    }

    // 创建数据库连接
    public static Connection getConnection(){
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // 预编译查询
    public static ResultSet queryResultSet(String sql, Object...params) throws SQLException {
        PreparedStatement pstate = connection.prepareStatement(sql);
        for(int i = 0; i < params.length; i++)
            pstate.setObject(i+1, params[i]);
        return pstate.executeQuery();
    }

    // 预编译更新（delete、update、insert
    public static int updateCount(String sql, Object...params) throws SQLException {
        PreparedStatement pstate = connection.prepareStatement(sql);
        for(int i =0;i<params.length;i++)
            pstate.setObject(i+1, params[i]);
        int affected = pstate.executeUpdate();
        closeQuietly(pstate);  // 关闭预编译对象
        return affected;
    }

    // 批量更新操作：传递不同的DML语句
    public static int updateBatch(String[] sqls) throws SQLException {
        connection.setAutoCommit(false); // 取消事务自动提交模式
        Statement state = connection.createStatement();
        for (String sql : sqls) state.addBatch(sql);
        int[] affedted = state.executeBatch();
        connection.commit();
        int count = 0;
        for (int j : affedted) count += j;
        return count;
    }

    // 关闭对象，释放资源
    public static void closeQuietly(AutoCloseable ac) {
        if (ac != null) {
            try {
                ac.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 关闭数据库连接
    public static void closeConnection(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
