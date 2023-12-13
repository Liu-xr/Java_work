package com.lzjtuimis._5_matrix;

import org.junit.Test;

public class TestArray {
    @Test
    public void symmetricArray(){
        // 二维对称矩阵输出
        Integer[][] array = {{1,2,3},{2,1,2},{3,2,1}};
        for (Integer[] a:array) {
            for (int b:a) {
                System.out.print(b);
            }
            System.out.println();
        }
        SymmetricArray<Integer> symmetricArray = new SymmetricArray<>(array, array.length);
        symmetricArray.display();
        System.out.println("存储到的一维数组长度为：" + symmetricArray.getLength());
        System.out.println("索引12处的值为：" + symmetricArray.getValue(1,2));
        symmetricArray.assign(9, 2, 1);
        System.out.println("修改索引21处的值为9后的显示，同理索引12处值也被修改保持对称");
        symmetricArray.display();
    }

    @Test
    public void triangleArray(){
        // 二维对称矩阵输出
        Integer[][] array = {{1,0,0},{2,1,0},{3,2,1}};
        for (Integer[] a:array) {
            for (int b:a) {
                System.out.print(b);
            }
            System.out.println();
        }
        TriangleArray<Integer> triangleArray = new TriangleArray<>(array, array.length);
        triangleArray.display();
        System.out.println("存储到的一维数组长度为：" + triangleArray.getLength());
        System.out.println("索引12处的值为：" + triangleArray.getValue(1,2));
        triangleArray.assign(9, 2, 1);
        System.out.println("修改索引21处的值为9后的显示：");
        triangleArray.display();
    }

    @Test
    public void diagonalArray() {
         int[][] array = {{1,1,0,0,0},{1,1,1,0,0},{0,1,1,1,0},{0,0,1,1,1},{0,0,0,1,1}};
        for (int[] a:array) {
            for (int b:a) {
                System.out.print(b);
            }
            System.out.println();
        }
        DiagonalArray diagonalArray = new DiagonalArray(array, 5, 1);
        diagonalArray.display();
    }
}
