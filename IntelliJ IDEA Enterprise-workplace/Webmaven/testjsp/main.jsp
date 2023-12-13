<%@ page import="java.time.LocalTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.util.*" %>
<%--
  Created by IntelliJ IDEA.
  User: Redrum
  Date: 2022/10/25
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
  <head>
     /* 每1s刷新页面，事实上也是每1s访问页面一次
      <meta http-equiv="Refresh" content="1">*/
    <title>主页面</title>
  </head>
  <body>
  <%
      String account = (String) session.getAttribute("account");
      // 时间转字符串
      LocalTime now = LocalTime.now();
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
      String time = now.format(formatter);
      // 该用户上次登录时间
      String lastTime = (String) application.getAttribute(account);
  %>
  登录用户<%=account%>你好！<br>
  你当前登录
  的时间是<%=time%>，
  <%
      if(lastTime != null)
          out.print(" 你上次登录的时间是" + lastTime);
      // 保存此次时间，键为用户名，值为时间
      application.setAttribute(account,time);
  %>
  </body>
</html>
