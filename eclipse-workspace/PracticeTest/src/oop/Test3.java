package oop;

public class Test3 {
	public static void main(String[] args) {
		// 第一题
		C cylinder = new Cylinder(new double[] {2.4, 1.6});
		System.out.println("圆柱面积为：" + cylinder.area());
		cylinder.setColor("海茵蓝");
		cylinder.volume();
		
		// 第二题
		System.out.println("乘法运算：4*6");
		new UseCompute().useCom(new Muipity(), 4, 6);
	}

}


/* 第一题：
（1）定义接口A，里面包含值为3.14的常量PI和抽象方法double area()。 
（2）定义接口B，里面包含抽象方法void setColor(String c)。 
（3）定义接口C，该接口继承了接口A和B，里面包含抽象方法void volume()。 
（4）定义圆柱体类Cylinder实现接口C，该类中包含三个成员变量：底圆半径radius、 
圆柱体的高height、颜色color。 
（5）创建主类来测试类Cylinder。
*/
interface A{
	final double PI = 3.14;
	
	double area();
}

interface B{
	void setColor(String c);
}

interface C extends A, B{
	void volume();
}

class Cylinder implements C{
	double radius;
	double height;
	String color;
	
	public Cylinder(double[] c) {
		radius = c[0];
		height = c[1];
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return radius * radius * PI * 2 + height * 2 * PI * radius;
	}
	@Override
	public void setColor(String c) {
		// TODO Auto-generated method stub
		color = c;
		System.out.println("圆柱颜色为：" + color);
		
	}
	@Override
	public void volume() {
		System.out.println("圆柱体积为："+ radius * radius * PI * height);
		
	}
}
/* 第二题：
利用接口做参数，写个计算器，能完成加减乘除运算。
（1）定义一个接口Compute含有一个方法int computer(int n, int m)。
（2）设计四个类分别实现此接口，完成加、减、乘、除运算。
（3）设计一个类UseCompute，类中含有方法：public void useCom(Compute com, int one, int two)，此方法能够用传递过来的对象调用computer方法完成运算，并输出运算的结果。
（4）设计一个主类Test，调用UseCompute中的方法useCom来完成加减乘除运算。
*/
interface Compute{
	int computer(int n, int m );
}

class Plus implements Compute{
	public int computer(int n, int m) {
		return n + m;
	}
}

class Minus implements Compute{
	public int computer(int n, int m) {
		return n - m;
	}
}

class Muipity implements Compute{
	public int computer(int n, int m) {
		return n * m;
	}
}

class Divide implements Compute{
	public int computer(int n, int m) {
		return n / m;
	}
}

class UseCompute{
	public void useCom(Compute com, int one, int two) {
		int result = com.computer(one, two);
		System.out.println("运算结果为：" + result);
	}
}





















