<%--
  Created by IntelliJ IDEA.
  User: Redrum
  Date: 2022/11/9
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
  <title>连接数据库</title>
</head>
<%!
  Connection con = null;
  Statement st = null;
  ResultSet rs = null;
  String url = "jdbc:mysql://localhost:3306/s_c_db?useUnicode=true&characterEncoding=utf-8";
  String user = "root";
  String psw = "mysql2022!";
  String sql = "select * from student";
%>
<body>
<h2>测试如下：</h2>
<%
  try {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    out.print("正在连接conn……<br>");
    con = DriverManager.getConnection(url, user, psw);
    out.print("连接成功!<br>");
    st = con.createStatement();
    rs = st.executeQuery(sql);
%>
<table border=1>
  <tr>
    <th>学号</th>
    <th>姓名</th>
    <th>性别</th>
  </tr>

  <%
    while (rs.next()) {
  %>
  <tr>
    <td><%=rs.getString(1)%></td>"
    <td><%=rs.getString(2)%></td>
    <td><%=rs.getString(3)%></td>
  </tr>

  <%
    }
  %>
</table>
<%
  } catch (SQLException e) {
    out.println("连接异常。");
    e.printStackTrace();
  }
  try {
    if(con!=null)
      con.close();
  } catch (SQLException e) {
    e.printStackTrace();
  }
  try {
    if(st!=null)
      st.close();
  } catch (SQLException e) {
    e.printStackTrace();
  }
  try {
    if(rs!=null)
      rs.close();
  } catch (SQLException e) {
    e.printStackTrace();
  }
%>
</body>
</html>
