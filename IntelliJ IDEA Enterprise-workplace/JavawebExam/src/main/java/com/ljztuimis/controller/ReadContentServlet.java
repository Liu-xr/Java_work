package com.ljztuimis.controller;

import com.ljztuimis.bean.ChapterInfo;
import com.ljztuimis.utils.JDBCUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "ReadContentServlet", value = "/ReadContentServlet")
public class ReadContentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String id = request.getParameter("cid");  // 获取当前显示的章节编号
        ResultSet set;
        String sql = "select * from chapterinfo where chapterId = ?";
        ChapterInfo chapterInfo = null;
        try {
            set = JDBCUtils.executeQuery(sql, id);
            while(set.next()){
                int chapterId = set.getInt("chapterid");
                String chapterName = set.getString("chaptername");
                Date date = set.getDate("studydate");
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String studyDate = format.format(date);
                int studyTime = set.getInt("studytime");
                String chapterDesc = set.getString("chapterdesc");
                chapterInfo = new ChapterInfo(chapterId,chapterName,studyDate,studyTime,chapterDesc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("cid",id);
        request.setAttribute("chapterInfo",chapterInfo);
        request.getRequestDispatcher("modifyContent.jsp").forward(request,response);
    }
}
