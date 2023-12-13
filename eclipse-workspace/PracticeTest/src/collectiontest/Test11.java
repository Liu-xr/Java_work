package collectiontest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/*
 * 1.使用List集合存储5个学生信息。
学生信息：姓名，年龄，成绩。
统计所有姓“张”的同学的平均成绩。

2.产生10个1-100的随机数，并放到一个数组中，
把数组中大于等于10的数字放到一个list集合中，并打印到控制台。

3.把如下元素存入List集合 “aaa” “bbb” “aaa” “abc”“xyz” “123” “xyz” 去掉重复元素
 */
public class Test11 {
	public static void main(String[] args) {
		// 1.
		List<Student> list = new ArrayList<>();
		list.add(new Student("张1", 0, 11));
		list.add(new Student("张2", 0, 12));
		list.add(new Student("张3", 0, 13));
		list.add(new Student("s1", 0, 0));
		list.add(new Student("s2", 0, 0));
		
		int total = 0;
		int count = 0;
		for (Student student : list) {
			if(student.name.startsWith("张")) {
				total += student.grade;
				count++;
			}
		}
		System.out.println("张姓同学的平均成绩为" + total/count);
		
		//2.
		Random random = new Random();
		int[] arr = new int[10];
		List<Integer> list1 = new ArrayList<>();
		
		for(int i = 0;i<10;i++)
			arr[i] = random.nextInt(1, 100);
		System.out.println("10个1到100之间的随机int数数组：");
		System.out.println(Arrays.toString(arr));
		
		for (int i : arr) {
			if(i>10)
				list1.add(i);
		}
		System.out.println("大于10的存储到list集合中");
		System.out.println(list1);
		
		//3.
		List<String> list2 = new ArrayList<>();
		list2.add("aaa");
		list2.add("bbb");
		list2.add("aaa");
		list2.add("abc");
		list2.add("xyz");
		list2.add("123");
		list2.add("xyz");
		System.out.println("有重复元素的list集合");
		System.out.println(list2);
		Set<String> set = new HashSet<>(list2);
		System.out.println("将list集合转换为set集合，查看是否还有重复元素：");
		System.out.println(set);
		// 再将set集合转换为list集合
		List<String> list3 = new ArrayList<String>(set);
	
	}
}

class Student { 
	String name;
	int age;
	int grade;
	
	public Student(String name, int age, int grade) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.age = age;
		this.grade = grade;
	}

	
	public String toString() {
		return "姓名：" + name + " 年龄：" + age + " 成绩：" + grade;
	}
}
/*
class Compara implements Comparator<Student>{  // 自定义比较器
	
	@Override
	public int compare(Student o1, Student o2) {  // 先按成绩降序，一样再按年龄升序
		// TODO Auto-generated method stub
		if(o2.grade - o1.grade == 0)
			return o1.age - o2.age;
		return o2.grade - o1.grade;
		
	}
}
*/