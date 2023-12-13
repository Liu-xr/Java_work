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

@SuppressWarnings("unchecked")
public class ListGraph <T>  implements IGraph<T>{
    GraphKind kind;
    int n, e;
    public VexNode<T>[] vexNodes;  //顶点结点数组

    public ListGraph(GraphKind kind, int n, int e, VexNode<T>[] vexNodes) {
        this.kind = kind;
        this.n = n;
        this.e = e;
        this.vexNodes = vexNodes;
    }

    public ListGraph(String filename, Class<T> tClass) {
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
        T[] t = (T[])jsonArray.toArray();
        for (int i = 0; i < n; i++) {
            t[i] = jsonArray.getObject(i,tClass);
        }
        vexNodes = new VexNode[n];
        for (int i = 0; i < n; i++) {
            vexNodes[i] = new VexNode<>(t[i], null);
        }
        // 获取边或弧arcs创建邻接表
        JSONArray jsonArray1 = jsonObject.getJSONArray("arcs");
        e = jsonArray1.size();
        for (int i = 0; i < n; i++) {
            int start = jsonArray1.getJSONObject(i).getIntValue("tail");
            int end = jsonArray1.getJSONObject(i).getInteger("head");
            double weight = jsonArray1.getJSONObject(i).getInteger("weight");
            insert(start,end,weight);
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

    @Override
    public T getVex(int i) {
        return vexNodes[i].data;
    }

    @Override
    public int locateVex(T vex) {
        for (int i = 0; i < n; i++) {
            if(vexNodes[i].equals(vex))
                return i;
        }
        return -1;
    }

    @Override
    public Arc getArc(int v, int w) {
        VexNode<T> vexNode = vexNodes[v];   // 获取序号v的顶点
        AdjListNode<T> p = vexNode.firstAdj;  // 获取顶点v的邻接表首个结点
        while(p!=null) {
            if (p.adjVex == w)                  // 找到v与w之间的边或弧
                return new Arc(v, w, p.weight);
            p = p.nextAdj;
        }
        return null;
    }

    @Override
    public int getInDegree(int v) {
        int count = 0;
        for(int i = 0;i<n;i++){
            AdjListNode<T> p = vexNodes[i].firstAdj;
            while(p!=null){
                if(p.adjVex == v)
                    count++;
                p = p.nextAdj;
            }
        }
        return count;
    }

    @Override
    public int getOutDegree(int v) {
        int count = 0;
        AdjListNode<T> p = vexNodes[v].firstAdj;
        while(p!= null){
            count++;
            p = p.nextAdj;
        }
        return count;
    }

    @Override
    public int getDegree(int v) {
        return IGraph.super.getDegree(v);
    }

    // 返回序号为v的顶点的邻接点序号的集合
    @Override
    public int[] getAdjVex(int v) {
        // 获得临接点个数，即出度个数
        int count = getOutDegree(v);
        int[] adjVexes = new int[count];
        AdjListNode<T> p = vexNodes[v].firstAdj;
        int k = 0;
        while(p!=null){
            adjVexes[k++] = p.adjVex;
            p = p.nextAdj;
        }
        return adjVexes ;
    }

    // 返回序号为v的顶点的邻接边的集合
    @Override
    public Arc[] getAdjArc(int v) {
        // 先获取序号为v的顶点临接点集合
        int[] adjVexes = getAdjVex(v);
        Arc[] adjArcs = new Arc[adjVexes.length];
        int k = 0;
        // 返回顶点v与其邻接点构成的邻接边w的集合
        for(int w=0;w<adjVexes.length;w++)
            adjArcs[k++] = getArc(v,w);
        return adjArcs;
    }

    // 第一个邻接点序号
    @Override
    public int firstAdjVex(int v) {
        if(vexNodes[v].firstAdj!=null)
            return vexNodes[v].firstAdj.adjVex;
        return -1;
    }

    // 顶点v在顶点w下一个邻接点序号
    @Override
    public int nextAdjVex(int v, int w) {
        AdjListNode<T> p = vexNodes[v].firstAdj;
        while(p!=null){
            if(p.adjVex == w){
                if(p.nextAdj!=null)
                    return p.nextAdj.adjVex;
                else
                    return -1;
            }
            p = p.nextAdj;
        }
        return -1;
    }

    // 插删顶点
    @Override
    public void insertVex(T vex) {
        VexNode<T>[] vexNodes = new VexNode[this.vexNodes.length+1];
        System.arraycopy(this.vexNodes, 0, vexNodes, 0, n);
        vexNodes[n-1] = new VexNode<>(vex,null);
        this.vexNodes = vexNodes;
        n++;
    }

    @Override
    public void removeVex(int v) {
        for (int i = v+1; i < n; i++) {
            vexNodes[i-1] = vexNodes[i];
        }
        n--;
        // v序号大的邻接表中的结点序号也要变，减1
        for (int i = 0; i < n; i++) {
            AdjListNode<T> pre = null;  // p的前驱结点
            AdjListNode<T> p = vexNodes[i].firstAdj;
            while(p!=null){
                if(p.adjVex>v)
                    p.adjVex -= 1;
                // 删掉在原顶点数组序号为v的结点
                else if(p.adjVex==v){
                    if(pre == null)   // 前驱null，表示v是邻接表第一个结点，删掉它
                        vexNodes[i].firstAdj = vexNodes[i].firstAdj.nextAdj;
                    else   //删掉，前驱的next指向p的next
                        pre.nextAdj = p.nextAdj;
                }
                pre = p;
                p = p.nextAdj;
            }
        }
    }

    // 插(改)删边弧
    @Override
    public void insertArc(int i, int j, double weight) {
        insert(i,j,weight);
        // 无向图/网
        if(kind == GraphKind.UDG||kind==GraphKind.UDN)
            insert(j,i,weight);
        e++;
    }
    // 插改有向
    private void insert(int i, int j, double weight){
        if(vexNodes[i].firstAdj==null||vexNodes[i].firstAdj.adjVex<j)
            vexNodes[i].firstAdj = new AdjListNode<>(j, weight, null);
        AdjListNode<T> p = vexNodes[i].firstAdj;
        while(p.nextAdj!=null&&p.adjVex <= j){
            p = p.nextAdj;
        }
        if(p.adjVex == j)
            p.weight = weight;
        AdjListNode<T> node = new AdjListNode<>(j, weight,null);
        node.nextAdj = p.nextAdj;
        p.nextAdj = node;
    }

    @Override
    public void removeArc(int i, int j) {
        remove(i,j);
        // 无向图/网是重复包含的
        if(kind == GraphKind.UDG || kind == GraphKind.UDN)
           remove(j,i);
        e--;
    }
    // 删除有向
    private void remove(int i, int j){
        // 删除第i个邻接表的j号结点
        AdjListNode<T> p = vexNodes[i].firstAdj;
        AdjListNode<T> q ;
        while(p!=null){
            q = p;              // 保存前一个结点
            if(p.adjVex == j)
                q.nextAdj = p.nextAdj;
            p = p.nextAdj;
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

}

// 顶点结点
class VexNode<T> {
    T data;             	        //图的顶点数据域
    AdjListNode<T> firstAdj;  	    //邻接表的第一个结点

    public VexNode(T data, AdjListNode<T> firstAdj) {
        this.data = data;
        this.firstAdj = firstAdj;
    }
}

class AdjListNode <T> {
    int adjVex; 		// 该邻接点在顶点结点数组中的位置
    double weight; 		// 边或弧的权值
    AdjListNode<T> nextAdj; 	// 指向下一个邻接点

    public AdjListNode(int adjVex, double weight, AdjListNode<T> nextAdj) {
        this.adjVex = adjVex;
        this.weight = weight;
        this.nextAdj = nextAdj;
    }
}