package com.lzjtuimis.javaannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(value = RetentionPolicy.RUNTIME)
// @Target为注解限定使用范围，下面表示在方法和字段中使用
@Target({ElementType.METHOD, ElementType.FIELD})
public @interface annotation {

    // 默认值123,不标明默认123
    String getAbc() default "123";

    String value();

    public enum Week{
        Monthday, Sunday, FRIDAY
    }
}

