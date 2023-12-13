package com.lzjtuimis.javaio;

import java.util.Arrays;
import java.util.Scanner;

public class TestScanner {
    public static void main(String[] args) {
        char[] a = {'s','d','g'};
        byte[] b = {1, 2};
        int[] c = {1, 2, 3, 4};
        System.out.println(a);  // 字符数组不需要foreach语句输出，即可显示数组内容,且以字符串显示

        //Arrays类的静态方法toString()方法，直接将数组内容显示,而不需要遍历显示
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(c));

        //将输入的字符串都加到一起输出
        Scanner sc = new Scanner(System.in);
        StringBuilder mes = new StringBuilder("");
        while (true){  // 不使用sc.next().equals("quit")判断就少一个用户输入
            mes.append(sc.next());
            System.out.println("输入quit结束");
            if (sc.next().equals("quit"))
                break;
        }
        System.out.println(mes);
        sc.close();

        //每输入一行字符串输出一次，若一行中以空格分割，则相当于输出两行字符串
        Scanner in = new Scanner(System.in);
        String str;
        // 以什么符号结束，原本可以空格分割符，现在设置只能换行当做分割输入
        in.useDelimiter("\n");
        while(in.hasNext()){
            str = in.next();
            System.out.println(str);
            if (str.equals("quit"))
                break;
        }
        in.close();
    }
}
