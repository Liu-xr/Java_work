package com.lzjtuimis._8_graph;

import com.lzjtuimis.entity.MyVex;
import org.junit.Test;

public class TestGraph {
    @Test
    public void graphCreate(){  // 测试图的创建
        MatrixGraph<MyVex>  matrixGraph = new MatrixGraph<>("matrix.json",MyVex.class);
        System.out.println(matrixGraph.getGraphKind());
        System.out.println(matrixGraph.n);
        System.out.println(matrixGraph.e);
        // 获取每一个顶点
        for (int i = 0; i < matrixGraph.n; i++) {
            System.out.println(matrixGraph.getVex(i));
        }
        System.out.println(matrixGraph.getVex(5).getName());
    }

    @Test
    public void graphMinSpanTree(){  // 测试最小生成树
        MatrixGraph<MyVex>  matrixGraph = new MatrixGraph<>("minSpanningTree.json",MyVex.class);
        // prim算法
        GraphApplication.minSpanTreePrim(matrixGraph,0);
        // 克鲁斯卡尔算法
        GraphApplication.minSpanTreeKruskal(matrixGraph);
        // 最小生成树测试结果不唯一，因为最小生成树可以多个

    }

    @Test
    public void graphShortestPath(){ // 测试最短路径
        System.out.println("使用邻接矩阵测试：");
        MatrixGraph<MyVex>  matrixGraph = new MatrixGraph<>("shortestPath.json",MyVex.class);
        GraphApplication.shortestPath(matrixGraph,0);
        System.out.println("使用邻接表测试：");
        ListGraph<MyVex>  matrixGraph1 = new ListGraph<>("shortestPath2.json",MyVex.class);
        GraphApplication.shortestPath(matrixGraph1,1);

    }
}
