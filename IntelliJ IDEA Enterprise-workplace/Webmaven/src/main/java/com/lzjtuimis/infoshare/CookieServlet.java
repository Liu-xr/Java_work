package com.lzjtuimis.infoshare;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "CookieServlet", value = "/CookieServlet")
public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // 时间转字符串格式
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy年MM月dd日HH:mm:ss");
        String nowTime = date.format(format);
        //上次访问时间和访问次数
        String lastVistTime = "";
        int vistedCount = 0;

        // 获取请求对象中的cookie对象并遍历
        Cookie[] myCookies = request.getCookies();
        if(myCookies != null) {
            for (Cookie cookie : myCookies) {
                // 找到属性名为上次访问的cookie对象，并赋值
                if("lastVist".equals(cookie.getName())) {
                    lastVistTime = cookie.getValue();
                }
                // 访问次数
                if("vistedCount".equals(cookie.getName())) {
                    vistedCount = Integer.parseInt(cookie.getValue());
                }
            }
        }
        // 若lastVistTime不为空串
        if(!"".equals(lastVistTime)){
            out.println("上次访问的时间：" + lastVistTime);
        }
        out.println("<br>访问该网站的次数：" + vistedCount);

        //这次访问后更换最后一次访问时间
        Cookie lastVistTimeC = new Cookie("lastVist", nowTime);
        lastVistTimeC.setMaxAge(24 * 60 * 60);
        //更换访问次数
        Cookie vistedCountC = new Cookie("vistedCount", (vistedCount + 1) + "");
        //最大存活时间为1天
        vistedCountC.setMaxAge(24 * 60 * 60);
        //向响应对象中添加cookie对象
        response.addCookie(lastVistTimeC);
        response.addCookie(vistedCountC);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
