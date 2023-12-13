package com.lzjtuimis._10_search;

import com.lzjtuimis._9_sort.Sort;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class SearchTest {
    @Test
    public void staticTable(){
        Integer[] a = {33,45,96,1,46,83,0,100,3,45,null};
        System.out.println(Search.seqSearchWithGuard(a, 100));

        // 二分查找，有序序列
        Integer[] b = {33,45,45,0,33,45,96,666,46,83,0,10,33,45,96,1,46,83};
        Sort.bubbleSort(b, Comparator.comparingInt(o -> o));
        System.out.println(Arrays.toString(b));
        System.out.println(Search.halfSearch(b, 45, Comparator.comparingInt(o -> o)));

    }

    @Test
    public void dynamicTable(){
        Integer[] a = {33,45,96,1,46,83,0,100,3,45,1};
        BinaryOrderTree<Integer> biOrderTree = new BinaryOrderTree<>();
        int count = 0;
        for (int i:a
             ) {
            Integer c = biOrderTree.search(i,Comparator.comparingInt(o -> o));
            if(c==null)
                count++;
        }
        System.out.println("原序列长度" + a.length);
        System.out.println("插入二叉排序树长度" + count);
        System.out.println("重复项有：" + (a.length-count));
    }

}
