package com.lzjtuimis.javaio;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class Propertiers {
    public static void main(String[] args) throws IOException {
        // properties类是一个字典，实现Map接口
        Properties properties1 = new Properties();
        Properties properties2 = new Properties();
        FileReader reader1 = new FileReader("settings1.properties");
        FileReader reader2 = new FileReader("settings2.properties");

        // 读取并加载内容到properties对象
        properties1.load(reader1);
        properties2.load(reader2);

        // 遍历显示读取到的内容
        Set<String> set1 = properties1.stringPropertyNames(); // 返回键的String类型的Set集合
        for (String key:set1) {
            System.out.println(key + "->" + properties1.getProperty(key));
        }

        Set<String> set2 = properties2.stringPropertyNames();
        for (String key:set2) {
            System.out.println(key + "->" + properties2.getProperty(key));
        }
    }
}
