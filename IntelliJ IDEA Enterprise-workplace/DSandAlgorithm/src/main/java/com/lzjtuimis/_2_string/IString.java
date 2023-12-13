package com.lzjtuimis._2_string;

public interface IString {
    void clear();   // 清空

    boolean isEmpty();  // 是否为空

    int length();   // 长度

    char charAt(int index);  // 返回index索引处的字符

    void charSet(int index, char c);  // 设置index索引处的字符为c

    IString subString(int begin, int end);  // 取子串，提供开始和结束索引，左开右闭返回子串

    void insert(int offset, IString str); // 在当前串中第offset个字符之前插入串str，并返回结果串对象

    void delete(int begin, int end); // 删除给定起始结束索引的子串，左开右闭

    void replace(int begin, int len, IString str); // 替换子串，给定起始位置、长度与替换串

    IString concat(IString str); // 串连接，返回连接后的串

    int compareTo(IString str);  // 串中字符的比较，返回-1/0/1，分别是this串小等大给定串

    int indexOf(IString str,int begin);  // 取子串在串中第一次出现的位置，可给定起始索引

    String display();
}
