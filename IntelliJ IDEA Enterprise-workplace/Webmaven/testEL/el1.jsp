<%--
  Created by IntelliJ IDEA.
  User: Redrum
  Date: 2022/11/17
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
  ${pageContext.servletContext.contextPath}   //获取该文件的上下文路径
  <c:set var="str" value="I am a person"/>
  <c:set var="array" value="${fn:split(str, ' ')}"/>
  <c:set var="arrays" value="${array}"/>
  <c:forEach var="i" items="${arrays}">
	${i}<br>
  </c:forEach>
<hr>
<%
	String[] str = {"i", "am", "a", "person"};
    request.setAttribute("strArray",str);
%>
${fn:join(requestScope.strArray, ' ')}    // 以空白连接字符串数组各个元素
<br>
  <%
    String[] str1 = {"sdf", "g", "uuw"};
    session.setAttribute("str1",str1);
  %>
  <c:set var="str" value="${str1}"/>
  <c:out value="${sessionScope.str[0]}"/>
<br>条件比较，数据类型自动转换
  <c:set var="num1" value="222"/>
  <c:set var="num2" value="${12}"/>
  <c:set var="num3" value="10"/>
  <c:out value="${num1-num2}"/>
  <c:choose>
    <c:when test="${num1 < num2}">${num2}</c:when>
    <c:when test="${num1 < num3}">${num3}</c:when>
    <c:otherwise>${num1}</c:otherwise>
  </c:choose>

  <br>实例bean赋值：
  <jsp:useBean id="student" class="com.lzjtuimis.beans.Student" scope="session"/>
  <c:set value="刘兴瑞" target="${sessionScope.student}" property="name"/>
  <jsp:getProperty name="student" property="name"/>
  </body>
</html>