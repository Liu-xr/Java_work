package 类_4;

public class Main4_14 {
	public static void main(String[] args) {
		System.out.println(new Car1().NoOfWheels());
		System.out.println(new Motorbike().NoOfWheels());
	}

}

abstract class Vehicle1{
	abstract String NoOfWheels();
}

class Car1 extends Vehicle1{

	@Override
	String NoOfWheels() {
		// TODO Auto-generated method stub
		return "四轮机动车";
	}
	
}

class Motorbike extends Vehicle1{

	@Override
	String NoOfWheels() {
		// TODO Auto-generated method stub
		return "双轮机动车";
	}
	
}