package com.lzjtuimis._1_linearlist;

// 循环双链表泛型类，结点类在DoubleLinkListClass类文件
public class CDoubleLinkListClass<E> implements LinearList<E>{
    DoubleLinkNode<E> head;							//头结点

    public CDoubleLinkListClass(){
        head = new DoubleLinkNode<>();				//创建头结点
        // 区别于双链表的创建空表
        head.prior = head;
        head.next = head;
    }

    //返回序号为i的结点
    private DoubleLinkNode<E> getI(int i){
        DoubleLinkNode<E> p=head;
        int j=-1;
        while (j<i){
            j++;
            p=p.next;
        }
        return p;
    }

    // 整体建立循环双链表：头插法
    public void CreateListF(E[] a){
        DoubleLinkNode<E> s;
        for (E e : a) {
            s = new DoubleLinkNode<>(e);            //新建存放a[i]元素的结点s
            s.next = head.next;                    //修改s结点的next字段
            head.next.prior = s;
            head.next = s;                        //修改头结点的next字段
            s.prior = head;                        //修改s结点的prior字段
        }
    }

    //尾插法
    public void CreateListR(E[] a){
        DoubleLinkNode<E> s,t;
        t=head;								//t始终指向尾结点,开始时指向头结点
        for (E e : a) {
            s = new DoubleLinkNode<>(e);            //新建存放a[i]元素的结点s
            t.next = s;                            //将s结点插入t结点之后
            s.prior = t;
            t = s;
        }
        t.next = head;							//将尾结点的next字段置为head
        head.prior = t;							//将头结点的prior字段置为t
    }

    @Override
    public boolean isEmpty() {
        return this.head.next == head;
    }


    @Override
    public void add(E e){
        DoubleLinkNode<E> s= new DoubleLinkNode<>(e);		//新建结点s
        DoubleLinkNode<E> p=head;
        while (p.next!=head)					//查找尾结点p
            p=p.next;
        p.next=s;								//在尾结点p之后插入结点s
        s.prior=p;
        s.next=head;
        head.prior=s;
    }

    @Override
    public int size(){
        DoubleLinkNode<E> p=head;
        int cnt=0;
        while (p.next!=head){
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
        DoubleLinkNode<E> p=getI(nLen-1);			//找到序号为nLen-1的结点p
        p.next=head;							//将结点p置为尾结点
        head.prior=p;
    }

    @Override
    public E getElem(int i){
        int len=size();
        if (i<0 || i>len-1)
            throw new IllegalArgumentException("查找:位置i不在有效范围内");
        DoubleLinkNode<E> p=getI(i);					//找到序号为i的结点p
        return p.data;
    }

    @Override
    public void setElem(int i, E e){
        if (i<0 || i>size()-1)
            throw new IllegalArgumentException("设置:位置i不在有效范围内");
        DoubleLinkNode<E> p=getI(i);					//找到序号为i的结点p
        p.data=e;
    }

    @Override
    public int indexOf(Object e){
        int j=0;
        DoubleLinkNode<E> p=head.next;
        while (p!=head && !p.data.equals(e)){
            j++;								//查找元素e
            p=p.next;
        }
        if (p==head)							//未找到时返回-1
            return -1;
        else
            return j;							//找到后返回其序号
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
    public void insert(int i, E e){
        if (i<0 || i>size())					//参数错误抛出异常
            throw new IllegalArgumentException("插入:位置i不在有效范围内");
        DoubleLinkNode<E> s = new DoubleLinkNode<>(e);		//建立新结点s
        DoubleLinkNode<E> p = getI(i-1);			        //找到序号为i-1的结点p,其后插入s结点

        s.next=p.next;							//修改s结点的next字段
        p.next.prior=s;
        p.next=s;								//修改p结点的next字段
        s.prior=p;								//修改s结点的prior字段
    }

    @Override
    public void delete(int i){
        if (i<0 || i>size()-1)					//参数错误抛出异常
            throw new IllegalArgumentException("删除:位置i不在有效范围内");
        DoubleLinkNode<E> p = getI(i);					//找到序号为i的结点p,删除该结点
        p.prior.next = p.next;					    //修改p结点的前驱结点的next字段
        p.next.prior = p.prior;
    }

    @Override
    public void deleteAll() {
        this.head.next = head;
        this.head.prior = head;
    }

    @Override
    public void reverse() {
        DoubleLinkNode<E> p = head.next;
        DoubleLinkNode<E> end = head.next;   // 记录原链表首结点变为尾结点指向头结点
        head.next = null;head.prior = null;	 //将L置为一个空表，只有头结点，用于存储倒置后的结点
        while (p!=head){
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
        end.next = head;             // 记录原链表首结点变为尾结点指向头结点
        head.prior = end;

    }

    @Override
    public String toString(){
        StringBuilder ans= new StringBuilder();
        DoubleLinkNode<E> p=head.next;
        while (p!=head){
            ans.append(p.data).append(" ");
            p = p.next;
        }
        return ans.toString();
    }
}
