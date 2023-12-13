package javaSE;


import java.lang.reflect.Field;
import java.util.Arrays;

public class CangeValues {
	public static void main(String[] args) throws Exception, NoSuchFieldException {
		System.out.println("\n2.8 函数交换两个基本数据类型的值："); 
		Integer a = 11, b = 22;
	     System.out.println("交换前两数的值：" + a + "、" + b);
	     change(a, b);
	     System.out.println("交换后两数的值：" + a + "、" +  b);
	     int[] array = {11, 22};
	        System.out.println("交换前值：" + Arrays.toString(array));
	        change(array);
	        System.out.println("交换后值：" + Arrays.toString(array));
	}
	
	  public static void change(Integer a, Integer b) throws  IllegalAccessException, NoSuchFieldException {
	        int temp = a;

	        Class<Integer> class1 = Integer.class;
	        Field field = class1.getDeclaredField("value");

	        field.setAccessible(true);

	        field.setInt(a, b);
	        field.setInt(b, temp);
	    }

	  public static void change(int[] array){
	        int t = array[0];
	        array[0] = array[1];
	        array[1] = t;
	    }
}

