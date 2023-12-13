package com.lzjtuimis.javabase;

import java.util.Scanner;

public class ForWhile {
    public static void main(String[] args) {

        System.out.println("计算t+tt+ttt+....");
        Scanner sc = new Scanner(System.in);
        System.out.println("输入t：");
        int t = sc.nextInt();
        System.out.println("输入n：");
        int n = sc.nextInt();
        int sum = 0;
        int t1 = t;
        for (int i = 0; i< n; i++){
            sum += t;
            if (i == n-1)
                System.out.print(t + " = ");
            else
                System.out.print(t + " + ");
            t = t * 10 + t1;
        }
        System.out.println(sum);


        System.out.println("\n\n计算1+2+...+m=101+102+...+n时，n与m的最小值，并求和");
        int m=2,  sum1=1, sum2=101;
        n = 102;
        while (sum1 != sum2)
        {
            if (sum1 < sum2)
                sum1 += m++;
            if (sum1 > sum2)
                sum2 += n++;
        }
        System.out.printf("相等时,m=%1d,n=%2d,sum1=%3d = sum2=%4d", m, n, sum1, sum2);
        System.out.println("\n" + (int)Math.ceil(1.0));

        //质数问题
        System.out.println("求不超过给定数的所有质数。");
        int zhs, chs, n1;                   //zhs:质数，chs:除数
        System.out.println("请输入正整数n的值：");
        n1 = new Scanner(System.in).nextInt();
        System.out.printf("答：不超过%d的质数有：", n1);
        for (zhs = 2; zhs <= n1; zhs++)
        {// 例如16 = 1*16,2*8,4*4,8*2，16*1，，中间对称，所以只要遍历到开方
            for (chs = 2; chs < Math.sqrt(zhs); chs++)
                if (zhs % chs == 0)
                    break;              //如果还存在一个能够比2大的数chs整除，那么就不是质数。
            if (chs > Math.sqrt(zhs))   //如果遍历到开方中间以上，那么chs会递增到一个大于zhs开方的数，此时zhs自然就是质数。
                System.out.printf("%d ", zhs);
        }

        // 数位转换，逆序数。例如将1234567转换为7654321
        System.out.println("请输入 a1= ");
        int a1 = sc.nextInt();
        int b1 = 0;
        while (a1 > 0){
            b1 = b1 * 10 + a1 % 10;  //取余挨个将个位提出来
            a1 = a1 / 10;            //求商逐渐将个位去掉
        }
        System.out.println("转换为 b1 = " + b1);

        //分解因式问题
        int yz=2, k;                    //yz:因子
        System.out.println("求给定数分解的因式相乘。");
        System.out.print("请输入正整数k的值：");
        k = sc.nextInt();
        System.out.print(k + "的分解因式为");
        while (k > 1)
        {
            if (k % yz == 0)
            {
                System.out.print(yz);
                k = k / yz;
                if (k > 1)
                    System.out.print(" * ");
            }
            else
                yz++;
        }

        // 耶稣门徒问题
        int[] members = new int[13];
        int member = 0, number = 0, i = 0;
        //number报号，member记出圈的人数，i索引
        while (member < 12){
            if (members[i] == 0){
                number++;
                if (number == 3){
                    members[i] = 1;
                    member++;
                    number = 0;
                }
            }
            //取数组的下一个索引，i=13后又回到0
            i = (i + 1) % 13;
        }
        for (i = 0; i < 13; i++){
            if (members[i] == 0)
                System.out.println("犹大是第" + (i + 1) + "个人");
        }

        //星阵问题
        //第一种：n*n
        int r1, c0;
        System.out.print("①表示n*n型星阵，请输入n的值：");
        int N1 = sc.nextInt();
        for (r1 = 1; r1 <= N1; r1++)
        {
            for (c0 = 1; c0 <= N1; c0++)
                System.out.print("*");
            System.out.println();
        }
        //第二种：左依次递增
        int r2, c2;
        System.out.print("②表示左依次递增型星阵，请输入n的值：");
        int N2 = sc.nextInt();
        for (r2 = 1; r2 <= N2; r2++)
        {
            for (c2 = 1; c2 <= r2; c2++)
                System.out.print("*");
            System.out.println();
        }
        //第三种：右依次递增
        int r3, c3;
        System.out.print("③表示右依次递增型星阵，请输入n的值：");
        int N3 = sc.nextInt();
        for (r3 = 1; r3 <= N3; r3++)
        {
            for (c3 = 1; c3 <= N3-r3; c3++)
                System.out.print(" ");           //每一行中空格与列数是互补关系
            for (c3 = 1; c3 <= r3; c3++)
                System.out.print("*");
            System.out.println();
        }
        //第四种：三角塔
        int r4, c4;
        System.out.print("④表示三角塔型星阵，请输入n的值：");
        int N4 = sc.nextInt();
        for (r4 = 1; r4 <= N4; r4++)
        {
            for (c4 = 1; c4 <= N4 - r4; c4++)
                System.out.print(" ");
            for (c4 = 1; c4 <= (2 * r4 - 1); c4++)
                System.out.print("*");
            System.out.println();
        }
        //第五种：对称三角塔
        int r5, c5;
        System.out.print("⑤表示对称三角塔型星阵，请输入n的值：");
        int N5 = sc.nextInt();
        for (r5 = 1; r5 <= N5; r5++)
        {
            for (c5 = 1; c5 <= N5 - r5; c5++)
                System.out.print(" ");
            for (c5 = 1; c5 <= (2 * r5 - 1); c5++)
                System.out.print("*");
            System.out.println();
        }
        for (r5 = N5; r5 >= 1; r5--)
        {
            for (c5 = 1; c5 <= N5 - r5; c5++)  //第一行0个空格
                System.out.print(" ");
            for (c5 = 1; c5 <= (2 * r5 - 1); c5++)
                System.out.print("*");         //第一行(2*N5-1)个*
            System.out.println();
        }
        //第六种：三角形（中心挖空）
        int r6, c6;
        System.out.print("⑥表示三角形（中心挖空）星阵，请输入n的值：");
        int N6 = sc.nextInt();
        for (r6 = 1; r6 <= N6; r6++)
        {
            for (c6 = 1; c6 <= N6 - r6; c6++)
                System.out.print(" ");
            System.out.print("*");
            for (c6 = 1; c6 < 2 * (r6 - 1); c6++)
                System.out.print(" ");
            if (r6 > 1)
                System.out.print("*");
            System.out.println();
        }
        //第七种：对称三角形（中心挖空）
        int r7, c7;
        System.out.print("⑥表示对称三角形（中心挖空）星阵，请输入n的值：");
        int N7 = sc.nextInt();
        for (r7 = 1; r7 <= N7; r7++)
        {
            for (c7 = 1; c7 <= N7 - r7; c7++)
                System.out.print(" ");
            System.out.print("*");
            for (c7 = 1; c7 < 2 * (r7 - 1); c7++)
                System.out.print(" ");
            if (r7 > 1)
                System.out.print("*");
            System.out.println();
        }
        for (r7 = N7; r7 >= 1; r7--)
        {
            for (c7 = 1; c7<= N7- r7; c7++)
                System.out.print(" ");
            System.out.print("*");
            for (c7= 1; c7 < 2 * (r7 - 1); c7++)
                System.out.print(" ");
            if (r7> 1)
                System.out.print("*");
            System.out.println();
        }
    }
}
