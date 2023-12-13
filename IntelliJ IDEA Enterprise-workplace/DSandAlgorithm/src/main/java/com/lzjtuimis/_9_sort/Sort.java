package com.lzjtuimis._9_sort;

import java.util.Comparator;

@SuppressWarnings("unchecked")
public class Sort {
    /* 插入排序 */
    public static<T> void insertSort(T[] elements, Comparator<T> comparator){
        for (int i = 1; i < elements.length; i++) {  // i是待排序元素，后方无序序列第一个，从第2个开始
            T temp = elements[i];
            int j;              // j是前方有序序列的最后一个
            for (j = i - 1; j >= 0 && comparator.compare(elements[j], temp) > 0; j--) {
                elements[j + 1] = elements[j];      // 向后移动，向前推进
            }
            elements[j + 1] = temp;         // 将temp插入位置
        }
    }
    public static<T> void insertSortWithGuard(T[] elements, Comparator<T> comparator){
        for (int i = 2; i < elements.length; i++) {
            elements[0] = elements[i];         // 待排序元素放到最前面，数组长度要多一个，索引为0处要腾出位置
            int j; // 少一个比较，无需判断是否j>=0越界，即若待排序元素比较到最前时，碰到监视哨，本身相等，自动跳出循环
            for (j = i - 1;comparator.compare(elements[j], elements[0]) > 0; j--) {
                elements[j + 1] = elements[j];      // 向后移动，向前推进
            }
            elements[j + 1] = elements[0];         // 将待排元素插入位置
        }
    }

    // 希尔排序
    public static<T> void shellSort(T[] elements, int[] delta,Comparator<T> comparator){
        for (int d:delta) {
            for (int i = d; i < elements.length; i++) {
                T temp = elements[i];
                int j;
                for (j = i - d; j >= 0 && comparator.compare(elements[j], temp) > 0; j-=d) {
                    elements[j + d] = elements[j];
                }
                elements[j + d] = temp;
            }
        }
    }

    /* 交换排序 */
    public static<T> void bubbleSort(T[] elements, Comparator<T> comparator){
            boolean flag = true;
            T temp;
            for (int i = elements.length-1; i >= 1 && flag; i--) {
                flag = false;
                for (int j = 0; j < i; j++) {
                    if(comparator.compare(elements[j], elements[j+1]) > 0){
                        temp = elements[j];
                        elements[j] = elements[j+1];
                        elements[j+1] = temp;
                        flag = true;
                    }
                }
            }
    }

    // 快速排序
    public static <T> void quickSort(T[] elements, Comparator<T> comparator) {
        //quickSort(elements, 0, elements.length - 1,comparator);
        //代码实现二：
        quickSort1(elements, 0, elements.length - 1,comparator);
    }
    // 代码实现一
    private static <T> void quickSort(T[] elements, int low, int high,Comparator<T> comparator) {
        if (low >= high) return;     // 低位不能大于高位
        int mid = partition(elements, low, high,comparator);
        quickSort(elements, low, mid - 1,comparator);   // 递归实现
        quickSort(elements, mid + 1, high,comparator);
    }
    private static <T> int partition(T[] elements, int low, int high,Comparator<T> comparator) {
        //固定的切分方式
        T temp = elements[low];
        while (low < high) {
            //从后半部分向前扫描
            while (low < high && comparator.compare(temp,elements[high]) <= 0)
                high--;
            elements[low] = elements[high];
            //从前半部分向后扫描
            while (low < high && comparator.compare(elements[low],temp) <= 0)
                low++;
            elements[high] = elements[low];
        }
        elements[low] = temp;
        return low;
    }
    // 代码实现二
    private static <T> void quickSort1(T[] elements, int low, int high,Comparator<T> comparator) {
        if (low >= high) return;     // 低位不能大于高位
        int mid = partition1(elements, low, high,comparator);
        if(low < mid)
            quickSort1(elements, low, mid - 1,comparator);   // 递归实现
        if(mid < high)
            quickSort1(elements, mid + 1, high,comparator);
    }
    private static <T> int partition1(T[] elements, int low, int high,Comparator<T> comparator) {
        //固定的切分方式
        T temp = elements[low];
        while (low < high) {
            //从后半部分向前扫描
            while (low < high && comparator.compare(temp,elements[high]) <= 0)
                high--;
            if(low == high) break;
            elements[low++] = elements[high];
            //从前半部分向后扫描
            while (low < high && comparator.compare(elements[low],temp) <= 0)
                low++;
            elements[high--] = elements[low];
        }
        elements[low] = temp;
        return low;
    }

