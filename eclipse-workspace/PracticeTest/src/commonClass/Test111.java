package commonClass;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 1.请根据控制台输入的特定日期格式拆分日期
如：请输入一个日期（格式如： ** 月 ** 日 **** 年）
经过处理得到： **** 年 ** 月 ** 日
提示：使用String的方法indexOf、lastIndexOf、substring

2.给出一个随机字符串，判断有多少字母？多少数字？

3.编写敏感词过滤程序
说明：在网络程序中，如聊天室、聊天软件等，经常需要对一些用户所提交的聊天内容中的敏感性词语进行过滤。如“性”、“色情”、“爆炸”、“恐怖”、“枪”、“军火”等，
	  这些都不可以在网上进行传播，需要过滤掉或者用其他词语替换掉。

提示：将用户的聊天内容保存到一个字符串对象或一个StringBuilder对象中，然后与敏感词语类表（数组实现）进行比对。如果属于敏感词语，就过滤掉或替换掉。

4. 字符串分割来达到查找字符串中存在的字符串有多少个
 */
public class Test111 {
	public static void main(String[] args) {
		//1. 将年月日各自摘取出来后重新排序连接
		Scanner sc = new Scanner(System.in);
	    System.out.println("请输入日期：（格式：xx月xx日xxxx年）");
	    String date = sc.next();
	    
	    int m = date.indexOf("月");
	    int d = date.indexOf("日");
	    String month = date.substring(0, m);
	    String day = date.substring(m+1, d);
	    String year = date.substring(d+1, date.length()-1);

	    sc.close();
	    System.out.println(year+"-"+month+"-"+day+"");
		
	    //2. 
	    String str = "123abcABC-+*+/";
	    char[] s = str.toCharArray();
	    int char_num=0;  //计算字母
	    int num = 0;     //计算数字
	    int other = 0;   //计算其他字符
	   // 字符是按照Unicode编码顺序排的
	    for(int i=0;i<s.length;i++){
	    	if (s[i]<='9' && s[i]>='0')
	    		num++;
	        else if (s[i]>='a'&&s[i]<='z' || s[i]>='A'&&s[i]<='Z')
	            char_num++;
	        else
	            other++;
	    }
	   
	    System.out.println("字符有" + char_num+"个;数字有"+ num +"个;其他字符有"+ other +"个");

	   // 3.
		String content = "军火商正准备把枪支贩卖给当地恐怖分子来使得他们制造一场恐怖的爆炸袭击，并且还会传播色情物品来达到丑化性的目的。";
		String[] warn = {"性", "色情", "爆炸", "恐怖", "枪", "军火"};
		for(int i = 0; i<warn.length;i++)
			content = content.replaceAll(warn[i], "*");  // 字符串替换，replaceAll()
		System.out.println(content);
		
		
		// 4. 
		String sing = "我不是朋友，你也不是朋友，我们什么也不是朋友";
		// 以朋友为分隔符分割出数组
		String[] aa = sing.split("朋友");
		System.out.println(Arrays.toString(aa));
		//分割出多少个元素，就要多少个分隔符，就有多少个“朋友”
		System.out.println("个数是："+aa.length);
	}

}
