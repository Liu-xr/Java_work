package com.Lineartable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PolyClass {
	PolyNode head;					//存放多项式单链表头结点
	public static PolyClass Add(PolyClass L1, PolyClass L2){	
        PolyNode s;									
		double c;
		PolyClass L3 = new PolyClass();
		PolyNode t = L3.head;				//t始终指向L3的尾结点
		PolyNode p = L1.head.next;
		PolyNode q = L2.head.next;
		while (p!=null && q!=null){	
            //L1的结点的指数较大
            if (p.exp>q.exp){
				s = new PolyNode(p.coef,p.exp);
				t.next = s; t = s;
				p = p.next;
			}
            //L2的结点的指数较大
			else if (q.exp>p.exp){
				s=new PolyNode(q.coef,q.exp);
				t.next = s; t = s;
				q = q.next;
			}
            //两结点的指数相等
			else{	
                c = p.coef + q.coef;							//求两指数相等结点的系数和c
				if (c!=0){										//系数和c不为0时复制
					s=new PolyNode(c,p.exp);
					t.next=s; t=s;
				}
				p=p.next; q=q.next;
			}
		}
		t.next = null;										//尾结点next置为null
        // 二路归并剩余部分,L3把剩余的结点第一个链接上就可以全部链接上
		if (p!=null) t.next = p;
		if (q!=null) t.next = q;
		return L3;
	}


	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		System.setIn(new FileInputStream("E:\\信息管理与信息系统\\数据结构与算法(Java)\\程序源代码——数据结构教程（Java语言描述）\\ch2\\Application\\abc.in"));	//将标准输入流重定向至abc.in
        Scanner fin = new Scanner(System.in);
    
		PolyClass L1=new PolyClass();
		PolyClass L2=new PolyClass();
		PolyClass L3;
    
		double[] a = new double[100];
		int[] b = new int[100];
		int n = fin.nextInt();							//输入第1个多项式的n
		for (int i=0;i<n;i++) {							//输入第1个多项式系数数组a
			a[i] = fin.nextDouble();
		}
		for (int i=0;i<n;i++) {							//输入第1个多项式指数数组b
			b[i] = fin.nextInt();
		}
    	//创建第1个多项式单链表
		L1.CreatePoly(a,b,n);							
		System.out.print("第1个多项式:  "); 
    	L1.DispPoly();L1.Sort(); 										//第1个多项式按指数递减排序
		System.out.print("排序后结果:   "); 
    	L1.DispPoly();
    
		n = fin.nextInt();								//输入第2个多项式的n
		for (int i=0;i<n;i++) {							//输入第2个多项式系数数组a
			a[i] = fin.nextDouble();
		}
		for (int i=0;i<n;i++) {							//输入第2个多项式指数数组b
			b[i] = fin.nextInt();
		}
    	//创建第2个多项式单链表
		L2.CreatePoly(a,b,n);							
		System.out.print("第2个多项式:  "); 
    	L2.DispPoly();L2.Sort();										//第2个多项式按指数递减排序
		System.out.print("排序后结果:   "); 
    	L2.DispPoly();
    
    	//两多项式相加
		L3 = Add(L1,L2);									
		System.out.print("相加后多项式: "); L3.DispPoly();
	}

	
    
	public PolyClass(){
		head = new PolyNode();		//建立头结点head	
	}
    //采用尾插法建立多项式单链表
	public void CreatePoly(double[] a,int[] b,int n){
		PolyNode s,t;
		t = head;								//t始终指向尾结点,开始时指向头结点
		for (int i=0;i<n;i++){	
            s = new PolyNode(a[i], b[i]);		//创建新结点s
			t.next = s;						    //在t结点之后插入s结点
			t = s;
		}
		t.next = null;						//尾结点next域置为null
	}
    //对多项式单链表按exp域递减排序:pre与p进行双层循环比较，p从第二个开始，每次pre从头开始。比较有作用的区间是pre在p之前，在这块区间内，若pre比p大，那么正好满足大的放前面，不进行任何操作，使得p遍历到下一个；若不满足，则正好交换顺序。
	public void Sort(){
   		// 开始遍历前，pre作为首结点的前驱结点，q作为首结点，p作为首结点的后继结点
		PolyNode pre,p,q;					
        
        // 先测试空表或只有一项不用排序
		q= head.next;				//q指向首结点     
		if (q==null) return;				//原单链表空返回
		p = head.next.next;					//p指向q结点的后继结点，即第二个结点
		if (p==null) return;				//原单链表只有一个数据结点即首结点返回       
        
        //构造一个有序单链表，首先提出原单链表的首结点来到其中
		q.next = null;	
        
        //p从第二个结点表示，开始遍历
		while (p!=null){	
            q = p.next;						//此时的t用于临时保存p结点的后继结点，为了能与p互相完成遍历
            //每次从有序表开头比较, pre指向结点p的前驱结点，即pre.next.next = p
			pre = head;						
            //从首结点，即将pre.next视为一体，开始遍历
			while (pre.next!=null && pre.next.exp > p.exp)
				pre = pre.next;			
            // pre.next结点比p结点小，交换位置
			p.next = pre.next;					//p指针指向pre.next结点
			pre.next = p;						//将pre结点之后插入p结点
            
            //结合q = p.next，相当于p = p.next。并将一开始构造只含有一个数据结点的链表连接起来，完成构造有序的单链表
			p = q;							
		}
	}
    //输出多项式单链表
	public void DispPoly(){	
        boolean first=true;					//first为true表示是第一项
		PolyNode p=head.next;
		while (p!=null){
			if (first) first=false;
			else if (p.coef>0) System.out.print("+");
			if (p.exp==0)					//指数为0时不输出'x'
				System.out.print(p.coef);
			else if (p.exp==1)				//指数为1时不输出指数
				System.out.print(p.coef+"x");
			else
				System.out.print(p.coef+"x^"+p.exp);
			p=p.next;
		}
		System.out.println();
	}
}


//单链表结点类型，即单项式
class PolyNode{	
  public double coef;				//系数
	public int exp;					//指数
	public PolyNode next;			//指针字段
  
	PolyNode(){						// 新建头结点不存储数据
		next = null;
	}
	PolyNode(double c,int e){
		coef = c;
		exp = e;
		next = null;
	}
}