    /*  选择排序 */
    public static <T> void selectionSort(T[] elements,Comparator<T> comparator) {
        for (int i = 0; i < elements.length - 1; i++) {
            int min = i;            // 记录最小值坐标，每次令外循环i为最小，若内循环j有更小则替代
            for (int j = i + 1; j < elements.length; j++) {
                if (comparator.compare(elements[min],elements[j]) > 0)
                    min = j;
            }
            if (min != i) {        // 一趟外循环后找到此次最小，交换位置
                T temp = elements[min];
                elements[min] = elements[i];
                elements[i] = temp;
            }
        }
    }
    // 树形选择排序
    public static <T> void treeSort(T[] elements, Comparator<T> comparator) {
        int numLeaf = elements.length;						// 叶子节点数量
        int numNotLeaf = (numLeaf%2==0?numLeaf-1:numLeaf);  // 非叶子结点数量，度为1与度为2的结点
        T[] elements1 = elements.clone();					// 辅助克隆数组
        // 建数组表示完全二 叉树，存放未排序元素的序号
        int[] bTree = new int[2*numNotLeaf + 1];			// 开辟满二 叉树n为偶数的存储空间，2*n2+1
        bTree[2*numNotLeaf] = -1;  							// 设一个叶子节点为空，仅当叶子节点数量为单数时有用
        // 数组末尾存放叶子结点，即待排序列elements的序号0,1,2……
        for(int i=numNotLeaf;i<numNotLeaf + numLeaf;i++){
            bTree[i] = i - numNotLeaf;
        }
        // 通过比较初始化胜者树，即非叶子节点，第一趟排序结果
        for(int i = numNotLeaf-1;i>=0;i--){
            bTree[i] = findMinIndex(elements1, bTree,i,comparator);
        }
        // 排序重赋值elements数组
        for(int k=0;k<numLeaf;k++){
            elements[k] = elements1[bTree[0]]; 		// 将每次排序得到的最小元素根节点
            int index = bTree[0] + numNotLeaf;  	// 找到此次排序的最小元素在二 叉树数组中的序号
            bTree[index] = -1;   					// 将此处的序号置为-1，表示删除该结点
            // 每次优胜者树的排序结果
            while(index>0) {
                index = (index-1)/2;	// 父结点
                bTree[index] = findMinIndex(elements1,bTree,index,comparator);// 找左 右孩子最小者在elements的序号
            }
        }
    }
    //找出序号为i的两个孩子元素中较小的元素的序号
    private static<T> int findMinIndex(T[] elements,int[] bTree,int i,Comparator<T> comparator) {
        if (bTree[2 * i + 1] == -1)
            return bTree[2 * i + 2];
        else if (bTree[2 * i + 2] == -1)
            return bTree[2 * i + 1];
        else {
            if (comparator.compare(elements[bTree[2 * i + 1]], elements[bTree[2 * i + 2]]) > 0)
                return bTree[2 * i + 2];
            else
                return bTree[2 * i + 1];
        }
    }

    // 堆排序
    public static <T> void heapSort(T[] elements,Comparator<T> comparator) {
        //构造初始堆,自下向上，从最后一个叶子节点的父结点开始调整,二 叉树不断扩大，左 右孩子节点中较大的交换到父节点中
        for (int i = elements.length/2-1; i >= 0; i--) {
            heapAdjust(elements, i, elements.length - 1, comparator);
        }
        //排序，将最大的节点放在堆尾，然后从根节点重新筛选调整，i--表示二 叉树不断缩小
        for (int i = elements.length - 1; i > 0; i--) {
            T temp = elements[0];
            elements[0] = elements[i];
            elements[i] = temp;
            heapAdjust(elements, 0, i - 1,comparator);
        }
    }
    private static <T> void heapAdjust(T[] elements, int start, int end,Comparator<T> comparator) {
        T temp = elements[start];		// 保留栈顶记录
        int i = start;
        // 有左 右孩子
        while (i * 2 < end) {   // 每次循环都是根左 右三个结点的比较
            int k = 2*i+1;				// k用来记录左孩子或右孩子序号，先从i的左孩子开始
            if (k + 1 <= end) {			// 有右孩子，取左 右孩子中最大者
                if (comparator.compare(elements[k],elements[k + 1]) < 0) {
                    k++;
                }
            } // 与堆顶记录比较，最大孩子结点调整到根节点，i为每次向下迭代的根节点
            if (comparator.compare(temp,elements[k]) < 0) {
                elements[i] = elements[k];
                i = k;
            }
            else   // 比左 右孩子都大，已调整为大顶堆，break
                break;
        }
        elements[i] = temp;  // 将堆顶记录筛选调整到相应位置
    }

    /* 归并排序 */
    public static <T> void mergeSort(T[] elements,Comparator<T> comparator) {
        T[] temp = (T[])new Object[elements.length];
        mergeSort(elements, 0, elements.length - 1, temp,comparator);
    }
    private static<T> void mergeSort(T[] elements, int left, int right, T[] temp,Comparator<T> comparator) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(elements, left, mid, temp,comparator);             // 左边归并排序，使得左子序列有序
            mergeSort(elements, mid + 1, right, temp,comparator);   // 右边归并排序有序
            merge(elements, left, mid, right, temp,comparator);         // 左 右有序子序列合并为一个
        }
    }
    private static<T>void merge(T[]elements, int left, int mid, int right, T[]temp, Comparator<T>comparator) {
        int i = left;       //左序列指针A
        int j = mid + 1;    //右序列指针B
        int t = 0;          //合并后的序列指针C
        // 在均为越界的时候双双比较
        while (i <= mid && j <= right) {
            if (comparator.compare(elements[i], elements[j]) < 0)
                temp[t++] = elements[i++];
            else
                temp[t++] = elements[j++];
        }
        // 单独一边没有合并完
        while (i <= mid)        //将左边剩余元素填充进temp中
            temp[t++] = elements[i++];
        while (j <= right)      //将右序列剩余元素填充进temp中
            temp[t++] = elements[j++];
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while (left <= right)
            elements[left++] = temp[t++];
    }
}
