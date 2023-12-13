package com.lzjtuimis.fileupload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet(name = "DownloadServlet", value = "/DownloadServlet")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* 服务器响应response下载文件 */
        // 获取在本地硬盘上的真实目录
        String path = getServletContext().getRealPath("images");
        // 获取文件的mime类型
        String  fileType = getServletContext().getMimeType(path + "/test.jpg");
        // 设置响应头类型
        response.setHeader("content-type",fileType);
        response.setHeader("Content-Disposition", "attachment;filename=test.jpg");
        // 读取文件输入流后，写入到输出流进行下载
        FileInputStream fin = new FileInputStream(path + "/test.jpg");
        OutputStream out = response.getOutputStream();
        byte[] bytes = new byte[1024];
        while(fin.read(bytes) >0){
            out.write(bytes);
        }
        out.flush();
        out.close();
        fin.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
