package com.lzjtuimis.javaio;

import java.io.*;

public class SerializableClass implements Serializable {
    static int i = 11;                // static修饰的变量不可串行化，类变量，不单单被一个实例对象使用
    public transient int j = 1;   //加transient关键字的非引用变量不可被串行化

    static void myMethod(){      // 静态方法不可串行化

    }

    public void method(){
        System.out.println("方法 public void method()");
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerializableClass sc = new SerializableClass();
        System.out.println("原本对象transient修饰的j变量为：" + sc.j);

        FileOutputStream f = new FileOutputStream("serilizable.ser");
        ObjectOutputStream s = new ObjectOutputStream(f);
        s.writeObject(sc);
        f.close();

        FileInputStream f1 = new FileInputStream("serilizable.ser");
        ObjectInputStream s1 = new ObjectInputStream(f1);
        SerializableClass sc1 = (SerializableClass) s1.readObject();
        System.out.println("读取串行化的对象查看j变量为：" + sc1.j);  // 输出0，说明在写入时根本就没有被串行化

        f1.close();
    }
}
