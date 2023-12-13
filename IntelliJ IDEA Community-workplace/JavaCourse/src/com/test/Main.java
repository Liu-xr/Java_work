package com.test;

import com.lzjtuimis.javabase.Array;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        /*
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int a = Integer.parseInt(scanner.nextLine());
        while(n<=0||n>1000&&a>n){
            n = Integer.parseInt(scanner.nextLine());
            a = Integer.parseInt(scanner.nextLine());
        }
        for(int i=0;i<n;i++){
            if(i%a==(a-1)&&i%2==0)
                System.out.println(i);
        }

        int n=10;
        int count = 0;
        int a = 0;
        for(int i=1;i<=n;i++){
            for(int j=2;j<i/2;j++)
                if(i%j==0)
                    count++;
            if(count >=2)
                a++;
        }
        System.out.println(a);

        int n = 10;
        int a = 0;
        for (int i = 1; i <= n; i++) {
            double b = Math.sqrt(Math.pow(i,3));
            if((int) b ==b)
                a++;
        }
        System.out.println(a);
         */

        /*
        * 小明今天收了N个鸡蛋，每个鸡蛋各有重量，现在小明想找M个重量差距最小的鸡蛋摆成一盒出售，输出符合条件的最重一盒鸡蛋的总重量
            输入说明：第一行，鸡蛋个数N(N<1000)  每盒个数M(M<N)；第二行，N个鸡蛋重量（浮点）
            输出说明：符合条件的最重一盒鸡蛋的总重量（保留2位小数）
            输入样例：8 4
            11  9 12 5 10 19 8 6
            输出样例：42.00
        * */
        /*
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Double> arrayList = new ArrayList<>();
        for(int i=0;i<n;i++)
            arrayList.add(scanner.nextDouble());
        Collections.sort(arrayList);
        System.out.println(arrayList);
        double[] fangcha = new double[n-m+1];    // 保存方差
        double[] a = new double[m];             // 保存每M个数用来求其方差

        // 每第i到第i+m个数加入数组并求其方差，再放入方差数组
        int k =0;
        for (int i=0;i<n-m+1;i++){
            for(int j=i;j<i+m&&j<n;j++){
                a[j-i] = arrayList.get(j);
            }
            fangcha[k++] = fangcha(a);
        }
        System.out.println(Arrays.toString(fangcha));
        // 找到方差最小的索引,排序小到大的：从后往前找，方差一样的前提下找最大的;或者判断加上等号
        int min = 0;
        for (int i = 0; i <fangcha.length; i++) {
            if(fangcha[i]<=fangcha[min]){
                min = i;
            }
        }
        System.out.println(min);
        double sum = 0;
        for(int i = min;i<min+m;i++)
            sum += arrayList.get(i);
        System.out.printf("%.2f", sum);
*/
/*
        System.out.println(reverse(1230));
        int n = 123456;
        int m = n;
        while (true){
            int mm = reverse(m);  // 逆序数
            int cha = Math.abs(mm-m);
            if(cha<=200000&&cha>=100000) {
                System.out.println(m);
                break;
            }
            if(m==Integer.MAX_VALUE-1) {
                System.out.println("F");
                break;
            }
            m++;
        }
*/
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Person[] people = new Person[n];
        //只有在读取到有效字符之后，next()方法才将其后的空格键、Tab键或Enter键等视为结束符；所以next()方法不能得到带空格的字符串。
        for (int i = 0; i < n; i++) {
            people[i] = new Person();
            //scanner.nextLine();  // 以Enter为结束读取,也就是说 nextLine()方法返回的是输入回车之前的所有字符，包括空白
            people[i].setId(scanner.next());
            people[i].setColor(scanner.next());
            people[i].setIsInject(scanner.next());
            people[i].setResult(scanner.next());
            people[i].setDays(scanner.nextInt());
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if(people[i].getColor().equals("G")) {
                if (people[i].getId().equals("L")){
                    if (people[i].getResult().equals("C"))
                        count++;
                }
                else{
                    if (people[i].getDays() <= 2)
                        if (people[i].getResult().equals("N"))
                            count++;
                }
            }
        }
        System.out.println(count);

    }

    // 求方差
    public static double fangcha(double[] a) {
        double sum = 0;
        for (double value : a) {
            sum += value;
        }
        double average = sum / a.length;
        double s2 = 0;
        for (double v : a) {
            s2 += Math.pow((average - v), 2);
        }
        return s2 / a.length;
    }

    // 逆序数
    public static int reverse(int a) {
        StringBuffer sa = new StringBuffer(String .valueOf(a));
        StringBuffer as = sa.reverse();
        return Integer.parseInt(String.valueOf(as));
    }
}

class Person{
    String id;
    String color;
    String isInject;
    String result;
    int days;

    public String getId() {
        return id;
    }

    public void setId(String id) throws Exception {
        if(id.equals("L")||id.equals("T"))
            this.id = id;
        else
            throw new Exception("非法参数");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) throws Exception {
        if(color.equals("R")||color.equals("Y")||color.equals("G"))
            this.color = color;
        else
            throw new Exception("非法参数");
    }

    public String getIsInject() {
        return isInject;
    }

    public void setIsInject(String isInject) throws Exception {
        if(isInject.equals("C")||isInject.equals("E"))
            this.isInject = isInject;
        else
            throw new Exception("非法参数");
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) throws Exception {
        if(result.equals("N")||result.equals("P")||result.equals("U"))
            this.result = result;
        else
            throw new Exception("非法参数");
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) throws Exception {
        if(days<=7&&days>=0)
            this.days = days;
        else
            throw new Exception("非法参数");
    }
}
class AAAA{
    public static void main(String[] args) {
        int b =0;
        try{
            int a = 1/b;
        }
        finally {
            int a = 1;
        }
        System.out.println("sss");
    }
}

