package com.lzjtuimis._10_search;

import java.util.Comparator;

public class Search {
    /* 静态查找表 */
    // 顺序查找
    public static<T> int seqSearch(T[] elements, T key){
        for(int i=0;i<elements.length;i++){
            if(elements[i].equals(key))
                return i;                   // 返回给定元素在查找表中索引
        }
        return -1;
    }
    // 改进，带监视哨,n表示监视哨位置，高处设置
    public static<T> int seqSearchWithGuard(T[] elements,T key){
        elements[elements.length-1] = key;
        int i = 0;
        while(!elements[i].equals(key)){
            i++;
        }
        if(i!=elements.length-1) return i;
        else return -1;
    }
    // 二分查找
    public static<T> int halfSearch(T[] elements,T key, Comparator<T> comparator){
        int low = 0, high = elements.length-1;
        while(low<=high){
            int mid = (low+high) / 2;
            if(comparator.compare(elements[mid],key)==0)
                return mid;
            else if(comparator.compare(elements[mid],key)<0)
                low = mid+1;
            else
                high = mid-1;
        }
       return -1;
    }
}
