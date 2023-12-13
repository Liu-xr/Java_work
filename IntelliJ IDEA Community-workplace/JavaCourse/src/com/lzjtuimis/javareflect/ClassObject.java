package com.lzjtuimis.javareflect;

import javax.lang.model.element.Element;
import java.lang.reflect.Array;

public class ClassObject {
    public static void main(String[] args) {
        /* 三种方式创建Class对象 */
        try {
            Class bookClass = Class.forName("com.lzjtuimis.javareflect.Book");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // class属性
        Class bookClass1 = Book.class;
        // getClass()方法:只有类的实例有，普通数据类型的值没有
        Book book = new Book();
        Class bookClass2 = book.getClass();

        // 三者返回的对象都相同，类都只有一份
        System.out.println(bookClass1== bookClass2);



        // 存储Object类的对象，其数据值均继承Object类，自动转换
        Object[] objects = {"lxr", 20, new int[]{2002, 4, 6}, new Student()};

        // 存储Class类的对象，需要每个类型的class静态属性获得Class类型对象
        Class[] classes = {String.class, int.class, int[].class, Student.class};

        /* 所有的Class类对象 */
        // 基本数据类型
        Class[] classes1 = {byte.class, short.class, int.class, long.class, float.class, double.class, boolean.class};
        // 基本数据类型的包装类
        Class[] classes2 = {Byte.class, Short.class, Integer.class, Long.class, Float.class, Double.class, Boolean.class};
        // 其他数据类型: 所有类的class对象、一个接口的class对象、所有类的类型的一维数组的class对象、基本数据类型的二维数组的class对象
        Class[] classes3 = {Object.class, Runnable.class, Object[].class, int[][].class};
        // 注解的class对象、枚举类型的class对象、void类型的class对象、Class类的class对象
        Class[] classes4 = {Override.class, Element.class, void.class, Class.class};
    }
}

class Student{

}