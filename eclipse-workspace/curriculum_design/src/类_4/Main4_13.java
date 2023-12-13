package 类_4;

public class Main4_13 {
	public static void main(String[] args) {
		new Auto();
		new Auto(4, "白色", 60, 55);
		new Auto(4, 32, 45);
	}
}

class Auto{
	int tireCount;
	String color;
	int weight;
	int speed;
	
	public Auto() {

	}

	public Auto(int tireCount, int weight, int speed) {
		super();
		this.tireCount = tireCount;
		this.weight = weight;
		this.speed = speed;
	}

	public Auto(int tireCount, String color, int weight, int speed) {
		super();
		this.tireCount = tireCount;
		this.color = color;
		this.weight = weight;
		this.speed = speed;
	}
	
	void speedUp(int sp) {
		speed += sp;
		System.out.println("汽车加速后的速度为" + speed);
	}
	
	void speedDown(int sp) {
		speed -= sp;
		System.out.println("汽车减速后的速度为" + speed);
	}
	
	void stop() {
		speed = 0;
		System.out.println("汽车已停车，车速为：" + speed);
	}
}

class Cars extends Auto{
	boolean CD;
	boolean AC;
	
	@Override
	void speedUp(int sp) {
		speed += 2 * sp;
		System.out.println("汽车加速后的速度为" + speed);
	}
	
	@Override
	void speedDown(int sp) {
		speed -= 2 * sp;
		System.out.println("汽车减速后的速度为" + speed);
	}
	
}