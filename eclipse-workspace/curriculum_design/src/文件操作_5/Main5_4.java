package 文件操作_5;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main5_4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Map<Character, Integer> map = new HashMap<>();
		File f = new File("E:\\信管专业课\\Java程序设计\\课程设计\\词汇统计.txt");
		FileReader fr = new FileReader(f);
		char[] ch = new char[2000];
		int len = fr.read(ch);
		String str = new String(ch, 0, len);
		for (char c : str.toCharArray()) {
			if(map.get(c) != null)
				map.put(c, map.get(c) + 1);
			else 
				map.put(c, 1);
		}
		Set<Character> keys = map.keySet();
		int i = 1;
		for (Character key : keys) {
			++i;
			if(i%6 ==0)
				System.out.println();
			else	
				System.out.print(key + "：" + map.get(key) + "。 ");
		}
		fr.close();
	}

}
