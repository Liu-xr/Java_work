package 类_4;

public class Main4_16 {
	public static void main(String[] args) {
		Employee employee = new Employee("张三", 25, "男", 5555);
		Employee employee2 = new Employee();
		System.out.println("Employee类的ID为：" + Employee.ID);
		employee.play();
		employee2.sing();
		
		Manager manager = new Manager();
		System.out.println(manager.position);
		
	}

}

abstract class Role{
	protected String name;
	private int age;         // 私有变量，不可被继承
	protected String sex;
	
	public Role() {
		
	}

	public Role(String name, int age, String sex) {
		this();            // this调用本类的构造方法
		this.setName(name);// this调用本类的成员方法
		this.name = name;  // this调用本类的成员变量
		this.age = age;
		this.sex = sex;
	}

	abstract void play();
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getSex() {
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
}

class Employee extends Role{
	int salary;
	static String ID;

	public Employee() {
		super.getAge();           // super调用父类的成员方法
		ID = "1001"; // super调用父类的成员变量
	}

	public Employee(String name, int age, String sex, int salary) {
		super(name, age, sex);   // super调用父类构造方法
		this.salary = salary;
	}

	@Override
	void play() {
		// TODO Auto-generated method stub
		System.out.println("扮演Employee角色");
	}
	
	final void sing() {
		System.out.println("final void sing()方法");
	}
}

class Manager extends Employee{
	final String position = "部门经理";
}