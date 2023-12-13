package com.lzjtuimis._3_stack;

import org.junit.Test;

import static com.lzjtuimis._3_stack.StackApplication.*;

public class TestApplication {
    @Test
    public void test(){
        // 括号匹配
        String a = "{}{[]}[()][]";
        String b = "{()}{}()([)]";
        System.out.println(isMatch(a));
        System.out.println(isMatch(b));
        System.out.println(isMatch("a[]{([])}({[]})"));
        System.out.println(isMatch("a{([])}({[]}){"));

        // 是否回文
        String str = "abccba";
        String str1 = "liuxingrui ";
        System.out.println(str + "是否回文：" + isPalindrome(str));
        System.out.println(str1 + "是否回文：" + isPalindrome(str1));

        // 大数加法
        String aa = "1111111111";
        String bb = "22222222222";
        System.out.println(addition(aa, bb));
    }
}
