package com.lzjtuimis.infoshare;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SessionServlet", value = "/SessionServlet")
public class SessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        // session保存用户信息
        HttpSession session = request.getSession();
        session.setAttribute("name", name);
        session.setAttribute("password", password);

        // 重定向继续输入
        if (null == name || name.trim().length() == 0) {
            response.sendRedirect("useSession.jsp");
            // 转发
        } else if (name.length() > 0 && password.length() > 0) {
            request.getRequestDispatcher("ForwardServlet").forward(request, response);
        }
    }
}
