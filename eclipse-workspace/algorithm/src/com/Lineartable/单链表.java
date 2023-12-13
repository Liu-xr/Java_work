package com.Lineartable;


public class 单链表 {
	public static void main(String[] args) {
		LinkListClass<Integer> L = new LinkListClass<>();
		L.CreateListR(new Integer[]{1, 2, 3});
		Reverse(L);
		System.out.println(L.toString());
	}
	
	// 采用头插法建表思路，p指向首结点，置L为空表，然后遍历L其余的数据结点，将p结点插入单链表L的头部
	public static void Reverse(LinkListClass<Integer> L){
			LinkNode<Integer> p = L.head.next;	//p指向首结点
	    	LinkNode<Integer> q;				// 
			L.head.next = null;					//将L置为一个空表，只有头结点，用于存储倒置后的结点
			while (p!=null){
				q = p.next;						// q临时保存p结点，达到遍历部分链表（只有首结点到尾结点部分）的作用
	            // 头插法，先插进去的会是最后一个结点
				p.next = L.head.next;			// 每次新插入的结点p要连接上，上一次插入的结点
				L.head.next = p;				// 每次新插入的结点p也都会是头结点的next，变为首结点
	            
				p = q;
			}
		}

}

class LinkNode<E>								//单链表结点泛型类
{
	E data;
	LinkNode<E> next;
	public LinkNode() {							//构造方法
		next=null;
	}
	public LinkNode(E d)						//重载构造方法
	{
		data=d;
		next=null;
	}
}
	
class LinkListClass<E>					//单链表泛型类
{
	LinkNode<E> head;							//存放头结点
	public LinkListClass()						//构造方法
	{
		head=new LinkNode<E>();					//创建头结点
		head.next=null;
	}
	private LinkNode<E> geti(int i)				//返回序号为i的结点
	{
		LinkNode<E> p=head;
		int j=-1;
		while (j<i)
		{
			j++;
			p=p.next;
		}
		return p;
	}
	//线性表的基本运算算法	
	public void CreateListF(E[] a)				//头插法：由数组a整体建立单链表
	{
		LinkNode<E> s;
		for (int i=0;i<a.length;i++)			//循环建立数据结点s
		{
			s=new LinkNode<E>(a[i]);			//新建存放a[i]元素的结点s
			s.next=head.next;					//将s结点插入到开始结点之前,头结点之后
			head.next=s;
		}
	}
	public void CreateListR(E[] a)				//尾插法：由数组a整体建立单链表
	{
		LinkNode<E> s,t;
		t=head;									//t始终指向尾结点,开始时指向头结点
		for (int i=0;i<a.length;i++) {			//循环建立数据结点s
			s=new LinkNode<E>(a[i]);			//新建存放a[i]元素的结点s
			t.next=s;							//将s结点插入t结点之后
			t=s;
		}
		t.next=null;							//将尾结点的next字段置为null
	}

	public void Add(E e)						//在线性表的末尾添加一个元素e
	{
		LinkNode<E> s=new LinkNode<E>(e);		//新建结点s
		LinkNode<E> p=head;
		while (p.next!=null)					//查找尾结点p
			p=p.next;
		p.next=s;								//在尾结点之后插入结点s
	}

	public int size()							//求线性表长度
	{
		LinkNode<E> p=head;
		int cnt=0;
		while (p.next!=null)					//找到尾结点为止
		{
			cnt++;
			p=p.next;
		}
		return cnt;
	}
	public void Setsize(int nlen)					//设置线性表的长度
	{
		int len=size();
		if (nlen<0 || nlen>len)
			throw new IllegalArgumentException("设置长度:n不在有效范围内");
		if (nlen==len) return;
		LinkNode<E> p=geti(nlen-1);				//找到序号为nlen-1的结点p
		p.next=null;							//将结点p置为尾结点
	}

	public E GetElem(int i)						//返回线性表中序号为i的元素
	{
		int len=size();
		if (i<0 || i>len-1)
			throw new IllegalArgumentException("查找:位置i不在有效范围内");
		LinkNode<E> p=geti(i);					//找到序号为i的结点p
		return p.data;
	}

	public void SetElem(int i,E e)				//设置序号i的元素为e
	{
		if (i<0 || i>size()-1)
			throw new IllegalArgumentException("设置:位置i不在有效范围内");
		LinkNode<E> p=geti(i);					//找到序号为i的结点p
		p.data=e;
	}

	// 查找第一个为e的数据元素的序号
	public int GetNo(E e){
		int j=0;
		LinkNode<E> p=head.next;	
		while (p!=null){
			j++;								//记录序号，j递增
			if(p.data.equals(e))
				return j;
			p = p.next;
		}
		return -1;    //循环完毕未找到返回-1
	}
	public void swap(int i,int j)				//交换序号i和序号j的元素
	{
		LinkNode<E> p=geti(i);
		LinkNode<E> q=geti(j);
		E tmp=p.data;
		p.data=q.data;
		q.data=tmp;
	}	

	public void Insert(int i, E e)				//在线性表中序号i位置插入元素e
	{
		if (i<0 || i>size())					//参数错误抛出异常
			throw new IllegalArgumentException("插入:位置i不在有效范围内");
		LinkNode<E> s=new LinkNode<E>(e);		//建立新结点s	
		LinkNode<E> p=head=geti(i-1);			//找到序号为i-1的结点p
		s.next=p.next;							//在p结点后面插入s结点
		p.next=s;
	}

	public void Delete(int i) 					//在线性表中删除序号i位置的元素
	{
		if (i<0 || i>size()-1)					//参数错误抛出异常
			throw new IllegalArgumentException("删除:位置i不在有效范围内");
		LinkNode<E> p=geti(i-1);				//找到序号为i-1的结点p
		p.next=p.next.next;						//删除p结点的后继结点
	}
	public String toString()					//将线性表转换为字符串
	{
		StringBuffer str = new StringBuffer();
		LinkNode<E> p = head.next;
		while (p!=null)
		{
			str.append(p.data + " ");
			p = p.next;
		}
		return str.toString();
	}
}
