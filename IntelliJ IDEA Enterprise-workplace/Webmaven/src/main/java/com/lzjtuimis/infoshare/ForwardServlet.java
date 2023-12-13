package com.lzjtuimis.infoshare;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ForwardServlet", value = "/ForwardServlet")
public class ForwardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 转发保留请求信息
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.print("转发后, 用户名:" + request.getParameter("name"));
        out.print("<br>密码:" + request.getParameter("password"));
        out.println("<html><body>");
        out.println("<br><a href='ShowServlet'>点击去往ShowServlet测试Session</a>");
        out.println("</body></html>");
    }
}
