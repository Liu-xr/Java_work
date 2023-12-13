package com.lzjtuimis.javathread;

public class StopThread {
    public static void main(String[] args) throws InterruptedException {
        Runnable10 r = new Runnable10();
        Thread t1 = new Thread(r);
        t1.start();

        Thread.sleep(2000);
        r.flag = false;

    }
}

class Runnable10 implements Runnable{
    public boolean flag = true;

    @Override
    public void run() {
        int i = 1;
        while(flag){
            System.out.println(Thread.currentThread().getName() + "-->" + i++);
        }
    }
}
