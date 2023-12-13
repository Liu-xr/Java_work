package com.lzjtuimis.javaio;

import java.io.*;
import java.time.LocalDate;

public class CustomizeSerializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //1. 测试部分定制串行化
        Employee e = new Employee(new int[]{1001, 20, 4000}, new String[]{"刘兴瑞", "信息管理部"});
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("部分定制串行化.ser"));
        out.writeObject(e);
        out.close();

        e = null;  //将对象设为空，接下来恢复为写入时的数据
        ObjectInputStream in = new ObjectInputStream((new FileInputStream("部分定制串行化.ser")));
        e = (Employee) in.readObject();
        in.close();
        System.out.println("=====职工=====\n" + e.toString());


        //2.测试完全定制串行化
        ManagerExtern m = new ManagerExtern(new int[]{1002, 20, 4000}, new String[]{"刘兴瑞", "信息管理部"},
                "部门经理");
        ObjectOutputStream outE = new ObjectOutputStream(new FileOutputStream("完全定制串行化.ser"));
        outE.writeObject(m);
        outE.close();

        m = null;
        ObjectInputStream inE = new ObjectInputStream((new FileInputStream("完全定制串行化.ser")));
        m = (ManagerExtern) inE.readObject();
        inE.close();
        System.out.println("=====管理者=====\n" + m.toString());
    }
}


class Employee implements Serializable{
    int id, age, salary;
    String name, department;

    public Employee(){}
    public Employee(int[] i, String[] s){  //属性初始化
        id = i[0];
        age = i[1];
        salary = i[2];
        name = s[0];
        department = s[1];
    }

    //实现writeObject()方法
    @Serial
    private void writeObject(ObjectOutputStream out) throws IOException {
        LocalDate savedNow = LocalDate.now();
        out.writeInt(id);
        out.writeInt(age);
        out.writeInt(salary);
        out.writeUTF(name);
        out.writeUTF(department);
        out.writeInt(savedNow.getYear());
    }

    //实现readObject()方法：以写入时的顺序读取
    @Serial
    private void readObject(ObjectInputStream in) throws IOException {
        LocalDate now = LocalDate.now();
        id = in.readInt();
        age = in.readInt();
        salary = in.readInt();
        name = in.readUTF();
        department = in.readUTF();
        int savedYear = in.readInt();
        age = age + (now.getYear() - savedYear);
    }

    public String toString(){
        return "id:" + id + "\nname:" + name +
                "\nage:" + age + "\nsalary:" + salary + "\ndepartment:" + department;
    }

}


class ManagerExtern extends Employee implements Externalizable{
    String position;

    public ManagerExtern(){}
    public ManagerExtern(int[] i, String[] s, String position){
        super(i, s);
        this.position = position;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        LocalDate savedNow = LocalDate.now();
        out.writeInt(id);
        out.writeInt(age);
        out.writeInt(salary);
        out.writeUTF(name);
        out.writeUTF(department);
        out.writeInt(savedNow.getYear());
        out.writeUTF(position);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        LocalDate now = LocalDate.now();
        id = in.readInt();
        age = in.readInt();
        salary = in.readInt();
        name = in.readUTF();
        department = in.readUTF();
        int savedYear = in.readInt();
        position = in.readUTF();
        age = age + (now.getYear() - savedYear);
    }

    public String toString(){
        return super.toString() + "\nposition:" + position;
    }
}