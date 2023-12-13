<%--
  Created by IntelliJ IDEA.
  User: Redrum
  Date: 2022/12/15
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>About</title>
    <link rel="stylesheet" href="css/about.css">
  </head>
  <body>
  <div>
 <h3><center>------About------</center></h3>
  <label>
    <textarea cols="30" rows="9" readonly="readonly" disabled="disabled" style="background-color: transparent;resize:none;">
    <c:import url="text/about.txt" charEncoding="UTF-8"/>
    </textarea>
  </label>
  </div>
  </body>
</html>
