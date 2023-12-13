package com.lzjtuimis.javaclass;

public class InnerClass {
}


class Outer{
    static int a = 0;
    int b = 0;

    //外部类访问内部类成员:属性和方法，需要创建内部类对象
    void funt(){
        Inner i = new Inner();
        i.c = b;
        i.fun();
    }

    //内部类无条件访问外部类成员：不需要对外部类创建对象访问
    class Inner{
        int b;   //内外部类相同类属性
        int c = a;  //内部类访问外部类成员：静态属性

        void fun(){
            a = 1;
            Outer.this.b = 0;
            funt();
        }
    }

}