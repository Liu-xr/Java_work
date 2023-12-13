package com.lzjtuimis._7_tree;

import com.lzjtuimis._4_queue.IQueue;
import com.lzjtuimis._4_queue.LinkQueueClass;

@SuppressWarnings("unchecked")
public class ParentChildTree<T> {
    public PCNode<T>[] nodes;

    public ParentChildTree(int size) {
        nodes = new PCNode[size];
    }
    public ParentChildTree(T[] element, int[] parent, ChildNode[] childNodes) {
        createTree(element, parent, childNodes);
    }

    // 返回结点在数组索引
    public int indexOf(PCNode<T> node){
        for(int i = 0;i<nodes.length;i++)
            if(node == nodes[i])
                return i;
        return -1;
    }

    // 整体创建树
    public void createTree(T[] element, int[] parent, ChildNode[] childNodes) {
        this.nodes = new PCNode[element.length];
        for(int i=0;i<nodes.length;i++){
            nodes[i] = new PCNode<>(element[i],parent[i], childNodes[i]);
        }
    }

    // 查找双亲结点
    public PCNode<T> getParent(int index){
        return nodes[nodes[index].parent];
    }

    // 查找第一个孩子结点
    public PCNode<T> getFirstChild(int index) {
        if(nodes[index].firstChild != null)
            return nodes[nodes[index].firstChild.index];
        return null;
    }

    // 查找一个结点的下一个相邻兄弟结点
    public PCNode<T> getNextSibling(int index) {
        int parent = nodes[index].parent;              // 先找到该节点的双亲结点
        if(parent==-1)                                // 根节点没有兄弟结点
            return null;
        ChildNode p = nodes[parent].firstChild;     // 该双亲结点的孩子链表的第一个结点
        while(p!=null){									// 遍历孩子链表
            if(p.index == index)						// 如果其中一个孩子结点的索引与该节点一样
                break;
            p = p.nextChild;
        }
        if(p!=null&&p.nextChild!=null)
            return nodes[p.nextChild.index];      // 那么下一个孩子结点就是该节点的下一个兄弟结点
        return null;       // 无孩子链表返回空
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

class ChildNode{
    public int index;
    public ChildNode nextChild;

    public ChildNode(int index, ChildNode nextChild){
        this.index = index;
        this.nextChild = nextChild;
    }

}

class PCNode<T>{
    public T data;
    public int parent;
    public ChildNode firstChild;

    public PCNode(T data, int parent, ChildNode firstChild) {
        this.data = data;
        this.parent = parent;
        this.firstChild = firstChild;
    }

    public PCNode(T data, ChildNode firstChild){     // 创建根节点
        this(data, -1,firstChild);
    }

    @Override
    public String toString() {
        return data.toString();
    }
}