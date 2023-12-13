package com.lzjtuimis._9_sort;

import com.lzjtuimis.entity.Student;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class SortTest {
    @Test
    public  void  insert(){
        Integer[] a = {null,5,4,0,1,9,20,52,12};
        Sort.insertSortWithGuard(a, Comparator.comparingInt(o -> o));
        System.out.println(Arrays.toString(a));

        Student student = new Student("001","刘兴瑞",20);
        Student student1 = new Student("011","刘",11);
        Student student2 = new Student("201","刘瑞",24);
        Student student3 = new Student("051","兴瑞",18);
        Student student4 = new Student("006","刘瑞兴",0);
        Student[] students = new Student[]{student, student1, student2, student3, student4};
        Sort.insertSort(students, Comparator.comparingInt(Student::getAge));
        for (Student s:students
             ) {
            System.out.println(s);
        }

        Integer[] b = {5,4,0,1,9,20,52,12};
        Sort.shellSort(b,new int[]{5,3,1}, Comparator.comparingInt(o -> o));
        System.out.println(Arrays.toString(b));
    }

    @Test
    public void swap(){
        Integer[] a = {33,45,96,1,46,83,0,10};
        Sort.quickSort(a, Comparator.comparingInt(o -> o));
        System.out.println(Arrays.toString(a));

        Student student = new Student("001","刘兴瑞",20);
        Student student1 = new Student("011","刘",13);
        Student student2 = new Student("201","刘瑞",21);
        Student student3 = new Student("051","兴瑞",19);
        Student student4 = new Student("006","刘瑞兴",24);
        Student student5 = new Student("120","张三",0);
        Student[] students = new Student[]{student, student1, student2, student3, student4,student5};
        Sort.quickSort(students, Comparator.comparingInt(Student::getAge));
        for (Student s:students
        ) {
            System.out.println(s);
        }

    }
    @Test
    public void select(){
        Integer[] a = {33,45,96,1,46,83,0,10};
        Sort.treeSort(a, Comparator.comparingInt(o -> o));
        System.out.println(Arrays.toString(a));

        Integer[] b = {33,45,96,1,46,83,0,10};
        Sort.heapSort(b, Comparator.comparingInt(o -> o));
        System.out.println(Arrays.toString(b));

    }
    @Test
    public void merge(){
        Integer[] a = {33,45,96,1,46,83,0,10};
        Sort.mergeSort(a, Comparator.comparingInt(o -> o));
        System.out.println(Arrays.toString(a));

        Student[] students = new Student[9];
        students[0] = new Student("10","虚拟人",16);
        students[1] = new Student("20", "张三", 12);
        students [2]= new Student("29", "张四", 13);
        students[3]= new Student("20", "张五", 18);
        students[4]= new Student("21", "张刘", 14);
        students [5]= new Student("220", "张七", 15);
        students [6]= new Student("320", "张八", 17);
        students [7]= new Student("40", "张就", 18);
        students [8]= new Student("2", "张是", 2);
        Sort.mergeSort(students, Comparator.comparingInt(Student::getAge));
        for (Student student : students) {
            System.out.println(student);
        }


    }
}
