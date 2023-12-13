package com.lzjtuimis._8_graph;

// 边类
public class Arc {
    int start;
    int end;
    double weight;

    public Arc(int start, int end, double weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}
