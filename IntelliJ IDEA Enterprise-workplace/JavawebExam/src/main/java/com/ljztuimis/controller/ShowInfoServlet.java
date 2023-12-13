package com.ljztuimis.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ljztuimis.bean.ChapterInfo;
import com.ljztuimis.bean.ObjectiveInfo;
import com.ljztuimis.utils.JDBCUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


@WebServlet(name = "ShowInfoServlet", value = "/ShowInfoServlet")
public class ShowInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* get请求响应章节内容 */
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String id = request.getParameter("chapterId");
        String sql = "select * from chapterinfo where chapterId = ?";
        ResultSet set;
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
        // bean对象转化为json字符串
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = objectMapper.writeValueAsString(chapterInfo);
        PrintWriter out = response.getWriter();
        out.print(jsonStr);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* post请求响应课程目标 */
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String sql = "select * from objectiveinfo";
        ResultSet set;
        ObjectiveInfo objectiveInfo = null;
        ArrayList<ObjectiveInfo> objectiveList = new ArrayList<>();
        try {
            set = JDBCUtils.executeQuery(sql);
            while(set.next()){
                int objectiveId = set.getInt("Objectiveid");
                String objectiveContent = set.getString("Objectivecontent");
                objectiveInfo = new ObjectiveInfo(objectiveId,objectiveContent);
                objectiveList.add(objectiveInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 集合对象转化为json字符串数组
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = objectMapper.writeValueAsString(objectiveList);
        PrintWriter out = response.getWriter();
        out.print(jsonStr);
    }
}
