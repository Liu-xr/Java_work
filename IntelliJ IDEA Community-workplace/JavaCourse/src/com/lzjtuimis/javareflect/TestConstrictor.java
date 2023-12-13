package com.lzjtuimis.javareflect;

import java.lang.reflect.*;

public class TestConstrictor {
    public static void main(String[] args) {
        // 获取动态类Book
        Class bookClass = Book.class;
        // 获取Book类的所有构造方法
        Constructor[] declaredContructors = bookClass.getDeclaredConstructors();
        // 遍历所有构造方法:先可变数量的参数、再有参数、最后无参
        for (int i = 0; i < declaredContructors.length; i++) {
            Constructor con = declaredContructors[i];
            System.out.println("该构造方法的包括定义形参的全名称是:" + con.toString());
            System.out.println("该构造方法的getNamed的函数名是:" + con.getName());
            System.out.println("是否允许带可变数量的参数：" + con.isVarArgs());

            // 获取每个构造方法的所有参数类型
            System.out.print("该构造方法的入口参数类型依次为：");
            Class[] parameterTypes = con.getParameterTypes();
            if (parameterTypes.length>0) {
                for (Class parameterType : parameterTypes) {
                    System.out.print(parameterType + ",\t");
                }
                System.out.println();
            }
            else
                System.out.println("无参数");
            // 获取所有可能拋出的异常类型
            System.out.print("该构造方法可能拋出的异常类型为：");
            Class[] exceptionTypes = con.getExceptionTypes();
            if (exceptionTypes.length>0) {
                for (int j = 0; j < exceptionTypes.length; j++) {
                    System.out.print(parameterTypes[j] + ",\t");
                }
                System.out.println();
            }
            else
                System.out.println("无可能抛出的异常类型");

            // 创建一个未实例化的Book类实例
            Book book1 = null;
            con.setAccessible(true); // 将private权限的构造方法也能创建实例
            while (book1 == null) {
                try {
                    if (i == 1) {
                        // 通过执行带两个参数的构造方法实例化book1
                        book1 = (Book) con.newInstance("Java 教程", 10);
                    } else if (i == 2) {
                        // 通过执行默认构造方法实例化book1
                        book1 = (Book) con.newInstance();
                    } else {
                        // 通过执行可变数量参数的构造方法实例化book1
                        Object[] parameters = new Object[]{new String[]{"100", "200"}};
                        book1 = (Book) con.newInstance(parameters);
                        // 或：book1 = (Book) con.newInstance("100", "200");
                    }
                } catch(Exception e){
                    e.printStackTrace();
                }

            }
            book1.print();
            System.out.println("=============================\n");
        }
    }
}


class Book {
    String name; // 图书名称
    int id, price; // 图书编号和价格
    // 空的构造方法
    private Book() {
        System.out.println("私有无参构造方法");
    }
    // 带两个参数的构造方法
    protected Book(String _name, int _id) {
        this.name = _name;
        this.id = _id;
    }
    // 带可变参数的构造方法
    public Book(String... strings) throws NumberFormatException {
        if (0 < strings.length)
            id = Integer.valueOf(strings[0]);
        if (1 < strings.length)
            price = Integer.valueOf(strings[1]);
    }
    // 输出图书信息
    public void print() {
        System.out.println("name=" + name);
        System.out.println("id=" + id);
        System.out.println("price=" + price);
    }
}
