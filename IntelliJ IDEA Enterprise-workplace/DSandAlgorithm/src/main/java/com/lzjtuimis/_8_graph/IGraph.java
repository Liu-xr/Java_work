package com.lzjtuimis._8_graph;

public interface IGraph<T>{
    GraphKind getGraphKind();

    int getN();

    int getE();

    T getVex(int i);   // 获取给定序号i的顶点

    int locateVex(T vex);  // 获取给定顶点的序号

    Arc getArc(int v, int w);  // 获取给定两个顶点序号的边

    int getInDegree(int v);

    int getOutDegree(int v);

    default int getDegree(int v) {
        if (getGraphKind() == GraphKind.DG || getGraphKind() == GraphKind.DN)
            return getInDegree(v) + getOutDegree(v);      // 有向图/网，返回出度+入度
        else
            return getOutDegree(v);    // 无向图/网，返回度
    }

    int[] getAdjVex(int v);   // 返回序号为i的顶点的临界点序号的集合

    Arc[] getAdjArc(int v);   // 返回序号为i的顶点的临接边的集合

    int firstAdjVex(int v);   // 获取顶点v第一个邻接点的序号

    int nextAdjVex(int v, int w);  // 获取顶点v从顶点w之后的下一个邻接点的序号

    void insertVex(T vex);

    void removeVex(int v);

    void insertArc(int i, int j, double weight);  // 插入一条边，起点、重点、权值

    void removeArc(int i, int j);       // 删除顶点i与顶点j的边，有向图/网是顶点i到j的一条方向的边

    void BFSTraverse() throws Exception;   //广度优先遍历BFS

    void DFSTraverse();                 //深度优先遍历DFS，

}
