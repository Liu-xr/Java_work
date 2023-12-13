package com.lzjtuimis._4_queue;

public interface IQueue<E> {
    //判断队列是否为空
    boolean empty();

    // 清空队列
    void clear();

    //元素进队，rear加1
    void offer(E e);

    //元素出队，front加1
    E poll();

    //取队头元素
    E peek();

    //返回队中元素个数
    int size();
}
