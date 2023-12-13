package com.lzjtuimis._6_binarytree;

import java.util.Stack;

public class HuffmanTree {
    HuffmanNode[] huffmanNodes;  // 存储结点的数组，最后得到哈夫曼树
    int n;                      // 原数组叶子结点的个数
    double[] weights;          // 存储权值的数组
    Stack<String> huffCode;    // 存储哈弗曼编码

    public HuffmanTree(double[] weights) {
        // 初始化
        this.n = weights.length;
        this.weights = new double[n];
        for(int i=0;i<n;i++)
            this.weights[i] = weights[i];
        huffmanNodes = new HuffmanNode[2*n-1];
        // 原数组中每个根节点赋值
        for(int i=0;i<n;i++)
            huffmanNodes[i] = new HuffmanNode(weights[i]);
        // 构造哈夫曼树
        this.create();
    }

    private void create(){
        for(int i=n;i<2*n-1;i++){
            int[] index = twoMinValueIndex(i);
            // 新生成根节点的左右孩子来源设置
            huffmanNodes[i] = new HuffmanNode(huffmanNodes[index[0]].weight + huffmanNodes[index[1]].weight);                          // 权值相加构造新的根节点
            huffmanNodes[i].lChild = index[0];
            huffmanNodes[i].rChild = index[1];
            // 选取的两个根节点的双亲与加入设置
            for(int j = 0;j<2;j++) {
                huffmanNodes[index[j]].parent = i;
                huffmanNodes[index[j]].flag = true;             // true为结点加入的标志
            }
        }
    }

    // 寻找未加入哈夫曼树的结点中权值最小的两个结点的索引，传递结点数组在添加新的根节点后的新长度
    public int[] twoMinValueIndex(int latest){
        int[] index = new int[2];
        double[] weight = new double[2];
        weight[0] = weight[1] = Double.MAX_VALUE;  // 先赋值double类型最大值，之后的遍历中比较大小而换值

        // 遍历结点数组，长度为原有n个叶子结点 + 新构造成的根节点的个数
        for(int i=0;i<latest;i++){
            // 在未被构造哈夫曼树中找，flag==flase
            if(!huffmanNodes[i].flag){
                if(huffmanNodes[i].weight < weight[0]){
                    index[1] = index[0];
                    weight[1]= weight[0];
                    index[0] = i;
                    weight[0] = huffmanNodes[i].weight;
                }
                else if(huffmanNodes[i].weight < weight[1]){
                    index[1] = i;
                    weight[1] = huffmanNodes[i].weight;
                }
            }
        }
        return index;
    }

    public void display(){
        System.out.printf("%8s","数组序号");
        System.out.printf("%6s","权重");
        System.out.printf("%6s","双亲序号");
        System.out.printf("%6s","左孩子序号");
        System.out.printf("%6s","右孩子序号");
        System.out.println();
        for(int i=0;i<huffmanNodes.length;i++){
            if(i==n)
                System.out.println("=================================================");
            System.out.printf("%8d",i);
            System.out.printf("%8.0f",huffmanNodes[i].weight);
            System.out.printf("%8s",huffmanNodes[i].parent);
            System.out.printf("%8s",huffmanNodes[i].lChild);
            System.out.printf("%8s",huffmanNodes[i].rChild);
            System.out.println();
        }
    }

    // 创建到某一个叶子结点的哈弗曼编码,传递该叶子结点的数组序号
    public void huffmanCode(int nodeIndex){
        huffCode = new Stack<>();
        HuffmanNode leaveNode = huffmanNodes[nodeIndex];
        while(leaveNode.parent != -1){
            HuffmanNode parentNode = huffmanNodes[leaveNode.parent];
            if(huffmanNodes[parentNode.lChild] == leaveNode) // 是左孩子
                huffCode.push("0");
            else if (huffmanNodes[parentNode.rChild] == leaveNode)// 是右孩子
                huffCode.push("1");
            // 循环向上
            leaveNode = parentNode;
        }
        // 输出哈夫曼编码
        while(!huffCode.empty())
            System.out.print(huffCode.pop());
    }
}


class HuffmanNode{
    double weight; 						// 结点的数据域/权值
    boolean flag; 						// 结点是否加入哈夫曼树的标志
    int parent, lChild, rChild;			// 双亲结点、左右孩子结点序号

    public HuffmanNode(){ 				// 构造一个空结点
        this(0);
    }

    public HuffmanNode(double weight){  // 构造带权值的单结点
        this.weight = weight;
        flag = false;
        parent = lChild = rChild = -1;
    }

}