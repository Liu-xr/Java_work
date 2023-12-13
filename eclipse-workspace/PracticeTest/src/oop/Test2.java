package oop;

public class Test2 {
	public static void main(String[] args) {
		Weapon tankWeapon = new Tank();
		tankWeapon.attack();
		tankWeapon.move();
		
		Flighter flighter = new Flighter();
		flighter.attack();
		flighter.move();
		
		Weapon warshipWeapon = new Warhsip();
		warshipWeapon.attack();
		warshipWeapon.move();
		
	}

}

/*第一题：
（1）定义一个抽象类Weapon,该抽象类有两个抽象方法attack()，move()
这两个方法分别表示武器的攻击方式和移动方式。

（2）定义3个类：Tank,Flighter,WarShip都继承自Weapon,
分别用不同的方式实现Weapon类中的抽象方法。

编写测试程序main方法，创建多个不同武器的实例。并分别调用attack()和move()方法。
能用多态尽量使用多态。
*/

abstract class Weapon{
	abstract void attack();
	abstract void move();
}

class Tank extends Weapon{

	@Override
	void attack() {
		// TODO Auto-generated method stub
		System.out.println("Tank's attack!");
	}

	@Override
	void move() {
		// TODO Auto-generated method stub
		System.out.println("Tank's move!");
	}
}

class Flighter extends Weapon{

	@Override
	void attack() {
		// TODO Auto-generated method stub
		System.out.println("Flighter's attack!");
	}

	@Override
	void move() {
		// TODO Auto-generated method stub
		System.out.println("Flighter's move!");
	}
}

class Warhsip extends Weapon{

	@Override
	void attack() {
		// TODO Auto-generated method stub
		System.out.println("Warship's attack!");
	}

	@Override
	void move() {
		// TODO Auto-generated method stub
		System.out.println("Warship's move!");
	}
	
}