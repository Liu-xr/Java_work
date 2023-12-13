package com.lzjtuimis.parseJSON;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.lzjtuimis.beans.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "JSONServlet", value = "/JSONServlet")
public class JSONServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        /* json文件的三种传入参数 */
        // 1.路径
        String path = Objects.requireNonNull(getClass().getResource("/students.json")).getPath().substring(1);
        JsonNode root = objectMapper.readTree(new File(path));
        // 2.URL
        URL url = getClass().getResource("/students.json");
        JsonNode root1 = objectMapper.readTree(url);
        // 3.流
        InputStream inputStream = getClass().getResourceAsStream("students.json");
        JsonNode root2 = objectMapper.readTree(inputStream);

        /* 读取json文件内容 */
        // 获取键的值的字符串
        String jsonStr = root.get("students").toString();
        String jsonStr1 = root.get("teacher").toString();
        // 将读取的为json对象的json字符串反序列化为Java对象
        Student student = objectMapper.readValue(jsonStr1, Student.class);
        // 将读取的为json数组的json字符串反序列化为Java对象
        CollectionType jsonType = objectMapper.getTypeFactory().constructCollectionType(List.class, Student.class);
        List<Student> studentList = objectMapper.readValue(jsonStr1,jsonType);
    }
}
