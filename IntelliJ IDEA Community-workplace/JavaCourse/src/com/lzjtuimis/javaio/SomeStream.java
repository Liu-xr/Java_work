package com.lzjtuimis.javaio;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class SomeStream {
    public static void main(String[] args) throws IOException {

        /*一、 转换流:字节流转换为字符流*//*
        //1. 转换输入流
        FileInputStream fin = new FileInputStream("a1.txt");
        InputStreamReader inr = new InputStreamReader(fin, StandardCharsets.UTF_8);
        char c = (char)inr.read();   //将读取一个字符返回的int类型强制转换为char字符
        System.out.println(c);
        inr.close();
        //2. 转换输出流
        FileOutputStream fout = new FileOutputStream("a2.txt");
        OutputStreamWriter outw = new OutputStreamWriter(fout, StandardCharsets.UTF_8);
        String s = "通过转换流的写入";
        outw.write(s);
        outw.close();
*/

        /*二、 缓存流*//*
        //1. 字节缓存流
        fin = null;
        fin = new FileInputStream("a1.txt");
        BufferedInputStream bfin = new BufferedInputStream(fin, 1024);
        c = (char)bfin.read();
        System.out.println(c);
        bfin.close();

        fout = null;
        fout = new FileOutputStream("a2.txt");
        BufferedOutputStream  bfout = new BufferedOutputStream(fout, 1024);
        bfout.write(1);
        bfout.flush();
        bfout.close();
        //2. 字符缓存流
        FileReader fr = new FileReader("a1.txt");
        BufferedReader bfr = new BufferedReader(fr, 1024);
        c = (char)bfr.read();
        System.out.println(c);
        bfr.close();

        FileWriter fw = new FileWriter("a2.txt");
        BufferedWriter  bfw = new BufferedWriter(fw, 1024);
        bfw.newLine();
        bfw.write("写入字符缓存流");
        bfw.flush();
        bfw.close();
*/

        /*三、 数据流*/
        DataOutputStream out = new DataOutputStream(new FileOutputStream("DATAStream.txt"));

        //创建数据输出流，前端套接文件流并以filename.file为输出目的地。
        double[] prices = {1, 2, 3, 4, 5};
        int[] units = {11, 22, 33, 44, 55};
        for(int i = 0; i < prices.length; i++){
            out.writeDouble(prices[i]);
            out.writeChar('\t');
            out.writeInt(units[i]);
            out.writeChar('\t');
        }
        out.close();

        //创建数据输入流，将上述保存文件打开并读取
        DataInputStream in = new DataInputStream(
                new FileInputStream("DATAStream.txt"));
        double price;
        int unit;
        double total = 0.0;
        for(int i = 0; i<prices.length;i++){
            price = in.readDouble();
            in.readChar();       // 读取写入时的\t，即扔掉tab键
            unit = in.readInt();
            in.readChar();
            System.out.print("单价：" + price + "\t");
            System.out.println("数量：" + unit);
            total = total + unit * price;
        }
        System.out.println("共计金额：" + total);
        in.close();

        /*四、 打印流*/
        PrintWriter pw = new PrintWriter("printwriter.txt");
        pw.println(46); // 向文件中打印46并换行
        pw.println("lxr");
        pw.println(new Object());
        pw.print(new char[]{'a', 'b', 'c', 'd'});
        pw.append('r');  //向文件末尾添加字符r不换行
        pw.append("2022/6/27");
        pw.flush();
        System.out.println("向文件打印内容成功");
        pw.close();
        PrintStream ps = new PrintStream("printstream.txt");
        ps.println("lxr");
        ps.print(2002);
        ps.append('r');
        ps.close();
    }
}
