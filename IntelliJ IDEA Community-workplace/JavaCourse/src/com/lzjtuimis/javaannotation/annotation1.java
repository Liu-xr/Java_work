package com.lzjtuimis.javaannotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

// @Target为注解限定使用范围，如下可在类上使用
@Target({ElementType.TYPE})
public @interface annotation1 {

    String method();

}
