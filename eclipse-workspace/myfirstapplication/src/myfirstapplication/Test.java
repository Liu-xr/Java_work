package myfirstapplication;


public class Test {
	@SuppressWarnings("null")
	public static void main(String[] args){
		        
		 A aa = new A(1, 2);
		 System.out.println(aa.hashCode());
		 swap(aa);
		 System.out.println(aa.hashCode());
		 System.out.println(aa.a);
		        
		    

	}
		 
	public static  void swap(A a) {
		a = new A(11, 11);
	}
		 

}

class A{
	int a;
	int b;
	
	public A(int a, int b) {
		this.a = a;
		this.b = b;
	}
}