<%--
  Created by IntelliJ IDEA.
  User: Redrum
  Date: 2022/11/9
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.lzjtuimis.beans.Student" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
  <h3>显示requestSqlServlet超链接访问的结果</h3>
  <%
    try {
    ResultSet rs = (ResultSet) session.getAttribute("rs");
    if(rs != null){
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
      <td><%=rs.getString(1)%></td>
      <td><%=rs.getString(2)%></td>
      <td><%=rs.getString(3)%></td>
    </tr>

    <%
      }}
    %>
  </table>
  <%
    } catch (SQLException e) {
      e.printStackTrace();
    }
  %>

  <h3>显示UtilsServlet转发处理的结果</h3>
  <table border=1>
    <tr>
      <th>学号</th>
      <th>姓名</th>
      <th>性别</th>
      <th>年龄</th>
      <th>专业</th>
    </tr>
    <%
      ArrayList<Student> students = (ArrayList<Student>) request.getAttribute("students");
      for (Student s:students) {
    %>
    <tr>
      <td><%=s.getNo()%></td>
      <td><%=s.getName()%></td>
      <td><%=s.getSex()%></td>
      <td><%=s.getAge()%></td>
      <td><%=s.getDept()%></td>
    </tr>
    <%
      }
    %>
  </table>
  </body>
</html>
