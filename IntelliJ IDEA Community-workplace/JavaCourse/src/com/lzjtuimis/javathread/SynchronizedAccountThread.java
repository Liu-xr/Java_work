package com.lzjtuimis.javathread;

public class SynchronizedAccountThread {
    public static void main(String[] args) {
        // 起初余额10000
        Account a1 = new Account("101", "刘兴瑞", 10000);

        // 同一个a1对象。创建两个线程，由于同步语句块，所以按顺序取款
        MyThread1 t1 = new MyThread1(a1);
        MyThread1 t2 = new MyThread1(a1);

        // 测试未使用同步的线程体，是否会抢断
        MyThread2 t3 = new MyThread2(a1);

        t1.start(); // 先线程t1取款5000，余额5000
        // 执行时，t1和t2线程由于需要先后访问锁，会有可察觉的停顿
        t2.start(); // 后线程t2取款5000，余额0

        // 未使用同步语句块的线程，有时抢断前两个线程，有时正常
        t3.start();

        // 避免main线程运行太快，睡眠1s后输出，阻塞状态
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("刘兴瑞借款后的最终余额为：" + a1.balance);


    }
}


class Account{
    String id;
    String name;
    int balance = 0;

    public Account(String id, String name, int balance){
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    //使用同步语句块
    public void withdraw(int money){

            int before = balance;
            int after = before - money;
            balance = after;
            System.out.println(name + "的账户余额为：" + balance);

    }

    //未使用同步语句块
    public void withdraw1(int money){
        int before = balance;
        int after = before - money;
        balance = after;
        System.out.println(name + "的账户余额为：" + balance);
    }
}

// 使用了同步的线程体
class MyThread1 extends  Thread{
     final Account account;

    public MyThread1(Account account){
        this.account = account;
    }

    @Override
    public void run(){
        synchronized (account) {
            account.withdraw(5000);
        }
    }
}

// 未使用同步的线程体
class MyThread2 extends Thread{
    Account account;

    public MyThread2(Account account){
        this.account = account;
    }

    @Override
    public void run(){
        account.withdraw1(5000);
    }
}