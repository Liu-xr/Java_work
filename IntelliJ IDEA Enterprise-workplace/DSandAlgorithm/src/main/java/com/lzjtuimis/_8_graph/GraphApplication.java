package com.lzjtuimis._8_graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class GraphApplication {
    /* prim最小生成树 */
    // 参数v为起始点，可以是任何一个
    public static<T> void minSpanTreePrim(IGraph<T> graph, int v) {
        // 内部类
        class CloseEdge{
            int adjVex;
            double lowCost;
        }
        // 创建CloseEdge数组，存放U与V-U的距离（最小权值的边）的U中顶点
        CloseEdge[] closeEdge = new CloseEdge[graph.getN()];
        /*  第一次初始化  */
        for(int i=0;i< graph.getN();i++){
            closeEdge[i] = new CloseEdge();
            closeEdge[i].adjVex = v;
            // 从U中顶点v开始，与其在V-U中的邻接点i赋权值
            if(graph.getArc(v,i)!=null)
                closeEdge[i].lowCost = graph.getArc(v,i).weight;
            else   						// 不是邻接点，距离就是最远+∞
                closeEdge[i].lowCost = Double.MAX_VALUE;
        }
        closeEdge[v].lowCost = 0;		// 起始点v0加入U，置为0

        /* 外层循环是V-U，循环n-1次，内层是closeEdge数组 */
        for (int i = 0; i < graph.getN()-1 ; i++) {
            int min = 0;
            // 找到第一个没加到U中的权值最小的
            for(int j = 0;j<closeEdge.length;j++){
                if(closeEdge[j].lowCost!=0){    // 不包括加入到U的0
                    min = j;					// min从j开始
                    break;
                }
            }
            // 一个循环，分为两个
            for(int j = min+1;j<closeEdge.length;j++){
                if(closeEdge[j].lowCost==0) continue;
                if(closeEdge[j].lowCost<=closeEdge[min].lowCost)  // 找到最小权值边
                    min = j;
            }
            closeEdge[min].lowCost = 0;							 // 置为0，加入U
            // 判断新加入U的顶点min与其邻接点j的权值，更新最小
            for (int j = 0; j < closeEdge.length; j++) {
                if(graph.getArc(min, j)!=null){
                    if (graph.getArc(min, j).weight < closeEdge[j].lowCost){
                        closeEdge[j].lowCost = graph.getArc(min, j).weight;  // 权值更新
                        closeEdge[j].adjVex = min;							 // 加入顶点更新
                    }
                }
            }
        }
        System.out.println("prim算法最小生成树包括：");
        for(int i=1;i<graph.getN();i++){
            int j = closeEdge[i].adjVex;
            System.out.println("顶点："+j+" --- 顶点：" +i+ " --- 权值："+ graph.getArc(j,i).weight);
        }
    }

    /* Kruskal最小生成树 */
    public static<T> void minSpanTreeKruskal(IGraph<T> graph){
        // 存入边到list
        ArrayList<Arc> list = new ArrayList<>() ;
        for(int i=0;i < graph.getN()-1;i++) {
            for(int j=i+1;j < graph.getN();j++) {
                if(graph.getArc(i,j)!=null)
                    list.add(graph.getArc(i,j));
            }
        }
        // 比较器，按照weight排序
        list.sort((o1, o2) -> (int) (o1.weight - o2.weight));
        ArrayList<Arc> listTree = new ArrayList<>();		// 生成树list
        // from数组初始化，填充值为-1
        int[] from = new int[list.size()];
        Arrays.fill(from, -1);
        // 判断是否回路，不构成则添加到生成树list中
        for(Arc arc:list){
            int m = find(from, arc.start);
            int n = find(from, arc.end);
            if(m!=n){               // 这条边的弧尾和弧头（邻接点的弧尾）不是同一个起始点
                from[m] = n;
                listTree.add(arc);
            }
        }
        System.out.println("Kruskal算法最小生成树：");
        for(Arc arc:listTree){
            System.out.println("顶点：" + arc.start+" --- 顶点：" + arc.end + " --- 权值：" + arc.weight);
        }
    }
    private static int find(int[] from, int v){
        while(from[v]!=-1)
            v = from[v];
        return v;
    }

    /*DijkstraAlgorithm,迪杰斯特拉算法,最短路径*/
    static class CloseEdge{
        int adjVex;        // 记录上一个的顶点，也就是从哪个顶点adjVex到达当前顶点i
        double lowCost;
        double weight;
    }   // v为顶点号，必须0开始，即创建的图顶点存在0号。若图不从0开始，则单独添加一个顶点0，不与任何顶点相连
    public static<T> void shortestPath(IGraph<T> graph, int v){
        /*  初始化  */
        CloseEdge[] closeEdge = new CloseEdge[graph.getN()];
        for(int i=0;i< graph.getN();i++){
            closeEdge[i] = new CloseEdge();
            closeEdge[i].adjVex = v;
            // 从S中顶点v开始，与其在V-S中的邻接点i赋权值
            if(graph.getArc(v,i)!=null)
                closeEdge[i].lowCost = graph.getArc(v,i).weight;
            else
                closeEdge[i].lowCost = Double.MAX_VALUE;
        }
        closeEdge[v].lowCost = 0;		// 源点v0加入U，置为0

        /*  迭代寻找  */
        for (int i = 0;i < graph.getN()-1;i++) {
            int min = 0;
            // 在数组中找到第一个未加到S中的权值最小弧，不包括0
            for(int j = 0;j<closeEdge.length;j++){
                if(closeEdge[j].lowCost!=0){
                    min = j;
                    break;
                }
            }
            for(int j = min+1;j < closeEdge.length;j++){
                if(closeEdge[j].lowCost==0) continue;
                if(closeEdge[j].lowCost<=closeEdge[min].lowCost)  // 找到最小权值弧
                    min = j;
            }
            // 代替进行更新数组最小权重值，因为要置为0
            closeEdge[min].weight = closeEdge[min].lowCost;
            closeEdge[min].lowCost = 0;

            // 判断新加入S的顶点min，是否满足D[min] + |v(min),vj| < D[j]
            for (int j = 0; j < closeEdge.length; j++) {
                if(graph.getArc(min, j)!=null){
                    if (closeEdge[min].weight + graph.getArc(min, j).weight < closeEdge[j].lowCost){
                        closeEdge[j].lowCost = closeEdge[min].weight + graph.getArc(min, j).weight; //权值更新
                        closeEdge[j].adjVex = min;
                    }
                }
            }
        }
        // 记录并显示输出
        for (int i = 1; i < graph.getN(); i++) {
            String shortestPath = (closeEdge[i].weight==Double.MAX_VALUE?" +∞ ":String.valueOf(closeEdge[i].weight));
            System.out.print("源点：" + v + " --> 终点："+ i +" 最短路径：" + shortestPath + " 途径顶点序列：");
            if(shortestPath.equals(" +∞ "))
                System.out.println("不可达");
            else
                System.out.println(v + "--" + getPath(i, v, closeEdge) + i);
        }
    }
    // 根据adjVex属性，循环查找该路径上一个途径顶点,v为源点
    private static StringBuilder getPath(int i, int v, CloseEdge[] closeEdge){
        StringBuilder s = new StringBuilder();
        while(closeEdge[i].adjVex!=v){
            s.insert(0,closeEdge[i].adjVex+"--");
            i = closeEdge[i].adjVex;
        }
        return  s;
    }

    /* 拓扑排序 */
    public static<T> boolean topologicalSort(ListGraph<T> G){
        int count = 0;							    // 输出顶点计数
        int[] inDegree = new int[G.getN()];
        for (int i = 0;i<G.getN();i++)
            inDegree[i] = G.getInDegree(i);		    // 求各顶点入度
        Stack<Integer> stack = new Stack<>();	    // 建零入度顶点栈
        for (int i = 0; i < G.getN(); i++)         // 入度为0者进栈
            if (inDegree[i] == 0)
                stack.push(i);
        while (!stack.isEmpty()) {
            int i = stack.pop();                    //栈不空，取栈顶元素
            System.out.print(G.getVex(i) + " ");    // 输出v号顶点并计数
            count++;
            // 修改邻接表顶点的入度
            AdjListNode<T> node = G.vexNodes[i].firstAdj;
            while(node!=null){
                if (--inDegree[node.adjVex] == 0)     // 对i号顶点的每个邻接点的入度减1
                    stack.push(node.adjVex);          // 若入度减为0，则入栈
                node = node.nextAdj;
            }
        }
        // 该有向图是否有回路，判断环
        return count >= G.getN();
    }

}
