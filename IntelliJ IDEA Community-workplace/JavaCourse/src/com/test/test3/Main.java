package com.test.test3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        int zhs, chs;                   //zhs:质数，chs:除数
        int n = new Scanner(System.in).nextInt();
        if(n<3||n>300)
            throw new Exception();
        ArrayList<Integer> arrayList = new ArrayList<>();
        // 求质数
        for (zhs = 2; zhs <= n; zhs++)
        {
            for (chs = 2; chs < Math.sqrt(zhs); chs++)
                if (zhs % chs == 0)
                    break;
            if (chs > Math.sqrt(zhs))
                arrayList.add(zhs);
        }
        // 求阶乘
        long sum = 0;
        for (int a:arrayList) {
            sum += jiecheng(a);
        }
        System.out.println(sum%96577771);
    }

    static long jiecheng(int n){
        long a = 1, b;
        long sum_of_squares =0;
        while (a <= n)
        {
            b = a++;
            sum_of_squares += b*b;
        }
        return sum_of_squares;
    }

}
