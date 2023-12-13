package com.lzjtuimis._1_linearlist;

import com.lzjtuimis.entity.Student;
import org.junit.Test;

import java.util.Comparator;

public class TestLinkList {
    // 选择排序，整数单链表
    public static void selectSort(LinkListClass<Integer> list){
        LinkNode<Integer> q = list.head.next;
        while(q != null){
            LinkNode<Integer> p = q.next;
            while(p != null){
                if(q.data > p.data) {     // 结点的数据元素的交换
                    Integer tmp = p.data;
                    p.data = q.data;
                    q.data = tmp;
                }
                p = p.next;
            }
            q = q.next;
        }
    }
    // 逆置，整数单链表
    public static void Reverse(LinkListClass<Integer> L){
        LinkNode<Integer> p = L.head.next;	//p指向首结点
        LinkNode<Integer> q;				//
        L.head.next = null;					//将L置为一个空表，只有头结点，用于存储倒置后的结点
        while (p!=null){
            q = p.next;						// q临时保存p结点，达到遍历部分链表（只有首结点到尾结点部分）的作用
            // 头插法，先插进去的会是最后一个结点，理解顺序上，先第2步，再第一步
            p.next = L.head.next;			// 每次新插入的结点p要连接上，上一次插入的结点
            L.head.next = p;				// 每次新插入的结点p也都会是头结点的next，变为首结点

            p = q;
        }
    }

    @Test
    public void testSort(){
        Integer [] d = {1,6,3,9,5};
        // 选择排序，逆置
        LinkListClass<Integer> L1 = new LinkListClass<>();
        L1.CreateListR(d);
        System.out.println(L1);
        selectSort(L1);
        System.out.print("选择排序：" + L1);
        Reverse(L1);
        System.out.print("逆置：" + L1);

        // 插入排序：整数单链表
        LinkListClass<Integer> L = new LinkListClass<>();
        L.CreateListR(d);
        L.insertSort(Comparator.comparingInt(o -> o));
        System.out.print("插入排序：" + L);
        // 插入排序：比较器学生对象单链表
        LinkListClass<Student> linkListClass = new LinkListClass<>();
        Student[] students = {new Student("01", "张三", 1),
                new Student("04", "李四", 19),
                new Student("06", "王五", 6),
                new Student("03", "赵六", 3),
                new Student("20", "刘兴瑞", 20)};
        linkListClass.CreateListF(students);
        linkListClass.insertSort(Comparator.comparing(Student::getNo));  // 对象的字符串字段比较
        System.out.println(linkListClass);
        linkListClass.reverse();
        System.out.print("Student单链表逆置：\n" + linkListClass);
    }

    public static void main(String[] args) {

       // 基本运算算法测试
        System.out.println("====测试1====");
        Integer [] a={1,2,3,4,5};
        LinkListClass<Integer> L1=new LinkListClass<Integer>();
        L1.CreateListR(a);
        System.out.println("L1: "+L1.toString());
        System.out.println("L1长度="+L1.size());
        L1.add(10);
        System.out.println("L1: "+L1.toString());
        System.out.println("求每个序号的元素值");
        for (int i=0;i<L1.size();i++)
            System.out.println("  序号"+i+"的元素值:"+L1.getElem(i));
        System.out.println("重新置长度为5");
        L1.setSize(5);
        System.out.println("L1: "+L1.toString());
        int i=1;
        int x=20;
        System.out.println("序号"+i+"位置插入"+x);
        L1.insert(i,x);
        System.out.println("L1: "+L1.toString());
        i=3;
        System.out.println("删除序号"+i+"的元素");
        L1.delete(i);
        System.out.println("L1: "+L1.toString());
        i=2; x=16;
        System.out.println("设置序号"+i+"的元素值为"+x);
        L1.setElem(i,x);
        System.out.println("L1: "+L1.toString());
        x=5;
        System.out.println("值为"+x+"的元素序号为"+L1.indexOf(x));

      /*  System.out.println();

        System.out.println("====测试2====");
        Character [] b={'a','b','c','d','e','f'};
        LinkListClass<Character> L2=new LinkListClass<Character>();
        L2.CreateListR(b);
        System.out.println("L2: "+L2.toString());
        System.out.println("L2长度="+L2.size());
        L2.add('x');
        System.out.println("L2: "+L2.toString());
        System.out.println("求每个序号的元素值");
        for (i=0;i<L2.size();i++)
            System.out.println("  序号"+i+"的元素值:"+L2.getElem(i));
        System.out.println("重新置长度为5");
        L2.setSize(5);
        System.out.println("L2: "+L2.toString());
        i=1;
        char y='y';
        System.out.println("在序号"+i+"位置插入"+y);
        L2.insert(i,y);
        System.out.println("L2: "+L2.toString());
        i=3;
        System.out.println("删除序号"+i+"的元素");
        L2.delete(i);
        System.out.println("L2: "+L2.toString());
        i=2; y='z';
        System.out.println("设置序号"+i+"的元素值为"+y);
        L2.setElem(i,y);
        System.out.println("L2: "+L2.toString());
        y='d';
        System.out.println("值为"+y+"的元素序号为"+L2.indexOf(y));*/
    }

}
