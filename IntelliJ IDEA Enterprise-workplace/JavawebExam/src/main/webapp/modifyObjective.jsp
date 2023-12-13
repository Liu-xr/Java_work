<%--
  Created by IntelliJ IDEA.
  User: Redrum
  Date: 2022/12/15
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>修改课程目标</title>
    <link rel="stylesheet" href="css/modifyObjective.css">
    <!--记录修改后的课程目标内容-->
    <script>
      var a;
      function sure(){
        a = confirm("确认修改");
        if(a){      // 未被修改，不传值
            var modifiedText0 = document.getElementsByClassName("modifiedText")[0].value;
            var modifiedText1 = document.getElementsByClassName("modifiedText")[1].value;
            var modifiedText2 = document.getElementsByClassName("modifiedText")[2].value;
            var modifiedText3 = document.getElementsByClassName("modifiedText")[3].value;
            if(!("${requestScope.objectiveList[0].objectiveContent}"===modifiedText0))
                document.getElementById("modifiedobjective1").value = modifiedText0;
            if(!("${requestScope.objectiveList[1].objectiveContent}"===modifiedText1))
                document.getElementById("modifiedobjective2").value = modifiedText1;
            if(!("${requestScope.objectiveList[2].objectiveContent}"===modifiedText2))
                document.getElementById("modifiedobjective3").value = modifiedText2;
            if(!("${requestScope.objectiveList[3].objectiveContent}"===modifiedText3))
                document.getElementById("modifiedobjective4").value = modifiedText3;
        }
        else
          alert("已取消");
      }

      function validate(){
        if(!a){
            alert("请先点击确认！");
            return false;
        }
        return true;
      }
    </script>
  </head>
  <body>
  <div id="center">
    <marquee behavior="alternate">===Javaweb系统开发与设计===</marquee>
  </div>
  <div id="div">
    <form action="ModifyObjectiveServlet" method="post">
      <table border="5" cellpadding="10" align="center">
        <tr><th>课程目标编号</th><th>课程目标内容</th></tr>
        <c:forEach var="objective" items="${requestScope.objectiveList}">
          <tr>
            <td align="center">${objective.objectiveId}</td>
            <td>
              <label>
                <textarea class="modifiedText" cols="60" rows="5" style="resize: none">${objective.objectiveContent}</textarea>
              </label>
            </td>
          </tr>
        </c:forEach>
        <tr align="center">
          <td><input type="button" value="点击确认" onclick="sure()" /></td>
          <td><input type="submit" value="点击提交"  onclick="return validate()"/></td>
        </tr>
      </table>
      <input type="text" value="1" name="objective1" id="modifiedobjective1" style="display: none;" />
      <input type="text" value="1" name="objective2" id="modifiedobjective2" style="display: none;" />
      <input type="text" value="1" name="objective3" id="modifiedobjective3" style="display: none;" />
      <input type="text" value="1" name="objective4" id="modifiedobjective4" style="display: none;" />
    </form>
  </div>
  </body>
</html>
