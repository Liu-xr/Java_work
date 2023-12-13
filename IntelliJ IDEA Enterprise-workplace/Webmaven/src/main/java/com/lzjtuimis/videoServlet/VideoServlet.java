package com.lzjtuimis.videoServlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.Arrays;
import java.util.Objects;

@WebServlet(name = "VideoServlet", value = "/VideoServlet")
public class VideoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 响应类型为mp4
        response.setContentType("video/mp4");
        // 响应头，分片按字节响应，减少传输量和传输时间。
        response.setHeader("Accept-Ranges", "bytes");

        InputStream inputStream = Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("/videos/test.mp4"));
        ServletOutputStream outputStream = response.getOutputStream();

        byte[] buffer = new byte[1024 * 1024 * 10];  // 每次传输10MB数据
        int len;
        while ((len = inputStream.read(buffer)) != -1) {
            byte[] data = Arrays.copyOf(buffer, len);  // 复制实际读取的数据字节
            outputStream.write(data);
        }

        inputStream.close();
        outputStream.close();
    }
}
