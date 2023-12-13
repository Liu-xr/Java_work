package com.hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="FirstServlet", urlPatterns={"/firstServlet/showTime"})
public class FirstServlet extends HttpServlet{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("Refresh","5");			// 设置响应表头
        // 显示时间字符串
        LocalTime now = LocalTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("hh:mm:ss");
        String t = now.format(format);
          
     	PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>当前时间</title></head>");
        out.println("<body>");
        out.println("<p>每5秒钟刷新一次页面<p>");
        out.println("<p>现在的时间是："+t+"<p>");
        out.println("</body>");
        out.println("</html>");
     } 

}
