<%--
  Created by IntelliJ IDEA.
  User: Redrum
  Date: 2022/11/9
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<%--
    JDBC驱动名、数据库 URL、数据库的用户名与密码
    useUnicode=true&characterEncoding=utf-8 防止中文乱码
 --%>
<sql:setDataSource var="snapshot" driver="com.mysql.cj.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/s_c_db?useUnicode=true&characterEncoding=utf-8"
                   user="root" password="mysql2022!" />

<%-- 插入数据
<sql:update dataSource="${snapshot}" var="result">
    INSERT INTO website (NAME,url,age,country) VALUES ('京东', 'https://www.jd.com/', 15, 'CN');
</sql:update> --%>

<%-- 删除website表中id为9数据
<c:set var="id" value="9" />
<sql:update dataSource="${snapshot}" var="count">
     DELETE FROM website WHERE id = ?
     <sql:param value="${id}" />
</sql:update>--%>

<%-- 修改website表中id为8数据
<c:set var="id" value="8" />
<sql:update dataSource="${snapshot}" var="count">
     UPDATE website SET name="biancheng" WHERE id = ?
     <sql:param value="${id}" />
</sql:update>--%>

<%-- 查询数据 --%>
<sql:query dataSource="${snapshot}" var="result">
  SELECT * from student;
</sql:query>

<table border="1" width="100%">
  <tr>
    <th>sno</th>
    <th>sname</th>
    <th>ssex</th>
    <th>sage</th>
    <th>sdept</th>
  </tr>
  <c:forEach var="row" items="${result.rows}">
    <tr>
      <td><c:out value="${row.sno}" /></td>
      <td><c:out value="${row.sname}" /></td>
      <td><c:out value="${row.ssex}" /></td>
      <td><c:out value="${row.sage}" /></td>
      <td><c:out value="${row.sdept}" /></td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
