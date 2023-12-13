package customException;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * 编写程序模拟用户注册：
1、程序开始执行时，提示用户输入“用户名”和“密码”信息。
2、输入信息之后，后台java程序模拟用户注册。
3、注册时用户名要求长度在[6-14]之间，小于或者大于都表示异常。

注意：
	完成注册的方法放到一个单独的类中。
	异常类自定义即可。

	class UserService {
		public void register(String username,String password){
			//这个方法中完成注册！
		}
	}

	编写main方法，在main方法中接收用户输入的信息，在main方法
	中调用UserService的register方法完成注册。
	*/
public class UserResignTest {
	public static void main(String[] args) throws LengthLongException {
		Map<String, String> users = new HashMap<>();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("请您接下来输入要保存的用户和密码：");
		String answer;
		while (true) {
			System.out.print("用户名：");
			String username = sc.next();
			System.out.print("密码：");
			String password = sc.next();
			new UserService(users).register(username, password);
			System.out.println("继续输入还是quit结束？");
			answer = sc.next();
			if(answer.equals("quit"))
				break;
			else 
				continue;
		}
		sc.close();
		System.out.println("保存的用户名和密码为：");
		System.out.println(users);
	}

}

class LengthLongException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int length;
	
	public LengthLongException(int length) {
		// TODO Auto-generated constructor stub
		this.length = length;
	}
	
	public void getSomeMessage() {
		if(length<6)
			System.out.println("密码长度太短！");
		else if(length > 14)
			System.out.println("密码长度太长！");
	}
}

class UserService {
	Map<String, String> users;
	
	public UserService(Map<String, String> users) {
		// TODO Auto-generated constructor stub
		this.users = users;
	}
	
	public void register(String username,String password) throws LengthLongException{  // 抛出异常前先在方法名处声明异常
		//这个方法中完成注册！
		if (password.length()<6 || password.length()>14) {
			// 抛出自定义异常并将异常信息打印
			new LengthLongException(password.length()).getSomeMessage();
			throw new LengthLongException(password.length());
		}
		users.put(username, password);
	}
}
