package com.lzjtuimis.javaclass;

public class ClassExtends {
    public static void main(String[] args) {
        A.b(2);
        B.b(4);

        C c = new C();
    }
}


class A {
    A() {
        System.out.println("A");
    }
    A(int a) {}

    void a() {}

    // 在类中使用其他类的类属性
    int a = B.b;

    static void b(int a) {
        System.out.println("123");
    }

    static void b() {}   // 静态方法的重载
}


class B extends A {
    static int b = 1;

    void a(int a) {} //重写父类方法a()

    B() {
        System.out.println("B");
    } //创建B类对象时，默认执行父类A的无参构造函数

    static void b(int a, int b) {} //重写父类静态方法b()

    void d() {}
}


class C extends B {
    C() {}   // 创建C类对象时，依次执行A、B和C的构造函数
}
