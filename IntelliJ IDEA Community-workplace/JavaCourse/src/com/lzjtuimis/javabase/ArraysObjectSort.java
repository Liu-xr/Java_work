package com.lzjtuimis.javabase;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysObjectSort {
    public static void main(String[] args) {

        Student student1 = new Student("1", "lxr", 18);
        Student student2 = new Student("2","lx", 19);
        Student student3 = new Student("3", "l", 20);

        Student[] students = {student1, student3, student2};
        System.out.println("排序前：");
        for (Student s:students
        ) {
            System.out.println(s.toString());
        }

        Arrays.sort(students, new Comparator<Student>() {  // 对象数组按照对象的学号属性排序
            @Override
            public int compare(Student o1, Student o2) {
                return o1.sno.compareTo(o2.sno);
            }
        });

        System.out.println("排序后：");
        for (Student s:students
             ) {
            System.out.println(s.toString());
        }


    }
}

