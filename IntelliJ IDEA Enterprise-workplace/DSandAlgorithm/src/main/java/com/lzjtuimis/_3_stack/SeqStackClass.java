package com.lzjtuimis._3_stack;

@SuppressWarnings("unchecked")
//顺序栈泛型类
public class SeqStackClass<E> implements IStack<E>{
    final int initCapacity = 10;						//顺序栈的初始容量(常量)
    private int capacity;    							//存放顺序栈的容量
    private E[] data;									//数组data，存放顺序栈中元素
    private int top;    								//存放栈顶指针

    //构造方法，实现data和size的初始化
    public SeqStackClass(){
        data = (E[])new Object[initCapacity];		//Object类强制转换为E类型数组，向下造型
        capacity = initCapacity;
        top = -1;
    }

    //改变顺序栈的容量为newCapacity
    private void updateCapacity(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        //复制原来的元素
        if (top >= 0) System.arraycopy(data, 0, newData, 0, top);
        capacity = newCapacity;						//设置新容量
        data = newData;								//仍由data标识数组
    }

    //判断栈是否为空
    @Override
    public boolean empty(){
        return (top == -1);
    }

    //求顺序栈的长度
    @Override
    public int length() {
        return top;
    }

    //清空栈
    @Override
    public void clear(){
        top = -1;
    }

    //元素e进栈
    @Override
    public void push(E e){
        if (top == capacity-1)						//顺序栈空间满时倍增容量,top为索引值要+1
            updateCapacity(2 * (top + 1));
        top++;										//栈顶指针增1
        data[top] = e;
    }

    //出栈操作
    @Override
    public E pop(){
        if (empty())
            throw new IllegalArgumentException("栈空");
        E e = data[top];
        top--;
        if (top+1 > initCapacity && top+1 == capacity/4) 	//满足条件则容量减半
            updateCapacity(capacity/2);
        return e;
    }

    //取栈顶元素操作
    @Override
    public E peek(){
        if (empty())
            throw new IllegalArgumentException("栈空");
        return (E)data[top];
    }

    //将栈转换为字符串,不是基本运算，仅仅调试用
    @Override
    public String toString(){
        StringBuilder ans = new StringBuilder();
        for (int i=0;i<=top;i++)
            ans.append(data[i].toString()).append(" ");
        return ans.toString();
    }

}