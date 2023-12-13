package com.lzjtuimis._4_queue;

import org.junit.Test;

public class TestQueue {
    @Test
    public void TestSeq() {
        // 循环顺序队
        Integer [] a={1,2,3,4,5};
        SeqQueueClass<Integer> qu1= new SeqQueueClass<>();
        for (Integer integer : a) {
            qu1.offer(integer);
            System.out.println("进队元素: " + integer);
            System.out.println("队头元素: " + qu1.peek());
        }
        System.out.println("qu1为空: "+qu1.empty());
        System.out.println("qu1: "+qu1);
        System.out.println("出队操作");
        Integer e;
        while (!qu1.empty())
        {
            System.out.println("队头元素: "+qu1.peek());
            e=qu1.poll();
            System.out.println("出队元素: "+e);
        }
        System.out.println("qu1: "+qu1);
        System.out.println("qu1为空: "+qu1.empty());
    }

    @Test
    public void TestLink(){
        // 链队
        Integer [] a={1,2,3,4,5};
        LinkQueueClass<Integer> st1= new LinkQueueClass<>();
        for (Integer integer : a) {
            st1.offer(integer);
            System.out.println("进队元素: " + integer);
        }
        System.out.println("st1为空: "+st1.empty());
        System.out.println("st1: "+ st1);
        Integer e;
        while (!st1.empty())
        {
            e=st1.poll();
            System.out.println("出队元素: "+e);
        }
        System.out.println("st1为空: "+st1.empty());
    }
}
