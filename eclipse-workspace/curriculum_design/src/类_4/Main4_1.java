package 类_4;

public class Main4_1 {
	public static void main(String[] args) {
		Vehicle vehicle = new Vehicle();
		vehicle.setSize(10);
		vehicle.setSpeed(20);
		System.out.println("速度设置为：" + vehicle.speed + "  大小设置为：" + vehicle.size);
		vehicle.speedUp(15);
		vehicle.speedDown(15);
	}
}

class Vehicle{
	int speed;
	int size; 

	void move() {
		
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public void speedUp(int speed) {
		this.speed += speed;
		System.out.println("加速后速度为：" + this.speed);
	}
	
	public void speedDown(int speed) {
		this.speed -= speed;
		System.out.println("减速后速度为：" + this.speed);
	}
}