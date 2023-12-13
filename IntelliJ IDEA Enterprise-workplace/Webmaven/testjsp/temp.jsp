<%@ page import="java.util.Arrays" %><%--
  Created by IntelliJ IDEA.
  User: Redrum
  Date: 2022/10/25
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
  <head>
    <title>验证页面</title>
  </head>
  <body>
  <%
    request.setCharacterEncoding("utf-8");
    String account = request.getParameter("account");
    String password = request.getParameter("password");
    String[] cities = request.getParameterValues("cities");

    // session存储信息，重定向后使用
    session.setAttribute("account", account);
    if (password.equals("123")) {
      out.print("登录成功！");
      out.print("<br>所选择的城市为：");
      out.print(Arrays.toString(cities));
      out.print("<br>3秒钟后跳转...");
      response.setHeader("refresh", "3;url=main.jsp");
    }
    else  // 验证失败后重定向
      response.sendRedirect("login.jsp");
  %>
  </body>
</html>
