package com.lzjtuimis.javaio;

import java.io.*;

public class FIleOutputStremCopy {
    public static void main(String[] args) throws IOException  {

        File f1 = new File("a1.txt");
        File f2 = new File("a2.txt");

        //1. 字节数组一次性copy
        OutputStream out = new FileOutputStream(f2);
        InputStream in = new FileInputStream(f1);
        byte[] b = new byte[1024];
        in.read(b);
        out.write(b);
        out.close();
        in.close();

        //2. 单个字节循环copy
        OutputStream out1 = new FileOutputStream(f2);
        InputStream in1 = new FileInputStream(f1);
        int content;
        while((content = in1.read()) != -1){
            out1.write(content);
        }
        out1.close();
        in1.close();
    }
}
