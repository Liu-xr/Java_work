package count;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

//首先通过流，将文件中的数据读取到二维数组中，然后放4层循环
public class Count1_2 {
      public static void main(String[] args) throws IOException {
            //double类型的用于确定投入生产顺序，因为四舍五入，几个数相等，不好确定
            double darray[]=Count1_2.Getdata();
            Map<Integer,Double> map=new HashMap<>();
            //int类型用于计算
            int Array[]=new int[darray.length];
            Map<Integer,Integer> map1=new HashMap<>();
            for (int i = 0; i <10 ; i++) {
                  map.put(i+1,darray[i]);
                  map1.put(i+1, (int) Math.round(darray[i]));
                  Array[i]=(int) Math.round(darray[i]);
            }
            Array=Count1_2.isort(Array);

            darray=Count1_2.dsort(darray);
            Count1_2.display(darray,map);


            Count1_2.disin_out(Array);



      }


//读取文件
      public static double[] Getdata() throws IOException {
            FileReader fr=new FileReader("C:\\Users\\Redrum\\Desktop\\average.txt");
            //可以换成工程目录下的其他文本文件
            BufferedReader br=new BufferedReader(fr);
            String line = null;
            int ind = 0;
            int countline=0;
            String[] sp;
            double [] lineArray =null;
            while((line=br.readLine())!=null){
                  sp = line.split(","); //将mat文件复制到txt后数据间默认是一个tab的距离
                  lineArray = new double[sp.length];
                  for(int j=0;j<sp.length;++j){
                        lineArray[j] =Double.parseDouble(sp[j]);
                  }
            }
            return lineArray;
      }

      //排序
      public static double[] dsort(double [] array){
            for (int i = 0; i < array.length-1; i++) {
                  for (int j = i+1; j <array.length ; j++) {
                        if(array[i]>array[j])
                        {
                              double temp=array[i];
                              array[i]=array[j];
                              array[j]=temp;
                        }
                  }
            }
            return array;
      }

      public static int[] isort(int [] array){
            for (int i = 0; i < array.length-1; i++) {
                  for (int j = i+1; j <array.length ; j++) {
                        if(array[i]>array[j])
                        {
                             int temp=array[i];
                              array[i]=array[j];
                              array[j]=temp;
                        }
                  }
            }
            return array;
      }


      //展示生产顺序
      public static void display(double Array[],Map<Integer,Double>map1)
      {
            for (int i = 0; i <Array.length ; i++) {
                  Set s1=map1.keySet();
                  if(i<Array.length-1)
                  {
                        for (Map.Entry<Integer, Double> entry : map1.entrySet()) {
                              if (entry.getValue().equals(Array[i])) {
                                    System.out.print(entry.getKey()+"--->");
                                    break;
                              }
                        }
                  }
                  else
                  {
                        for (Map.Entry<Integer, Double> entry : map1.entrySet()) {
                              if (entry.getValue().equals(Array[i])) {
                                    System.out.println(entry.getKey());
                                    break;
                              }
                        }

                  }
            }
      }

      //展示各个疫苗进出时间
      public static void disin_out(int Array[]){
            int timesum=0;
            for (int i = 0; i <= Array.length+3; i++) {
                  if(i<Array.length) {
                        timesum+=Array[i];
                        Mytime m1=new Mytime(0,0,0);
                        m1.addSecond(timesum);
                        //System.out.println(timesum);
                        System.out.print("第" + (i+1)+"种类型的进入C1时间：");
                        m1.display();
                        if(i>3)
                        {
                              Mytime m2=new Mytime(0,0,0);
                              m2.addSecond(timesum);
                              //System.out.println(timesum);
                              System.out.print("第" + (i-3)+"种类型的出去C4时间：");
                              m2.display();
                        }
                  }
                  else {
                        Mytime m3=new Mytime(0,0,0);
                        if(i<Array.length+3)
                        {
                              timesum+=Array[Array.length-1];
                              m3.addSecond(timesum);
                              System.out.print("第" + (i-3)+"种类型的出去C4时间：");
                              m3.display();
                        }
                        else {
                              m3.addSecond(timesum+Array[Array.length-1]);
                              System.out.print("第" + (i-3)+"种类型的出去C4时间：");
                              m3.display();
                        }
                  }


            }
            System.out.println();
            System.out.println("生产总时间为："+timesum);
      }

}
