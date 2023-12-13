package com.lzjtuimis._4_queue;

@SuppressWarnings("unchecked")
//循环队列泛型类
class SeqQueueClass<E> implements IQueue<E>{
    final int MaxSize = 100;							//假设容量为100
    private E [] data;								    //存放队列中的元素
    private int front, rear;							//队头队尾指针

    //构造方法
    public SeqQueueClass(){
        data = (E[])new Object[MaxSize];
        front = 0;
        rear = 0;
    }

    @Override
    public boolean empty(){
        return front==rear;
    }

    @Override
    public void clear() {
        data = (E[])new Object[MaxSize];
        front = rear = 0;
    }

    @Override
    // 进队
    public void offer(E e){
        if ((rear + 1) % MaxSize == front)				  //队满
            throw new IllegalArgumentException("队满");
        data[rear] = e;
        rear = (rear+1) % MaxSize;
    }

    @Override
    // 出队
    public E poll(){
        if (empty())							        	//队空
            throw new IllegalArgumentException("队空");
        E temp = data[front];
        front = (front+1) % MaxSize;
        return temp;
    }

    @Override
    public E peek(){
        if (empty())								       //队空
            throw new IllegalArgumentException("队空");
        return data[front];
    }

    @Override
    public int size(){
        return (rear - front + MaxSize) % MaxSize;
    }

    @Override
    public String toString(){
        StringBuilder ans= new StringBuilder();
        if (!empty()){
            int p = front;
            do {
                ans.append(data[p]).append(" ");
                p = (p + 1) % MaxSize;
            } while (p != rear);
        }
        return ans.toString();
    }
}
