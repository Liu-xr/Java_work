<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.time.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	LocalTime localtime = LocalTime.now();
%>
<h3>现在的时间是：</h3>
<%= localtime.toString().substring(0, 8) %>

<hr>
<% 
	out.println("今天日期是：" + LocalDate.now()); 
%>
</body>
</html>