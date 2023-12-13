package com.lzjtuimis._10_search;

import java.util.Comparator;

public class BinaryOrderTree<E> {
    BiNode<E> root = null;

    // 查找结点为key 的data值，查找
    public E search(E key, Comparator<E> comparator){
        // 空树，插入根节点并返回
        if (root == null) {
            root = new BiNode<>(key);
            return null;
        }
        BiNode<E> p = root;
        BiNode<E> parent = null; // 记录双亲结点，插入结点时使用
        while(p!=null){
            parent = p;
            int result = comparator.compare(key,p.data);
            if (result==0)
                return p.data;
            else if(result<0)
                p = p.lChild;
            else
                p = p.rChild;
        }
        // return null → turn insert;
        BiNode<E> node = new BiNode<>(key);
        if (comparator.compare(key,parent.data)<0)
            parent.lChild = node;
        else                            // 不存在=，=会查找成功
            parent.rChild = node;
        return null;
    }

    // 查找成功下的删除节点
    public void remove(E key, Comparator<E> comparator){
        BiNode<E> p = root;
        BiNode<E> parent = p;   // 记录双亲结点，删除结点时使用
        while(p!=null){
            int result = comparator.compare(key,p.data);
            if (result==0)
                break;
            else if(result<0){
                parent = p;
                p = p.lChild;
            }
            else{
                parent = p;
                p = p.rChild;
            }
        }
        // 查找不成功 → do nothing
        if(p == null) System.out.println("记录不存在！");
        // 查找成功 → turn remove;
        else{
            /* 前两种情况 */
            if(p.lChild==null||p.rChild==null) {
                // 被删除结点是叶子结点
                if (p.lChild == null && p.rChild == null) {
                    if (p == parent.lChild)
                        parent.lChild = null;
                    if (p == parent.rChild)
                        parent.rChild = null;
                }
                // 被删除结点只有左或右孩子
                else {
                    if (p == parent.lChild)
                        parent.lChild = p.lChild==null?p.rChild:p.lChild;
                    if (p == parent.rChild)
                        parent.rChild = p.lChild==null?p.rChild:p.lChild;
                }
            }
            /* 第三种情况 */
            else{
                /* 找被删节点p的直接前驱q，左子树的最右孩子 */
                BiNode<E> q = p.lChild;
                while(q.rChild!=null){
                    parent = q;             // 记录直接前驱的双亲结点
                    q = q.rChild;
                }
                p.data = q.data;            // 直接前驱的结点值赋给被删节点的data值
                /* 删掉直接前驱q，直接前驱没有右孩子 */
                if(p.lChild == q)           // 1.直接前驱就是被删结点的左孩子
                    p.lChild = q.lChild;
                parent.rChild = q.lChild;   // 2.一般情况
            }
        }

    }

}
//二 叉链结点泛型类
class BiNode<E>{
    E data;										    //数据元素
    BiNode<E> lChild;								//指向左孩子结点
    BiNode<E> rChild;								//指向右孩子结点

    //构造一个空结点
    public BiNode(){
        lChild = rChild = null;
    }

    //构造一个左、右孩子为空的结点
    public BiNode(E data){
        this(data,null,null);
    }

    // 构造一个数据域和左、右孩子域都不为空的结点
    public BiNode(E data, BiNode<E> lChild, BiNode<E> rChild) {
        this.data = data;
        this.lChild = lChild;
        this.rChild = rChild;
    }

    @Override
    public String toString() {
        return "BiNode{" +
                "data=" + data +
                '}';
    }
}