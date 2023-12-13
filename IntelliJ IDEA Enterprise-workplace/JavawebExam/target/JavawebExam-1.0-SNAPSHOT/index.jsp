<%--
  Created by IntelliJ IDEA.
  User: Redrum
  Date: 2022/12/15
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>Javaweb系统开发与设计</title>
    <!--导入css样式文件-->
    <link rel="stylesheet" href="css/index.css">
    <!--导入jQuery包-->
    <script src="https://code.jquery.com/jquery-3.1.1.js"
            integrity="sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA=" crossorigin="anonymous">
    </script>
    <!--包装函数使用Ajax的post异步请求ShowInfoServlet-->
    <script src="js/execute.js"></script>
    <!--点击各个导航选项触发函数事件请求ShowInfoServlet-->
    <script src="js/request.js"></script>
  </head>
  <body>

  <div id="center">
   <marquee behavior="alternate">===Javaweb系统开发与设计===</marquee>
  </div>

  <div id="backtop">
    <a href="#top">
      <p id="backtopfont">
        回<br>
        到<br>
        顶<br>
        部</p>
    </a>
  </div>

  <!--导航选项-->
  <div id="nav">
    <c:forEach var="chapter" items="${requestScope.chapterList}"  varStatus="status">
    <nav><a id="${chapter.chapterId}" name="${chapter.chapterId}">${chapter.chapterName}</a></nav>
  </c:forEach>
    <nav><a href="about.jsp">About</a></nav>
  </div>

  <!--课程目标div1-->
  <div id="div1">
    <center><h3>《Web系统开发与设计》课程目标</h3></center>
    <div class="objective">
      <p class="p-title">课程目标一：</p>
      <div class="p-content"><p id="objective1">正在载入...</p></div>
    </div>
    <div class="objective">
      <p class="p-title">课程目标二：</p>
      <div class="p-content"><p id="objective2">正在载入...</p></div>
    </div>
    <div class="objective">
      <p class="p-title">课程目标三：</p>
      <div class="p-content"><p id="objective3">正在载入...</p></div>
    </div>
    <div class="objective">
      <p class="p-title">课程目标四：</p>
      <div class="p-content"><p id="objective4">正在载入...</p></div>
    </div>
    <div>
      <form method="post" action="ReadObjectiveServlet">
        <input type="submit" id="modifyobjective" value="点击修改课程目标">
      </form>
    </div>
  </div>

  <!--章节内容div2-->
  <div id="div2">
    <center><h3>《Web系统开发与设计》章节内容</h3></center>
    <div class="chapter">
      <table border="5" cellpadding="10" width="800" height="250">
        <tr>
          <th>章节编号</th><td id="chapterid"></td>
          <th>章节名称</th><td id="chaptername"></td>
        </tr>
        <tr>
          <th>学习时间</th><td id="studydate"></td>
          <th>学习时长</th><td id="studytime"></td>
        </tr>
        <tr>
          <th>章节简介</th><td colspan="3" id="chapterdesc"></td>
        </tr>
      </table>
    </div>
    <div style="margin-top: 20px;">
      <form method="post" action="ReadContentServlet">
        <label><input type="text" id="cid" name="cid" style="display:none"></label>
        <input type="submit" id="modifychapter" value="点击修改章节内容">
      </form>
    </div>
  </div>

  </body>
</html>
