package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Collection1 {
	public static void main(String[] args) {
        /*Set接口与其实现类HashSet*/
       //创建一个hashset对象，默认的初始容量是16
       Set<String> s = new HashSet<>();
       //将命令行的每个字符串加到集合s中，不包含重复元素
       for (String a:args) {
           if(!s.add(a))
               System.out.println("重复元素" + a);
       }
       System.out.println("set集合大小：" + s.size() +"  不同元素有：" + s);  //s能以列表[e1,e2....]形式列出而非其类型


       /* List接口与其实现类ArrayList*/
       int numHands = 2;       //Integer.parseInt(args[0]);  //整数类型转换，转换命令行参数,抽几组牌
       int cardsPerHand = 5;  //Integer.parseInt(args[1]); //每组牌的牌数

       //生成一副牌52张
       String[] suit = {"spades", "hearts", "diamonds", "clubs"};
       String[] rank = {"ace", "2", "3", "4", "5","6","7","8","9","10","jack","queen","king"};
       List<String> deck = new ArrayList<>();
       //花色与牌号组合：deck
       for (String ss:suit)
           for (String sss:rank)
               deck.add(sss +" of "+ ss);
       Collections.shuffle(deck);  //随机改变deck中元素的排列次序，洗牌

       for (int i = 0;i < numHands;i++){
           System.out.println(dealHand(deck, cardsPerHand));
       System.out.println(deck);
       }


       /* Map接口与其TreeMap实现类*/
       String[] words = {"if","it","is","to","be","it","is","up","to","me","to"};
       Integer freq;
       Map<String, Integer> m = new TreeMap<>();

       //构造字符串数组words的单词频率表，以单词为key，以频率为value
       for (String a:words) {   //遍历键
           freq = m.get(a);
           //词频递增
           if (freq == null)
               freq = 1;
           else   //遍历words数组中的元素，再getMap中的值，如果get中已经有存在的元素，+1，不存在就是null，那就出现一次
               freq += 1;
           m.put(a, freq);
       }
       System.out.println(m.get("to")); //to有3个，to对应的值有3个
       System.out.println(m.size() + "个不同的单词查看");
       System.out.println(m);  // 显示为{be=1, if=1, is=2 .....}的形式


       /*迭代器iterator*/
       List<Integer> list = new ArrayList<>();

       //向list中添加元素
       for (int i = 0; i<5; i++){
           list.add(i);
       }
       System.out.println("list初始元素为：" + list);

       // 创建list的iterator
       ListIterator<Integer> listIter = list.listIterator();
       listIter.add(0);  //在序号为0的元素前添加一个元素0
       System.out.println("在开始使用add方法后" + list);

       System.out.println(listIter.previousIndex()); //迭代器从索引0开始迭代，所以previousIndex()返回索引值0
       System.out.println(listIter.previous()); //迭代器从索引0开始迭代，所以previous()返回索引为0的元素

       if(listIter.hasNext()){
           int i = listIter.nextIndex();   //迭代器从索引0开始迭代，所以nextIndex()返回下一个索引值1
           listIter.next();                //迭代器从索引0开始迭代，返回索引为1的元素：0
           listIter.set(9);                //迭代到list中的索引为1的元素，0变成9
           System.out.println("在使用set方法 " + i + ":" + list);
       }

       if(listIter.hasNext()){
           int i = listIter.nextIndex();  //由于上一个操作已返回索引值1，所以i的值将取返回的下一个索引值2
           listIter.next();
           listIter.remove();              //删除索引为2的元素
           System.out.println("在使用remove方法后 " + i + ":" + list);
       }


  }

   public static List<String> dealHand(List<String> deck, int n) {
       //第一个人先抽cardsPerHand张牌后，第二个人在剩余牌中抽，所以clear()方法清空抽走的牌，也就是子list
       int deckSize = deck.size();
       //从deck中截取一个子链表
       List<String> handView = deck.subList(deckSize - n, deckSize);//第一步取子list变量
       List<String> hand = new ArrayList<>(handView);//第二步生成arraylist对象
       handView.clear();//清空子list变量
       return hand; //  返回的是抽取的牌
   }

}
