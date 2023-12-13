package com.lzjtuimis.javabase;

import java.util.Scanner;

public class Statements {
    public static void main(String[] args) {
        //1. if语句判断一元二次方程ax2+bx+c = 0
        Scanner sc = new Scanner(System.in);
        System.out.println("每行依次输入a、b、c的值：");
        float a = sc.nextFloat();
        float b = sc.nextFloat();
        float c = sc.nextFloat();
        System.out.printf("方程： %1.1fx2 + %1.1fx + %1.1fx", a, b, c);
        if (a == 0) {
            if (b == 0)
                System.out.println("\n该方程为c = 0，无解。");
            else {
                float x = -c / b;
                System.out.printf("\na = 0，非一元二次方程，x = -c/b = 2.2%f ", x);
            }
        } else {
            float derta = b * b - 4 * a * c;
            if (derta < 0)
                System.out.println("\n该方程的的△ < 0,无根。");
            else if (derta == 0) {
                float x = -b / 2 * a;
                System.out.printf("\n该方程的△ = 0，单根，x = -b/2*a = %1.1f", x);
            } else {
                double x1 = (-b + Math.sqrt(derta)) / 2 * a;
                double x2 = (-b - Math.sqrt(derta)) / 2 * a;
                System.out.printf("\n该方程的△ > 0，双根，x1 =%1$1.1f, x2 = %2$1.1f", x1, x2);
            }
        }

        //2. 求解最大公约数和最小公倍数
        System.out.println("\n每行依次输入x、y的值：");
        int x = sc.nextInt();
        int y = sc.nextInt();
        int remainder;
        int xy = x * y;
        do {
            remainder = x % y;
            x = y;
            y = remainder;
        } while (remainder == 0);
        int min = xy / y;
        System.out.printf("\n%1$d和%2$d的最大公约数为：" + y, x, y);
        System.out.printf("\n%1$d和%2$d的最小公倍数为：" + min, x, y);
        /*法2：两个数一起从除以其中最小的数开始，然后除数不断减1，直到两个数除以这个除数的余数都为0
        double a,b,x,y;
        Scanner sc=new Scanner(System.in);
        a=sc.nextDouble();
        b=sc.nextDouble();
        double i = b;
        do {
            x = a % i;
            y = b % i;
            i--;
        }while(!(x==0&&y==0));
        System.out.println(i+1);
         */

        //3. m + mm + ... +（n个m）的值
        System.out.println("\n每行依次输入m、n的值：");
        int m = sc.nextInt();
        int m1 = m;
        int n = sc.nextInt();
        long total = 0;
        for ( int i = 0; i < n ;i++)
        {
            total += m;
            if (i == n - 1)
                System.out.printf("%d = ", m);
            else
                System.out.printf("%d + ", m);
            m = m * 10 + m1;
        }
        System.out.println(total);
    }

}




