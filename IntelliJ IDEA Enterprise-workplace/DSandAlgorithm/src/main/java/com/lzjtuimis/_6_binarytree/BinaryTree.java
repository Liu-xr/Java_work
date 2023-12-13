package com.lzjtuimis._6_binarytree;

import com.lzjtuimis._4_queue.IQueue;
import com.lzjtuimis._4_queue.LinkQueueClass;

import java.util.ArrayList;
import java.util.Stack;

@SuppressWarnings("unchecked")
// 二 叉链表类
public class BinaryTree<E> {
    BTNode<E> root;

    // 构造一棵空树
    public BinaryTree(){
        this.root = null;
    }

    // 构造根结点为root的树
    public BinaryTree(BTNode<E> root) {
        this.root = root;
    }

    // 通过栈和括号表示法字符串构造二 叉树
    public BinaryTree(String str){
        Stack<BTNode<Character>> st = new Stack<>();
        BTNode<Character> p = null;
        boolean flag = true;                        // 控制构造左右 孩子
        int i = 0;
        //循环扫描str中每个字符
        while (i<str.length()) {
            char ch = str.charAt(i);
            switch (ch) {
                case '(':
                    st.push(p);                        //刚刚新建的结点有孩子,将其进栈
                    flag = true;
                    break;
                case ')':
                    st.pop();                        //栈顶结点的子树处理完，出栈
                    break;
                case ',':
                    flag = false;                    //开始处理栈顶结点的右孩子
                    break;
                // ch为字母结点值
                default:
                    p = new BTNode<>(ch);
                    if (root==null)
                        root= (BTNode<E>) p;						//若尚未建立根结点,p作为根结点
                    // 已建立二 叉树根结点
                    else{
                        //新结点p作为栈顶结点的左孩子
                        if (flag){
                            if (!st.empty())
                                st.peek().lChild=p;
                        }
                        //新结点p作为栈顶结点的右孩子
                        else{
                            if (!st.empty())
                                st.peek().rChild=p;
                        }
                    }
                    break;
            }
            i++;                                //继续遍历
        }
    }

    /* 整体构造二 叉树 */
    // 由表明空子树的先序序列
    // 公开创建方法
    public void createBTree(ArrayList<E> list) {
        index=0;
        root = new BTNode<>();
        root = createBTree(root,list);  // 根节点链上左右分支子树
    }
    // 私有递归调用
    static int index=0;
    private BTNode<E> createBTree(BTNode<E> root, ArrayList<E> list) {
        E data = list.get(index++);
        // 空树
        if(data == null){
            return null;
        }
        else{
            root.data = data;     // 递归调用，每次index++，则对于满二 叉树的先序序列，总能按照根-左-右的顺序赋值左右 孩子
            root.lChild = createBTree(new BTNode<>(), list);
            root.rChild = createBTree(new BTNode<>(), list);
            return root;  // 最后根节点是设置好左右分支子树的结点
        }
    }

    // 由二 叉树的顺序存储结构
    public void createBTree(E[] array) {
        BTNode<E>[] nodeArray = new BTNode[array.length];   // 创建二 叉树结点数组
        // 一般二 叉树的空结点存储赋值
        for (int i = 0; i < array.length; i++) {
            E elem = array[i];
            if(elem==null)
                nodeArray[i]=null;
            else
                nodeArray[i] = new BTNode<>(array[i]);
        }
        // 结点数组设置二 叉树左右子树
        for (int i = 0; i < nodeArray.length/2; i++) {
            BTNode<E> node = nodeArray[i];
            if (i*2+1 < nodeArray.length)         // 设置左孩子
            {
                assert node != null;
                node.lChild = nodeArray[i*2+1];
            }
            if (i*2+2 < nodeArray.length)		  // 设置右孩子
                node.rChild = nodeArray[i*2+2];
        }
        root = nodeArray[0]; // 根节点编号0
    }

    // 先序遍历，递归
    public void preRootTraverse(BTNode<E> root) {
        if (root!=null) {
            System.out.print(root.data);    // 输出根节点（每个结点）,也可做其他处理
            preRootTraverse(root.lChild);
            preRootTraverse(root.rChild);
        }
    }

