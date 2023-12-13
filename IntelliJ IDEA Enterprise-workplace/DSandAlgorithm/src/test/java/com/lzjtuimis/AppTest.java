package com.lzjtuimis;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Collections;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    static int[] huffmanNodes = {2,9,4,5,3,6};
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    public static void main(String[] args) {
        // 删除线性表元素，自动前移，需要从后向前删除
        int[] a = {1, 2, 3, 4, 5};
        LinkedList<Integer> arrayList = new LinkedList<>();
        for (int i:a) {
            arrayList.add(i);
        }
        System.out.println(arrayList);
        // 删除索引为偶数的元素
        for(int i = arrayList.size()-1;i>=0;i--)
            if(i%2==0)
                arrayList.remove(i);
        System.out.println(arrayList);

        System.out.println(Double.MAX_VALUE);
        int[] index = twoMinValueIndex(5);
        System.out.println(Arrays.toString(index));

    }
    // 寻找已知数组中值最小的两个数的索引，返回数组
    public static int[] twoMinValueIndex(int latest){
        int[] index = new int[2];
        double[] weight = new double[2];
        weight[0] = weight[1] = Double.MAX_VALUE;

        for(int i=0;i<latest;i++){
                if(huffmanNodes[i] < weight[0]){
                    index[1] = index[0];
                    weight[1]= weight[0];
                    index[0] = i;
                    weight[0] = huffmanNodes[i];
                }
                else if(huffmanNodes[i] < weight[1]){
                    index[1] = i;
                    weight[1] = huffmanNodes[i];
                }
        }
        return index;
    }

}
