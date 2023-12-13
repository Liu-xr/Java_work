package 文件操作_5;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main5_1 {
	public static void main(String[] args) throws IOException {
		File f1 = new File("C:\\ProgramData\\Kugou\\2.txt");
		String filename = f1.getAbsolutePath().substring(f1.getAbsolutePath().indexOf("2"));
		System.out.println(filename); // 截取文件名称
		File f2 = new File("D:\\a\\" + filename);
		if(f2.createNewFile());
			System.out.println(filename + "创建成功！");
		Scanner sc = new Scanner(System.in);
		System.out.println("每行诗句，输入end退出：");
		int i = 0;
		StringBuffer poet = new StringBuffer();
		while(true) {
			++i;
			System.out.print("诗的第" + i + "行：");
			String line = sc.next();
			if(line.equals("end"))
				break;
			poet.append(line + "\n");
		}
			
		FileWriter fw = new FileWriter(f2);
		fw.write(poet.toString());
		fw.close();
		sc.close();
		
	}

}
