package collectiontest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.naming.InterruptedNamingException;

/*
 * 
1.分别用Comparable和Comparator两个接口对下列四位同学的成绩做降序排序，如果成绩一样，
那在成绩排序的基础上按照年龄由小到大排序。

姓名（String）年龄（int）分数（float）
liusan			20				90.0F
lisi		    22				90.0F
wangwu			20				99.0F
sunliu			22				100.0F

编写一个Student类用来实现Comparable<Student>接口,并在其中重写CompareTo(Student o)方法　
在主函数中使用Comparable 与 Comparetor分别对ArrayList进行排序.


2.有2个数组，第一个数组内容为：[黑龙江省,浙江省,江西省,广东省,福建省]，
第二个数组为：[哈尔滨,杭州,南昌,广州,福州]，
将第一个数组元素作为key，第二个数组元素作为value存储到Map集合中。
如{黑龙江省=哈尔滨, 浙江省=杭州, …}

3.定义一个泛型为String类型的List集合，统计该集合中每个字符
（注意，不是字符串）出现的次数。例如：集合中有”abc”、”bcd”两个元素，
程序最终输出结果为：“a = 1,b = 2,c = 2,d = 1”。
 */
public class Test22 {
	public static void main(String[] args) {
		// 1.
		List<Student> list = new ArrayList<>();
		list.add(new Student("lisi", 22, 90));
		list.add(new Student("sunliu", 22, 100));
		list.add(new Student("wangwu", 20, 99));
		list.add(new Student("liusan", 20, 90));
		
		// 匿名类实现比较器
		list.sort(new Comparator<Student>(){
			@Override
			public int compare(Student o1, Student o2) {  // 先按成绩降序，一样再按年龄升序
				// TODO Auto-generated method stub
				if(o2.grade - o1.grade == 0)
					return o1.age - o2.age;
				return o2.grade - o1.grade;
			}
		});
		
		for (Student student : list) {
			System.out.println(student);
		}
		
		// 2.
		String[] province = {"黑龙江省","浙江省","江西省","广东省","福建省"};
		String[] cities = {"哈尔滨","杭州","南昌","广州", "福州"};
		Map<String, String> map = new HashMap<>();
		for(int i =0;i<5;i++)
			map.put(province[i], cities[i]);
		System.out.println(map);
		
		// 3. 
		List<String> list1 = new ArrayList<>();
		list1.add("lxy");
		list1.add("abc");
		list1.add("bcd");
		list1.add("abd");
		list1.add("bcd");
		Map<Character, Integer> map1 = new HashMap<>();
		for (String string : list1) {
			for(char ch:string.toCharArray())
				if(!map1.containsKey(ch))
					map1.put(ch, 1);
				else 
					map1.put(ch, map1.get(ch) + 1);
		}
		System.out.println(map1);
	}
}
