package com.lzjtuimis._4_queue;


import static com.lzjtuimis._4_queue.QueueApplication.yhTriangle;

public class TestApplication {
    public static void main(String[] args) {
        // 杨辉三角
        LinkQueueClass<Integer> queue = new LinkQueueClass<>();
        System.out.println("n=10的杨辉三角：");
        yhTriangle(queue, 10);

        // 后缀表达式求值
        QueueApplication.ExpressClass obj=new QueueApplication.ExpressClass();
        String str="(56-20)/(4+2)";
        obj.setExp(str);
        System.out.println("中缀表达式: "+str);
        obj.Trans();
        System.out.println("后缀表达式: "+obj.getPostExp());
        System.out.println("求值结果:   "+obj.getValue());
        obj.postExp=new StringBuilder();

        str="1+2*3";
        obj.setExp(str);
        System.out.println("中缀表达式: "+str);
        obj.Trans();
        System.out.println("后缀表达式: "+obj.getPostExp());
        System.out.println("求值结果:   "+obj.getValue());
        obj.postExp=new StringBuilder();

        str="2*3+1";
        obj.setExp(str);
        System.out.println("中缀表达式: "+str);
        obj.Trans();
        System.out.println("后缀表达式: "+obj.getPostExp());
        System.out.println("求值结果:   "+obj.getValue());
        obj.postExp=new StringBuilder();

        str="1+3*2";
        obj.setExp(str);
        System.out.println("中缀表达式: "+str);
        obj.Trans();
        System.out.println("后缀表达式: "+obj.getPostExp());
        System.out.println("求值结果:   "+obj.getValue());
        obj.postExp=new StringBuilder();
    }
}

