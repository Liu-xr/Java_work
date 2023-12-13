package com.lzjtuimis._1_linearlist;

@SuppressWarnings("unchecked")   // 注解，未检查Object向E类型转换
public class SeqListClass<E>  implements LinearList<E>{
    final int initCapacity = 10; 		    //顺序表的初始容量（常量）
    public E[] data;						//存放顺序表中的元素
    public int size;						//存放顺序表的长度，元素个数
    private int capacity;				    //存放顺序表的容量

    //构造方法，实现 data 和 length 的初始化
    public SeqListClass(){
        data =(E[]) new Object [initCapacity];  //强制转换为 E 类型数组
        capacity = initCapacity ;
        size = 0;
    }

    //改变顺序表的容量为 newCapacity
    private void updateCapacity (int newCapacity){
        E[] newData = (E[]) new Object [newCapacity];
        //复制原来的元素
        if (size >= 0)
            System.arraycopy(data, 0, newData, 0, size);
        capacity = newCapacity ;							//设置capacity属性为新的容量
        data = newData;									//指向data数组，仍由 data 标识数组
    }

    public void createList(Object[] a) {
        size = 0;								// size表示期初顺序表是没有元素的
        for (Object o : a) {
            if (size == capacity)                 // 元素溢出扩容
                updateCapacity(2 * size);
            data[size] = (E) o;
            size++;
        }
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public void add(E e){
        if(size == capacity)                 // 元素溢出扩容
            updateCapacity(2 * size);
        data[size] = e;						// 从现有size个数据元素的顺序表附加元素
        size ++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void setSize(int nLen) {
        if(nLen <0 || nLen >size)
            throw new IllegalArgumentException("设置长度：n不在有效范围内");
        size = nLen;
    }

    @Override
    public E getElem(int i) {
        return data[i];
    }

    @Override
    public void setElem(int i, E e) {
        if(i <0 || i >size-1)
            throw new IllegalArgumentException("设置：位置i不在有效范围内");
        data[i] = e;
    }

    @Override
    public int indexOf(E e) {
        int i = 0;
        while(i <= size){
            if(data[i].equals(e))
                return i;
            else
                i++;

        }
        return -1;
    }

    @Override
    public void swap(int i, int j) {
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    @Override
    public void insert(int i, E e) {
        //插入时，序号i不正确抛出异常；插入元素，应先将序号i到n-1的每个元素都往后移一个位置，
        // 腾出一个位置i插入元素e，最后长度size增1.若溢出，则扩容两倍。
        if(i <0 || i >size-1)
            throw new IllegalArgumentException("插入：位置i不在有效范围内");
        if(size == capacity)
            updateCapacity(2 * size);
        for(int j = size;j>i;j--)   // 在还未size++前，j是从size开始，而非size-1
            data[j] = data[j-1];
        data[i] = e;
        size++;
    }

    @Override
    public void delete(int i) {
        //删除时，序号i不正确抛出异常；删除序号i的元素，应将序号i+1到n-1的每个元素都往前移一个位置，
        // 将空出的i位置补全，最后长度size减1.若当前容量大于初始容量并且实际元素个数仅为当前容量的1/4，则缩容一半。
        if(i <0 || i >size-1)
            throw new IllegalArgumentException("删除：位置i不在有效范围内");
        // 每个元素前移一位，最后一位序号为size-1，因为j+1，所以<
        if (size - 1 - i >= 0)
            System.arraycopy(data, i + 1, data, i, size - 1 - i);
        size--;
        if(capacity>initCapacity && size == capacity/4)
            updateCapacity(capacity/2);
    }

    @Override
    public void deleteAll() {
        // 初始容量，长度为0
        data = (E[]) new Object[initCapacity];
        size = 0;
    }

    @Override
    public void reverse() {
        int i =0,j = size() - 1;
        while(i < j){
            swap(i, j);
            i++;
            j++;
        }
    }

    //将线性表转换为字符串：toString()
    public String toString(){
        StringBuilder str = new StringBuilder();
        for(int i = 0;i<size;i++)
            str.append(data[i]).append(" ");
        return str.toString();
    }
}
