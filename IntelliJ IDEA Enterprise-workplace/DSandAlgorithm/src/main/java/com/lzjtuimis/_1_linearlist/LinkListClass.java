package com.lzjtuimis._1_linearlist;

import com.lzjtuimis.utils.DeepCopy;
import java.util.Comparator;

//单链表泛型类
public class LinkListClass<E extends Comparable<E>> implements LinearList<E>{
    LinkNode<E> head;							// 存放头结点

    public LinkListClass(){						// 构造方法：创建空表
        head = new LinkNode<>();				// 创建头结点，不存储数据元素
        head.next = null;						// 初始化，头结点的指针为null
    }

    //返回序号为i的 <结点>, 广泛用于基本运算算法的查找
    private LinkNode<E> getI(int i){
        LinkNode<E> p = head;
        int j = -1;							// 头结点没有序号，或者序号比0小1，-1
        while (j<i){
            j++;
            p = p.next;
        }
        return p;
    }

    //头插法：由数组a整体建立单链表，建成后的单链表是与数组data的元素次序相反：head → c → b → a
    //时间复杂度O(n)，n为元素个数
    public void CreateListF(E[] a){
        LinkNode<E> s;
        for (E e : a) {            //循环建立数据结点s
            s = new LinkNode<>(e);            //新建存放a[i]数据元素的结点s
            // 相当于插入结点，例如现已插入a结点，则b结点是插入在head头结点和a结点之间。
            s.next = head.next;                    //将s结点插入到开始结点之前,头结点之后
            head.next = s;
        }
    }

    //尾插法：由数组a整体建立单链表，次序一致，将新结点s插入当前链表的表尾上，为此需要增加一个尾指针t，
    // 使其始终指向当前链表的尾结点，时间复杂度O(n)，n为元素个数。
    public void CreateListR(E[] a){
        LinkNode<E> s,t;
        t = head;								//t始终指向尾结点,开始时指向头结点
        for (E e : a) {            //循环建立数据结点s
            s = new LinkNode<>(e);            //新建存放a[i]数据元素的结点s
            // 附加法，从结尾插入，例如已插入a结点：head → a，则此时a作为尾结点要赋值覆盖给t结点
            t.next = s;                            //将s结点插入t结点之后
            t = s;                                // s结点在覆盖当前t结点成为尾结点
        }
        t.next=null;							//将尾结点的next字段置为null
    }

    @Override
    public boolean isEmpty() {
        return head.next == null; // 是否存在首结点
    }

    @Override
    public void add(E e) {
        LinkNode<E> s = new LinkNode<>(e);		//新建结点s
        LinkNode<E> p = head;
        while (p.next != null)					//查找尾结点p，尾结点的指针为null
            p = p.next;
        p.next = s;
    }

    @Override
    public int size() {
        LinkNode<E> p = head;
        int size = 0;
        while (p.next != null){         //找到尾结点为止
            size++;
            p = p.next;
        }
        return size;
    }

    @Override
    public void setSize(int nLen) {
        int len = size();
        if (nLen<0 || nLen>len)
            throw new IllegalArgumentException("设置长度:n不在有效范围内");
        if (nLen == len) return;					// return直接退出方法
        LinkNode<E> p = getI(nLen-1);			   //找到序号为 nLen-1 的结点p
        p.next = null;							   //将结点p置为尾结点，抛去剩下的结点
    }

    @Override
    public E getElem(int i) {
        int len = size();
        if (i<0 || i>len-1)
            throw new IllegalArgumentException("查找:位置i不在有效范围内");
        LinkNode<E> p = getI(i);					//找到序号为i的结点p
        return p.data;                           // 结点的数据元素是E类型
    }

    @Override
    public void setElem(int i, E e) {
        int len = size();
        if (i<0 || i>len-1)
            throw new IllegalArgumentException("设置:位置i不在有效范围内");
        LinkNode<E> p = getI(i);					//找到序号为i的结点p
        p.data = e;
    }

    @Override
    public int indexOf(E e) {
        int j=0;
        LinkNode<E> p=head.next;
        while (p!=null){
            j++;								//记录序号，j递增
            if(p.data.equals(e))
                return j;
            p = p.next;
        }
        return -1;    //循环完毕未找到返回-1
    }

