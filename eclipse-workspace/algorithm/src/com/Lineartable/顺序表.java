package com.Lineartable;

import java.util.Arrays;

public class 顺序表 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {0, 1, 2, 3, 4};
		for(int i = 0;i<a.length;i++)
			if(a[i] == 0||a[i] == 3)
				a[i] = 0;                // 数组数据结构不存在删除元素
		System.out.println(Arrays.toString(a));
		
		int b = 0;
		if(b == 0)return;

	}

}

class SqListClass < E >{			//顺序表泛型类
 	final int initcapacity = 10; 			//顺序表的初始容量（常量）
	public E[] data;						//存放顺序表中的元素
 	public int size;						//存放顺序表的长度
 	private int capacity ;					//存放顺序表的容量
     
    //构造方法，实现 data 和 length 的初始化
 	public SqListClass (){					
 		data =(E[]) new Object [initcapacity];  //强制转换为 E 类型数组
		capacity = initcapacity ;
		size=0;
	}
 	
 	public E getElem(int i) {
 		return data[i];
 	}
 	
 	public int getNo(E e){
 	    int i = -1;
 	    while(i <= size){
 	    	i++;
 	        if(data[i].equals(e))
 	            break;
 	        else
 	            return -1;   
 	    }
		return i;
 	}
 	
 	public String toString(){
 	    StringBuffer str = new StringBuffer();
 	    for(int i = 0;i<size;i++)
 	        str.append(data[i].toString() + " ");
 	    return str.toString();
 	}
}
