package com.test.test4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int y = scanner.nextInt();
        int m = scanner.nextInt();
        int d = scanner.nextInt();
        if(y<1100||y>2200)
            throw  new Exception();
        if(m<=0||m>12)
            throw  new Exception();
        if(d<=0||d>=310)
            throw  new Exception();
        int oneday = Integer.parseInt(scanner.nextLine());
        int[] months = {31,28,31,30,31,30,31,31,30,31,30,31};
        int days = 0;
        for(int i = 0;i<m;i++){
            days += months[i];
        }
        // 是否闰年
        if(y%4==0||y%100==0)
            days +=1;
        days += d;  // 这个月第几号
        days -= (7-oneday);
        System.out.println((days%7)+1);
    }
}
