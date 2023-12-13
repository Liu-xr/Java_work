package com.lzjtuimis.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

@WebServlet(name = "FirstServlet", value = "/FirstServlet",
        initParams = { @WebInitParam(name = "firstParam", value = "one"),
                        @WebInitParam(name = "secondParam", value = "two")})
public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstParam = getInitParameter("firstParam");
        String secondParam = getInitParameter("secondParam");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8"); // 编码优先
        PrintWriter out = response.getWriter();
        out.print("FirstServlet类的firstParam参数值为" + firstParam);
        out.print("<br>");
        out.print("FirstServlet类的secondParam参数值为" + secondParam);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
