package com.lzjtuimis.parseXML;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "XMLServlet", value = "/XMLServlet")
public class XMLServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("members.xml");
        SAXReader reader = new SAXReader();
        PrintWriter out  = response.getWriter();
        try {
            Document document = reader.read(inputStream);
            Element root = document.getRootElement();		// 获取最开始的标签members
            out.println(root.asXML());
            List<Element> membersElem = root.elements("member");   // 获取为List结点集合
            for (Element memberElem:membersElem) {
                String no = memberElem.element("no").getText(); 	// 获取每一个结点的子节点的文本值
                String name = memberElem.element("name").getText();
                int age = Integer.parseInt(memberElem.elementText("age"));
                System.out.println(no +"  " +  name + "  " +  age);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
