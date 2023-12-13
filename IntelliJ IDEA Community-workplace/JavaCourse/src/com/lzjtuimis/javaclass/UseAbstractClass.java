package com.lzjtuimis.javaclass;

public class UseAbstractClass {
    public static void main(String[] args) {
        // 定义子类对象，父类为引用变量
        Shape sh = new Circle("圆形", 4);

        /*
        由于定义父类引用变量，所以无法访问子类特有的属性：r，半径
        所以  sh.r;  会报错
        */

        System.out.println(sh.description());
        Shape.count_side(1);

        /* 调用抽象的方法：虽然无法通过sh.r访问子类circle特有的属性：r半径，
        但是在调用下面的方法时，会用到半径r，也就是说从另一个层面间接访问了半径r，
        这是因为创建circle对象时，构造函数初始化了。
         */
        sh.area();
        sh.girth();


        C c = new C();
        c.a(1);
    }
}


abstract class Shape  //定义形状类
{
    // 实例属性 + 雷属性 + final常量
    String description = "凸多边形";
    static String shape_name;
    final double PAI = 3.1415926;

    // 构造函数
    Shape(String shape_name){
        Shape.shape_name = shape_name;
    }

    // 实例方法：返回该类的凸多边形描述
    String description(){
        return description;
    }

    // 类方法：输出该图形的边数
    static void count_side(int count){
        System.out.println(shape_name + "的边有" + count +  "条");
    }

    // 抽象方法：求边长和面积
    abstract void girth();

    abstract  void area();
}


class Circle extends Shape
{
    int r; //圆的半径

    //构造函数：初始化该图形的名字和半径
    Circle(String shape_name, int r){
        super(shape_name);
        this.r = r;
    }

    @Override
    void girth() {
        double girth = 2 * PAI * r;
        System.out.printf("这个%1$s的周长为%2$f \n", shape_name, girth);
    }

    @Override
    void area() {
        double area = PAI * Math.pow(r, 2);
        System.out.printf("这个%1$s的边长为%2$f \n", shape_name, area);
    }
}

class AA{
    void a(int a){
        System.out.println("A的方法a");
    }
}
class BB extends AA{

    void a(String b){
        System.out.println("B的方法b");
    }
}
class CC extends BB{
    CC(){
        super();
        super.a(1);
    }

}
