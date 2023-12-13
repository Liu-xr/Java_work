package customThread;

public class newthread implements Runnable
{
	newthread(String name)  //构造函数
	{
		Thread obj = new Thread(this, name); //当前实现runnable接口的类的对象，新线程名
		System.out.println("新线程开始");
		obj.start();  //同时也调用了run()方法。
	}
	
	public void run() //存放新线程需要执行的代码任务
	{
		try {
		for(int i = 0;i<4;i++)
		{
			System.out.println("正在执行新线程第"+(i+1)+"次");			
			Thread.sleep(10);  //程序休眠10ms毫秒
		}
			} 
		catch (InterruptedException e) 
		{
			System.out.println("新线程被打断");
		}
	}
	
	public static void main(String args[])
	{
		new newthread("新线程");  //新建类执行构造函数，即刻开始执行新线程的代码任务
		try
		{
			for(int i = 0;i<4;i++)
			{
				System.out.println("正在执行main线程第"+(i+1)+"次");			
				Thread.sleep(1);
			}
		}
		catch (InterruptedException e) 
		{
			System.out.println("main线程被打断");
		}
		System.out.println("main函数for循环结束");
	}
}
