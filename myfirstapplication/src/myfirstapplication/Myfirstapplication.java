package myfirstapplication;
import java.util.Arrays;
import java.util.Scanner;  //用户输入


/*
 * 文档注释
 */
public class Myfirstapplication {
	 public static long fib(long n)
	 {
	 	if (n == 0 || n == 1)
	 		return n;
	 	else
	  		return n + fib(n-1);
	 }
  public static void main(String args[])
  {/*
	  char cha = '1';
	  double a = 1.5;
	  int b = (int)a;
	  System.out.println(b);   //强制转换不会四舍五入
	  
	  //一个堆内存可以被多个栈内存指向。
	  int[] arr = new int[5];
	  for(int c : arr)
	  {
		  System.out.print(c+"\t"); 
	  }
	  System.out.println();    //数组arr赋值array，当array改变值时，二者都改变。
	  int[] array = arr;
	  array[0] = 1;
	  for(int c : arr)
	  {
		  System.out.print(c+"\t");
	  }
	  System.out.println();   //二维数组
	  int[][] array1 = {{1,2},{3,4,5}};
	  for(int[] c : array1)
	  {
		  for(int d : c)
		  {
		  System.out.print(d+"\t");
		  }
		  System.out.println(); 
	  }
	  
	  //命令行参数
	  System.out.println("the first parameter " + args[0]); 
	  System.out.println("the second parameter " + args[1]); 
	  //在命令行执行时：java  文件路径(加后缀)  命令行参数string类型
	  int x = Integer.parseInt(args[0]);
	  System.out.println(x+1);
	  
	  //类
	  Rectangle obj = new Rectangle(4.6,6.3);
	  obj.周长();
	  Rectangle.面积(obj); //静态方法，由于main()方法不在该类中，所以加类名前缀使用
	  
	  //递归函数
	  long a = fib(3);
	  System.out.println(a);
	  
	  //字符串与ASCII编码
	  System.out.println('\u0041'); //Unicode字符码表中的0041编号表示字符'A'
	  System.out.println(0x41);  //输入十六进制，以十进制显示。0x41 = (10)65
	  byte[] arr = {97, 0x41, 65};  //二进制ASCII值97表示a，65表示A，十六进制0x41也表示A
	  String s = new String(arr);
	  System.out.println(s);
	  System.out.println("Aaa".compareToIgnoreCase("AAa111"));
	  */
	   /*
	  //用户输入
	  System.out.println("输入一行内容：");
	  Scanner s = new Scanner(System.in);
	  String mes =  s.next();
	  System.out.println("得到该行：" + mes);
	  */
	  
	  int[][] a = {{1, 2, 3}, {4, 5, 6}};
	  int[] b = {5, 9, 3, 2};
	  System.out.println(Arrays.deepToString(a));
	  Arrays.sort(b);
	  System.out.println(Arrays.toString(b));
	  System.out.printf("--%1$5s", "lxr");
	  
	  
  }
}
