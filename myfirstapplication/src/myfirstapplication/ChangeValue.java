package myfirstapplication;

import java.lang.reflect.Field;

public class ChangeValue {
	public static void main(String[] args) throws Exception, NoSuchFieldException {
		Integer a = 2;
        Integer b = 4;
        System.out.println("a="+a+","+"b="+b);//a=2,b=4
        change(a,b);
        System.out.println("a="+a+","+"b="+b);//a=4,b=2
	}
	
	  public static void change(Integer a, Integer b) throws  IllegalAccessException, NoSuchFieldException {
	        int temp = a;

	        Class<Integer> class1 = Integer.class;
	        Field field = class1.getDeclaredField("value");

	        field.setAccessible(true);

	        field.setInt(a, b);
	        field.setInt(b, temp);
	    }

}
