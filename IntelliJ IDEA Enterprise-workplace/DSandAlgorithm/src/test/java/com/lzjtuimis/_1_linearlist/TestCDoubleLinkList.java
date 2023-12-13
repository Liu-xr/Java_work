package com.lzjtuimis._1_linearlist;

import org.junit.Test;

public class TestCDoubleLinkList {
    @Test
    public void reverse(){
        Integer [] d = {1,6,3,9,5};
        CDoubleLinkListClass<Integer> L = new CDoubleLinkListClass<>();
        L.CreateListR(d);
        System.out.println(L);
        L.reverse();
        System.out.println("整数循环双链表逆置：");
        System.out.println(L);
    }

    public static void main(String[] args) {
        System.out.println("====测试1====");
        Integer [] a={1,2,3,4,5};
        CDoubleLinkListClass<Integer> circleDL=new CDoubleLinkListClass<Integer>();
        circleDL.CreateListR(a);
        System.out.println("circleDL: "+ circleDL);
        System.out.println("L1长度="+circleDL.size());
        circleDL.add(10);
        System.out.println("circleDL: "+ circleDL);
        System.out.println("求每个序号的元素值");
        for (int i=0;i<circleDL.size();i++)
            System.out.println("  序号"+i+"的元素值:"+circleDL.getElem(i));
        System.out.println("重新置长度为5");
        circleDL.setSize(5);
        System.out.println("circleDL: "+ circleDL);
        int i=1;
        int x=20;
        System.out.println("序号"+i+"位置插入"+x);
        circleDL.insert(i,x);
        System.out.println("circleDL: "+ circleDL);
        i=3;
        System.out.println("删除序号"+i+"的元素");
        circleDL.delete(i);
        System.out.println("circleDL: "+ circleDL);
        i=2; x=16;
        System.out.println("设置序号"+i+"的元素值为"+x);
        circleDL.setElem(i,x);
        System.out.println("circleDL: "+ circleDL);
        x=5;
        System.out.println("值为"+x+"的元素序号为"+circleDL.indexOf(x));
    }
}
