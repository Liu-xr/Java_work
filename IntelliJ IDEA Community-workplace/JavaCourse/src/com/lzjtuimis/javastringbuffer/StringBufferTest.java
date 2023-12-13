package com.lzjtuimis.javastringbuffer;

public class StringBufferTest {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("liu");
        System.out.println(str);   //原始：liu

        //结尾附加  ：liurui
        str.append("rui");
        System.out.println(str);

        //插入字符串: liu xingrui
        str.insert(3, " xing");
        System.out.println(str);

        //替换（左闭右开）:liu XingRui
        str.replace(4, 9, "XingR");
        System.out.println(str);

        //删除指定位置的字符串（左闭右开）：liu
        str.delete(3, 11);
        System.out.println(str);

        //字符串反转：uil
        str.reverse();
        System.out.println(str);

    }
}
