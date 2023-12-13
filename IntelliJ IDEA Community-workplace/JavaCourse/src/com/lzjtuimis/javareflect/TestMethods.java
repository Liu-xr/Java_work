package com.lzjtuimis.javareflect;

import java.lang.reflect.*;

public class TestMethods {
    public static void main(String[] args) {
        // 获取动态类Book1
        Book1 book = new Book1();
        Class class1 = book.getClass();  // 方式2：Book1.class;
        // 获取Book1类的所有方法
        Method[] declaredMethods = class1.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println("方法的全名称为：" + method.getName());
            System.out.println("方法的带参数的全名称为：" + method.toString());
            System.out.println("方法是否带有可变数量的参数：" + method.isVarArgs());
            System.out.println("方法的返回值类型为：" + method.getReturnType());

            /* 获取所有参数类型 */
            System.out.print("方法的参数类型依次为：");
            Class[] methodTypes = method.getParameterTypes();
            if (methodTypes.length>0) {
                for (Class methodType : methodTypes) {
                    System.out.print(methodType.getName() + ",\t");
                }
                System.out.println();
            }
            else
                System.out.println("该方法没有参数");

            /* 获取所有可能抛出的异常 */
            System.out.print("方法可能抛出的异常类型有：");
            Class[] methodExceptions = method.getExceptionTypes();
            if (methodExceptions.length>0) {
                for (Class methodException : methodExceptions) {
                    System.out.print(methodException + ",\t");
                }
                System.out.println();
            }
            else
                System.out.println("该方法没有抛出异常类型");

            boolean isTurn = true;
            while (isTurn) {
                try { // 如果该成员变量的访问权限为private，则抛出异常
                    switch (method.getName()) {
                        case "staticMethod" ->      // 调用没有参数的方法
                                method.invoke(book);
                        case "publicMethod" ->      // 调用一个参数的方法
                                System.out.println("publicMethod(10)的返回值为：" + method.invoke(book, 10));
                        case "protectedMethod" ->   // 调用两个参数的方法
                                System.out.println("protectedMethod(\"10\",15)的返回值为：" + method.invoke(book, "10", 15));
                        case "privateMethod" -> {   // 调用可变数量参数的方法
                            Object[] parameters = new Object[]{new String[]{"J", "A", "V", "A"}};
                            System.out.println("privateMethod()的返回值为：" + method.invoke(book, parameters));
                        }
                    }
                    isTurn = false;
                } catch (Exception e) {
                    System.out.println("在设置成员变量值时遇到private权限抛出异常，下面执行setAccessible()方法");
                    method.setAccessible(true);  // 设置为允许访问private方法
                    isTurn = true;
                }
            }
            System.out.println("=============================\n");
        }
    }
}


class Book1 {
    // static 作用域方法
    static void staticMethod() {
        System.out.println("执行staticMethod()方法");
    }
    // public 作用域方法
    public int publicMethod(int i) {
        System.out.println("执行publicMethod()方法");
        return 100 + i;
    }
    // protected 作用域方法
    protected int protectedMethod(String s, int i) throws NumberFormatException {
        System.out.println("执行protectedMethod()方法");
        return Integer.parseInt(s) + i;
    }
    // private 作用域方法：无法直接调用，得不到返回值，只会输出sout的语句
    private String privateMethod(String... strings) {
        System.out.println("执行privateMethod()方法");
        StringBuilder sb = new StringBuilder();
        for (String string : strings) {
            sb.append(string);
        }
        return sb.toString();
    }
}