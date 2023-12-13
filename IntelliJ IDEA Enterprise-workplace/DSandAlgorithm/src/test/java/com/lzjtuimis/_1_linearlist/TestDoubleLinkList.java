package com.lzjtuimis._1_linearlist;

import org.junit.Test;

public class TestDoubleLinkList {
    @Test
    public void reverse(){
        Integer [] d = {1,6,3,9,5};
        DoubleLinkListClass<Integer> L = new DoubleLinkListClass<>();
        L.CreateListR(d);
        System.out.println(L);
        L.reverse();
        System.out.println("整数双链表链表逆置：");
        System.out.println(L);
    }

    public static void main(String[] args) {
        System.out.println("====测试1====");
        Integer [] a={1,2,3,4,5};
        DoubleLinkListClass<Integer> L1=new DoubleLinkListClass<Integer>();
        L1.CreateListR(a);
        System.out.println("L1: "+ L1);
        System.out.println("L1长度="+L1.size());
        L1.add(10);
        System.out.println("L1: "+ L1);
        System.out.println("求每个序号的元素值");
        for (int i=0;i<L1.size();i++)
            System.out.println("  序号"+i+"的元素值:"+L1.getElem(i));
        System.out.println("重新置长度为5");
        L1.setSize(5);
        System.out.println("L1: "+ L1);
        int i=1;
        int x=20;
        System.out.println("序号"+i+"位置插入"+x);
        L1.insert(i,x);
        System.out.println("L1: "+ L1);
        i=3;
        System.out.println("删除序号"+i+"的元素");
        L1.delete(i);
        System.out.println("L1: "+ L1);
        i=2; x=16;
        System.out.println("设置序号"+i+"的元素值为"+x);
        L1.setElem(i,x);
        System.out.println("L1: "+ L1);
        x=5;
        System.out.println("值为"+x+"的元素序号为"+L1.indexOf(x));
    }
}
