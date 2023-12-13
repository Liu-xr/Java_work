package com.lzjtuimis._5_matrix;


// 下三角矩阵泛型类
@SuppressWarnings("unchecked")
public class TriangleArray<E> {
    private final int length;
    private final int n;
    E[] data;

    public TriangleArray(int n) {
        this.length = n*(n+1)/2;
        this.n = n;
        data = (E[])new Object[length];
    }

    // 对称矩阵存储到数组中
    public TriangleArray(E[][] array, int n) {
        this.n = n;
        length = n*(n+1)/2;
        data = (E[])new Object[length];
        // 存储
        for (int i = 0; i < array.length; i++) {  // 赋值非空元素
            for (int j = 0; j <= i; j++) {
                int k = i * (i + 1) / 2 + j;
                data[k] = array[i][j];
            }
        }
    }

    public int getLength(){
        return length;
    }

    public E getValue(int i, int j){
        int k = 0;
        if (i >= j) {
            k = i * (i + 1) / 2 + j;
        } else {
            return (E) Integer.valueOf(0);
        }
        return data[k] ;
    }

    public void assign(E e, int i, int j){
        int k = 0;
        if (i >= j) {
            k = i * (i + 1) / 2 + j;
        } else {
            return;
        }
        data[k] = e;
    }

    public void display(){
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++)
                System.out.print(" " + getValue(i, j) + " ");
            System.out.println();
        }
    }
}
