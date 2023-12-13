package io;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		long filePoint = 0; //文件位置指针
        String s;
        String path = "E:\\Java_work\\IntelliJ IDEA Community-workplace\\JavaCourse\\src\\com\\lzjtuimis\\javaio\\RandomAccessTest.java";
        RandomAccessFile file = new RandomAccessFile(path, "r");
        long fileLength = file.length();
        while(filePoint < fileLength){   //文件位置指针与文件长度比较来判断是否读完
            s = file.readLine();       //Readline()是从当前位置开始读到第一个’\n’为止，读取一行文本返回一个String对象。
            System.out.println(s);
            filePoint = file.getFilePointer();
        }
        file.close();

	}

}
