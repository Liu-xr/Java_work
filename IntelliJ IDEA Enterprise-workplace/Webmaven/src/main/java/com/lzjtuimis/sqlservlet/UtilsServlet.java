package com.lzjtuimis.sqlservlet;

import com.lzjtuimis.beans.Student;
import com.lzjtuimis.utils.JDBCUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "UtilsServlet", value = "/UtilsServlet")
public class UtilsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sql = "select * from student where ssex = ?";
        ResultSet set;
        ArrayList<Student> students = new ArrayList<>();
        try {
            set = JDBCUtils.executeQuery(sql, "男");
            while(set.next()){
                String sno = set.getString("sno");
                String sname = set.getString("sname");
                String ssex = set.getString("ssex");
                Student student = new Student(sno,sname,ssex);
                student.setAge(set.getInt("sage"));
                student.setDept(set.getString("sdept"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtils.closeConn();
        request.setAttribute("students", students);
        request.getRequestDispatcher("testsql/responseSqlServlet.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
