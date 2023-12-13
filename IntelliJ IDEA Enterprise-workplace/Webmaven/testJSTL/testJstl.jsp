<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.lzjtuimis.beans.Student" %><%--
  Created by IntelliJ IDEA.
  User: Redrum
  Date: 2022/11/22
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>jstl标签库</title>
  </head>
  <body>
    <h3>设置与移除变量</h3>
    输出字符串：<c:out value="this is a string."/><br>
    <c:set value="2022/11/22" var="today"  scope="page"/>
    输出变量：<c:out value="${pageScope.today}"/><br>
    <c:remove var="today" scope="page"/>
    变量移除后显示：<c:out value="${pageScope.today}"/><br>
    识别value中xml标签：
    <c:out value='<marquee bgcolor=\'blue\' behavior=\'alternate\'">
	<font color="white">这是一条来回交替滚动文字。</font></marquee>' escapeXml="false"/>

  <h3>导入外部文本静态文件</h3>
    新建文本文件后再另存为带有BOM的UTF-8<br>
    <label>
    <textarea cols="45" rows="25" >
    <c:import url="../images/about.txt" charEncoding="UTF-8"/>
    </textarea>
    </label>
    <br>新建文本文件后另存为UTF-8<br>
    <label>
    <textarea cols="45" rows="25" >
    <c:import url="../images/claim.txt" charEncoding="UTF-8"/>
    </textarea>
    </label>

    <h3>获取request内置对象属性，并遍历</h3>
    <%
      List<Student> users = new ArrayList<>();
      users.add(new Student("001","lxr","男"));
      users.add(new Student("002","lrx","女"));
      request.setAttribute("users", users);
    %>
    <table border="5" cellspacing="5" cellpadding="10">
      <tr align="center"><th>学号</th><th>姓名</th><th>性别</th></tr>
      <c:forEach var="user" items="${requestScope.users}">  <%--存储在request作用域的user类集合--%>
        <tr align="center">
          <td>${user.no}</td>
          <td>${user.name}</td>
          <td>${user.sex}</td>
        </tr>
      </c:forEach>
    </table>

    <h3>构造一个url，超链接去往</h3>
    <c:url value="../index.jsp" var="myURL" scope="page">
      <c:param name="no" value="${requestScope.users[0].no}"/>
      <c:param name="name" value="${requestScope.users[0].name}"/>
    </c:url>
    <a href="${pageScope.myURL}" target="_blank">点击跳往index.jsp页面</a>

  <h3>九九乘法表</h3>
  <table border="1" cellpadding="5">
    <c:forEach var="i" begin="1" end="9">
      <tr>
        <c:forEach var="j" begin="1" end="${i}">
          <td>${j} * ${i} = ${i*j}</td>
        </c:forEach>
      </tr>
    </c:forEach>
  </table>

  </body>
</html>
