package io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileReaderwriter {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileReader r = new FileReader("a1.txt");
        // 1. 读并返回一个字符的int类型
        System.out.println(r.read());       //读一个j
        System.out.println((char) r.read()); //读一个a，将int类型转换为原本的char类型

        // 2. 循环读取字符保存到字符数组
        char[] ch = new char[1024];
        int len = 0, content;
        //read()方法逐个字符读取，若到文件末尾则返回-1
        while((content = r.read()) != -1)  {
            ch[len] = (char)content;         //从a开始读了
            len++;
        }
        r.close();
        System.out.println(ch);
        // 偏移量显示，只显示所读取到的文件部分
        System.out.println(new String(ch, 0, len));  //注意偏移量，否则未读到的剩余字符数组显示空框

        // 3. 读取字符数组
        FileReader r1 = new FileReader("a1.txt");
        char[] c1 = new char[1024];
        int length = r1.read(c1);  // 字符数组返回读取的字符数，即字符长度
        System.out.println(new String(c1, 0, length)); // 偏移量显示
        r1.close();

        // 须为已存在的file对象，true表示从文件末尾写入而非覆盖。
        Writer w = new FileWriter("a2.txt",true);
        String contents = "\nmaybe u r not my favourite.";
        w.write(contents);    //write(String s)写入一个字符串
        w.flush();            //刷新缓冲区
        System.out.println("写入成功！");
        w.close();            //关闭写入流

	}

}
