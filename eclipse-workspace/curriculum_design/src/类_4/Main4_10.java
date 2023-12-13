package 类_4;

public class Main4_10 {
	public static void main(String[] args) {
		System.out.println(StaticDemo.a);
		System.out.println(new StaticDemo().b);
	}

}

class StaticDemo{
	static int a = 10;
	int b = 5;
}
