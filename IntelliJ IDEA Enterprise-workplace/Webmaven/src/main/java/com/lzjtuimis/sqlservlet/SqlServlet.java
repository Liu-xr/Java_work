package com.lzjtuimis.sqlservlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "SqlServlet", value = "/SqlServlet")
public class SqlServlet extends HttpServlet {
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    String url = "jdbc:mysql://localhost:3306/s_c_db?useUnicode=true&characterEncoding=utf-8";
    String user = "root";
    String psw = "mysql2022!";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.print("<html><body>");
        // 获取查询数据的参数
        String choose = request.getParameter("according");
        String select = request.getParameter("select");
        // 获取更新数据的参数
        String snoUpdate = request.getParameter("sno");
        String sageUpdate = request.getParameter("sage");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        out.print("正在连接conn……<br>");
        try {
            con = DriverManager.getConnection(url, user, psw);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        out.print("连接成功!<br>");
        if(select!=null){
            try {
                if(choose.equals("sno"))
                    pst = con.prepareStatement("select * from student where sno=?");
                if (choose.equals("sname"))
                    pst = con.prepareStatement("select * from student where sname=?");
                pst.setString(1,select);
                rs = pst.executeQuery();
                request.getSession().setAttribute("rs",rs);
                // 在testsql目录下的路径
                out.print("<a href='testsql/responseSqlServlet.jsp'>点击去往jsp页面查看显示结果</a></body></html>");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(snoUpdate!=null&&sageUpdate!=null){
            out.print("<br><hr><br> 更新结果显示：");
            try {
                pst = con.prepareStatement("update student set sage=? where sno=?");
                pst.setInt(1,Integer.parseInt(sageUpdate));
                pst.setString(2,snoUpdate);
                int nums = pst.executeUpdate();
                out.print("<br> 更新受影响行数：" + nums);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
