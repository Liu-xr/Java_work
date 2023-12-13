package com.Stack;


public class 顺序栈 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("测试1");
		int [] b={1,3,2,4};
		solve(b);

		System.out.println("测试2");
		int [] c={4,3,1,2};
		solve(c);
	}

	// 记录进出栈
	static String op="";

	public static boolean isSerial2(int[] b){
			int n = b.length;
			Integer e;     // 出栈元素
			SqStackClass<Integer> st = new SqStackClass<Integer>();	//建立一个顺序栈
			int i = 0, j = 0;
	        //进栈和b数组出栈均没有遍历完
			while (i<n && j<n){
	            //栈空或者栈顶元素不是b[j],进栈
				if (st.empty() || (st.peek()!=b[j])){
					st.push(i+1);					
					op += "  元素"+(i+1)+"进栈\n";
					i++;
				}
	            //否则出栈
				else{	
	                e=st.pop();
					op += "  元素"+e+"出栈\n";			
					j++;
				}
			}
	        //将顺序栈中还未出栈且对比b出栈序列相同的元素出栈
			while (!st.empty() && j<n && st.peek()==b[j]){	
	            e = st.pop();
				op += "  元素"+e+"出栈\n";
				j++;
			}
	        // 若最后b数组的元素都能出栈（遍历完）则true
			if (j==n)
				return true;						
			else
				return false;						
	}
		
	//求解算法
	public static void solve(int[] b){
			for (int i=0;i<b.length;i++)
				System.out.print(" "+b[i]);
			if (isSerial2(b)){
				System.out.println("是合法的出栈序列");
				System.out.println(op);
				op = "";
			}
			else{
				System.out.println("不是合法的出栈序列");
	    		System.out.println(op);
	    		op = "";
	        }
	}
}




//顺序栈泛型类
class SqStackClass<E>{
	final int initcapacity = 10;						//顺序栈的初始容量(常量)
	private int capacity;    							//存放顺序栈的容量
	private E[] data;									//数组data，存放顺序栈中元素
	private int top;    								//存放栈顶指针
    
    //构造方法，实现data和size的初始化
	@SuppressWarnings("unchecked")
	public SqStackClass(){
		data = (E[])new Object[initcapacity];		//Object类强制转换为E类型数组，向下造型
		capacity = initcapacity;
		top = -1;
	}
    
    //改变顺序栈的容量为newcapacity
	private void updatecapacity(int newcapacity){
		@SuppressWarnings("unchecked")
		E[] newdata = (E[])new Object[newcapacity];
		for (int i=0;i<top;i++)						//复制原来的元素
			newdata[i] = data[i];
		capacity = newcapacity;						//设置新容量
		data = newdata;								//仍由data标识数组
	}
	
//判断栈是否为空
	public boolean empty(){
		return (top == -1);
	}

//元素e进栈
	public void push(E e){
		if (top == capacity-1)						//顺序栈空间满时倍增容量,top为索引值要+1
			updatecapacity(2 * (top + 1));
		top++;										//栈顶指针增1
		data[top] = e;
	}

//出栈操作
	public E pop(){
		if (empty())
			throw new IllegalArgumentException("栈空");
		E e = data[top];
		top--;
		if (top+1 > initcapacity && top+1 == capacity/4) 	//满足条件则容量减半
			updatecapacity(capacity/2);
		return e;
	}

//取栈顶元素操作
	public E peek(){
		if (empty())
			throw new IllegalArgumentException("栈空");
		return (E)data[top];
	}

//将栈转换为字符串,不是基本运算，仅仅调试用
	public String toString(){
		String ans = "";
		for (int i=0;i<=top;i++)
			ans += data[i].toString()+" ";
		return ans;
	}

}
