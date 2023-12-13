package com.lzjtuimis.infoshare;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ShowServlet", value = "/ShowServlet")
public class ShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // session在转发一次又请求一次后仍保留客户信息
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(true);
        String name = (String) session.getAttribute("name");
        String password = (String) session.getAttribute("password");

        out.println("<html><body>");
        out.println("请求的servlet对象：" + getServletName());
        out.println("<br>session对象的ID：" + session.getId());
        out.println("<br>存储在session对象中的用户名信息：" + name);
        out.println("<br>存储在session对象中的密码信息：" + password);
        out.println("<br><a href='useSession.jsp'>返回重新输入用户名</a>");
        out.println("</body></html>");
    }
}
