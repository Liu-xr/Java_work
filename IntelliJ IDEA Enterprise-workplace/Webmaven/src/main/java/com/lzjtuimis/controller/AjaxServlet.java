package com.lzjtuimis.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.lzjtuimis.beans.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "AjaxServlet", value = "/AjaxServlet")
public class AjaxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");

        Student student = new Student();
        student.setNo("001");
        student.setName("张三");
        student.setSex("女");
        Student student1 = new Student("002",name,sex);

        ArrayList<Student> students = new ArrayList<>();
        students.add(student);
        students.add(student1);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = objectMapper.writeValueAsString(students);
        PrintWriter out = response.getWriter();
        out.println(jsonStr);
        //doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*response.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));

        Student student = new Student();
        student.setNo("20200105120");
        student.setName(name);
        student.setAge(age);
        student.setDept("IMIS");

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = objectMapper.writeValueAsString(student);
        PrintWriter out = response.getWriter();
        out.println(jsonStr);*/
doGet(request,response);
    }
}
