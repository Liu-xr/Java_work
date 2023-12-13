package 类_4;

public class InterfaceDemo {
	public static void main(String[] args) {
		Bike bike = new Bike();
		bike.start(10);
		bike.stop(1);
		
		Bus bus = new Bus();
		bus.start(30);
		bus.stop(3);
		
	}

}

class Bike implements Vehicles1{

	@Override
	public void start(int a) {
		System.out.println("Bike的start()方法：" + a);
	}

	@Override
	public void stop(int a) {
		System.out.println("Bike的stop()方法：" + a);
	}
	
}

class Bus implements Vehicles1{

	@Override
	public void start(int a) {
		System.out.println("Bus的start()方法：" + a);
	}

	@Override
	public void stop(int a) {
		System.out.println("Bus的stop()方法：" + a);
	}
	
}