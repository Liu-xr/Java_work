package com.ljztuimis.controller;

import com.ljztuimis.utils.JDBCUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ModifyContentServlet", value = "/ModifyContentServlet")
public class ModifyContentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        int affected = 0;
        // 获取从index.jsp页面请求时保存的请求参数——cid
        String chapterId = (String) request.getSession().getAttribute("cid");
        String chapterName = request.getParameter("chaptername");
        String studyDate = request.getParameter("studydate");
        String studyTime = request.getParameter("studytime");
        String chapterDesc = request.getParameter("modifiedchapterdesc");
        System.out.println(chapterDesc);
        String sql = "update chapterinfo set chaptername=? ,studydate=?,studytime=? where chapterid=?";
        String sql1 = "update chapterinfo set chaptername=? ,studydate=?,studytime=?,chapterdesc=? where chapterid=?";
        try {
            if(chapterDesc.equals("1"))    // 说明章节简介没有被修改，不更新
                affected = JDBCUtils.executeUpdate(sql,chapterName,studyDate,studyTime,chapterId);
            else
                affected = JDBCUtils.executeUpdate(sql1,chapterName,studyDate,studyTime,chapterDesc,chapterId);
        } catch (SQLException e) {
                e.printStackTrace();
        }
        System.out.println(affected);
        response.getWriter().print("<h3>修改章节内容完成，3秒后跳转，请稍候..........</h3>");
        response.setHeader("Refresh","3;url=index.jsp");
    }
}
