package com.Lineartable;


public class 双链表{
    //交换p和q结点的data和freq
	private static void swap(DLinkNode1<Integer> p, DLinkNode1<Integer> q){
        // 交换data
		int tmp = p.data;
		p.data = q.data; 
        q.data = tmp;
        // 交换freq
		tmp = p.freq;
		p.freq = q.freq; 
        q.freq = tmp;
	}	
	//查找数据元素为x的结点
	public static boolean LocateElem(DLinkListClass1<Integer> L, Integer x){
		DLinkNode1<Integer> p = L.dhead.next;							//p指向开始结点（首结点）
        // 遍历完结束循环或找到x结束循环
		while (p!=null && !p.data.equals(x))
			p = p.next;
        //未找到值为x的结点返回false
		if (p==null)
			return false;						
		p.freq++;								//找到值为x的结点p，频数加个1
		DLinkNode1<Integer> pre = p.prior;		// 定义数据为x的结点p的前驱结点
        //若p结点的freq比前驱结点pre大,两者数据值交换
		while (pre!=L.dhead && pre.freq<p.freq){	
            swap(pre,p);
            //p、pre同步前移遍历，依次向前比较大小
			p = pre; pre = p.prior;					
		}
		return true;							//成功找到值为x的结点返回true
	}
    //测试结果输出的算法
	public static void Find(DLinkListClass1<Integer> L, Integer x){
		System.out.println("查找值为：" + x + " 的结点");
		if (LocateElem(L,x))
			System.out.println("====查找成功,双链表L按照freq属性递减顺序排列为: " + L.toString());
		else
			System.out.println("====查找失败");
	}
	public static void main(String[] args){
		Integer [] a=  {1,2,3,4,5};
		DLinkListClass1<Integer> L = new DLinkListClass1<Integer>();
		L.CreateListR(a);		// 尾插法整体建立双链表
		System.out.println("L: " + L.toString());
		Find(L,5);
		Find(L,5);
		Find(L,5);  // 最后数据值为5的结点的freq属性为3
		Find(L,4);
        Find(L,0); // 查找失败
		Find(L,4);
   }   
}


//双链表结点泛型类
class DLinkNode1<E>								
{
	E data;										
	int freq;									//结点访问频度		
	DLinkNode1<E> prior;						//前驱结点指针
	DLinkNode1<E> next;							//后继结点指针
	public DLinkNode1(){	
		freq = 0;
		prior = null;	
      next = null;
	}
	public DLinkNode1(E d){
		freq = 0;	
      data = d;
		prior = null;	
      next = null;
	}
}
//双链表泛型类
class DLinkListClass1<E>{
	DLinkNode1<E> dhead;						//存放头结点
	public DLinkListClass1(){
		dhead = new DLinkNode1<E>();				//创建头结点，无数据元素的存放
		dhead.prior = null;
		dhead.next = null;
	}
	//尾插法：由数组a整体建立双链表
	public void CreateListR(E[] a){
		DLinkNode1<E> s,t;
		t = dhead;								//t始终指向尾结点,开始时指向头结点
		for (int i=0;i<a.length;i++){	
          s = new DLinkNode1<E>(a[i]);		//新建存放a[i]元素的结点s
			t.next = s;							//将s结点插入t结点之后
			s.prior = t; t = s;					// t继续指向新插入结点完成更新
		}
		t.next = null;							//将尾结点的next字段置为null
	}

	public String toString(){
      StringBuffer str = new StringBuffer();
		DLinkNode1<E> p = dhead.next;
		while (p!=null){
			str.append(p.data + "["+p.freq+"]" + " ");
			p = p.next;
		}
		return str.toString();
	}
}