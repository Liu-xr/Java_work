package com.lzjtuimis.javathread;

public class JoinThread {
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        t1.start();
    }
}


class Thread1 extends Thread{
    @Override
    public void run() {
        Thread2 t2 = new Thread2();
        t2.start();

        try {
            for(int i =0;i<3;i++){
                System.out.println("线程1");
                sleep(10);
                t2.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class Thread2 extends Thread{
    @Override
    public void run() {
        try {
            for(int i =0;i<3;i++){
                System.out.println("线程2");
                sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}