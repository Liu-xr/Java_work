package thread;

public class lambdaThread {
	public static void main(String[] args) {
		// 原匿名类使用
		new Thread(new Runnable() {	
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		});
		
		// lambda表达式
		new Thread(() -> {
			System.out.println("111");
		});
		
		new Thread(() -> System.out.println("111"));
	}

}
