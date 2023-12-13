<%--
  Created by IntelliJ IDEA.
  User: Redrum
  Date: 2022/11/9
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
  <head>
    <title>Title</title>
  </head>
	<body>
    <form method="post" action="../SqlServlet">  <!--在上一级路径-->
      <!--查询数据表格-->
      <table border="1" cellpadding="5" width="255">
        <tr><th colspan="2">查询数据</th></tr>
        <tr>
          <th rowspan="2">选择查询依据</th>
          <td><label>学号<input type="radio" name="according" value="sno"></label></td>
        </tr>
        <tr>
          <td><label>姓名<input type="radio" name="according" value="sname"></label></td>
        </tr>
        <tr>
          <th>输入</th>
          <td><label><input type="text" name="select"></label></td>
        </tr>
        <tr align="center">
          <td colspan="2"><label><input type="submit" value="提交查询" ></label></td>
        </tr>
      </table>
      <hr size="8" width="300px" align="left" color="#0000FF">
      <!--  更新数据表格-->
      <table border="1" cellpadding="5" align="left">
        <tr><th  colspan="2">更新数据</th></tr>
        <tr><th>学号依据</th>
          <td><label><input type="text" name="sno"></label></td></tr>
        <tr><th>更新年龄</th>
          <td><label><input type="text" name="sage"></label></td></tr>
        <tr align="center">
          <td colspan="2"><label><input type="submit" value="提交更新"></label></td>
        </tr>
      </table>
    </form>
<br><br><br>
    <form action="../UtilsServlet">
    <input type="submit" value="点击请求UtilsServlet">
    </form>
  </body>
</html>
