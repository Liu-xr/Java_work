package com.lzjtuimis._3_stack;

public class LinkStackClass<E> implements IStack<E> {
    StackNode<E> head;						//存放头结点，在栈顶元素上方

    public LinkStackClass(){
        head = new StackNode<E>();				//创建头结点
        head.next = null;						//设置为空栈
    }

    //判断栈是否为空
    @Override
    public boolean empty(){
        return head.next == null;
    }

    @Override
    public int length() {
        int size = 0;
        StackNode<E> p = new StackNode<>();
        while(p.next != null){
            p = p.next;
            size++;
        }
        return size;
    }

    @Override
    public void clear() {
        head.next = null;						//设置为空栈
    }

    //元素e进栈
    @Override
    public void push(E e){
        StackNode<E> s = new StackNode<>(e);
        //将结点s插入到表头，头插法
        s.next = head.next;			// 首结点作栈顶元素，新结点s指向原本的首结点，即s覆盖原首结点成为新的首结点栈顶元素
        head.next = s;				// 首结点s要被头结点指向
    }

    //出栈操作：删除并返回栈顶元素
    @Override
    public E pop(){
        if (empty())
            throw new IllegalArgumentException("栈空");
        E e = head.next.data;						//取首结点值，即取top.data
        head.next = head.next.next;					//删除原首结点，头结点指向原首结点指向的结点（即原第二结点）
        return e;
    }
    //取栈顶元素操作
    @Override
    public E peek(){
        if (empty())
            throw new IllegalArgumentException("栈空");
        return head.next.data;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        if (!empty()) {
            StackNode<E> p = head.next;
            while (p != null) {
                str.append(p.data).append(" ");
                p = p.next;
            }
        }
        return str.toString();
    }
}


//链栈结点泛型类
class StackNode<E>{
    E data;
    StackNode<E> next;

    @Override
    public String toString() {
        return "StackNode{" +
                "data=" + data +
                '}';
    }

    //构造方法
    public StackNode(){
        next = null;
    }

    public StackNode(E d){
        data = d;
        next = null;
    }
}