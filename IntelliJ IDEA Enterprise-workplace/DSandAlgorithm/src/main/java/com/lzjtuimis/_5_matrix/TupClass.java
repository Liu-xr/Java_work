package com.lzjtuimis._5_matrix;

import java.util.ArrayList;

//三元组表示类
public class TupClass{
    int rows;						//行数
    int cols;						//列数
    int nums;						//非零元素个数
    ArrayList<TupElem> data;		//稀疏矩阵对应的三元组顺序表

    // 创造空三元组表
    public TupClass(){
        data = new ArrayList<>();
        nums = 0;
    }

    // 创造空三元组表
    public TupClass(int rows,int cols, int nums){
        data = new ArrayList<>();
        this.nums = nums;
        this.rows = rows;
        this.cols = cols;
    }

    // 二维稀疏矩阵传入整体创建
    public TupClass(int [][] array){
        data = new ArrayList<>();
        rows = array.length;
        cols = array[0].length;
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++)
                //存储非零元素
                if (array[i][j]!=0){
                    data.add(new TupElem(i,j,array[i][j]));
                    nums++;
                }
        }
    }

    // 三元组元素赋值array[i][j]=x，存在覆盖，不存在添加。k遍历三元组顺序表长度
    public boolean setValue(int i,int j,int x){
        if (i<0 || i>=rows || j<0 || j>=cols)
            return false;
        // 顺序表中每个三元组存储一个非零元素对象，这个非零元素用data.get(k)访问，是一个TupElem类对象
        int k=0;
        while (k<nums && data.get(k).r<i)				// 找行坐标i
            k++;
        while (k<nums && i==data.get(k).r && data.get(k).c<j)
            k++;										//找到第i行后再继续找到第j列

        //若给出的ij坐标是一个非零元素存储在三元组顺序表中，赋值。
        if (data.get(k).r==i && data.get(k).c==j)
            data.set(k, new TupElem(i,j, x));
            //不存在这样的元素时，在三元组顺序表k位置中中插入一个元素
        else{
            data.add(k, new TupElem(i,j, x));
            nums++;
        }
        return true;
    }

    // 执行x=array[i][j]，访问元素并赋值变量
    public int getValue(int i,int j){
        if (i<0 || i>=rows || j<0 || j>=cols)
            return 0;
        // 如果get的值在最后一个非零元素之后，就都是0
        if(i>=data.get(nums-1).r&&j>data.get(nums-1).c)
            return 0;
        int k=0;
        while (k<nums && data.get(k).r<i)
            k++;								//找到第i行
        while (k<nums && data.get(k).r==i && data.get(k).c<j)
            k++;								//在第i行中找到第j列
        //三元组顺序表中找到了这样的非零元素
        if (data.get(k).r==i && data.get(k).c==j)
            return data.get(k).value;					//返回非0元素值
        return 0;									//没有找到返回0
    }

    // 输出三元组表示
    public void display(boolean b){
        //没有非零元素时返回
        if (!(nums > 0))
            return;
        System.out.printf("行数=%d,列数=%d,非0元素个数=%d\n",rows,cols,nums);
        for (int i=0;i<nums;i++)
            System.out.printf("%5d%5d%5d\n",data.get(i).r,data.get(i).c,data.get(i).value);
    }
    public void display(){
        for (int i = 0; i <rows; i++) {
            for (int j = 0; j <cols ; j++)
                    System.out.print("\t" + getValue(i, j) + "\t");
            System.out.println();
        }
    }

    // 三元组转置
    public static TupClass transpose(TupClass a){
        if (a.nums == 0)
            throw new IllegalArgumentException("不可转置");
        //行变列，列变行，非零个数不变
        TupClass b = new TupClass(a.cols,a.rows,a.nums);	//新建空三元组表示b
        // 按原矩阵的列优先遍历
        for (int j=0;j<a.cols;j++)					//按列号j查找
            for (int i=0;i<a.nums;i++)
                //找到j列号的非零元素
                if (a.data.get(i).c == j){		// 行列交换，传递column、row、value的顺序
                    TupElem p = new TupElem(a.data.get(i).c, a.data.get(i).r,
                            a.data.get(i).value);
                    b.data.add(p);			//转置后的三元组顺序表b是按列优先存储，将每个元素添加
                }
        return b;
    }
    // 优化，快速转置
    public static TupClass fastTranspose(TupClass a) {
        TupClass b = new TupClass(a.cols,a.rows,a.nums);
        // 不使用数组而使用ArrayList顺序表所必须做的操作，要扩充设置size，否则在转置时会出现索引越界异常
        // 原因在于add(index,element)方法时，存在检查机制ArrayList.rangeCheckForAdd()使得index不能超过size
        // 总结：ArrayList中的rangeCheck是与集合内的元素总数做比较，而不是与底层的数组长度做比较
        for(int i = 0;i<b.nums;i++)
            b.data.add(new TupElem(0,0,0));
        int j = 0, k = 0;
        // num[col]存放矩阵a中第col列的非零元素的个数
        int[] num = new int[a.cols];
        for(int col=0;col<a.cols;col++){
            num[col]=0;
        }
        for (int i=0; i<a.nums; i++)  {
            j = a.data.get(i).c;      // j的取值为每个col列，每个元素的所在列
            num[j]++;                 // 记录非零元素个数，第col列的非零元素个数++
        }
        // cpot[col]存放矩阵a中第col列的第一个非零元素在data顺序表中的位置
        int[] cpot = new int[a.cols];
        cpot[0] = 0;
        for (int i=1; i<a.cols; i++)
            cpot[i] = cpot[i-1] + num[i-1];     //i-1是因为i从1开始
        //找非零元素转置
        for (int i=1; i<b.nums; i++) {
            j = a.data.get(i).c; // cpot[j]指顺序表第i个元素的所在的第j列，找该列第一个非零位置
            //行列交换转置
            b.data.add(cpot[j], new TupElem(a.data.get(i).c,a.data.get(i).r,a.data.get(i).value));
            cpot[j]++;              //该列下一个非零元的存放位置
        }
        return b;
    }

    // 三元组稀疏矩阵加法
    public TupClass addition(TupClass b){
        if(rows!=b.rows||cols!=b.cols)
            throw new IllegalArgumentException("纬度不同不可相加");
        TupClass c = new TupClass();
        c.rows = rows;
        c.cols = cols;
        int i=0,j=0;
        while(i<nums&&j<b.nums){
            // 行列相等，相加
            if(data.get(i).r == b.data.get(j).r&&
                    data.get(i).c==b.data.get(j).c){
                int value = data.get(i).value + b.data.get(j).value;
                c.data.add(new TupElem(data.get(i).r,data.get(i).c,value));
                c.nums ++;
                i++;j++;
            }
            // 行不相等，加上行小者
            else
                // 行相等，加上列小者
                if(data.get(i).r<b.data.get(j).r||
                        (data.get(i).r == b.data.get(j).r&&data.get(i).c<b.data.get(j).c)) {
                    c.data.add(new TupElem(data.get(i).r, data.get(i).c, data.get(i).value));
                    c.nums++;
                    i++;
                }
                else if(data.get(i).r>b.data.get(j).r||
                        (data.get(i).r == b.data.get(j).r&&data.get(i).c>b.data.get(j).c)) {
                    c.data.add(new TupElem(b.data.get(j).r, b.data.get(j).c, b.data.get(j).value));
                    c.nums++;
                    j++;
                }
        }
        // 剩余未加完的
        while(i<nums){
            c.data.add(new TupElem(data.get(i).r, data.get(i).c, data.get(i).value));
            c.nums++;
            i++;
        }
        while(j<b.nums){
            c.data.add(new TupElem(b.data.get(j).r, b.data.get(j).c, b.data.get(j).value));
            c.nums++;
            j++;
        }
        return c;
    }
}

//三元组元素类
class TupElem{
    int r;								//行号
    int c;								//列号
    int value;								//元素值

    public TupElem(int r,int c,int value){
        this.r = r;
        this.c = c;
        this.value = value;
    }
}