package com.lzjtuimis.javathread;

import java.io.*;
import java.util.*;

public class ReadPropertiesThread {
    public static void main(String[] args) throws FileNotFoundException {

        Properties properties1 = new Properties();
        Properties properties2 = new Properties();
        FileReader reader1 = new FileReader("settings1.properties");
        FileReader reader2 = new FileReader("settings2.properties");
        ThreadGroup threadGroup = new ThreadGroup("newThread");

        new ReadFile(properties1, reader1, threadGroup);
        new ReadAnotherFile(properties2, reader2, threadGroup).start();

        // 显示读取到的内容
        Set<String> set1 = properties1.stringPropertyNames();
        for (String key:set1
        ) {
            System.out.println(key + "->" + properties1.getProperty(key));
        }

        Set<String> set2 = properties2.stringPropertyNames();
        for (String key:set2
        ) {
            System.out.println(key + "->" + properties2.getProperty(key));
        }
    }
}


// 实现runnable接口
class ReadFile implements Runnable{
    Properties properties = null;
    FileReader fr = null;

    public ReadFile(Properties properties, FileReader fr, ThreadGroup threadGroup){
        this.properties = properties;
        this.fr = fr;
        Thread thread = new Thread(threadGroup, this, "读取第一个文件线程");
        thread.start();
    }

    @Override
    public void run() {
        try {
            properties.load(fr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


//继承Thread类
class ReadAnotherFile extends Thread{
    Properties properties = null;
    FileReader fr = null;

    public ReadAnotherFile(Properties properties, FileReader fr, ThreadGroup threadGroup){
        super(threadGroup, "读取第二个文件线程");
        this.properties = properties;
        this.fr = fr;
    }

    @Override
    public void run() {
        try {
            properties.load(fr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




