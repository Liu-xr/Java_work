package com.lzjtuimis._1_linearlist;

public class TestSeqList {
    public static void main(String[] args) {
        // 测试insert方法
        Double [] list = {1.0,2.0,3.0,4.0,5.0};
        SeqListClass<Double> seqListClass=new SeqListClass<>();
        seqListClass.createList(list);
        System.out.println("list: "+seqListClass);
        seqListClass.insert(3,3.5);
        System.out.println("插入元素后list: "+seqListClass);

        System.out.println("*******测试1****************");
        Integer [] a={1,2,3,4,5};
        SeqListClass<Integer> L1=new SeqListClass<>();
        L1.createList(a);
        System.out.println("L1: "+L1);
        System.out.println("L1长度="+L1.size());
        L1.add(10);
        System.out.println("L1: "+L1.toString());
        System.out.println("求每个序号的元素值");
        for (int i=0;i<L1.size();i++)
            System.out.println("  序号"+i+"的元素值:"+L1.getElem(i));
        System.out.println("重新置长度为5");
        L1.setSize(5);
        System.out.println("L1: "+L1.toString());
        int i=1;int x=20;
        System.out.println("在序号"+i+"位置插入"+x);
        L1.setElem(i,x);
        System.out.println("L1: "+ L1);
        i=3;System.out.println("删除序号"+i+"的元素");
        L1.delete(i);
        System.out.println("L1: "+ L1);
        i=2; x=16;System.out.println("设置序号"+i+"的元素值为"+x);
        L1.setElem(i,x);
        System.out.println("L1: " + L1);
        x=1;System.out.println("值为" + x + "的元素序号为"+  L1.indexOf(x));

        System.out.println();

        System.out.println("*******测试2****************");
        Character [] b={'a','b','c','d','e','f'};
        SeqListClass<Character> L2=new SeqListClass<Character>();
        L2.createList(b);
        System.out.println("L2: "+ L2);
        System.out.println("L2长度="+L2.size());
        L2.add('x');
        System.out.println("L2: "+ L2);
        System.out.println("求每个序号的元素值");
        for (i=0;i<L2.size();i++)
            System.out.println("  序号"+i+"的元素值:"+L2.getElem(i));
        System.out.println("重新置长度为5");
        L2.setSize(5);
        System.out.println("L2: "+ L2);
        i=1;
        char y='y';
        System.out.println("在序号"+i+"位置赋值"+y);
        L2.setElem(i,y);
        System.out.println("L2: "+ L2);
        i=3;
        System.out.println("删除序号"+i+"的元素");
        L2.delete(i);
        System.out.println("L2: "+ L2);
        i=2; y='z';
        System.out.println("设置序号"+i+"的元素值为"+y);
        L2.setElem(i,y);
        System.out.println("L2: "+ L2);
        y='y';
        System.out.println("值为"+y+"的元素序号为"+L2.indexOf(y));
    }
}
