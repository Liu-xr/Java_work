package com.lzjtuimis.utils;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

@SuppressWarnings("unchecked")
public class DeepCopy<T> {
    /* 序列化深拷贝（克隆） */
    public static<T> T copyWithSerializable(T obj) {
        T obj1 = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            obj1 = (T) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj1;
    }

    /* 反射机制深拷贝（克隆） */
    public static<T> T copyWithReflect(T obj){
        T obj1 = null;
        Class<?> objClass = obj.getClass();  // T，未确定Class类型，用?
        try {
            obj1 = (T) objClass.getConstructor().newInstance();
            Field[] fields = objClass.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                Object property = field.get(obj);
                field.set(obj1, property);
            }
        } catch (InstantiationException | IllegalAccessException |
                InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return obj1;
    }
}
