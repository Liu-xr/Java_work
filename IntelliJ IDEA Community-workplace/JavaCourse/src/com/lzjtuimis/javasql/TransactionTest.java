package com.lzjtuimis.javasql;

import java.sql.*;

public class TransactionTest {
    public static void main(String[] args) {

        //1. 预定义变量
        String url = "jdbc:mysql://localhost:3306/test?characterEncoding=utf-8";
        String user = "root";
        String password = "mysql2022!";
        Connection con = null;
        Statement state;
        PreparedStatement updateSales;
        PreparedStatement updateTotal;
        ResultSet result;
        String update1 = "update coffees set sales = ? where cof_name = ?";
        String update2 = "update coffees set total = total + ? where cof_name = ?";
        String sql = "select * from coffees";
        int[] salesForWeek = {175, 150, 60, 155, 90};
        String[] coffees = {"colombian", "french_roast", "espresso", "colombian_decaf", "french_roast_deca"};
        int length = coffees.length;

        //2 . 连接数据库对象
        try{
            con = DriverManager.getConnection(url, user, password);
            updateSales = con.prepareStatement(update1);
            updateTotal = con.prepareStatement(update2);

        //3. 取消自动提交事务并开始更新数据
            con.setAutoCommit(false);
            for (int i =0;i<length; i++){
                updateSales.setInt(1, salesForWeek[i]);
                updateSales.setString(2, coffees[i]);
                updateSales.executeUpdate();

                updateTotal.setInt(1, salesForWeek[i]);
                updateTotal.setString(2, coffees[i]);
                updateTotal.executeUpdate();
                con.commit();
            }
        //4. 恢复自动提交事务并查看更新后数据
            con.setAutoCommit(true);
            updateSales.close();
            updateTotal.close();
            state = con.createStatement();
            result = state.executeQuery(sql);
            System.out.println("cof_name\tsup_id\tprice\tsales\ttotal");
            while(result.next()){
                System.out.print(result.getString(1) + "\t");
                System.out.print(result.getString(2) + "\t");
                System.out.print(result.getString(3) + "\t");
                System.out.print(result.getString(4) + "\t");
                System.out.print(result.getString(5) + "\n");
            }
         //5. 关闭SQL语句处理对象、连接对象
            state.close();
            con.close();
            Savepoint a = con.setSavepoint("a");
            con.releaseSavepoint(a);
        //6. SQL异常处理：事务回滚
        }catch(SQLException e){
            System.err.println(e.getMessage());
            if (con != null){
                try {
                    System.err.println("事务正在回滚………");
                    con.rollback();
                }catch(SQLException e1){
                    System.err.println(e1.getMessage());
                }
            }
        }
    }
}
