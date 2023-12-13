package com.lzjtuimis.javareflect;

import java.lang.reflect.*;

public class TestFields {
    public static void main(String[] args) throws IllegalAccessException {
        Book2 book = new Book2();
        // 获取动态类Book2
        Class class1 = book.getClass();
        // 获取Book2类的所有成员变量
        Field[] declaredFields = class1.getDeclaredFields();
        /* 遍历Book2类中的所有的成员变量 */
        for (Field field : declaredFields) {
            // 获取类中的成员变量
            System.out.println("成员变量名称为：" + field.getName());
            System.out.println("成员变量的全路径名称：" + field);  // 加不加toString()一样，字符串自动转换
            System.out.println("成员变量类型为：" + field.getType());
            String modifier = field.getModifiers() != 0?Modifier.toString(field.getModifiers()):"default";
            System.out.println("成员变量的访问权限符:" + modifier);

            /* 访问成员变量的值 */
            Class fieldType = field.getType();
            field.setAccessible(true); // 允许访问private权限变量
            System.out.println("修改前成员的值为：" + field.get(book));
                    // int类型成员变量赋值
                    if (fieldType.equals(int.class)) {
                        System.out.println("利用setInt()方法修改成员的值");
                        field.setInt(book, 100);
                    } else if (fieldType.equals(float.class)) {
                        // float类型成员变量赋值
                        System.out.println("利用setFloat()方法修改成员的值");
                        field.setFloat(book, 29.815f);
                    } else if (fieldType.equals(boolean.class)) {
                        // boolean类型成员变量赋值
                        System.out.println("利用setBoolean()方法修改成员的值");
                        field.setBoolean(book, true);
                    } else {
                        System.out.println("利用set()方法修改成员的值");
                        field.set(book, "Java");
                    }
            System.out.println("修改后成员的值为：" + field.get(book));
            System.out.println("=============================\n");
        }
    }
}


class Book2 {
    String name;
    public int id;
    private float price;
    protected boolean isLoan;
}
