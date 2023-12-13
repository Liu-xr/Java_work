package collection;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class Map1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//无序，根据hashcode法计算并存储
        Hashtable<String, Integer> hashtable = new Hashtable<>();
        hashtable.put("a", 2);
        hashtable.put("b", 4);
        hashtable.put("d", 1);
        hashtable.put("c", 3);
        System.out.println("hashtable：" + hashtable);

        //keys()方法返回enum枚举类型，再通过方法asIterator()转换为迭代器
        System.out.println("迭代器的while循环遍历键：");
        Iterator<String> iterator = hashtable.keys().asIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("增强的循环遍历值：");
        for (Integer s : hashtable.values()) {
            System.out.println(s);
        }


        //无序，根据hashcode法计算并存储，区别哈希表是可存在null对象
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(0, "B");
        hashMap.put(2, "D");
        hashMap.put(3, "A");
        hashMap.put(1, "C");
        System.out.println("hashmap：" + hashMap);

        //增强的for循环可遍历集合对象
        System.out.println("键的Set对象:");
        for (Integer integer : hashMap.keySet()) {
            System.out.println(integer);
        }
        System.out.println("值的Collection对象:");
        for (String s : hashMap.values()) {
            System.out.println(s);
        }

	}

}
