package com.lzjtuimis.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

@WebServlet(name = "OneServlet", value = "/OneServlet",
        initParams = { @WebInitParam(name = "sno", value = "20200105120")})
public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求得到的参数数据的编码
        request.setCharacterEncoding("UTF-8");
        //响应获取在客户端的输出流对象
        PrintWriter out = response.getWriter();

        // 获取初始参数：学号
        String sno = this.getInitParameter("sno");
        // request对象获取请求的参数值：姓名和密码
        String user = request.getParameter("用户名");
        String password = request.getParameter("密码");

        //保存到servlet上下文对象属性
        ServletContext servletContext = request.getServletContext();
        servletContext.setAttribute("sno", sno);
        servletContext.setAttribute("user", user);
        servletContext.setAttribute("password", password);

        // 重定向到TwoServlet类显示保存的属性
        response.sendRedirect("TwoServlet");
        // 重定向到.jpg资源文件
        // response.sendRedirect("images/test.jpg");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 表单post方法执行
        doGet(request, response);
    }
}
