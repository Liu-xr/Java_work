package com.lzjtuimis.fileupload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "Servlet1", value = "/Servlet1")
public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* 浏览器请求上传文件 */
        // 获取name为file的上传的文件
        Part part = request.getPart("file");

        // 获取在本地硬盘上target文件夹的真实目录
        String path = getServletContext().getRealPath("images");
        // 获取文件名包含后缀
        String filename = part.getSubmittedFileName();
        // 生成File对象，将路径与文件名结合
        File file = new File(path, filename);
        FileOutputStream fout = new FileOutputStream(file);
        // 将上传的文件作为输入流
        InputStream fin = part.getInputStream();
        byte[] bytes = new byte[1024];
        int len;
        // 文件输入到byte[]数组中在写入到服务器目录中
        while((len= fin.read(bytes))>0){
            fout.write(bytes,0,len);
        }
        fout.flush();
        fout.close();
    }
}
