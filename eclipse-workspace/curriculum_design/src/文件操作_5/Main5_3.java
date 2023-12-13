package 文件操作_5;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main5_3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileReader fr = new FileReader("E:\\Java_work\\eclipse-workspace\\curriculum_design\\src\\文件操作_5\\Main5_3.java");
		char[] ch = new char[1024];
		int len = fr.read(ch);
		String content = new String(ch, 0, len);
		String[] src = content.split("\n");  // 换行符分割成每一行
		System.out.println(Arrays.toString(src));
		for (String string : src) {
			System.out.print(string);
		}
		fr.close();
	}
}
