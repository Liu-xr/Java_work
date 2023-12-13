package com.lzjtuimis.javathread;

public class Priority implements Runnable {
    private final int val;
    Thread obj;
    Priority(int val, String name)
    {
        obj = new Thread(this, name);
        obj.setPriority(val);

        this.val = val;
        System.out.println("线程" + name + "被赋予优先级" + this.val);

        obj.start();
    }
    public void run()
    {
        System.out.println("线程" + obj + "正在运行");
    }

    public static void main(String[] args) {
        new Priority(1, "low thread");
        new Priority(10, "high thread");
    }
}
