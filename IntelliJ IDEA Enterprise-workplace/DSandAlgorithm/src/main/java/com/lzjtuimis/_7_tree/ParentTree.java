package com.lzjtuimis._7_tree;

import com.lzjtuimis._4_queue.IQueue;
import com.lzjtuimis._4_queue.LinkQueueClass;

@SuppressWarnings("unchecked")
public class ParentTree<T> {
    private PNode<T>[] nodes;

    public ParentTree(int size) {
        nodes = new PNode[size];
    }
    public ParentTree(T[] element, int[] parent) {
        createTree(element, parent);
    }

    // 返回结点在数组索引
    public int indexOf(PNode<T> node){
        for(int i = 0;i<nodes.length;i++)
            if(node == nodes[i])
                return i;
        return -1;
    }

    // 整体创建树
    public void createTree(T[] element, int[] parent) {
        this.nodes = new PNode[element.length];
        for(int i=0;i<nodes.length;i++){
            nodes[i] = new PNode<>(element[i],parent[i]);
        }
    }

    // 查找双亲结点
    public PNode<T> getParent(int index){
        return nodes[nodes[index].parent];
    }

    // 查找第一个孩子结点
    public PNode<T> getFirstChild(int index) {
        for (PNode<T> node : nodes)
            if (node.parent == index)
                return node;
        return null;
    }

    // 查找下一个兄弟结点
    public PNode<T> getNextSibling(int index) {
        int parent = nodes[index].parent;
        for (int i = index+1; i < nodes.length; i++)        // 找到的第一个兄弟和该节点具有同一个双亲
            if (nodes[i].parent == parent)
                return nodes[i];
        return null;
    }

    // 先序
    public void prevTraverse(int index) {
        if(index>=0&&index<nodes.length){
            System.out.print(nodes[index].data);
            prevTraverse(indexOf(getFirstChild(index)));
            prevTraverse(indexOf(getNextSibling(index)));
        }
    }

    // 后序
    public void postTraverse(int index) {
        if(index>=0&&index<nodes.length){
            prevTraverse(indexOf(getFirstChild(index)));
            System.out.print(nodes[index].data);
            prevTraverse(indexOf(getNextSibling(index)));
        }
    }

    // 层序
    public void levelTraverse() {
        IQueue<Integer> queue = new LinkQueueClass<>();
        queue.offer(0);						// 进队根节点索引
        while (!queue.empty()){
            int index = queue.poll();
            System.out.print(nodes[index].data);
            // 遍历数组查找index结点的孩子索引，将其进队
            for(int i=0;i<nodes.length;i++)
                if(nodes[i].parent == index)
                    queue.offer(i);
        }
    }

}


class PNode<T>{
    public T data;                  // 记录数据域
    public int parent;              // 记录该节点的双亲序号

    public PNode(T data, int parent) {
        this.data = data;
        this.parent = parent;
    }

    public PNode(T data){     // 创建根节点
        this(data, -1);
    }

    @Override
    public String toString() {
        return "PNode{" +
                "data=" + data +
                ", parent=" + parent +
                '}';
    }
}