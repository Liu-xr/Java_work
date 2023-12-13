package com.lzjtuimis._2_string;


public class SeqStringClass implements IString{
    int capacity;        // 容量，可进行动态扩容
    char[] data;        // 字符数组实现顺序串
    int size;          // 当前串的长度大小

    // 初始化字符数组，串
    public SeqStringClass(int initCapacity){
        capacity = initCapacity;
        data = new char[capacity];
        size = 0;
    }
    // 整体创建：字符数组
    public SeqStringClass(char[] chars){
        data = new char[chars.length];
        System.arraycopy(chars, 0, data, 0, chars.length);
        size = chars.length;
        capacity = 2*size;
    }
    // 整体创建：字符串
    public SeqStringClass(String string){
        data = string.toCharArray();
        size = string.length();
        capacity = 2*size;
    }
    // 整体创建：同类串
    public SeqStringClass(SeqStringClass string){
        data = new char[string.length()];
        for(int i = 0;i< string.length();i++)
            data[i] = string.charAt(i);
        size = string.length();
        capacity = string.capacity;
    }

    //改变容量为 newCapacity
    private void updateCapacity (int newCapacity){
        char[] newData =  new char[newCapacity];
        //复制原来的元素
        if (size >= 0) System.arraycopy(data, 0, newData, 0, size);
        capacity = newCapacity ;							//新最大容量
        data = newData;									//指向data数组，仍由 data 标识数组
    }

    public int getCapacity(){
        return capacity;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public char charAt(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("提供的无效索引");
        return data[index];
    }

    @Override
    public void charSet(int index, char c) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("提供的无效索引");
            data[index] = c;
    }

    @Override
    public IString subString(int begin, int end) {
        if (begin<0 || end>size || begin>end) {
            throw new IllegalArgumentException("提供的无效参数");
        }
        // 顺序串
        SeqStringClass sub = new SeqStringClass(end-begin);
        sub.size = end - begin;
        for(int i = begin;i<end;i++)
            sub.charSet(i-begin, data[i]);
        return sub;

        /* 字符串
        StringBuffer string = new StringBuffer();
        for(int i = begin;i<end;i++)
            string.append(data[i]);
        return new SeqStringClass(string.toString());
        */
    }

    @Override
    public void insert(int offset, IString str) {
        if (offset<0 || offset>size)
            throw new IllegalArgumentException("提供的无效参数");
        int length = str.length();
        int newLength = size + length;
        // 动态扩容
        if(newLength > capacity/4 *3)
            updateCapacity(capacity * 2);
        for(int i = size-1;i>=offset;i--)
            data[i+length] = data[i];         // 后移str的length位
        for(int i = 0;i<length;i++)
            data[offset + i] = str.charAt(i); // str字符的插入
        size = newLength;
    }

    @Override
    public void delete(int begin, int end) {
        if (begin<0 || end>size || begin>end)
            throw new IllegalArgumentException("提供的无效参数");
        for(int i = 0;i<size-end;i++)
            data[i+begin] = data[end+i];
        size -= (end - begin);
        // 动态缩容
        if(size < capacity/2)
            updateCapacity(capacity/2);
    }

    @Override
    public void replace(int begin, int len, IString str) {
        if(begin<0||begin+len>size||len<0 || str.length()>len)
            throw new IllegalArgumentException("提供的无效参数");
        for(int i = 0;i<len;i++)
            data[i+begin] = str.charAt(i);
    }

    @Override
    public IString concat(IString str) {
        SeqStringClass seqStr = new SeqStringClass(this);
        if(seqStr.size + str.length() > seqStr.capacity/4 *3)
            seqStr.updateCapacity(2 * seqStr.size);
        for(int i = 0;i<str.length();i++)
            seqStr.data[i+size] = str.charAt(i);
        seqStr.size += str.length();
        return seqStr;
    }

    @Override
    public int compareTo(IString str) {
        for(int i=0;i<size&&i<str.length();i++)   // 字符比较，返回-1或1
            if (data[i] != str.charAt(i))
                return data[i] - str.charAt(i);
        // 相同0，或返回不一样的长度差
        return size-str.length();
    }

    @Override
    public int indexOf(IString str, int begin) {
        if(begin<0||begin>size)
            throw new IllegalArgumentException("提供的无效参数");
        int i = begin;
        while(i < size-str.length()){
            if(str.compareTo(this.subString(i, i+str.length())) == 0)
                return i;
            i++;
        }
        return -1;
    }

    /* KMP字符串搜索算法 */
    public int index_KMP(IString t, int start) {
        if(start<0||start>this.length()-1)
            throw new IllegalArgumentException("提供的无效索引");
        int[] next = getNext(t); 	   //计算模式串t的next[]函数值
        int i = start, j = 0;      	   // i为主串指针，j为模式串指针
        while (i < this.length() && j < t.length()) {
            if (j ==-1 || this.charAt(i) == t.charAt(j)){
                ++i;  ++j; 			// 继续比较后继字符：当前阶段每个字符相等，或
            }
            else
                j = next[j];          // 模式串向右移动，j指针指向k处，跳过k个字符比较
        }
        if (j < t.length())  			// 匹配到最后仍有未匹配完的字符，j指针未满
            return -1;
        else
            return  i-t.length();         // 匹配成功，返回第一次出现位置
    }
    private int[] getNext(IString subStr) {
        int len = subStr.length();
        int[] next = new int[len];
        next[0] = -1;                         // j=0处初始化-1
        int k = -1;
        int j = 0;
        while (j < len - 1){
            // k==-1为第一位迭代
            if (k == -1 || subStr.charAt(k) == subStr.charAt(j)){     // 即P[k] == P[j]，前k个有与j前k个相同
                next[++j] = ++k;
            }
            else{					// P[k] != P[j]时，指针j指向的位置取next[k],对应上表j=5和j=11取值完后的判断
                k = next[k];
            }
        }
        return next;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (char c:data) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    @Override
    public String display(){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i =0;i<size;i++)
            stringBuilder.append(data[i]);
        return stringBuilder.toString();
    }
}
