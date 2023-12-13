package algorithm;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		int[] a = {1, 6, 3, 1, 0};
	
		System.out.println(mind(a));
		System.out.println(Arrays.toString(a));
		
	}

	public static int mind(int [] a)
	{
		int n=a.length;
		Arrays.sort(a);			//递增排序
		int d=a[n-1]-a[0];		//置最大差
		for (int i=1;i<n;i++)
			if (a[i]-a[i-1]<d)
				d=a[i]-a[i-1];
		return d;
	}
}
