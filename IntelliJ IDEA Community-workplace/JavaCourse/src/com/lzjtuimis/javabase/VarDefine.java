package com.lzjtuimis.javabase;

public class VarDefine {
    public static void main(String[] args)  {
        // 基本数据类型
        // 1.数值类型
        byte h = 0;
        short z = 1;
        int a = -10;
        float b = 3.14f;
        double c = 2.718;
        long x = 20220303;
        System.out.println(h);
        System.out.println(z);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(x);
        // 2. 字符类型
        char d = 'a';
        char e = '\u0041';
        System.out.println(d);
        System.out.println("unicode的0041表示：" + e);
        // 3. 布尔类型
        boolean f = true;
        boolean g = false;
        System.out.println(f);
        System.out.println(g);
        // 引用数据类型
        //1. 数组
        int[] array = new int[2];
        int aa = array[1] = 1;
        System.out.println(aa);
        //2. String类
        String s = "liuxingrui";
        s = s +  "刘兴瑞";
        StringBuffer s1 = new StringBuffer("信管20级");
        System.out.println(s);
        System.out.println(s1);
        //3. 类
        Person lxr = new Person("刘兴瑞");
        System.out.println(lxr.name + "在"+Person.dept + "专业");

        // 运算符按从左到右运算连接
        String aaa = 4 + 6 + "\tsdfsdfds\t" + 46;  //输出10    sdfsdfds    46
        String bbb = 4 + "\tdscsfs\t" + 6 + 6;   //输出4    dscsfs    66

        int i = 1;
        System.out.println(i+++i+++i++);

    }
}

// 3. 类
class Person{
    public String name;
    public static String dept = "信息管理与信息系统";
    Person(String name){
        this.name = name;
    }
}

//4. 接口
interface collate{
    public int a = 0;
}
