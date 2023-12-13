package com.Lineartable;

public class 约瑟夫环问题 {
	public static void main(String[] args) {
		System.out.println("********测试1***********");
		int n=6,m=3;
		Joseph L=new Joseph(n,m);
		System.out.println("n = " + n + ",m = " + m + "的约瑟夫序列");
		System.out.println(L.Jsequence());
        
		System.out.println("********测试2：耶稣门徒***********");
		n=13; m=3;
		L=new Joseph(n,m);
		System.out.println("n = " + n + ",m = " + m + "的约瑟夫序列，即为耶稣门徒问题");
		System.out.println(L.Jsequence());
	}

}


//小孩结点类，将每个小孩看做一个结点
class Child{	
  int no;							// 小孩编号作为数据元素
	Child next;						// 指向下一个结点指针
	public Child(int no1){			// 新建结点构造函数
		no = no1;
		next = null;
	}	
}

//将问题转化为循环单链表，建立求解类
class Joseph{	
  int n, m;						// 总人数n和每次计数m
	Child first;					// 创建首结点，第一个小孩
  
  //构造方法,建立有n个结点的循环单链表
	public Joseph(int n, int m){
      // 前两步用于初始化这个序列
		this.n = n; 
      this.m = m;					
		first = new Child(1);			//第一个小孩
		Child t = first;				//t结点先表示首结点，之后不断更新始终指向单链表的尾结点
      Child p;						// 用于遍历表的表示结点p
      // 将每个小孩围在一起构成循环单链表
		for (int i=2;i<=n;i++){	
          p = new Child(i);			//建立一个编号为i的新结点p，每个小孩
          //将p结点链到末尾，t又作为尾结点
			t.next = p; 
          t = p;			
		}
		t.next = first;				    //首尾相连
	}
  
  //求解约瑟夫环序列
	public String Jsequence(){
		StringBuffer str = new StringBuffer();
		int j;
		Child p;		
      // 循环次数，有多少人，出列多少人，循环多少次
		for (int i=1;i<=n;i++){	
          p = first;			// 每次循环首结点变换位置，循环单链表不受影响，从哪一个结点查找都一样
			j = 1;
          //开始报数，报到第m-1个结点
			while (j<m-1){			
              j++;				//报数递增
				p = p.next;			//结点移动
			}
          //用q指向第m个结点，q用于表示出圈小孩
			Child q = p.next;				    
			str.append(q.no + (i==n?"":"→"));		//该结点的小孩出列
			p.next = q.next;			//删除q结点，p为第m-1个结点，指向q的下一个即m+1个结点
          //从下一个即m+1个结点重新开始
			first = p.next;			    
		}
		return str.toString();
	}
}