package com.lzjtuimis._6_binarytree;

import org.junit.Test;

public class TestHuffmanTree {
    @Test
    public void createHuffman(){
        double[]  weights = {5,6,2,9,7};
        HuffmanTree huffmanTree = new HuffmanTree(weights);
        huffmanTree.display();

        // 测试权值为2的叶子结点的哈弗编码,该节点在原数组的序号为2
//        huffmanTree.huffmanCode(2);

        // 测试所有叶子结点哈弗曼编码
        for(int i =0;i<huffmanTree.n;i++) {
            System.out.print("权值为 " + (int)weights[i] + " 的叶子结点哈夫曼编码为");
            huffmanTree.huffmanCode(i);
            System.out.println();
        }

    }
}
