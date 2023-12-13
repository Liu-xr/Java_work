package com.lzjtuimis.utils;

/*
 * java web项目
 * 数据库包装类
 */

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;
import java.util.List;

public class JDBCUtils {
    private static final String className = "com.mysql.cj.jdbc.Driver";
    private static final String url="jdbc:mysql://localhost:3306/s_c_db?useUnicode=true&characterEncoding=utf-8";
    private static final String username = "root";
    private static final String password = "mysql2022!";
    private static  Connection conn = null;
    //创建一个ThreadLocal对象，线程连接池
    private static final ThreadLocal<Object> threadLocal = new ThreadLocal<>();

    static{
        try {
            Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){   // 多用户访问的同一个连接对象
        try {
            //首先到ThreadLocal索要当前线程关联的Connection
            conn = (Connection)threadLocal.get();
            //若线程没有连接对象则创建并set到threadLocal中
            if(conn==null){
                conn= DriverManager.getConnection(url, username,password);
                //将新建Connection与当前线程关联保存到ThreadLocal
                threadLocal.set(conn);
            }
            //conn.setAutoCommit(false);        //设置事务为手动提交
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /** 查询操作    */
    public static ResultSet executeQuery(String sql, Object... paras) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        for (int i = 0; i < paras.length; ++i) {
            stmt.setObject(i + 1, paras[i]);
        }
        return stmt.executeQuery();
    }

    /**  查询操作（一次性取出所有数据放入内存中）   */
    public static CachedRowSet executeQueryToCachedRowSet(String sql, Object... paras) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Connection connection = getConnection();
        stmt = connection.prepareStatement(sql);
        for (int i = 0; i < paras.length; ++i) {
            stmt.setObject(i + 1, paras[i]);
        }
        rs = stmt.executeQuery();
        RowSetFactory rowSetFactory = RowSetProvider.newFactory();
        CachedRowSet crs = rowSetFactory.createCachedRowSet();
        crs.populate(rs);
        closeQuietly(rs);
        closeQuietly(stmt);
        return crs;
    }

    /** 更新操作 */
    public static int executeUpdate(String sql, Object... paras) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        for (int i = 0; i < paras.length; ++i) {
            stmt.setObject(i + 1, paras[i]);
        }
        int result = stmt.executeUpdate();
        closeQuietly(stmt);
        return result;
    }

    /** 更新操作：传入其他connection对象 */
    public static int executeUpdate(Connection connection, String sql, Object... paras) throws SQLException {
        PreparedStatement stmt = null;
        stmt = connection.prepareStatement(sql);
        for (int i = 0; i < paras.length; ++i) {
            stmt.setObject(i + 1, paras[i]);
        }
        int result = stmt.executeUpdate();
        closeQuietly(stmt);
        return result;
    }

    /**  事务的更新操作   */
    public static boolean executeUpdateTrans(List<String> sqlList, List<Object[]> parasList) throws SQLException {
        PreparedStatement stmt = null;
        Connection connection = getConnection();
        try {
            connection.setAutoCommit(false);
            for (int i = 0; i < sqlList.size(); ++i) {
                stmt = connection.prepareStatement(sqlList.get(i));
                stmt.clearParameters();
                for (int j = 0; j < parasList.get(i).length; ++j) {
                    stmt.setObject(j + 1, parasList.get(i)[j]);
                }
                stmt.executeUpdate();
                closeQuietly(stmt);
            }
            connection.commit();
            return true;
        } catch (Exception e) {
            connection.rollback();
            return false;
        }
    }

    /**  批量更新操作：传递一个预编译SQL语句，根据传递不同参数进行批量更新  */
    public static boolean executeUpdateBatch(String sql, List<Object[]> parasList) throws SQLException {
        PreparedStatement stmt = null;
        Connection connection = getConnection();
        try {
            connection.setAutoCommit(false);
            stmt = connection.prepareStatement(sql);
            for (int i = 0; i < parasList.size(); ++i) {
                stmt.clearParameters(); // 每将一个预编译SQL语句填充好参数并addBatch后清除所填充参数，进行下一次填充参数
                for (int j = 0; j < parasList.get(i).length; ++j) {
                    stmt.setObject(j + 1, parasList.get(i)[j]);
                }
                stmt.addBatch();  // 填充好参数后的预编译SQL语句进行添加进Batch
                if (i % 1000 == 0) { // 每1000个sql语句批量执行一次
                    stmt.executeBatch();
                }
            }
            stmt.executeBatch();  // 剩下不足1000的SQL语句执行
            connection.commit();
            return true;
        } catch (Exception e) {
            connection.rollback();
            return false;
        }
    }

    /** 获取最后插入数据的自增主键值   */
    public static int getLastInsertId() throws SQLException {
        ResultSet rs = null;
        try {
            rs = executeQuery( "select last_insert_id() id ");
            rs.next();
            return rs.getInt("id");
        } finally {
            closeQuietly(rs);
        }
    }

    /**   关闭资源    */
    public static void closeQuietly(AutoCloseable ac) {
        if (ac != null) {
            try {
                ac.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**   关闭连接    */
    public static void closeConn() {
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
