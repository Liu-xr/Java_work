package com.lzjtuimis.javaannotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;

@annotation1(method = "1")
public class One {
    public static void main(String[] args) {
        int a = 0;
        long b = 10;
        // 弃用的方法会有横线划掉
        new AN().getName();




    }
}



class AN{

    // 表示该方法已被弃用，在某个版本后
    @Deprecated(since = "11")
    String getName(){
        return "lxr";
    }

    @annotation(value = "0")
    int a(){
        return  1;
    }
    @annotation(value = "annotation.Week.FRIDAY")
    @SuppressWarnings(value={"unchecked"})
    void add(int a, String b){
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(a, b);
    }
}


