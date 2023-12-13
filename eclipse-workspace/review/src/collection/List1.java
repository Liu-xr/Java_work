package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class List1 {
	@SuppressWarnings("removal")
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				add(1);
				add(2);
				add(3);
			}
		};
		
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().equals(new Integer(1)))
				iterator.remove();
		}
		System.out.println(list);
		
		// 新建迭代器，上一个以及指针到最后
		Iterator<Integer> iterator1 = list.iterator();
		while(iterator1.hasNext()) {
			System.out.println(iterator1.next());
		}
		
	}



}
