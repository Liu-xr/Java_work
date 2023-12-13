package com.lzjtuimis.javacollection;

import java.io.*;
import java.util.Properties;
import java.util.Set;

public class PropertiesTry {
    public static void main(String[] args) {
        Properties properties = new Properties();
        Properties properties1 = new Properties();

        properties.setProperty("key1", "value1");  //相当于put赋值
        properties.put("key2", "value2");    // 继承put方法

        String s1 = properties.getProperty("key2");   // String类型的key，返回String类
        String s = (String) properties.get("key1"); // Object类型的key，返回object类，强制转换String

        properties.propertyNames();//返回键的枚举
        //返回键的字符串的set集合
        Set<String> set = properties.stringPropertyNames();
        Object[] arr = set.toArray();
        // 遍历
        for (int i = 0; i < arr.length; i++) {
            String key = arr[i].toString();
            System.out.print(key + "->");
            System.out.println(properties.get(key));
        }

        Writer fout = null;
        Reader fin = null;
        try {
            // 一般配置文件读取.properties的文件
            fin = new FileReader("src\\propertiesTry.properties");
            fout = new FileWriter("src\\propertiesTry1.properties");

            // 读取流中的键值对，键和值之间以=或:分割以识别
            properties1.load(fin);
            Set<String> set1 = properties1.stringPropertyNames();
            // 遍历
            for (String key:set1) {
                System.out.println(key + " -> " + properties1.get(key));
            }

            // 将properties读取到的内容写到文件中
            properties.store(fout,"xml");
            fout.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fout != null)
                    fout.close();
                if(fin != null)
                    fin.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
