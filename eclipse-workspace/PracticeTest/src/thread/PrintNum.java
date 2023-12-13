package thread;

/*
 * 使用生产者和消费者模式实现，交替输出：
	假设只有两个线程，输出以下结果：
		t1-->1
		t2-->2
		t1-->3
		t2-->4
		t1-->5
		t2-->6
		....

		要求：必须交替，并且t1线程负责输出奇数。t2线程负责输出偶数。
		两个线程共享一个数字，每个线程执行时都要对这个数字进行：++
 */
import java.util.Iterator;

public class PrintNum {
	public static void main(String[] args) {
		Num num = new Num();
		new JiShu(num).start();
		new OuShu(num).start();
		
	}
}

class Num{
	// 对同步的方法（操作）进行通知notify和等待wait操作
	synchronized void add(int count) throws InterruptedException {
		System.out.println(count);
		this.notifyAll();
		this.wait();
	}
}

class JiShu extends Thread{
	Num num;
	
	public JiShu(Num num) {
		// TODO Auto-generated constructor stub
		this.num = num;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i =1;i<=100;i+=2) {
			try {
				num.add(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}

class OuShu extends Thread{
	Num num;
	
	public OuShu(Num num) {
		// TODO Auto-generated constructor stub
		this.num = num;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i =2;i<=100;i+=2)
			try {
				num.add(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	}
}