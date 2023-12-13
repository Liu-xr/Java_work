package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class connect {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String url="jdbc:mysql://localhost:3306/s_c_db?characterEncoding=utf-8";
		Connection connection = DriverManager.getConnection(url, "root", "mysql2022!");
		
		@SuppressWarnings("unused")
		String sql = "select * from student";
		String sql1 = "insert into student value(?, ?, ?, ?, '信管')";
		PreparedStatement ps = connection.prepareStatement(sql1);
		/* 预编译
		ps.setString(1, "20200105166");
		ps.setString(2, "王五");
		ps.setString(3, "男");
		ps.setInt(4, 22);
		int a = ps.executeUpdate();
		System.out.println("受影响行数" + a);
		*/
		/* 查询结果集
		ResultSet result = ps.executeQuery();
		while(result.next()) {
			System.out.println(result.getString(1));
			System.out.println(result.getString(2));
			System.out.println(result.getString(3));
			System.out.println(result.getInt(4));
		}
		result.close();*/
		// 批处理
		connection.setAutoCommit(false);
		Statement s = connection.createStatement();
		s.addBatch("delete from student where sdept = 'imis'");
		s.addBatch("delete from student where sname = '王五'");
		int[] b = s.executeBatch();
		connection.commit();
		int a = 0; //总共受影响行数
		for(int i = 0; i<b.length;i++) {
			System.out.println("第一次受影响语句：" + b[i]);
			a += b[i];
		}
		System.out.println("总受影响行数：" + a);
		connection.setAutoCommit(true);
		
		ps.close();
		connection.close();
		
		

	}

}
