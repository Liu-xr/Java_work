package com.lzjtuimis._1_linearlist;

//双链表泛型类
public class DoubleLinkListClass<E> implements LinearList<E> {
    DoubleLinkNode<E> head;							//存放头结点

    public DoubleLinkListClass(){					//构造方法，新建空双链表，只有头结点
        head = new DoubleLinkNode<>();				//创建头结点
        head.prior = null;
        head.next = null;
    }

    private DoubleLinkNode<E> getI(int i){			//返回序号为i的结点，序号从0开始
        DoubleLinkNode<E> p = head;
        int j = -1;								// 头结点没有序号，或者序号比0小1，-1
        while (j<i){
            j++;
            p = p.next;
        }
        return p;
    }

    //头插法：由数组a整体建立双链表，次序相反
    public void CreateListF(E[] a){
        DoubleLinkNode<E> s;
        //循环建立数据结点s
        for (E e : a) {
            s = new DoubleLinkNode<>(e);       //新建存放a[i]元素的结点s，将其插入到表头
            s.next = head.next;            // 新插入结点s的后指针要指向上一个插入的结点，上一个插入的结点是作为首结点的，即头结点的后继结点
            if (head.next != null)        //同时设置上一个插入的结点的前指针指向，第一次插入时，不进入if语句
                head.next.prior = s;

            head.next = s;                     // 新插入的结点s作为首结点，是头结点的后继结点
            s.prior = head;                    // 同时设置新插入结点s的前指针指向
        }
    }
    
    //尾插法：由数组a整体建立双链表，次序一致
    public void CreateListR(E[] a){
        DoubleLinkNode<E> s,t;
        t = head;								//t始终指向尾结点,开始时指向头结点
        //循环建立数据结点s
        for (E e : a) {
            s = new DoubleLinkNode<>(e);            //新建存放a[i]元素的结点s
            t.next = s;                            //将新插入结点s设为尾结点t的后继结点
            s.prior = t;
            t = s;                    // 同时设置先插入结点s的前指针指向，并更新尾结点t
        }
        t.next = null;							//将尾结点的next字段置为null
    }

    @Override
    public boolean isEmpty() {
        return this.head.next == null;
    }

    @Override
    public void add(E e){
        DoubleLinkNode<E> s = new DoubleLinkNode<>(e);		//新建结点s
        DoubleLinkNode<E> p = head;
        while (p.next!=null)					//查找尾结点p
            p = p.next;
        p.next = s;								//在尾结点之后插入结点s
        s.prior = p;
    }

    @Override
    public int size(){
        DoubleLinkNode<E> p=head;
        int cnt=0;
        while (p.next!=null){			//找到尾结点为止
            cnt++;
            p=p.next;
        }
        return cnt;
    }

    @Override
    public void setSize(int nLen){
        int len=size();
        if (nLen<0 || nLen>len)
            throw new IllegalArgumentException("设置长度:n不在有效范围内");
        if (nLen==len) return;
        DoubleLinkNode<E> p = getI(nLen-1);			//找到序号为nLen-1的结点p
        p.next = null;							//将结点p置为尾结点
    }

    @Override
    public E getElem(int i){
        int len=size();
        if (i<0 || i>len-1)
            throw new IllegalArgumentException("查找:位置i不在有效范围内");
        DoubleLinkNode<E> p = getI(i);					//找到序号为i的结点p
        return p.data;
    }

    @Override
    public void setElem(int i,E e){
        if (i<0 || i>size()-1)
            throw new IllegalArgumentException("设置:位置i不在有效范围内");
        DoubleLinkNode<E> p=getI(i);					//找到序号为i的结点p
        p.data=e;
    }

    @Override
    public void swap(int i, int j) {
        // 查找相应序号的结点
        DoubleLinkNode<E> p = getI(i);
        DoubleLinkNode<E> q = getI(j);
        // 中间变量结点交换
        E tmp = p.data;
        p.data = q.data;
        q.data = tmp;
    }

    @Override
    public int indexOf(E e){
        int j=0;
        DoubleLinkNode<E> p=head.next;
        while (p!=null && !p.data.equals(e)){
            j++;								//查找元素e
            p=p.next;
        }
        if (p==null)							//未找到时返回-1
            return -1;
        else
            return j;							//找到后返回其序号
    }

    @Override
    public void insert(int i, E e){
        if (i<0 || i>size())					//参数错误抛出异常
            throw new IllegalArgumentException("插入:位置i不在有效范围内");
        DoubleLinkNode<E> s = new DoubleLinkNode<>(e);		//建立带e数据元素的新结点s
        DoubleLinkNode<E> p = getI(i-1);			        //找到序号为i-1的结点p,其后位置i插入s结点
        // 插入结点的四个步骤
        s.next = p.next;
        if (p.next!=null)						    // p结点是尾结点时，不进入if语句
            p.next.prior = s;
        p.next = s;
        s.prior = p;
    }

    @Override
    public void delete(int i){
        if (i<0 || i>size()-1)					//参数错误抛出异常
            throw new IllegalArgumentException("删除:位置i不在有效范围内");
        DoubleLinkNode<E> p = getI(i);					//找到序号为i的结点p,删除该结点
        // 删除节点的两个步骤
        p.prior.next = p.next;
        if (p.next!=null)						// p结点是尾结点时，不进入if语句
            p.next.prior = p.prior;
    }

    @Override
    public void deleteAll() {
        this.head.next = null;
        this.head.prior = null;
    }

    @Override
    public void reverse() {
        DoubleLinkNode<E> p = head.next;
        head.next = null; head.prior = null;	  //将L置为一个空表，只有头结点，用于存储倒置后的结点
        while (p!=null){
            DoubleLinkNode<E> q = p.next;		// q临时保存p结点，达到遍历链表的作用

            // 头插法插入p，先插进去的会是最后一个结点，理解顺序上，先第2步，再第一步
            // p指向原本首结点，头结点指向p，p作为新首结点
            p.next = (head.next);		// 每次新插入的结点p要连接上，上一次插入的结点
            if(head.next!=null)
                head.next.prior = p;
            head.next = p;		   // 每次新插入的结点p也都会是头结点的next，变为首结点
            p.prior = head;

            p = q;
        }
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        DoubleLinkNode<E> p = head.next;
        while (p!=null){
            str.append(p.data).append(" ");
            p = p.next;
        }
        return str.toString();
    }
}

//双链表结点泛型类
class DoubleLinkNode<E>{
    E data;
    DoubleLinkNode<E> prior;							//前驱结点指针
    DoubleLinkNode<E> next;							//后继结点指针

    public DoubleLinkNode(){							// 构造方法，新建空数据元素结点
        prior = null;
        next = null;
    }
    public DoubleLinkNode(E data){					//重载构造方法:创建一个含数据元素的结点，前后指针为null
        this.data = data;
        prior = null;
        next = null;
    }
}

