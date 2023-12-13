package com.lzjtuimis._1_linearlist;

public interface LinearList<E> {
    boolean isEmpty(); // 判断是否空

    void add(E e);// 将元素 e 添加到线性表末尾。

    int size(); // 求线性表的长度。

    void setSize(int nLen); // 设置线性表的长度为 nLen 。

    E getElem(int i); // 求线性表中序号为 i 的元素。

    void setElem(int i , E e ); // 设置线性表中序号为 i 的元素值为 e 。

    int indexOf(E e ); // 求线性表中第一个值为 e 的元素的索引。

    void swap (int i , int j ); // 交换线性表中序号为 i 和序号为 j 的元索值。

    void insert(int i , E e ); // 在线性表中插人数据元素 e 作为第 i 个元索。

    void delete(int i ); // 在线性表中删除第 i 个数据元素

    void deleteAll(); // 删除全部元素

    void reverse(); // 逆序
}
