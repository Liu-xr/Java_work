package com.test.test2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入a：");
        int a = sc.nextInt();
        if(a<0||a>9)
            throw new Exception();
        int n = a;
        int sum = 0;
        int a1 = a*10 + a;  // 66
        // 偶数
        if(a%2==0){
            a =a*10+a;
            for (int i = 2; i<= n; i+=2){
                sum += a;
                if(i!=n)
                    System.out.print(a + " + ");
                else
                    System.out.print(a + " = ");
                a = a * 100 + a1;
            }
            System.out.println(sum);
        }
        else {
            for (int i = 1; i<= n; i+=2){
                sum += a;
                if (i == n)
                    System.out.print(a + " = ");
                else
                    System.out.print(a + " + ");
                a = a * 100 + a1;
            }
            System.out.println(sum);
        }

    }
}
