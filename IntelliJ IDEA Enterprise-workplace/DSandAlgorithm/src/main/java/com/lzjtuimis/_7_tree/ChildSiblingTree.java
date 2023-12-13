package com.lzjtuimis._7_tree;

import com.lzjtuimis._4_queue.IQueue;
import com.lzjtuimis._4_queue.LinkQueueClass;

public class ChildSiblingTree<T> {
    public CSNode<T> root;

    public ChildSiblingTree(CSNode<T> root) {
        this.root = root;
    }

    // 查找第一个孩子结点
    public CSNode<T> getFirstChild(CSNode<T> node) {
        return node.firstChild;
    }

    // 查找一个结点的下一个相邻兄弟结点
    public CSNode<T> getNextSibling(CSNode<T> node) {
        return  node.nextSibling;
    }

    // 与二叉树先序递归遍历相似
    public void preRootTraverse(CSNode<T> T) {
        if (T!=null) {
            System.out.print(T.data);
            preRootTraverse(T.firstChild);
            preRootTraverse(T.nextSibling);
        }
    }

    // 与二叉树中序递归遍历相似
    public void postRootTraverse(CSNode<T> T) {
        if (T!=null) {
            postRootTraverse(T.firstChild);
            System.out.print(T.data);             //先输出孩子结点，之后输出同层的兄弟结点。因为第一个孩子结点链兄弟结点
            postRootTraverse(T.nextSibling);
        }
    }

    // 层序
    public void levelTraverse() {
        IQueue<CSNode<T>> queue = new LinkQueueClass<>();
        queue.offer(root);
        CSNode<T> p = root;
        // 根节点开始，兄弟结点左到右进队
        while(p.nextSibling!=null) {
            queue.offer(p.nextSibling);
            p = p.nextSibling;
        }
        // 兄弟结点左到右出队，有第一个孩子进队后再把该孩子的兄弟进队，依次反复。
        while (!queue.empty()){
            p = queue.poll();
            System.out.print(p.data);
            if(p.firstChild!=null) {
                p = p.firstChild;
                queue.offer(p);
                while (p.nextSibling != null) {
                    queue.offer(p.nextSibling);
                    p = p.nextSibling;
                }
            }
        }
    }

}

class CSNode<T> {
    T data;
    CSNode<T> firstChild;      // 存储第一个孩子
    CSNode<T> nextSibling;     // 存储该节点的第一个兄弟

    public CSNode(T data, CSNode<T> firstChild, CSNode<T> nextSibling) {
        this.data = data;
        this.firstChild = firstChild;
        this.nextSibling = nextSibling;
    }

    @Override
    public String toString() {
        return  data.toString();
    }
}