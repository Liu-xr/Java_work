package com.lzjtuimis.javathread;

public class PCSynchronized1 {
    public static void  main(String[] args) {
        MyNumber mn = new MyNumber();
        Producer1 p = new Producer1(mn);
        Consumer1 c = new Consumer1(mn);
        p.start();
        c.start();
    }
}

class MyNumber {
    private boolean flag = false;      //标志是否有数据的信号灯
    private int data = 0;              //存放数据的变量

    public synchronized void push(int i) {
        while (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notify();
        System.out.print("pushed " + i + ",");
        data = i;
        flag = true;
    }

    public synchronized int pop() {
        while (!flag) {                    //flag为false表示没有新数据
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notify();
        flag = false;
        return data;
    }
}

class Producer1 extends Thread {
    private MyNumber mn;

    public Producer1(MyNumber mn) {
        this.mn = mn;
    }

    public void run() {
        int count  = 0;
        while (count < 10) {
            int i = (int) (Math.random() * 10);
            mn.push(i);
            /*try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            count++;
        }
    }
}

class Consumer1 extends Thread {
    private MyNumber mn;

    public Consumer1(MyNumber mn) {
        this.mn = mn;
    }

    public void run() {
        int count = 0;
        while (count < 10) {         // 由于System.out.println("consume:" + i);不包含在synchronized的方法中，
            synchronized (mn) {      // 因此在push()方法中加一个sleep()方法睡眠，所以输出会不对应
                int i = mn.pop();    // 体现在换行的现实中，但生成与消费是一致的，生产多少消费多少
                System.out.println("consume:" + i);  // 所以将该条语句使用synchronized同步语句块包含即可
                count++;
            }
        }
    }
}

