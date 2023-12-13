package com.ljztuimis.controller;

import com.ljztuimis.utils.JDBCUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ModifyObjectiveServlet", value = "/ModifyObjectiveServlet")
public class ModifyObjectiveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String objective1 = request.getParameter("objective1");
        String objective2 = request.getParameter("objective2");
        String objective3 = request.getParameter("objective3");
        String objective4 = request.getParameter("objective4");
        String sql = "update objectiveinfo set objectivecontent = ? where objectiveid=?";
        try {
            if(!objective1.equals("1"))
                JDBCUtils.executeUpdate(sql,objective1,1);
            if(!objective2.equals("1"))
                JDBCUtils.executeUpdate(sql,objective2,2);
            if(!objective3.equals("1"))
                JDBCUtils.executeUpdate(sql,objective3,3);
            if(!objective4.equals("1"))
                JDBCUtils.executeUpdate(sql,objective4,4);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.getWriter().print("<h3>修改课程目标完成，3秒后跳转，请稍候..........</h3>");
        response.setHeader("Refresh","3;url=index.jsp");
    }
}
