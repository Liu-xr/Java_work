package com.lzjtuimis._5_matrix;

import org.junit.Test;

public class TestTup {
    @Test
    public void sparse(){
        int[][] mat1 = {{0,0,0,1},{0,2,0,0},{0,0,3,1},{0,8,0,1},{4,0,0,0}};
        TupClass tupClass = new TupClass(mat1);
        System.out.println("三元组的稀疏矩阵1显示：");
        tupClass.display();
        System.out.println("其非零元素个数为：" + tupClass.nums);

        //测试转置
        System.out.println("========测试转置========");
        TupClass tupClassT = TupClass.transpose(tupClass);
        System.out.println("稀疏矩阵1的转置显示：");
        tupClassT.display();
        TupClass tupClassT1 = TupClass.fastTranspose(tupClass);
        System.out.println("稀疏矩阵1的快速转置显示：");
        tupClassT1.display();

        //测试加法
        System.out.println("========测试加法========");
        int[][] mat2 = {{0,0,0,2},{1,0,0,0},{0,3,0,0},{0,2,3,1},{0,0,2,0}};
        TupClass tupClass2 = new TupClass(mat2);
        System.out.println("三元组的稀疏矩阵2显示：");
        tupClass2.display();
        System.out.println("其非零元素个数为：" + tupClass2.nums);
        TupClass tupClass3 = tupClass.addition(tupClass2);
        System.out.println("相加后，三元组的稀疏矩阵3显示：");
        tupClass3.display();
        System.out.println("其非零元素个数为：" + tupClass3.nums);



    }
}
