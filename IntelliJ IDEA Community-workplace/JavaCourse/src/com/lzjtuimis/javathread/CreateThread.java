package com.lzjtuimis.javathread;


public class CreateThread {
    public static void main(String[] args) {
        // 匿名类创建
        Thread t1 = new Thread(() -> {   //将new Runnable转换为lambda表达式，因为该匿名类只需实现一个方法
            for (int i =0; i<10;i++) {
                System.out.println(Thread.currentThread().getName() + "->" + i);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.setName("子线程1");
        //在此处开始执行子线程1
        t1.start();


        Thread main = Thread.currentThread();
        Thread.currentThread().setName("主线程main");
        // 主线程main
        for (int i =0; i<10;i++) {
            System.out.println(main.getName() + "->" + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

