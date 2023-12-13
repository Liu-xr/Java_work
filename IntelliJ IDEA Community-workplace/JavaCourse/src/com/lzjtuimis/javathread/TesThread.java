package com.lzjtuimis.javathread;

public class TesThread {
    public static void main(String[] args) {
        // 测试main线程
        Thread obj = Thread.currentThread();
        System.out.println(obj);
        String mainName = obj.getName();
        System.out.println(mainName);
        obj.setName("new thread");
        System.out.println(obj);

/*
        // 测试实现runnable接口的新线程
        new NewThread();  //新建类执行构造函数，即刻开始执行新线程的代码任务
        try{
            for(int i = 0;i<4;i++){
                System.out.println("正在执行main线程第"+(i+1)+"次");
                Thread.sleep(1);	//程序休眠1毫秒
            }
        }catch (InterruptedException e) {
            System.out.println("main线程被打断");
        }
        System.out.println("main线程for循环执行结束");
*/

        //测试继承Thread类的新线程
        System.out.println("开始此次测试的main线程");
        ExtendsThread t = new ExtendsThread();
        t.start(); 	//ExtendsThread类继承Thread类，调用start()方法即启动新线程
        try{
            for(int i = 0; i < 4; i++){
                System.out.println("正在执行main线程第"+ (i+1) +"次");
                Thread.sleep(10);	//程序休眠10毫秒
            }
            System.out.println("main线程结束");
        }catch (InterruptedException e) {
            System.err.println("新线程被打断");
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("111");
            }
        });

        new Thread(() ->{
            System.out.println("111");
        });

        new Thread(() -> System.out.println("111"));
    }
}


class NewThread implements Runnable{
    public NewThread(){
        Thread obj = new Thread(this, "新线程");
        System.out.println("新线程开始");
        obj.start();
    }
    public void run(){
        try {
            for(int i = 0; i < 4; i++){
                System.out.println("正在执行新线程第" + (i+1) + "次");
                Thread.sleep(10);   //程序休眠10毫秒
            }
        } catch (InterruptedException e){
            System.out.println("新线程被打断");
        }
    }
}

class ExtendsThread extends Thread
{
    public ExtendsThread(){
        super("新线程"); 	  //调用Thread类的构造函数给新线程命名
        System.out.println("新线程开始");
    }
    public void run() {
        try {
            for (int i = 0; i < 4; i++) {
                System.out.println("正在执行新线程第" + (i + 1) + "次");
                sleep(10);   //继承了Thread类，可直接调用静态方法sleep()
            }
        } catch (InterruptedException e) {
            System.out.println("新线程被打断");
        }
    }
}

