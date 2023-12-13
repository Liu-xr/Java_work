package com.lzjtuimis.entity;


public class MyVex implements Comparable<MyVex> {
    public String no;
    private String name;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{no:"+no+",name:"+name+"}";
    }

    @Override
    public int compareTo(MyVex o) {
        return no.compareTo(o.no);
    }
}
