package Class;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Change {   // 函数交换两个基本数据类型的变量值
	// 定义为static成员变量,实质上也是类引用数据类型的传值
	static int aa = 1;
	static int bb = 2;

	public static void main(String[] args) throws IllegalArgumentException, InvocationTargetException, Exception {
		// TODO Auto-generated method stub
		int a = 1;
		int b = 2;
		change(a, b);
		System.out.println("a:" + a);
		System.out.println("b:" + b);
		
		change1(new Change());
		System.out.println("aa:" + aa);
		System.out.println("bb:" + bb);
		

	}
	
	// 反射方法设置
	static void change(Integer a, Integer b) throws  IllegalAccessException, NoSuchFieldException, Exception, IllegalArgumentException, InvocationTargetException {
        int temp = a;

        Class<? extends Integer> classa = a.getClass();
        Constructor<? extends Integer> fielda = classa.getDeclaredConstructor(int.class);
        fielda.setAccessible(true);
        a = fielda.newInstance(b);

        Class<? extends Integer> classb = b.getClass();
        Constructor<? extends Integer> fieldb = classb.getDeclaredConstructor(int.class);
        fieldb.setAccessible(true);
        b = fieldb.newInstance(temp);
    }
	
	static void change1(Change change) {
		int t = Change.aa;
		Change.aa = Change.bb;
		Change.bb = t;
	}

}
