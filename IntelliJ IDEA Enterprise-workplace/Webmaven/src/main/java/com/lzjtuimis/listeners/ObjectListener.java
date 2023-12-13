package com.lzjtuimis.listeners;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

//@WebListener
public class ObjectListener implements ServletContextListener, HttpSessionListener, ServletRequestListener{

    public ObjectListener() {
    }

    /* ServletContext作用域对象监听器 */
    //实现ServletContextListener接口的方法：运行服务器开启结束的web应用程序上下文路径
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /* This method is called when the servlet context is initialized(when the Web application is deployed). */
        ServletContext servletContext = sce.getServletContext();    //返回context对象
        String ctxPath = servletContext.getContextPath();  		 //返回web应用程序的上下文路径
        System.out.println("服务器即将启动" + ctxPath);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
        ServletContext servletContext = sce.getServletContext();
        String ctxPath = servletContext.getContextPath();
        System.out.println("服务器即将关闭" + ctxPath);
    }


    /* HttpSession作用域对象监听器 */
    // 实现HttpSessionListener接口的方法：查看一个session对象的创建与销毁的ID
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
        HttpSession session = se.getSession();    //返回当前session对象
        System.out.println("创建一个session对象的ID: " + session.getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
        HttpSession session = se.getSession();
        System.out.println("销毁一个session对象的ID: " + session.getId());
    }


    /* ServletRequest作用域对象监听器 */
    //实现ServletRequestListener接口的方法：运行请求的耗时
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        // 返回request对象
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        String uri = request.getRequestURI();  // 返回request对象的URI
        //是否有附带参数请求的URI
        uri = (request.getQueryString() == null ? uri : (uri + "?" + request.getQueryString()));
        //request对象存储此刻创建的时间，毫秒单位
        request.setAttribute("dateCreated", System.currentTimeMillis());
        System.out.println("IP " + request.getRemoteAddr() + " 请求 " + uri);
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        // 时间戳的秒数相减
        long dateCreated = (long) request.getAttribute("dateCreated");
        long time = System.currentTimeMillis() - dateCreated;
        System.out.println(request.getRemoteAddr() + "请求处理结束，用时:" + time + "毫秒 ");
    }


}
