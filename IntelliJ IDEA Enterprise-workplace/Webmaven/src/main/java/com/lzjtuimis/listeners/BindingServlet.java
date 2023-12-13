package com.lzjtuimis.listeners;



import com.lzjtuimis.beans.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BindingServlet", value = "/BindingServlet")
public class BindingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student student = new Student();
        student.setName("刘兴瑞");
        student.setNo("20200105120");
        request.getSession().setAttribute("student", student);
        request.getSession().removeAttribute("student");
    }
}
