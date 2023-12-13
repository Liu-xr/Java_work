package MainPackage;

public class MainClass {
	int a = 1;
	int b = 2;
	String c = "MainClass";
	
	public MainClass() {
		System.out.println("a:" + a);
		System.out.println("b:" + b);
		System.out.println("c:" + c);
	}
	
	public MainClass(int a, int b, String c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}

}
