package com.lzjtuimis._7_tree;

import org.junit.Test;

public class TestTree {

    @Test
    public void testPTree(){
        String[] data = {"A","B","C","D","E","F","G","H","I","J","K","L"};
        int[] parent = {-1,0,0,0,1,1,2,3,3,3,5,8};
        ParentTree<String> parentTree = new ParentTree<>(data, parent);
        System.out.println("查找结点E的双亲结点：" + parentTree.getParent(4));
        System.out.println("查找结点D的第一个孩子结点：" + parentTree.getFirstChild(3));
        System.out.println("查找结点H的下一个兄弟结点：" + parentTree.getNextSibling(7));
        System.out.println("先序遍历：");
        parentTree.prevTraverse(0);
        System.out.println("\n后序遍历：");
        parentTree.postTraverse(0);
        System.out.println("\n层序遍历：");
        parentTree.levelTraverse();
    }

    @Test
    public void testPCTree(){
        // 建立孩子链表
        ChildNode childD = new ChildNode(3, null);
        ChildNode childC = new ChildNode(2, childD);
        ChildNode childB = new ChildNode(1, childC);
        ChildNode childF = new ChildNode(5, null);
        ChildNode childE = new ChildNode(4 , childF);
        ChildNode[] childNodes = {childB, childE, null,null,null,null};

        String[] data = {"A","B","C","D","E","F"};
        int[] parent = {-1,0,0,0,1,1};

        ParentChildTree<String> parentChildTree = new ParentChildTree<>(data, parent, childNodes);
        System.out.println("查找结点B的双亲结点：" + parentChildTree.getParent(1));
        System.out.println("查找结点B的第一个孩子结点：" + parentChildTree.getFirstChild(1));
        System.out.println("查找结点B的下一个兄弟结点：" + parentChildTree.getNextSibling(1));
        System.out.println("先序遍历：");
        parentChildTree.prevTraverse(0);
        System.out.println("\n后序遍历：");
        parentChildTree.postTraverse(0);
        System.out.println("\n层序遍历：");
        parentChildTree.levelTraverse();
    }

    @Test
    public void testCSTree(){
        CSNode<String> csNodeF  = new CSNode<>("F", null,null);
        CSNode<String> csNodeE  = new CSNode<>("E", null,csNodeF);
        CSNode<String> csNodeD = new CSNode<>("D", null,null);
        CSNode<String> csNodeC = new CSNode<>("C",csNodeD,null);
        CSNode<String> csNodeB = new CSNode<>("B", csNodeE,csNodeC);
        CSNode<String> csNodeA = new CSNode<>("A",csNodeB,null);

        ChildSiblingTree<String> childSiblingTree = new ChildSiblingTree<>(csNodeA);
        System.out.println("查找结点B的第一个孩子结点：" + childSiblingTree.getFirstChild(csNodeB));
        System.out.println("查找结点B的下一个兄弟结点：" + childSiblingTree.getNextSibling(csNodeB));
        System.out.println("先序遍历：");
        childSiblingTree.preRootTraverse(csNodeA);
        System.out.println("\n后序遍历：");
        childSiblingTree.postRootTraverse(csNodeA);
        System.out.println("\n层序遍历：");
        childSiblingTree.levelTraverse();
    }
}
