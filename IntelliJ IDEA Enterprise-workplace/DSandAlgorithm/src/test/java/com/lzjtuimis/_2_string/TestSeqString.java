package com.lzjtuimis._2_string;

public class TestSeqString {
    public static void main(String[] args) {
        char[] chars = {'e', 'a', 'l', 'a', 'z'};
        SeqStringClass seqStringClass = new SeqStringClass(chars);
        System.out.println("串：" + seqStringClass);
        System.out.println("串的长度" + seqStringClass.length());
        // 取子串
        IString s1 = seqStringClass.subString(1, 3);
        System.out.println("取子串索引1,3为：" + s1.toString());
        //插入 e a l x r a z
        seqStringClass.insert(3, new SeqStringClass("xr"));
        System.out.println("插入操作构成lxr：" + seqStringClass);
        System.out.println("  去掉空格显示：" + seqStringClass.display());
        System.out.println("串的容量为" + seqStringClass.getCapacity() +
                "，长度为" + seqStringClass.length());
        //删除 e a l x r
        seqStringClass.delete(5,7);
        System.out.println("删除操作：" + seqStringClass);
        //替换 a m l x r
        seqStringClass.replace(0,2,new SeqStringClass("am"));
        System.out.println("替换操作：" + seqStringClass);
        //比较
        int result = seqStringClass.compareTo(new SeqStringClass("am lxr"));
        System.out.println("比较结果：" + (result==0?"相同":"不相同"));
        //连接 a m l x r.刘兴瑞
        IString s2 = seqStringClass.concat(new SeqStringClass(".刘兴瑞"));
        System.out.println("连接串：" + s2.toString());
        System.out.println("  去掉空格显示：" + s2.display());
        System.out.println("s2连接串的长度：" + s2.length());
        //索引值
        SeqStringClass seqStringClass1 = new SeqStringClass("abc adz");
        int index = seqStringClass1.indexOf(new SeqStringClass("ab"), 2);
        System.out.println("adz出现在abc adz的索引2开始处第一次索引为：" + index);

        // KMP算法
        SeqStringClass string = new SeqStringClass("lxr abc go 检测");
        System.out.println(string.index_KMP(new SeqStringClass("go"), 0));
    }
}
