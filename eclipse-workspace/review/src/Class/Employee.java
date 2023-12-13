package Class;

public class Employee {
	protected String  id;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	protected String name;
	protected int age;
	protected String adress;
	
	public static void main(String[] args) {
		// TODO
	}
	
	Employee(){
		
	}

	Employee(String id, String name, String age, String address){
		this.id = id;
		this.name = name;
		this.age = Integer.parseInt(age);
		adress = address;
	}
	
	void getMessage(){
		System.out.println("信息为：");
		System.out.println(id + name + age + adress);
	}
	
	boolean getMessage(boolean x){  // 重载
		return true;
	}
}


class Manager extends  Employee{
	private int salary;
	
	public Manager() {
		// TODO Auto-generated constructor stub
	}
	
	Manager(String id, String name, String age, String adress, int salary){  // 继承父类的构造函数
		this.id = id;
		this.name = name;
		this.age = Integer.parseInt(age);
		this.adress = adress;
		this.salary = salary;
	}
	
	void getMessage(){   // 重写
		System.out.println("信息为：");
		System.out.println(id + name + age + adress + salary);
	}
	
}