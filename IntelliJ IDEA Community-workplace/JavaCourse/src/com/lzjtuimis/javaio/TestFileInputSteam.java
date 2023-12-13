package com.lzjtuimis.javaio;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class TestFileInputSteam {
    public static void main(String[] args) throws IOException {
        //流在把文件读到末尾时是不可逆的，所以再次读取要新建另一个字节流

        File f = new File("test.txt");  //相对路径存在于与src同目录下
        InputStream in1 = new FileInputStream(f);
        /*读取文件内容到二进制数组中*/
        byte[] b = new byte[100];    //创建可一次读取100字节内容的数组
        int i = 0;
        i = in1.read(b);              //read(byte[] b)方法返回所读取文件内容的字节数
        //→. 查看文件的字节数
        System.out.println("文件长度" + i);
        //→. 直接输出byte数组，但文件不足100字节，剩余字节数组元素以初始化0显示
        System.out.println(Arrays.toString(b));
        //→. 将字节转化为字符串查看文本内容，由于字节数组后面部分为0，转换为String后会方格乱码
        System.out.println(new String(b));


        //循环读取，len用于记录文件长度,字节数组长度大于文件长度，只输出文件长度的字节数组
        InputStream in = new FileInputStream(f);
        byte[] bytes = new byte[1024];
        int len = 0;
        System.out.println("文件的十六进制遍历表示：");
        len = in.read(bytes); // 返回字节数，即文件长度
        for (i=0; i<len; i++){
            System.out.print(Integer.toHexString(0xff&bytes[i]) + " "); //读取后以为十六进制输出
        }
        System.out.println("\n文件长度" + len);
        // 只将字节数组读取到的文件内容转换为字符换，而不管后面0的部分
        System.out.println(new String(bytes, 0, len, StandardCharsets.UTF_8));  //utf-8编码

        //字节数组大小小于文件长度：utf-8中文3字节，英文1字节。文件有49个字节
        InputStream in2 = new FileInputStream(f);
        byte[] b2 = new byte[9];   // 3的倍数确保一个中文占的字节不会被拆开
        StringBuilder content = new StringBuilder();
        int l = 0;
        while((l = in2.read(b2))!= -1){ // read(byte[] b) 方法读到文件末尾也返回-1
            if (l < b2.length){         // 读取字节数不足字节数组大小时的输出，即读到46至49字节
                for (i = 0; i< l; i++) {
                    System.out.print(b2[i] + "  ");
                }
                content.append(new String(b2,0, l, StandardCharsets.UTF_8)); //在这里将46和49字节的文件内容转换String
            }
            else {
                // 输出字节数组本身全部读取并占位的字节
                System.out.println(Arrays.toString(b2));
                //转化为字符串显示文本内容
                content.append(new String(b2, StandardCharsets.UTF_8));
            }

        }
        System.out.println("\n文件的字符串内容为：\n" + content);


        in2.close();
        in1.close();
        in.close();
    }
}
