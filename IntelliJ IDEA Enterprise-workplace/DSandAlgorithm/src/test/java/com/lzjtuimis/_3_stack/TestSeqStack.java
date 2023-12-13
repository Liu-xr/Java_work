package com.lzjtuimis._3_stack;

import com.lzjtuimis.entity.Student;

public class TestSeqStack {
    public static void main(String[] args) {
        Student student = new Student();
        student.setNo("101010");
        student.setName("张三");
        student.setAge(21);
        SeqStackClass<Student> stackClass = new SeqStackClass<>();
        stackClass.push(student);
        stackClass.clear();
        System.out.println(stackClass.empty());
        stackClass.push(student);
        System.out.println(stackClass.peek());
    }
}
