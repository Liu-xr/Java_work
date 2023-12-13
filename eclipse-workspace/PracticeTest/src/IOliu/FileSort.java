package IOliu;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**

* 查看D盘中所有的文件和文件夹名称，并且使用名称升序降序，

* 文件夹在前和文件夹在后，文件大小排序等。

*

* 程序分析:

* 1.查找文件和文件夹，需要例题二里遍历文件的工具类（这里直接调用，不在重写）

* 2.排序需要用到list集合里面的Collections工具类类的sort方法

* 3.这里有三重排序：首先是要按是否是文件夹来排序，然后按名称来排序，最后按大小来排序

* 其实这里还是会有问题的，按照某一个排序还没事，但是三个都排序就不一定有效！

实际应用中也是只按一种排序就可以了的

* */
public class FileSort {
	public static void main(String[] args) {
		File[] files = new File("E:\\Java_work\\eclipse-workspace\\PracticeTest").listFiles();
		List<File> list = new ArrayList<>();
		for (File file : files) {
			list.add(file);
		}

		//按文件夹先显示的顺序：
		Collections.sort(list, new Comparator<File>() {
			@Override
			public int compare(File o1, File o2) {
				return (o2.isDirectory()?1:-1)-(o1.isDirectory()?1:-1);
			}
		});

		//按文件名称显示的顺序：
		Collections.sort(list, new Comparator<File>() {
		@Override
		public int compare(File o1, File o2) {
			return (o1.getName()).compareTo(o2.getName());
		}
		});

		//按文件长度显示的顺序：
		Collections.sort(list, new Comparator<File>() {
		@Override
		public int compare(File o1, File o2) {
			return (int)(o1.length()-o2.length());
		}
		});

		//遍历集合的文件
		for (File file : list) {
			//打印排序后的文件或文件夹
			System.out.println(file.getName());
		}
	}
}
