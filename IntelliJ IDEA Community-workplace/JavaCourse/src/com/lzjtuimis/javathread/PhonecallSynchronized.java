package com.lzjtuimis.javathread;

public class PhonecallSynchronized {
    public static void main(String[] args) {
        PhonecallThread t1 = new PhonecallThread("first");
        PhonecallThread t2 = new PhonecallThread("second");
        PhonecallThread t3 = new PhonecallThread("thread");
        t1.start();
        t2.start();
        t3.start();
    }
}


class Phonecall{    //定义打电话类
    public synchronized static void call(String name){
        try{
            System.out.println("<--" + name + "拨打电话-->");
            Thread.sleep(100);
            System.out.println("<--" + name + "正在通话中-->");
            Thread.sleep(100);
            System.out.println("<--" + name + "挂断电话-->");
            Thread.sleep(100);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class PhonecallThread extends Thread{    //定义打电话线程类
    PhonecallThread(String name)
    {
        super(name);  //调用thread类构造函数给新线程命名
    }
    public void run() {

        Phonecall.call(this.getName());  //getName()方法返回线程对象的名称
    }
}
