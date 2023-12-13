package com.lzjtuimis.javabase;


import java.lang.reflect.Field;

// 转换为成员变量的基本数据类型可以实现函数值交换
public class ChangeBaseTypeValue {
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private int x;
    private int y;

    public ChangeBaseTypeValue(int x,int y){
      this.x = x;
      this.y = y;
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        ChangeBaseTypeValue changeBaseTypeValue = new ChangeBaseTypeValue(4, 5);

        System.out.println("交换之前a："+changeBaseTypeValue.getX()+" 交换之前b："+changeBaseTypeValue.getY());
        swap(changeBaseTypeValue);
        System.out.println("交换之后a："+changeBaseTypeValue.getX()+" 交换之后b："+changeBaseTypeValue.getY());

        int[] arr = {11, 22, 111, 222};
        System.out.println("交换前的值" + arr[0] + "和" + arr[3]);
        change(arr, 0, 3);
        System.out.println("交后值" + arr[0] + "和" + arr[3]);

        Integer a = 2;
        Integer b = 4;
        System.out.println("a="+a+","+"b="+b);//a=2,b=4
        change(a,b);
        System.out.println("a="+a+","+"b="+b);//a=4,b=2


    }
    public static void swap(ChangeBaseTypeValue t)
    {
        int temp = t.x;
        t.x = t.y;
        t.y = temp;
    }

    // data数组张红每两个为要交换的数的值，a和b是要交换 两数的索引
    public static void change(int[] data, int a, int b){
        int t = data[a];
        data[a] = data[b];
        data[b] = t;
    }

    // 使用反射，jdk版本过高不适用
    public static void change(Integer a, Integer b) throws  IllegalAccessException, NoSuchFieldException {
        int temp = a;

        Class classa = a.getClass();
        Field field = classa.getDeclaredField("value");

        field.setAccessible(true);

        field.setInt(a, b);
        field.setInt(b, temp);
    }
    }
