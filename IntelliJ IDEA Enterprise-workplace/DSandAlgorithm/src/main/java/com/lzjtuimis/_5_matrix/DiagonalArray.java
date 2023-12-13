package com.lzjtuimis._5_matrix;

// 对角矩阵存储结构
public class DiagonalArray {
    int[] data;
    int n;
    int d;
    int length;
    
    public DiagonalArray(int n, int d){
        length = n * (2*d+1);
        data = new int[length];
        this.n = n;
        this.d = d;
    }

    // 带状二维数组存储
    public DiagonalArray(int [][] array,int n, int d) {
        this.n = n;
        this.d = d;
        length = n * (2*d+1);
        data = new int[length];
        // 存储
        for (int i = 0; i < n; i++) {      // 赋值非空元素
            for (int j = 0; j<n; j++) {
                if(Math.abs(i-j)<=d){     // 非空元素满足条件，行数i固定，j距离主对角线不能超过半带宽。
                    int k = i*(2*d+1)+d+(j-i);
                    data[k] = array[i][j];
                }
            }
        }
    }

    public int getLength(){
        return n*n;
    }

    public int getValue(int i, int j){
        int k = i*(2*d+1)+d+(j-i);
        return data[k] ;
    }

    public void assign(int e, int i, int j){
        int k =  i*(2*d+1)+d+(j-i);
        data[k] = e;
    }

    public void display(){
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++)
                if(Math.abs(i-j)<=d)   //输出带状非零元素
                    System.out.print(" " + getValue(i, j) + " ");
                else
                    System.out.print(" 0 ");
            System.out.println();
        }
    }
}
