package 数组_3;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
	//3.5函数int add(int a[N][N] , int b[N])的功能是将a数组中每行的最小元素放入b数组中，编写该函数实现之。
	public static int[] add(int[][] a, int[] b) {
		for(int[] i:a)
			Arrays.sort(i);  // 自小到大排序
		for(int i = 0;i<b.length;i++)
			b[i] = a[i][0];
		return b;
	}
	
	public static void main(String[] args) {
        //3.1任意输入a[N][N]个数，找出并输出其中的最大数和最小数，以及它们的下标。
		Scanner sc = new Scanner(System.in);
		System.out.println("3.1 输入a[N][N]数组，找min和max及其下标。输入n为：");
        int n = sc.nextInt();
        int[][] a = new int[n][n]; 
        int i, j = 0;
        System.out.println("输入" + (n * n) + "个数组元素：");
        for (i = 0; i < n; i++)
            for (j = 0; j < n; j++)
                a[i][j] = sc.nextInt();
        System.out.println("如下二维数组：" + Arrays.deepToString(a));
        int max = a[0][0], min = a[0][0];
        for (i = 0; i < n; i++)
            for (j = 0; j < n; j++){
                if (a[i][j] > max)  
                    max = a[i][j];
                if (a[i][j] < min)
                    min = a[i][j];
            }
        for (i = 0; i < n; i++)
            for (j = 0; j < n; j++){
                if (a[i][j] == max)
                	System.out.println("最大值为：" + a[i][j] + " 下标：" + "(" + i + "," +  j + ")");
                if (a[i][j] == min)
                	System.out.println("最小值为：" + a[i][j] + " 下标：" + "(" + i + "," +  j + ")");
            }
        
        //3.2求数组a[8][8]中，主对角线和次对角线上各元素之和。
        System.out.println("\n3.2 求a[8][8]数组的主次对角线之：");
        a = new int[8][8]; 
        i = j = 0;         
        System.out.println("a[8][8]的数组随机定为：");
        for (i = 0; i < 8; i++){
            for (j = 0; j < 8; j++){
                a[i][j] = (int)(Math.random() * 100);
                System.out.print(" " + a[i][j] + " ");
            }
            System.out.println();
        }
        int sum1 = 0, sum2 = 0;
        for (i = 0; i < 8; i++){
            sum1 += a[i][i];
            sum2 += a[8 - i - 1][i];
        }
        System.out.println("主对角线元素之和：" + sum1 + " 次对角线元素之和：" + sum2);

        //3.3任意输入N个数，将它们由大到小排序输出。
        System.out.println("\n3.3 输入任意n个数，由大到小排序输出，输入n：");
        n = sc.nextInt();
        int[] array = new int[n];
        System.out.println("输入" + n + "个数：");
        for (i = 0; i < n; i++)
            array[i] = sc.nextInt();
        System.out.println("排序前的" + n + "个数：" + Arrays.toString(array));
        for (i = 0; i < array.length; i++){                                                                                
            for (j = i + 1; j < array.length; j++)
                if (array[i] < array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
        }
        System.out.println("大到小排序后的" + n + "个数：" + Arrays.toString(array));
      
        //3.4编程打印下列的杨辉三角形。（设10行）。
        System.out.println("\n3.4 杨辉三角的10行显示：");
        a = new int[10][10];
        for (i = 0; i < 10; i++) 
            a[i][0] = 1;
        for (i = 1; i < 10; i++){
            for (j = 1; j <= i; j++)
                a[i][j] = a[i - 1][j - 1] + a[i - 1][j];  // 左肩加右肩
        }
        for (i = 0; i < 10; i++){
            for (j = 0; j < 10 - i; j++)
            	System.out.printf("%1$5s", " ");
            for (j = 0; j <= i; j++){
            	System.out.printf("%1$5d", a[i][j]);
                System.out.printf("%1$5s", " ");
            }
            System.out.println();
        }
        
        //3.5函数int add(int a[N][N] , int b[N])的功能是将a数组中每行的最小元素放入b数组中，编写该函数实现之。
        System.out.println("\n3.5 将二维数组a[n][n]中的每行元素的最小值放入一维数组b中，输入n：");
        n = sc.nextInt();
        a = new int[n][n];
        int[] b = new int[n];
        System.out.println("输入" + (n * n) + "个数组元素：");
        for (i = 0; i < n; i++)
            for (j = 0; j < n; j++)
                a[i][j] = sc.nextInt();
        System.out.println("二维数组a的元素显示：");
        System.out.println(Arrays.deepToString(a));
        System.out.println("取每行最小值得到的数组b为：");
        System.out.println(Arrays.toString(add(a, b)));
                 
        //3.6将一个数组逆序输出。
        System.out.print("\n3.6 一维数组逆序输出，输入数组个数：");
        n = sc.nextInt();
        array = new int[n];
        System.out.println("输入" + n + "个数组元素：");
        for (i = 0; i < n; i++)
            array[i] = sc.nextInt();
        System.out.println("定义数组：" + Arrays.toString(array));
        for (i = 0, j = array.length - 1; i < j; i++, j--){
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        System.out.println("逆序排序数组：" + Arrays.toString(array));
        
        //3.7任意输入两个字串放入两个字符数组中，并分别排序，
        //然后采用“逐个比较两字串中字符大小”的方法，将他们由小到大的合并到另一数组中。   
        //二路归并。
        System.out.println("\n3.7 两个字符数组分别排序，再采用“逐个比较两字串中字符大小”合并。\n分别输入两个字符串：");
        String s1 = sc.next();
        String s2 = sc.next();
        char[] char1 = s1.toCharArray();
        char[] char2 = s2.toCharArray();
        System.out.println("第一个字符串排序：");
        Arrays.sort(char1);
        System.out.println(Arrays.toString(char1));

        System.out.println("第二个字符串排序：");
        Arrays.sort(char2);
        System.out.println(Arrays.toString(char2));

        char[] char3 = new char[char1.length + char2.length];
        int c1 =0,c2 =0;   // 分别用于遍历char1数组和char2数组
        int c3 = 0;  // 遍历char3数组
        while(c1 < s1.length() && c2 <s2.length()) {
        	if(char1[c1] > char2[c2]) {
        		char3[c3] = char2[c2];
        		c2++;
        	}
        	else {
        		char3[c3] = char1[c1];
        		c1++;
			}
        	c3++;    // char3数组递增
        }
        // char1数组没有遍历完
        if(c1<char1.length)
        	for(;c1<char1.length;c1++) {
        		char3[c3] = char1[c1];
        		c3++;
        	}
        // char2数组没有遍历完
        if(c2<char2.length)
        	for(;c2<char2.length;c2++) {
        		char3[c3] = char2[c2];
        		c3++;
        	}
        System.out.println("二路合并，字符串排序：");
        System.out.println(Arrays.toString(char3));

       
        //3.8找出一个二维数组中的“鞍点”，即该位置上的元素在该行中最大，在该列中最小（也可能没有“鞍点”），打印出有关信息。
        System.out.println("\n3.8 求二维数组鞍点，二维数组为：");
        int[][] arr = {{1, 0, 3, 2},{6, 5, 4, 7},{8, 9, 10, 11},{16, 15, 14, 13}};
        System.out.println(Arrays.deepToString(arr));
        int t = 0;
        for (i = 0; i < arr.length; i++){
            int k;max = 0;
            for (j = 0; j < arr[i].length; j++)   // 寻找行最大并保存坐标
                if (arr[i][max] < arr[i][j])
                    max = j;
            for (k = 0; k < arr.length; k++){       // 寻找列最小，行递增
                if(arr[i][max] > arr[k][max])
					break;
            }
            if (k == arr.length)   // 列上找到最小，在k递增的过程中没有被break
                System.out.println("鞍点的索引为" + i + "," +  max + "，值为" + arr[i][max]);
            else
                t++;   // 记录无鞍点，每一行找到最大后找列最小，找不到t递增，直到与行数一致也没找到
        }
        if (t == arr.length)
            System.out.println("该数组无鞍点");
        

        //3.9耶稣有13个门徒，其中有一个就是出卖耶稣的叛徒，请用排除法找出这位叛徒：13人围坐一圈，从第一个开始报号：
        //1，2，3，1，2，3„„，凡是报到“3”就退出圈子，最后留在圈内的人就是出卖耶稣的叛徒，请找出它原来的序号。
        System.out.println("\n3.9 耶稣门徒问题");
        int[] members = new int[13];           
        int member = 0, number = 0;
        i = 0;
        //number报号，member记出圈的人数，i索引
        while (member < 12){
            if (members[i] == 0){
                number++;
                if (number == 3){
                    members[i] = 1;
                    member++;
                    number = 0;
                }
            }
            //取数组的下一个索引，i=13后又回到0
            i = (i + 1) % 13;               
        }
        for (i = 0; i < 13; i++){
            if (members[i] == 0)
                System.out.println("犹大是第" + (i+1) + "个人");
        }
        

        //3.10从键盘上输入一个2*3的矩阵，将其转秩后形成3*2的矩阵输出。
        System.out.println("\n3.10 数组转置输出");
        System.out.println("输入2*3个数");
        a = new int[2][3];
        for (i = 0; i < 2; i++)
            for (j = 0; j < 3; j++)
                a[i][j] = sc.nextInt();
        System.out.println("原2 * 3的矩阵：");
        for (i = 0; i < 2; i++){
            for (j = 0; j < 3; j++)
                System.out.print(" " + a[i][j] + " ");
            System.out.println();
        }
        System.out.println("转置后3 * 2的矩阵：");
        for (j = 0; j < 3; j++){
            for (i = 0; i < 2; i++)
            	System.out.print(" " + a[i][j] + " ");
            System.out.println();
        }
        
	}

}
