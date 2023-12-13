package com.lzjtuimis._6_binarytree;

import java.util.Stack;

@SuppressWarnings("unchecked")
//完全二叉树的顺序式结构
public class SeqBTree<E> {
    E[] data;

    public SeqBTree(int n){
        data = (E[]) new Object[n];
    }

    public SeqBTree(E[] data){
        this.data = (E[])new Object[data.length];
        System.arraycopy(data, 0, this.data, 0, data.length);
    }

    public E getValue(int i){
        if(i<0||i>= data.length)
            throw new IllegalArgumentException("索引异常");
        return data[i];
    }

    public void setValue(int i, E e){
        if(i<0||i>= data.length)
            throw new IllegalArgumentException("索引异常");
        data[i] = e;
    }

    public E getParent(int i){
        // 根节点无双亲
        if(i<=0||i>= data.length)
            throw new IllegalArgumentException("索引异常");
        return data[(i-1)/2];
    }

    public E getlChild(int i){
        if(2*i+1< data.length)
            return data[2*i+1];
        return null;
    }

    public E getrChild(int i){
        if(2*i+2< data.length)
            return data[2*i+2];
        return null;
    }

    // 使用栈寻找第i号结点的路径
    public void displayPath(int i){
        Stack<E> stack = new Stack<>();
        E iE = getValue(i);    // 记录序号为i的结点值
        stack.push(iE);
        while(i != 0){
            stack.push(getParent(i));
            i = (i-1)/2;
        }
        while(!stack.empty()) {
            if(stack.peek() == iE)
                System.out.println(" " + stack.pop());
            else
                System.out.print(" " + stack.pop() + " →");
        }
    }

}


