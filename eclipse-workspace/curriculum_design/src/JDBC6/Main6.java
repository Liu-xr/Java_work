package JDBC6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main6 {

	public static void main(String[] args) throws SQLException {
		/*
		 * 图书馆要进行出版商的统计。要求创建一个具有交互功能的用户接口的出版商信息应用程序，该应用程序应该使管理人员能够从出版商表中添加、更新信息。
		 */
		System.out.println("===欢迎使用图书馆出版商统计管理系统===");
		Scanner sc = new Scanner(System.in);
		do {
			String choose;
			do {
				System.out.println("请选择以下操作：A-查询出版商信息，B-添加出版商信息，C-更新出版商信息");
				System.out.print("您的选择：");
				choose = sc.next();
				switch (choose){
				case "A": {
					// 查询数据
					Statement statement = connect().createStatement();
					ResultSet resultSet = statement.executeQuery("select * from publisher");
					while (resultSet.next()) {
						System.out.print("出版商id：" + resultSet.getString("id") + "\t");
						System.out.printf("出版商名称：%1$-10s",resultSet.getString("name"));
						System.out.printf("出版商地址：%1$-15s",resultSet.getString("address"));
						System.out.print("出版商电话：" + resultSet.getString("phone") + "\t");
						System.out.println("出版商邮箱：" + resultSet.getString("email"));
					}
					resultSet.close();
					statement.close();
					break;
				}
				case "B": {
					// 插入数据
					System.out.print("输入想要添加的出版商编号：");
					String id = sc.next();
					System.out.print("输入想要添加的出版商名称：");
					String name = sc.next();
					System.out.print("输入想要添加的出版商地址：");
					String address = sc.next();
					System.out.print("输入想要添加的出版商电话：");
					String phone = sc.next();
					System.out.print("输入想要添加的出版商邮编：");
					String email = sc.next();
					String[] params = {id, name, address, phone, email};
					if(insertData(params) == 1)
						System.out.println("插入数据成功！受影响行数：1行");
					break;
				}
				case "C": {
					// 更新数据
					System.out.print("输入想要更新的字段：");
					String updatecolumn = sc.next();
					System.out.print("输入想要更新的字段值：");
					String value1 = sc.next();
					System.out.print("请输入条件限制的字段：");
					String wherecolumn = sc.next();
					System.out.print("输入条件限制的字段值：");
					String value2 = sc.next();
					int affected = updateselectData(updatecolumn, wherecolumn, value1, value2);
					if(affected != 0)
						System.out.println("更新数据成功！受影响行数：" + affected + "行");
					break;
				}
				default:
					System.err.println("请正确输入！");
				}
			}while(!(choose.equals("A") || choose.equals("B")||choose.equals("C")));
			System.out.println("输入continue继续选择操作，输入其他字符退出系统：");
		}while(sc.next().equals("continue"));
		System.out.println("谢谢使用，您已退出系统。");
		sc.close();
	}
	
	public static Connection connect() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/java_design";
		Connection connection = DriverManager.getConnection(url, "root", "mysql2022!");
		return connection;
	}
	
	// 插入数据
	public static int insertData(String[] params) throws SQLException {
		String sql = "insert into publisher value(?,?,?,?,?)";
        PreparedStatement pstate = connect().prepareStatement(sql);
        for(int i = 1;i <= params.length;i++)
            pstate.setString(i, params[i-1]);
        int affected = pstate.executeUpdate();
        closeQuietly(pstate);  // 关闭预编译对象
        return affected;
	}

	// 更新数据
	public static int updateselectData(String updatecolumn, String wherecolumn, String...params) throws SQLException {
		String sql = String.format("update publisher set %1s = ? where %2s = ?", updatecolumn, wherecolumn);
        PreparedStatement pstate = connect().prepareStatement(sql);
        for(int i = 1;i <= params.length;i++)
            pstate.setString(i, params[i-1]);
        int affected = pstate.executeUpdate();
        closeQuietly(pstate);  // 关闭预编译对象
        return affected;
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
            connect().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
