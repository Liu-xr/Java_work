package com.lzjtuimis.javaio;

import java.io.*;


public class TestFile {
    public static void main(String[] args) {
        // 1. 测试file文件对象
        //File f = new File("test.txt");  相对路径创建在与src在同一目录下
        File f = new File("E:\\Java_work\\TestFile.txt");
        if (f.exists()){
            System.out.println("文件存在。");
            if (f.canRead())
                System.out.println("文件可读。");
        }
        else{
            System.out.println("文件不存在");
            try {
                if(f.createNewFile())
                    System.out.println("已创建新文件");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("文件长度：" + f.length());


        // 2. 测试file目录对象
        File fdir = new File("E:\\Java_work\\TestFile");
        if (fdir.exists()){
            System.out.println("目录存在。");
        }
        else{
            System.out.println("目录不存在");
            if (fdir.mkdir())
                System.out.println("文件夹目录已创建");
            else
                System.out.println("文件夹目录创建失败");
        }
        //列出已存在目录下的各个文件
        File fdir1 = new File("E:\\信管专业课");
        //list()方法：返回该file目录对象下的文件名字符串数组
        String[] str = fdir1.list();
        assert str != null;  // 断言str不为空
        for(String s :str)
            System.out.println(s);

        //ListFiles()方法：返回file对象（包含完整的路径名）的数组
        File[] fil = fdir1.listFiles();
        if (fil != null) {     //在fil数组不为空下进行
            for (File file : fil) System.out.println(file);
        }

    }
}
