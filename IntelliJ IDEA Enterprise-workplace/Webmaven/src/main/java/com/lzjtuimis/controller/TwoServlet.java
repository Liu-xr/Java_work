package com.lzjtuimis.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TwoServlet", value = "/TwoServlet")
public class TwoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求得到的参数数据的编码
        request.setCharacterEncoding("UTF-8");
        //设置服务器响应到客户端的类型
        response.setContentType("text/html;charset=utf-8");
        /* 设置响应到服务器的字符集编码，优先覆盖上述方法的字符集编码
        response.setCharacterEncoding("GBK");
        */
        //响应获取在客户端的输出流对象
        PrintWriter out = response.getWriter();

        ServletContext servletContext = request.getServletContext();
        String user = (String) servletContext.getAttribute("user");
        String password = (String) servletContext.getAttribute("password");
        String sno = (String) servletContext.getAttribute("sno");
        if(user!=null&&password!=null){
            out.print("从OneServlet得到的初始化参数学号为：" +  sno);
            out.print("<br>欢迎登陆！" + user);
            out.print("<br>你的登录密码是:" + password + "，请注意保存。");
        }
        else
            out.print("你未从表单请求OneServlet后重定向该Servlet。");

        // 使用超链接get方法请求
        String dept = request.getParameter("dept");
        if(dept!=null)
            out.print("<br>你从test.jsp页面直接访问该Servlet得到的系为：" + dept);
        else
            out.print("<br>你未从test.jsp页面超链接直接请求该Servlet。");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
