import java.io.*;

public class RandomAccessTest {
    public static void main(String[] args) throws Exception{
        long filePoint = 0;
        String s;
        String path = "readfile.java";
        RandomAccessFile file = new RandomAccessFile(path, "r");
        long fileLength = file.length();
        while(filePoint < fileLength){   //文件位置指针与文件长度比较来判断是否读完
            s = file.readLine();
            System.out.println(s);
            filePoint = file.getFilePointer();
        }
        file.close();
    }
}
