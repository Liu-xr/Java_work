package io;

import java.io.File;
import java.io.FileNotFoundException;

public class file {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File fdir1 = new File("E:\\信管专业课");
		
		if(!fdir1.exists())
			throw new FileNotFoundException("文件不存在");
		
	    //list()方法：返回该file目录对象下的文件名（包括文件后缀名）字符串数组
	    String[] str = fdir1.list();
	    assert str != null;  // 断言str不为空
	    for(String s :str)
	        System.out.println(s);
	    
	   //ListFiles()方法：返回file对象（包含完整的路径名）的数组
	    File[] fil = fdir1.listFiles();
	    if (fil != null) {     //在file数组不为空下进行
	        for (File file : fil) System.out.println(file);
	    }

	}

}
