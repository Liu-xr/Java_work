package com.lzjtuimis.javasql;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestUtil {
    public static void main(String[] args) throws IOException, SQLException {
        FileReader fileReader = new FileReader("src\\com\\lzjtuimis\\javasql\\setting.properties");
        new JDBCUtil(fileReader);
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from student where sname like ?";
        ResultSet resultSet = JDBCUtil.queryResultSet(sql, "%刘%");
        while(resultSet.next()) {
            System.out.print(resultSet.getString("sname") + "\t");
            System.out.print(resultSet.getString("sno") + "\t");
            System.out.println(resultSet.getString("ssex"));
        }
    }
}
