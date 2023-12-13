package com.lzjtuimis._3_stack;

public interface IStack<E> {
    boolean empty ();//判断栈是否为空，若栈空返回真，否则返回假。

    int length();

    void clear();

    void push ( E e );//进栈操作，将元素 e 插人栈中作为栈顶元素。按压。*

    E pop ();//出栈操作，返回栈顶元素。弹出。

    E  peek ();//取栈顶操作，返回当前的栈顶元素。峰顶。
}
