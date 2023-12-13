package 类_4;

public class Main4_3 {
	public static void main(String[] args) {
		Number number = new Number(55, 10);
		System.out.println(number.addition());
		System.out.println(number.subtration());
		System.out.println(number.multiplication());
		System.out.println(number.division());
	}
}

class Number{
	private int n1;
	private int n2;
	
	public Number(int n1, int n2) {
		this.n1 = n1;
		this.n2 = n2;
	}
	
	public int addition() {
		return n1 + n2;
	}
	
	public int subtration() {
		return n1 - n2;
	}
	
	public int multiplication() {
		return n1 * n2;
	}
	
	public double division() {
		return (double)n1 / (double)n2;
	}
	
}
