package 函数_2;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;

public class Main_2 {
	public static void main(String[] args) throws Exception {
        //2.1求1+2!+3!+...+20!的和，N！定义为函数。
		System.out.println("2.1 计算1+2!+3!+...+20!的和为：" + nJieChengSum(20));
        
        //2.2编写一个函数，将字符串中的元音字母输出。例如字符串为“boy and girl”, 则输出为：oai。
        System.out.println("\n2.2 字符串元音字母输出：");
        yuanYinLetterPrint("boy and girl");
        
        //2.3 编程实现将任意的十进制整数转换成R进制数（R在2-16之间）。
        System.out.println("\n\n2.3 十进制整数转换为R进制数：");
        jinZhiConvert(10, 2);
        jinZhiConvert(10, 8);
        jinZhiConvert(10, 16);
        
        //2.4计算x^n。
        System.out.println("\n2.4 计算计算x^n，x为2， n为4：" +  powXN(2, 4));

        //2.5编写函数，参数为学习成绩：学习成绩>=90分的同学用A表示，60-89分之间的用B表示，60分以下的用C表示。
        System.out.println("\n2.5 学习成绩等级表示：");
        gradeShow(89);
        gradeShow(91);
        gradeShow(59);

        //2.6编一函数，能把从参数读入的一个字符中的小写字母全部转换成大写字母，
        //然后输出到一个磁盘文件“test”中保存（用字符！表示输入字符串的结束）。
        System.out.println("\n2.6 小写字母的字符串转大写字母后写入text.txt文件：");
        lowerToUpper("this is java test.");
         
        //2.7在主函数中输入6个字符串，用另一个函数对他们按从小到大的顺序，然后在主函数中输出这6个已经排好序的字符串。
        System.out.println("\n2.7 字符串数组小到大排序；");
        String[] str = { "abcdef", "abcde", "abc","abcd","ab","a" };
        System.out.println("排序前，字符串数组：" + Arrays.toString(str));
        sortString(str);
        System.out.println("排序后，字符串数组：" + Arrays.toString(str));
         
        //2.8 定义一个函数，交换两个数的值。
        System.out.println("\n2.8 函数交换两个基本数据类型的值：");
        Integer a = 11, b = 22;
	    System.out.println("交换前两数的值：" + a + "、" + b);
	    change(a, b);
	    System.out.println("交换后两数的值：" + a + "、" +  b);
        int[] array = {11, 22};
        System.out.println("交换前值：" + Arrays.toString(array));
        change(array);
        System.out.println("交换后值：" + Arrays.toString(array));
        
        //2.9编一函数，根据每个月上网时间计算上网费用，计算方法如下：
        //时间不大于10小时，费用为30元；10-50小时，每小时3元；大于50小时，每小时5元。
        System.out.println("\n2.9 上网费用计算：");
        internetFee(9.9);
        internetFee(20);
        internetFee(56.0);
        
        //2.10 应用String的substring,trim,left,pad,length,replace等函数。
        System.out.println("\n2.10 String相关函数：");
        String string = "  this is a java String!  ";
        System.out.println(string);
        System.out.println(string.substring(12, 23));
        System.out.println(string.trim());
        System.out.println(string.length());
        System.out.println(string.replace('j', 'J'));
	}
	
    //2.1 求1+2!+3!+...+20!的和，N！定义为函数。
    public static long nJieChengSum(int n){
        long i = 1, jiecheng = 1, sum = 0;
        while (i <= n){
            jiecheng *= i;
            sum += jiecheng;
            i++;
        }
        return sum;
    }

    //2.2 编写一个函数，将字符串中的元音字母输出。例如字符串为“boy and girl”, 则输出为： oai。
    public static void yuanYinLetterPrint(String str){
    	System.out.print(str + "中的元音字符有：");
        for(char c : str.toCharArray())
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                System.out.print(c);
    }

    //2.3 编程实现将任意的十进制整数转换成R进制数（R在2-16之间）。
    public static void jinZhiConvert(int sjz, int R) throws Exception{
        int sjz1 = sjz; 
        StringBuffer a = new StringBuffer("");
        if (R >= 2 && R <= 10){
            while (sjz1 > 0){
                a.append(String.valueOf(sjz1 % R));
                sjz1 /= R;
            }
        }
        else if (R > 10 && R <= 16){
            while (sjz1 > 0){
                if (sjz1 % R < 10)
                	a.append(String.valueOf(sjz1 % R));
                else
                	a.append(String.valueOf((char) (0x41 + sjz1 % R - 10)));
                sjz1 = sjz1 / R;
            }
        }
        else
            throw new Exception("请规范输入！");
        System.out.printf("(10)%1d = (%2$1d)" + a.reverse() + "\n", sjz, R);
    }

    //2.4计算x的n次方。
    public static int powXN(int x, int n){
        int s = 1;
        for (int i = 1; i <= n; i++){
            s *= x;
        }
        return s;
    }

    //2.5编写函数，参数为学习成绩：学习成绩>=90分的同学用A表示，60-89分之间的用B表示，60分以下的用C表示。
    public static void gradeShow(int grade){
        if (grade >= 90)
            System.out.println(grade + " -> A");
        else if (grade >= 60 && grade <= 89)
        	System.out.println(grade + " -> B");
        else
        	System.out.println(grade + " -> C");
    }

    //2.6 编一函数，能把从参数读入的一个字符中的小写字母全部转换成大写字母，
    //然后输出到一个磁盘文件“test”中保存（用字符！表示输入字符串的结束）。
    public static void lowerToUpper(String str) throws IOException{
        String str1 = str.toUpperCase();
        FileWriter fw = new FileWriter("E:\\信管专业课\\Java程序设计\\课程设计\\test.txt");
        fw.write(str1 + "!");
        fw.close();
        System.out.println("保存成功！");
    }

    //2.7 在主函数中输入6个字符串，用另一个函数对他们按从小到大的顺序，然后在主函数中输出这6个已经排好序的字符串。
    public static void sortString(String[] str){
        for (int i = 0; i < str.length; i++){
            for (int j = i + 1; j < str.length; j++)
                if (str[i].length() > str[j].length()){
                    String middle = str[i];
                    str[i] = str[j];
                    str[j] = middle;
                }
        }
    }

    //2.8 定义一个函数，交换两个数的值。
    // 1） 使用反射修改值，会有警告
    public static void change(Integer a, Integer b) throws  IllegalAccessException, NoSuchFieldException {
        int temp = a;

        Class<? extends Integer> classa = Integer.class;
        Field field = classa.getDeclaredField("value");
        field.setAccessible(true);

        field.setInt(a, b);
        field.setInt(b, temp);
    }
    // 2) 使用数组交换两个数的值
    public static void change(int[] array){
        int t = array[0];
        array[0] = array[1];
        array[1] = t;
    }

    //2.9编一函数，根据每个月上网时间计算上网费用，计算方法如下：
    //时间不大于10小时，费用为30元；10-50小时，每小时3元；大于50小时，每小时5元。
    public static void internetFee(double hour){
        if (hour <= 10)
        	System.out.println("上网" + hour + "小时费用为30元。");
        else if (hour > 10 && hour <= 50)
        	System.out.println("上网" + hour + "小时费用为" + (hour * 3) +  "元。");
        else
        	System.out.println("上网" + hour + "小时费用为" + (hour * 5) +  "元。");
    }

}
