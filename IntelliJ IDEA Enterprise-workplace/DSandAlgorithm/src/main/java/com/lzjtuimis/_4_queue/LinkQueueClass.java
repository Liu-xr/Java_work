package com.lzjtuimis._4_queue;


//链队泛型类
public class LinkQueueClass<E> implements IQueue<E>{
    LinkNode<E> front;							//首结点指针，即队首结点，无头结点
    LinkNode<E> rear;							//尾结点指针

    //构造方法
    public LinkQueueClass(){
        front = null;
        rear = null;
    }

    @Override
    public boolean empty(){
        return front==null;
    }

    @Override
    public void clear() { front = rear = null; }

    @Override
    public void offer(E e){
        LinkNode<E> s = new LinkNode<E>(e);		//新建结点s
        if (empty())							//原链队为空，队首和队尾结点都指向该新的第一个结点
            front = rear = s;
            //原链队不空
        else{
            rear.next = s;						//将s结点链接到rear队首结点后面
            rear = s;
        }
    }

    @Override
    public E poll(){
        E e;
        if (empty())							//原链队不空
            throw new IllegalArgumentException("队空");
        //原链队只有一个结点
        if (front == rear){
            e = front.data;					//取首结点值
            front = rear = null;					//置为空
        }
        //原链队有多个结点
        else{
            e = front.data;					//取首结点值
            front = front.next;					//front指向下一个结点
        }
        return e;
    }

    @Override
    public E peek(){
        if (empty())
            throw new IllegalArgumentException("队空");
        return (E)front.data;
    }

    @Override
    public int size() {
        LinkNode<E> p = new LinkNode<>();
        int size = 0;
        while(p.next != rear){
            size++;
            p = p.next;
        }
        return size;
    }

    public String toString(){
        StringBuilder ans = new StringBuilder();
        if (!empty()){
            LinkNode<E> p = front;
            while (p!=null){
                ans.append(p.data.toString()).append(" ");
                p = p.next;
            }
        }
        return ans.toString();
    }
}

//链队结点泛型类
class LinkNode<E>{
    E data;
    LinkNode<E> next;

    public LinkNode(){
        next=null;
    }
    //重载构造方法
    public LinkNode(E d){
        data = d;
        next = null;
    }
}
