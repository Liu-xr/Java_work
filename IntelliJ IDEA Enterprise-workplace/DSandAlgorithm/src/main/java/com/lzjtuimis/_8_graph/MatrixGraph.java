package com.lzjtuimis._8_graph;


import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.lzjtuimis._4_queue.IQueue;
import com.lzjtuimis._4_queue.LinkQueueClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

import static com.lzjtuimis._8_graph.GraphKind.*;

@SuppressWarnings("unchecked")
public class MatrixGraph<T> implements IGraph<T> {
    final static int INFINITY =  Integer.MAX_VALUE;  //int类型最大值，如果算法有INF+INF，则会溢出
    GraphKind kind; 		        //图的种类标志
    public int n, e;     			//图的当前顶点数和边数
    public T[] vexes; 		 		//顶点的数组
    public double[][] arcs; 		//邻接矩阵
    
    public MatrixGraph(String filename, Class<T> tClass) {
        // 以字节流的形式读取文件
        InputStream is = Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(filename));
        InputStreamReader isr = new InputStreamReader(is);          // 字节流转换字符流
        BufferedReader br = new BufferedReader(isr);                // 服务缓冲字符流，读取一行一行速度快
        String line;
        StringBuilder content = new StringBuilder();                // 保存读取的json内容
        try {
            while((line = br.readLine())!=null){                    // 读取文件内容到字符串
                content.append(line);
            }
        } catch (IOException ex) {
                ex.printStackTrace();
        }
        JSONObject jsonObject = JSONObject.parseObject(content.toString(),JSONObject.class);     // 字符串解析为json对象
        // 转换图的类型kind，读取
        kind = GraphKind.valueOf(jsonObject.get("kind").toString());
        // 获取顶点vexes数组
        JSONArray jsonArray = jsonObject.getJSONArray("vexes");
        n = jsonArray.size();
        vexes = (T[]) new Object[n];
        for (int i = 0; i < n; i++) {
            vexes[i] = jsonArray.getObject(i,tClass);
        }
        // 获取边或弧arcs邻接矩阵
        JSONArray jsonArray1 = jsonObject.getJSONArray("arcs");
        e = jsonArray1.size();
        arcs = new double[e][e];
        for (int i = 0; i < e; i++) {                               // 获取每个json对象中的三个属性，根据类型get值
            int start = jsonArray1.getJSONObject(i).getIntValue("tail");
            int end = jsonArray1.getJSONObject(i).getInteger("head");
            double weight = jsonArray1.getJSONObject(i).getInteger("weight");
            arcs[start][end] = weight;                              // 矩阵，行列确定位置赋值
            if(kind == GraphKind.UDG || kind == GraphKind.UDN)
                arcs[end][start] = weight;
        }
    }

    @Override
    public GraphKind getGraphKind() {
        return kind;
    }

    @Override
    public int getN() {
        return n;
    }

    @Override
    public int getE() {
        return e;
    }

    // 获取给定序号i的顶点
    @Override
    public T getVex(int i) {
        return vexes[i];
    }

    // 获取给定顶点的序号
    @Override
    public int locateVex(T vex) {
        for(int i =0;i<n;i++)
            if(vexes[i].equals(vex))
                return i;
        return -1;
    }

    // 获取给定两个顶点序号的边
    @Override
    public Arc getArc(int i, int j) {
        // 边值不是0或∞
        if(arcs[i][j]!=0 && arcs[i][j]<INFINITY) {
            return new Arc(i, j, arcs[i][j]);
        }
        return null;
    }

    // 获取序号为j的顶点的入度：第j列所有元素，对应顶点数组的第j个
    @Override
    public int getInDegree(int j) {
        int count = 0;
        for(int i =0;i<n;i++)
            if(arcs[i][j]!=0 && arcs[i][j]<INFINITY)
                count ++;
        return count;
    }

    // 获取序号为i的顶点的入度:第i行的所有元素，对应顶点数组的第i个
    @Override
    public int getOutDegree(int i) {
        int count = 0;
        for(int j =0;j<n;j++)
            if(arcs[i][j]!=0 && arcs[i][j]<INFINITY)
                count ++;
        return count;
    }

    @Override
    public int getDegree(int v) {
        return IGraph.super.getDegree(v);
    }

    // 返回序号为i的顶点的邻接点序号的集合
    @Override
    public int[] getAdjVex(int i) {
        // 获得临接点个数，即出度个数
        int count = getOutDegree(i);
        int[] adjVexes = new int[count];
        int k = 0;
        for(int j =0;j<n;j++)
            if(arcs[i][j]!=0 && arcs[i][j]<INFINITY)
                adjVexes[k++] = j;
        return adjVexes ;
    }

    // 返回序号为i的顶点的邻接边的集合
    @Override
    public Arc[] getAdjArc(int i) {
        // 先获取序号为i的顶点临接点集合
        int[] adjVexes = getAdjVex(i);
        Arc[] adjArcs = new Arc[adjVexes.length];
        int k = 0;
        // 返回顶点i与其邻接点构成的邻接边的集合
        for(int j=0;j<adjVexes.length;j++)
            adjArcs[k++] = getArc(i,j);
        return adjArcs;
    }

    // 获取顶点i第一个邻接点的序号
    @Override
    public int firstAdjVex(int i) {
        for(int j =0;j<n;j++)
            if(arcs[i][j]!=0 && arcs[i][j]<INFINITY)
                return j;
        return -1;
    }

    // 获取顶点i从顶点j之后的下一个邻接点的序号
    @Override
    public int nextAdjVex(int i, int j) {
        for(int k =j;k<n;k++)
            if(arcs[i][k]!=0 && arcs[i][k]<INFINITY)
                return k;
        return -1;
    }

    // 插入顶点，顶点数组附加，邻接矩阵加一列一行
    @Override
    public void insertVex(T vex) {
        // 顶点数组扩容，数组复制
        T[] vexes1 = (T[]) new Object[n + 1];
        if (n >= 0) System.arraycopy(vexes, 0, vexes1, 0, n);
        vexes1[n++] = vex;       //n已加1
        vexes = vexes1;
        // 邻接矩阵扩容,数组复制
        double[][] arcs1 = new double[n][n];
        for (int i = 0; i < n - 1; i++)
            System.arraycopy(arcs[i], 0, arcs1[i], 0, n - 1);
        // 邻接矩阵增加一行一列
        int value = kind == DG || kind == UDG ? 0 : INFINITY;
        for (int i = 0; i < n; i++) {
            arcs1[n- 1][i] = value;
            arcs1[i][n- 1] = value;
        }
        arcs = arcs1;
    }

    // 移除序号为v的顶点，顶点数组删除，邻接矩阵删除一行一列
    @Override
    public void removeVex(int v) {
        // v顶点在顶点数组中前移
        for (int i = v + 1; i < n; i++) {
            vexes[i - 1] = vexes[i];
        }
        int count = getOutDegree(v);                            // 统计第v行出度
        if (kind == GraphKind.DG || kind == GraphKind.DN)   // 有向图/网的入度
            count += getInDegree(v);
        // 行上移，列前移
        for (int i = v + 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arcs[i - 1][j] = arcs[i][j];
                arcs[j][i - 1] = arcs[j][i];
            }
        }
        // 修改顶点数、边数
        n--;
        e -= count;   // 减去顶点v的度，边数减少
    }

    // 在顶点i与顶点j处插入权值为weight的边,以前没有
    @Override
    public void insertArc(int i, int j, double weight) {
        arcs[i][j] = weight;
        // 若为无向图/网，对称矩阵
        if(kind == UDG || kind == GraphKind.UDN)
            arcs[j][i] = weight;
    }

    // 删除顶点i与顶点j的边，有向图/网是顶点i到j的一条方向的边
    @Override
    public void removeArc(int i, int j) {
        // 若为图，权值为0
        if(kind == UDG || kind == DG) {
            if (kind == UDG)  // 无向，对称
                arcs[i][j] = arcs[j][i] = 0;
            else
                arcs[i][j] = 0;
        }
        // 若为网，权值为∞，
        if(kind == GraphKind.UDN || kind == GraphKind.DN) {
            if (kind == GraphKind.UDN)
                arcs[i][j] = arcs[j][i] = INFINITY;
            else
                arcs[i][j] = INFINITY;
        }
    }

    private static boolean[] visited;	// 定义标志数组
    // 广度优先遍历BFS
    @Override
    public void BFSTraverse() {
        // 标志数组初始化,false
        visited = new boolean[n];
        for (int v = 0; v < n; v++)
            visited[v] = false;
        // 对没有访问过的顶点，调用BFS()方法从一个顶点出发广度搜索
        for (int v = 0; v < n; v++)
            if (!visited[v]) 		// v尚未访问
                BFS(this, v);
    }
    private void BFS(IGraph<T> G, int v) {
        IQueue<Integer> queue = new LinkQueueClass<>();     // 自定义链队
        System.out.print(G.getVex(v) + " ");                // 输出顶点值
        visited[v] = true;
        queue.offer(v);			                            // 访问过的顶点v入队
        while (!queue.empty()) {
            int u = queue.poll();		                    // 队头元素出队，先进先出
            // 从顶点u的第一个邻接点开始，遍历u的每个邻接点
            for (int w = G.firstAdjVex(u); w >= 0; w = G.nextAdjVex(u,w))
                if (!visited[w]) {		// 若w为u的尚未访问的邻接顶点
                    visited[w] = true;
                    System.out.print(G.getVex(w)+ " ");
                    queue.offer(w);
                }
        }
    }

    // 深度有点遍历DFS
    @Override
    public void DFSTraverse() {
        //标志数组初始化,false
        visited = new boolean[n];
        for (int v = 0; v < n; v++)
            visited[v] = false;
        // 对没有访问过的顶点，调用DFS()方法从一个顶点出发深度搜索
        for (int v = 0; v < n; v++)
            if (!visited[v])		// 对尚未访问的顶点
                DFS(this, v);
    }
    private void DFS(IGraph<T> G, int v){
        // 标记第v个顶点访问过
        visited[v] = true;
        System.out.print(G.getVex(v) + " ");
        // 从顶点v的第一个邻接点开始，遍历v的每个邻接点w
        for (int w = G.firstAdjVex(v); w >= 0; w = G.nextAdjVex(v, w))
            if (!visited[w])	        // 尚未访问的v的邻接顶点w
                DFS(G, w);	            // 递归调用
    }

    // 输出图
    public void display(){
        for(int i = 0;i<n;i++){
            for(int j =0;i<n;j++){
                if(arcs[i][j] == INFINITY)
                    System.out.print(" ∞ ");
                else
                    System.out.print(" " + arcs[i][j] + " ");
            }
            System.out.println();
        }
    }
}
