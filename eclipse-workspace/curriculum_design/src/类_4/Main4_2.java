package 类_4;

public class Main4_2 {

}

class MyTime{
	private int hour;
	private int minute;
	private int second;
	
	public MyTime() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void display() {
		System.out.println(hour + "时" + minute + "分" + second + "秒");
	}
	
	void addSecond(int sec) {
		second += sec;
	} 
	
	void addMinute(int min) {
		minute += min;
	}
	
	void addHour(int hou) {
		hour += hou;
	}
	
	void subSecond(int sec) {
		second -= sec;
	}
	
	void subMinute(int min) {
		minute -= min;
	} 
	
	void subHour(int hou) {
		hour -= hou;
	}
}
