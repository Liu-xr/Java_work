package IOliu;

/*
 * 一） 在电脑D盘下创建一个文件为HelloWorld.txt文件，判断他是文件还是目录，在创建一个目
录IOTest,之后将HelloWorld.txt移动到IOTest目录下去；之后遍历IOTest这个目录下的文
件
 */
import java.io.File;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args) {
		File file = new File("E:\\Java_work\\eclipse-workspace\\PracticeTest\\HelloWorld.txt");
        try {
            System.out.println(file + "是否创建成功：" + file.createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (file.isDirectory()) {
            System.out.println(file.getAbsolutePath() + "是目录");
        } else if (file.isFile()) {
            System.out.println(file + "是文件");
        }
        File dir = new File("E:\\Java_work\\eclipse-workspace\\PracticeTest");
        System.out.println(dir + "是否创建成功：" + dir.mkdir());
        System.out.print(file + "文件重命名是否成功：");
        System.out.println(file.renameTo(new File(dir.getAbsolutePath() + File.separator + file.getName())));

        System.out.println("遍历目录：" + dir);
        String[] files = dir.list();
        for (String fileName : files) {
            System.out.println(fileName);
        }
	}

}
