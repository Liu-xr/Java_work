package com.lzjtuimis.javathread;

public class ThreadBlock {
    public static void main(String[] args) throws InterruptedException {

        MyThread t1 = new MyThread("新线程");
        t1.start();

        //main线程
        for (int i = 1; i<= 10; i++){
            System.out.println(Thread.currentThread().getName() + " " + i);
            if(i % 2 == 0) {      //当前线程让出给同优先级的线程运行机会
                Thread.yield();   //每当偶数次时，让给t1运行，但t1运行几次后，main又抢占CPU调度，偶数次再让，依次不断。
            }
            if (i == 6)   //打断main线程的堵塞状态，yield方法失效
                Thread.currentThread().interrupt();
        }

    }
}

class MyThread extends Thread{

    MyThread(String name){
        super(name);
    }
    @Override
    public void run(){
        for (int i =1; i<=10; i++){
            System.out.println(currentThread().getName() + i);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
                    }
    }
}