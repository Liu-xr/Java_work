package com.test;

import java.io.*;
import java.lang.reflect.*;
import java.sql.*;

public class Test {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException, NoSuchMethodException, NoSuchFieldException, IllegalAccessException {
        /*
        System.out.println("java开发工具idea");
        System.out.println(666);
        Scanner scan = new Scanner(System.in);

        String s = scan.next();
        System.out.println("go and fuck yourself!\t" + s);
        */

        /* ++i与i++
        int i = 1;
        i = i++;  //i++的i赋值给左边的i，完成，此时i=1。（重点在于i复制给了i，所以并没有执行i++的第二步：i再加一）。
        int j = i++;  //由于是i赋值给j，所以执行了i++的第二步：赋值给j后i再加1，下面i就变成了2。上一步i = 1，所以此时j=1。
        int k = i + ++i * i++; // k = 2 + 3 * (2 + 1),这里的2+1是第一项i=2执行了++i的第二步的结果，此时k=11
        System.out.println(i);
        System.out.println(j);
        System.out.println(k);
        */

        System.out.println("i heat u .".substring(1, 5));  //substring()参数表示起始索引和结束索引

        //引用数据类型，String类与数组的不同函数参数传递
        String d = "oo";
        String f = d;
        f = "kk";
        System.out.println(f + d);

        String[] a = {"lxr", "lxy"};
        for (String i : a)
        {
            System.out.println(i);
        }
      /*  a(a);
        for (String i : a)
        {
            System.out.println(i);

        }*/
        var i = 1;


        char[] cc = {'a','c','d'};
        String str = String.valueOf(cc, 0, 2);
        System.out.println(str);
        StringBuffer s = new StringBuffer();
        s.append("liu xr");
        s.replace(3, 4, "xxxxx");
        System.out.println(s);
        s.delete(3, 4);
        System.out.println(s);

        //递归的极限
        System.out.println(digui(25));
        System.out.println(digui(100));

        String me = "liuxingrui";
        String u = "liuxing";
        String we = me.substring(u.length());  //传递一个参数时是指起始索引到末尾
        System.out.println(we);
        String name = "lxxr";
        int age = 20;
        int[] birthday = {2002, 4, 6};
        A object = new A();
        System.out.println();
        // String类构造函数修饰符
        Class string = name.getClass();
        Constructor con = string.getDeclaredConstructor();
        System.out.println(Modifier.toString(con.getModifiers()));


        Integer A = 1, b = 2;
        change(A, b);
        System.out.println(A);
        System.out.println(b);

    }
    // 使用反射，jdk版本过高不适用
    static void change(Integer a, Integer b) throws  IllegalAccessException, NoSuchFieldException {
        int temp = a;

        Class<? extends Integer> classa = a.getClass();
        Field fielda = classa.getDeclaredField("value");
        fielda.trySetAccessible();
        fielda.setAccessible(true);

        fielda.setInt(a, b);
        fielda.setInt(b, temp);

    }

    public static long digui(long a){
        if(a==1)
            return a;
        else if(a == 0)
            return 1;
        else
            return a * digui(a-1);
    }

   /* public static void a(String @NotNull [] a){
        for (int i =0; i<a.length;i++)
        { a[i] = "0";
            System.out.println(a[i]);}
    }*/

    public static void transform(A a){
        if (a instanceof B){
            B b = (B) a;
            b.put();
        }
        else
            a.a();
    }
}


class A{
    int age;
    static int a = 0;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    void a(){
        System.out.println("Aa");
    }

    public boolean equals(Object obj){
        return this == obj;
    }
    public boolean equals(A a){
        return this == a;
    }

    public void ccc(){
        C.c = 0;
    }

    //内部类
    static class C{
        static int c = 0;
        public void ccc(){
        }
    }

}


class B extends A{
    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }

    int l;
    void a(){
        System.out.println("Ba" +
                "");
    }

    void put(){
        System.out.println("B的put方法");
    }
}


