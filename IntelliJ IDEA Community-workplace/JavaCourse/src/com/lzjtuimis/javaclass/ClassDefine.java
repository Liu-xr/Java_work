package com.lzjtuimis.javaclass;

import com.lzjtuimis.javabase.test;

public class ClassDefine {
    public static void main(String[] args) {
        Students s1 = new Students("20200105120", "刘兴瑞",
                '男', "信息管理与信息系统", 2002);

        s1.printMessage();
        System.out.println(s1.sname + "的年龄周岁实际为19岁");

        s1.setGrade(88, 90);
        int grade_1 = s1.getGrade();
        System.out.printf("%1$s的课程1成绩为： %2$s\n", s1.sname, grade_1);
        int grade_all = s1.getGrade(true);
        System.out.printf("%1$s的课程1、2的成绩总分为： %2$s\n", s1.sname, grade_all);
        byte a = 1;
        s1.a(a);

    }
}

class Students{

    // 三个default属性
    String sno;
    String sname;
    char ssex;

    // 两个public属性
    public int sage;
    public String sdept;

    // 两个private属性
    private int grade_1;
    private int grade_2;

    public Students(String sno,String sname, char ssex, String sdept, int birth_year){
        //this();  调用自身的构造方法，也就是下面的Students()
        this.sno = sno;
        this.sname = sname;
        this.ssex = ssex;
        this.sdept = sdept;
        setsage(birth_year);
    }

    @test
    public Students(){
        System.out.println("11");
    }

    private void setsage(int birth_year){
        sage = 2022 - birth_year;
    }

    // getGrade()的方法重载
    public int getGrade(){
        return grade_1;
    }

    public int getGrade(boolean a){
        if (a)
            return  grade_1 + grade_2;
        else
            return 0;
    }

    void setGrade(int... grade){
        this.grade_1 = grade[0];
        this.grade_2 = grade[1];
    }

    void printMessage(){
        System.out.println("学号：" + sno + "\n姓名：" + sname + "\n性别：" +
                ssex + "\n年龄：" + sage + "\n所在系：" + sdept);
    }

    void a(long a){
        System.out.println("long类型" + a);
    }

    void a(int a){
        System.out.println("int类型" + a);
    }

}