    // 中序遍历，递归
    public void middleRootTraverse(BTNode<E> root) {
        if (root!=null) {
            middleRootTraverse(root.lChild);
            System.out.print(root.data);		 // 输出根节点（每个结点）,也可做其他处理
            middleRootTraverse(root.rChild);
        }
    }

    // 后序遍历，递归
    public void postRootTraverse(BTNode<E> root) {
        if (root!=null) {
            postRootTraverse(root.lChild);
            postRootTraverse(root.rChild);
            System.out.print(root.data);		 // 输出根节点（每个结点）,也可做其他处理
        }
    }

    // 层次遍历
    public void levelTraverse() {
        IQueue<BTNode<E>> queue = new LinkQueueClass<>(); // 自定义链队
        queue.offer(root);						// 先入队根节点root
        while (!queue.empty()){
            BTNode<E> p = queue.poll();
            System.out.print(p.data);        // 输出出队的每个结点
            // 需要判断左右子树是否为空再进队
            if(p.lChild!=null)
                queue.offer(p.lChild);
            if(p.rChild!=null)
                queue.offer(p.rChild);
        }
    }

    // 先序遍历，非递归
    public void preOrderTraverse() {
        Stack<BTNode<E>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BTNode<E> node = stack.pop();
            System.out.print(node.data);
            // 先push右再push左，则pop时实现先访问左再访问右
            if (node.rChild != null)
                stack.push(node.rChild);
            if (node.lChild != null)
                stack.push(node.lChild);
        }
    }

    // 中序遍历，非递归
    public void middleOrderTraverse() {
        Stack<BTNode<E>> stack = new Stack<>();
        stack.push(root);
        BTNode<E> p;
        while (!stack.isEmpty()) {
            while (stack.peek().lChild!=null)      // 沿着左子树若非空压栈
                stack.push(stack.peek().lChild);
            do{
                p = stack.pop();				// 访问出栈结点（既是左结点又可作根节点）
                System.out.print(p.data);
            }while(!stack.isEmpty() && p.rChild==null);  // 出栈的结点有右结点就得进行下面if语句访问右结点
            if(p.rChild!=null)        // 再用if语句判断的是root结点后是否存在的右分支子树
                stack.push(p.rChild);
        }
    }

    // 后序遍历，非递归
    public void postOrderTraverse() {
        Stack<BTNode<E>> stack = new Stack<>();
        stack.push(root);
        BTNode<E> p, q;
        while (!stack.isEmpty()){
            q = stack.peek();
            while(q.rChild!=null || q.lChild!=null){    // 第一次会把root左右节点进栈，之后会沿左分支子树搜索
                if(q.rChild!=null) stack.push(q.rChild);
                if(q.lChild!=null) stack.push(q.lChild);
                q = stack.peek();   // 去栈顶元素判断该while循环是否继续
            }
            do{
                q = stack.pop();
                System.out.println(q.data);
                p = q;    // p指向被访问过的结点    // ↓ 取栈顶元素的左或右结点若被访问则再访问该节点（作为根节点）
            }while(!stack.isEmpty() && (stack.peek().rChild==p || stack.peek().lChild==p));
        }
    }

    //  统计叶子结点数目
    public int countLeafNode(BTNode<E> root){
        if(root == null)
            return 0;
        if (root.lChild == null && root.rChild == null)
            return 1;
        return countLeafNode(root.lChild) + countLeafNode(root.rChild);  //递归找到底
    }

    // 统计所有结点数目
    public int countNode(BTNode<E> root){
        if(root == null)
            return 0;
        return 1 + countNode(root.lChild) + countNode(root.rChild);  // 当前节点1 + 左右 孩子结点，递归完成了查找所有节点
    }
}

//二 叉链结点泛型类
class BTNode<E>{
    E data;										    //数据元素
    BTNode<E> lChild;								//指向左孩子结点
    BTNode<E> rChild;								//指向右孩子结点

    //构造一个空结点
    public BTNode(){
        lChild = rChild = null;
    }
    //构造一个左、右孩子为空的结点
    public BTNode(E data){
        this.data = data;
        lChild = rChild = null;
    }
    // 构造一个数据域和左、右孩子域都不为空的结点
    public BTNode(E data, BTNode<E> lChild, BTNode<E> rChild) {
        this.data = data;
        this.lChild = lChild;
        this.rChild = rChild;
    }
}