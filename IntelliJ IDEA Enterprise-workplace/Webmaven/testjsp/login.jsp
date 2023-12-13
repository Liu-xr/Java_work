<%--
  Created by IntelliJ IDEA.
  User: Redrum
  Date: 2022/10/25
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
  <head>
    <title>登录页面</title>
  </head>
  <body>
  <form action="temp.jsp">
    <p>
      账号：<label><input type="text" name="account"></label>
    </p>
     <p>
     密码：<label><input type="password" name="password" ></label>
     </p>
    城市选择：
    <label>
      <input type="checkbox" name="cities" value=”上海”>
    </label>上海
    <label>
      <input type="checkbox" name="cities" value=”北京”>
    </label>北京
    <p>
    <input type="submit" value="提交" >
      &nbsp;&nbsp;<a href="">忘记密码？</a>
    </p>
  </form>
  </body>
</html>
