package commonClass;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.TemporalUnit;

/*
 *
6.计算某年、某月、某日和某年、某月、某日之间的天数间隔

7.计算并输出21世纪的闰年，计算程序的执行时间。

8.编写一个程序，设定一个有大小写字母的字符串，先将字符串的小写字符输出，再将字符串中的大写字符输出。

 */
public class Test222 {
	public static void main(String[] args) {
		//1.
		LocalDate today = LocalDate.now();
		LocalDate past = LocalDate.of(2002, 04, 06);
		Long cha = today.toEpochDay() - past.toEpochDay();
		System.out.println("我出生已经" + cha + "天了。");
		
		//2.
		long t1 = System.currentTimeMillis();
		int count = 0;
		for(int i = 2100;i<2200;i++) {
			LocalDate date = LocalDate.of(i,1, 1);
			if(date.isLeapYear())
				count++;
		}
		System.out.println("21世纪共有闰年：" + count);
		long t2 = System.currentTimeMillis();
		System.out.println(t1);
		System.out.println(t2);
		System.out.println("程序执行时间：" + (t2-t1) + "毫秒");
		
		//3. 使用ascii码
		 String string1 = new String("AsDasdDa");
		 StringBuffer string2 = new StringBuffer();
		 StringBuffer string3 = new StringBuffer();
		 for(int i=0;i<string1.length();i++) {
			 char c = string1.charAt(i);
			 int asc = (int)c;
			 if(asc >= 97)   //   97十进制以上为小写字母
				 string2.append(c);
		 }
		  System.out.println("小写字符:" + string2);
		  for(int i=0;i<string1.length();i++) {
		  		char c = string1.charAt(i);
		  		int asc = (int)c;
		  		if(asc <= 90) //  90十进制以下为大写字母
		  			string3.append(c);
		  	}
		  System.out.println("大写字符:" + string3);
		  // A——十六进制0x41——十进制65
		  System.out.println('\u0041');
		  System.out.println(0x41);
		  // a——十六进制0x61——十进制97
		  System.out.println('\u0061');
		  System.out.println(0x61);
		  // Z——十六进制0x5A——十进制90
		  System.out.println('\u005A');
		  System.out.println(0x5A);
		  
		  
		  
	}
}
