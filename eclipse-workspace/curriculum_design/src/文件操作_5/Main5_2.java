package 文件操作_5;

import java.io.File;

public class Main5_2 {
	public static void main(String[] args) {
		File file = new File("E:\\信管专业课\\Java程序设计");
		String[] fileContent = file.list();
		System.out.println(file.getAbsolutePath() + "的目录，包含以下目录和文件：");
		for (String string : fileContent) {
			System.out.println(string);
		}
	}

}
