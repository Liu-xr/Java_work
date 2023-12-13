package com.lzjtuimis._6_binarytree;

import org.junit.Test;

public class TestBinaryTree {
    @Test
    public void traverse(){
        String str = "A(B(D,F(E)),C(G(,H),I))";
        BinaryTree<String> binaryTree = new BinaryTree<>(str);
        System.out.println("先序遍历：");
        binaryTree.preRootTraverse(binaryTree.root);
        System.out.println("\n中序遍历：");
        binaryTree.middleRootTraverse(binaryTree.root);
        System.out.println("\n后序遍历：");
        binaryTree.postRootTraverse(binaryTree.root);
        System.out.println("\n层次遍历：");
        binaryTree.levelTraverse();
        System.out.println("\n======非递归遍历======");
        System.out.println("先序非递归遍历：");
        binaryTree.preOrderTraverse();
        System.out.println("\n中序非递归遍历：");
        binaryTree.middleOrderTraverse();
        System.out.println("\n叶子节点数目：" + binaryTree.countLeafNode(binaryTree.root));
        System.out.println("所有节点数目：" + binaryTree.countNode(binaryTree.root));
    }
}