    @Override
    public void swap(int i, int j) {
        // 查找相应序号的结点
        LinkNode<E> p = getI(i);
        LinkNode<E> q = getI(j);
        // 中间变量结点交换
        E tmp = p.data;
        p.data = q.data;
        q.data = tmp;
    }

    @Override
    public void insert(int i, E e) {
        if (i<0 || i>size())					//包括结尾附加元素，终端结点的序号为size()-1，
            throw new IllegalArgumentException("插入:位置i不在有效范围内");
        LinkNode<E> s = new LinkNode<>(e);		//建立新结点s
        LinkNode<E> p = getI(i-1);			    //找到序号为i-1的结点p
        //在p结点后面插入s结点
        s.next = p.next;
        p.next = s;
    }

    @Override
    public void delete(int i) {
        if (i<0 || i>size()-1)
            throw new IllegalArgumentException("删除:位置i不在有效范围内");
        LinkNode<E> p = getI(i-1);				//找到序号为i-1的结点p
        p.next = p.next.next;					//删除p结点的后继结点，使得p结点指向其后继结点的后继结点
    }

    @Override
    public void deleteAll() {
        head.next = null;    // 头结点指向空，表示删除所有元素
    }

    @Override
    public void reverse() {
        LinkNode<E> p = head.next;	//p指向首结点
        head.next = null;				//将L置为一个空表，只有头结点，用于存储倒置后的结点
        while (p!=null){
            LinkNode<E> q = p.next;		// q临时保存p结点，达到遍历链表的作用

            // 头插法插入p，先插进去的会是最后一个结点，理解顺序上，先第2步，再第一步
            // p指向原本首结点，头结点指向p，p作为新首结点
            p.next = (head.next);		// 每次新插入的结点p要连接上，上一次插入的结点
            head.next = p;		   // 每次新插入的结点p也都会是头结点的next，变为首结点

            p = q;
        }
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        LinkNode<E> p = head.next;
        while (p!=null){
            str.append(p.data).append(" \n");
            p = p.next;
        }
        return str.toString();
    }

    // 单链表的插入排序
    public void insertSort(Comparator<E> comparator){
        LinkNode<E> q = head.next;  // 用于遍历原本的单链表，后端无序表
        head.next = null;           // 置于空表，重新链接sort后的结点
        while(q != null){
            LinkNode<E> p = head;  // 新表，前端有序表
            while (p.next!=null &&
                    comparator.compare(p.next.data, q.data)<0){ // 头结点第一次为空跳出选好
                p = p.next;  // 与前端有序表一个个比，符合继续下一个比
            } // p作为头结点，不进行第一次循环，先在下处链上首结点，开始分前后端的表
            LinkNode<E> r = q.next;  // 变量r临时表示q的后一个结点，用于遍历
            // q插在p结点后：p -> q ->(原)p.next
            q.next = p.next;     // q结点链p的后一个结点
            p.next = q;          // p链q结点

            q = r;
        }
    }

    // 浅拷贝：引用同一个单链表
    public void copyShallow(LinkListClass<E> list){ //this单链表拷贝list单链表
        this.head = list.head;
    }

    // 深拷贝：第一种：引用同一个结点对象；第二种：创建新的单链表，相互独立
    public void copyDeep(LinkListClass<E> list){
        LinkNode<E> p = list.head.next;  // 遍历list单链表
        this.head = new LinkNode<>();
        LinkNode<E> rear = head;        // 始终指向尾结点
        while (p!=null){
            //LinkNode<E> q = new LinkNode<>(p.data);  //第一种深拷贝，直接引用结点的data对象

            E data = DeepCopy.copyWithReflect(p.data); //第二种深拷贝，复制结点也新建独立data对象
            LinkNode<E> q = new LinkNode<>(data);      // 新建结点，开始链接

            // 尾插法
            rear.next = q;
            rear = q;       // q作为新的尾结点

            p = p.next;
        }
    }

}

//单链表结点泛型类
class LinkNode<E>{
    E data;
    LinkNode<E> next;

    public LinkNode() {							//无参构造方法：创造一个不带数据元素的结点
        next = null;
    }

    public LinkNode(E d){						//重载构造方法：创建带数据元素的结点
        data = d;
        next = null;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public LinkNode<E> getNext() {
        return next;
    }

    public void setNext(LinkNode<E> next) {
        this.next = next;
    }
}