package 文件操作_5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main5_5 {
	public static void main(String[] args) throws IOException {
		File f = new File("C:\\Users\\Redrum\\Pictures\\C#课设\\登录界面.png");
		File f1 = new File("D:\\登录界面.png");
		System.out.println("创建要剪切到的目录中的文件：" + (f1.createNewFile()?"创建成功！":"创建失败！"));
		FileInputStream fin = new FileInputStream(f);
		FileOutputStream fout = new FileOutputStream(f1);
		int i;
		while((i = fin.read()) != -1) {
			fout.write(i);
		}
		
		System.out.println("删除原来目录文件达到剪切效果：" + (f.delete()?"删除成功.":"删除失败."));
		fout.close();
		fin.close();
	}

}
