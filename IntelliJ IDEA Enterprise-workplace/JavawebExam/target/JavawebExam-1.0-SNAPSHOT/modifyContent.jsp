<%--
  Created by IntelliJ IDEA.
  User: Redrum
  Date: 2022/12/15
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
  <head>
    <title>修改章节内容</title>
    <link rel="stylesheet" href="css/modifyContent.css">
    <script>
      var a;
      function sure(){
        a = confirm("确认修改");
        if(a){      // 未被修改，不传值
            var chapterdescValue = document.getElementById("chapterdesc").value;
            if(!("${requestScope.chapterInfo.chapterDesc}"===chapterdescValue))
                document.getElementById("modifiedchapterdesc").value = chapterdescValue;
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
    <form action="ModifyContentServlet" method="post">
      <table border="5" cellpadding="20" width="500" align="center">
        <tr>
          <th>章节编号</th><td>${requestScope.chapterInfo.chapterId}</td>
          <th>章节名称</th>
          <td><input type="text" name="chaptername" class="modifiedText" value="${requestScope.chapterInfo.chapterName}"/></td>
        </tr>
        <tr>
          <th>学习时间</th>
          <td><input type="text" name="studydate" class="modifiedText" value="${requestScope.chapterInfo.studyDate}"/></td>
          <th>学习时长</th>
          <td><input type="text" name="studytime" class="modifiedText" value="${requestScope.chapterInfo.studyTime}"/></td>
        </tr>
        <tr>
          <th>章节简介</th>
          <td colspan="3">
          <textarea id="chapterdesc" class="modifiedText" cols="60" rows="5" style="resize:none">${requestScope.chapterInfo.chapterDesc}</textarea>
          </td>
        </tr>
        <tr>
          <td colspan="2"><input type="button" value="点击确认" onclick="sure()" /></td>
          <td colspan="2"><input type="submit" value="点击提交" onclick="return validate()"/></td>
        </tr>
      </table>
      <input type="text" value="1" name="modifiedchapterdesc" id="modifiedchapterdesc" style="display: none;" />
    </form>
  </div>
  </body>
</html>
