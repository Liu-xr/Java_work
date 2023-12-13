package com.lzjtuimis.javathread;

import java.util.ArrayList;

// 测试：生产者消费者模型-->管程法：利用缓冲区解决
// 生产者，消费者，产品，缓冲区。线程同步问题，同一时刻只允许消费者或生产者对产品的作用
public class PCSynchronize {
    public static void main(String[] args)  throws Exception{
        SynContainer container = new SynContainer();

        // 虽然先生产者线程push在消费和线程pop前调用，但真正线程启动时是随机的，
        // 为避免第一次，pop方法先执行，但容器中没产品，所以如果pop方法抢，则让其wait等待
        new Producer(container).start();
        new Consumer(container).start();

    }
}

// 生产者
class Producer extends Thread {
    SynContainer s;

    Producer(SynContainer s) throws InterruptedException {
        this.s = s;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                s.push();
                System.out.println("生产者：" + i);
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

// 消费者
class Consumer extends Thread {
    SynContainer s ;

    Consumer(SynContainer s) throws InterruptedException {
        this.s = s;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                s.pop();
                System.out.println("消费者：" + i);
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

// 缓冲区
class SynContainer {

    // 需要一个容器
    static ArrayList<String> list = new ArrayList<>();

    // 生产者放入产品
    public synchronized void push() throws InterruptedException {/*
        // 如果容器里面有产品，就需要等待消费者消费
        if (!list.isEmpty()) {
            // 通知消费者消费，生产者等待
            this.wait();
        }
        // 如果没有产品，则生产者添加产品
        list.add("鸡腿");
        System.out.println("生产后容器余量：" + list.size());
        System.out.println("生产者添加了1件产品");
        this.notify();*/


        /* 首次执行不会抢，则接下来必定是一个等待，一个通知状态的线程执行顺序*/

        list.add("root");
        System.out.println("生产后容器余量：" + list.size());
        System.out.println("生产者添加了1件产品");
        this.notifyAll();
        this.wait();


    }

    // 消费者消费产品
    public synchronized void pop() throws InterruptedException {/*
        // 判断能否消费
        if (list.isEmpty()) {
            // 通知生产者生产，消费者等待
            this.wait();
        }
        // 如果有产品了，则通知消费者消费
        list.remove(0);
        System.out.println("消费后容器余量：" + list.size());
        System.out.println("消费者消费了1件产品");
        this.notify();
*/

        /* 首次执行不会抢，则接下来必定是一个等待，一个通知状态的线程执行顺序*/

        list.remove(0);
        System.out.println("消费后容器余量：" + list.size());
        System.out.println("消费者消费了1件产品");
        this.notifyAll();
        this.wait();


    }
}
