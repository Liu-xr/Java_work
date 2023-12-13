package Class;

import java.util.Arrays;
import java.util.Random;

public class 常用类 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*  String类 */
		String a = "lxr";     // 定义在常量池中的地址
		String c = "lxr";
		System.out.println(a == c);   // a和c指向常量池中的同一个"lxr"地址，true
		
		String b = new String("lxr");  // 定义在堆栈里的地址
		System.out.println(a.equals(b));  // true  String类的equals()方法比较指向的最终地址，类对象的堆地址实际上也还指向了常量池的"lxr"地址
		System.out.println(a == b);     // false  常量池地址和类对象的堆地址不一样
		
		String d = new String("lxr");
		System.out.println(d.equals(b));  // true   类对象的开辟的堆内存地址都不同，但深入到指向常量池的字面值"lxr"相同
		System.out.println(d == b);     // false    类对象不能用==比较，必须深入比较到常量池地址，b和d对象各自开辟堆地址，不一致
		
		System.out.println("a".compareTo("cd123"));  // 两字符串长度不一，直接返回首字母的ascii码的差值：-2
		System.out.println("aa".compareTo("aabcd123"));  // 两字符串长度一致，又有可比较相同的字母，则返回剩余长度：-6
		
		// 格式化输出
		int i = 22;
		String end = String.format("直到%d岁才会大学毕业", i);
		System.out.println(end);
		//字符串转换
		char[] ch = {'a','b','c','d'};
		String stri = String.valueOf(ch, 1, 3); // 取偏移量和长度bcd
		System.out.println(stri);
		System.out.println(String.valueOf(i).getClass().getTypeName());  // 其他基本数据类型转换为字符串
		
		
		/*  StringBuffer和StringBuilder类  */
		StringBuffer str = new StringBuffer("liu");
        System.out.println(str);   //原始：liu
        //结尾附加  ：liurui
        str.append("rui");
        System.out.println(str);
        //插入字符串: liu xingrui
        str.insert(3, " xing");
        System.out.println(str);
        //替换（左闭右开）:liu XingRui
        str.replace(4, 9, "XingR");
        System.out.println(str);
        //删除指定位置的字符串（左闭右开）：liu
        str.delete(3, 11);
        System.out.println(str);
        //字符串反转：uil
        str.reverse();
        System.out.println(str);
        
        /*  Math类  */
        int n = -18;
        // 绝对值
        System.out.println("\n\n" + Math.abs(n));
        // 平方根
        System.out.println(Math.sqrt(-n));
        // 四舍五入
        System.out.println(Math.round(4.66));
        // 幂运算
        System.out.println(Math.pow(2, 3)); // 结果double
        // 圆周率
        System.out.println(Math.PI);
        // 自然对数的底数
        System.out.println(Math.E);
        // 随机数0到1，左闭右开
        System.out.println(Math.random());
        System.out.println(Math.random() * 10);
        
        /*  Random类  */
        Random random = new Random();
        System.out.println("\n\n" + random.nextDouble());  // 随机生成0到1间的小数
        System.out.println(random.nextFloat(-10, 10));
        System.out.println(random.nextInt(-100, 100));    // 随机生成-100到100间的int型数
        System.out.println(random.nextBoolean());  // true和false随机生成
        
        /*  System类 */
        long now = System.currentTimeMillis(); // 返回当前时间的毫秒数
        System.out.println(now);
        int[] arr = {1, 2, 3};
        int[] arrCopy = new int[3];
        System.arraycopy(arr,0, arrCopy, 1, 2); // 源数组, 原数组开始位置， 目标数组，目标数组开始位置，复制长度
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arrCopy));
        
        /*  Object类 */
        // 所有类的父类：equals()、wait()、notify()、notifyAll()、clone()浅复制、toString()
		
	}

}
