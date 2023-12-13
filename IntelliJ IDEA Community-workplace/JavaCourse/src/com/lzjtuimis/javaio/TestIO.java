package com.lzjtuimis.javaio;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TestIO {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //测试加transient关键字的普通变量不可串行化

        FileInputStream f1 = new FileInputStream("serilizable.ser");
        ObjectInputStream s1 = new ObjectInputStream(f1);
        SerializableClass sc1 = (SerializableClass) s1.readObject();
        System.out.println(sc1.j);
        f1.close();
    }
}
