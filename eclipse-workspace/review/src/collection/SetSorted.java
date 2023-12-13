package collection;

import java.util.Set;
import java.util.TreeSet;

public class SetSorted {
	public static void main(String[] args) {
		Student s1 = new Student("s1", "男", 0, 97);
		Student s2 = new Student("s2", "男", 1, 95);
		Student s3 = new Student("s3", "男", 2, 100);
		Student s4 = new Student("s4", "女", 3, 91);
		Set<Student> set = new TreeSet<>();
		set.add(s1);
		set.add(s2);
		set.add(s3);
		set.add(s4);
		System.out.println(set);
		for (Student student : set) {
			System.out.println(student);
		}
		
	}

}


class Student implements Comparable<Student>{
	String name;
	String sex;
	int age;
	int grade;
	
	public Student(String name, String sex, int age, int grade) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.grade = grade;
	}

	@Override
	public int compareTo(Student o) {  
		// TODO Auto-generated method stub
		return this.grade - o.grade;      // 按照grade属性自小到大排序,升序
		// return o.grade - this.grade;  大到小排序，降序
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "姓名：" + name + "\t性别：" + sex + "\t年龄：" + age + "\t成绩：" + grade;
	}	
	
}