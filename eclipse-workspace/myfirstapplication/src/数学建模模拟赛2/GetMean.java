package 数学建模模拟赛2;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class GetMean {
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("E:\\数学建模\\模拟赛2\\CJ1.txt");
		char[] ch = new char[10240];
		int length = 0;
		length = fr.read(ch);
		System.out.println(length);
		System.out.println(ch);
		System.out.println("============分割线===========");
		String str = new String(ch);
		System.out.println(str);
		str = str.trim();   // 取两端空白
		String[] s = str.split("   ");   // 每个数据以3个空格分割
		System.out.println("============分割线===========");
		System.out.println(Arrays.toString(s));
		Arrays.sort(s);
		System.out.println("最小值为：" + s[1]);
		double sum = 0;
		for(int i = 0; i<s.length;i++)
			sum += Double.parseDouble(s[i]);
		System.out.println(s.length);
		System.out.println(sum);
		System.out.println(sum/s.length);
		fr.close();
			
		
			
	}

}
