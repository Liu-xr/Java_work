package com.lzjtuimis._6_binarytree;

import org.junit.Test;

public class TestSeqBTree {
    @Test
    public void displayPath(){
        /*  字符串结点 */
        // 建立深度为3，结点数为7的简单完全二 叉树
        String[] strings = {"1","2","3","4","5","6","7"};
        SeqBTree<String> seqBTree = new SeqBTree<>(strings);
        // 查找序号为6的路径,即结点值7的路径
        System.out.println("从root根结点到序号为6的路径为：");
        seqBTree.displayPath(6);

        /* 族谱结点 */
        Family f1 = new Family("001","祖父","男");
        Family f2 = new Family("002","父亲","男");
        Family f3 = new Family("003","伯父","男");
        Family f4 = new Family("004","我","男");
        Family f5 = new Family("005","弟弟","男");
        Family f6 = new Family("006","堂兄","男");
        Family f7 = new Family("007","堂弟","男");
        Family f8 = new Family("008","儿子","男");
        Family f9 = new Family("009","女儿","女");
        Family f10 = new Family("010","侄子","男");
        Family[] families = {f1,f2,f3,f4,f5,f6,f7,f8,f9,f10};
        SeqBTree<Family> seqBTree1 = new SeqBTree<>(families);
        // 查找序号为9的结点路径，即侄子010的血系
        seqBTree1.displayPath(9);
        // 查找序号为7的结点路径，即儿子008的血系
        seqBTree1.displayPath(7);

    }
}

class Family{
    String id;
    String address;
    String sex;

    public Family(String id, String address, String sex) {
        this.id = id;
        this.address = address;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return  id + ",  " + address;
    }
}