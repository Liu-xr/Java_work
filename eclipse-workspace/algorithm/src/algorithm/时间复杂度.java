package algorithm;


public class 时间复杂度 {
	public static void main(String[] args) {
		//1. 二重循环
		long t1 = System.currentTimeMillis();
		int sum = 0, t = 0;
		for(int i = 1;i<=1000;i++) {	
			t = 0;
			for(int j = 1; j<=i;j++)
				t += j;	
			sum += t;
		}
		long t2 = System.currentTimeMillis();
		System.out.println(sum);
		System.out.println("方法一执行时间：" + (t2-t1));
		
		// 2. 单重迭代
		t1 = System.currentTimeMillis();
		double i = 1;
		double m = 0;
		sum = 0;
		while(i <= 1000) {
			m = i*(i+1)/2;
			sum += m;
			i++;
		}
		t2 = System.currentTimeMillis();
		System.out.println(sum);
		System.out.println("方法二执行时间：" + (t2-t1));
		
		// 3. 公式计算
		t1 = System.currentTimeMillis();
		int n = 1000;
		sum = n*(n+1)*(n+2)/6;
		t2 = System.currentTimeMillis();
		System.out.println(sum);
		System.out.println("方法三执行时间：" + (t2-t1));
	}

}
