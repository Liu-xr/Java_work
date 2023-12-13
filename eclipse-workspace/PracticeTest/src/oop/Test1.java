package oop;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. 用户类
		new User("001", "123", "1@1").showInfo();

	}

}

/* 1.定义一个用户类 
要处理的信息有用户ID、用户密码、email地址。
属性私有化，对外提供公开的set和get方法
提供无参数构造方法
提供有参数构造方法
提供一个showInfo()方法，通过这个方法展示用户信息。
编写测试程序创建对象，调用showInfo()方法。
*/
class User{
	private String ID;
	private String password;
	private String email;
	
	User(){
		
	}
	
	User(String ID, String password, String email){
		this.ID = ID;
		this.password = password;
		this.email = email;
	}
	
	void showInfo() {
		System.err.println("ID：" + ID +"密码：" + password + "email地址：" + email);
	}
	
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
