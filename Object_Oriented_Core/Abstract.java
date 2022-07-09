/*추상 클래스
-구현 코드 없이 메서드의 선언만 있는 추상 메서드를 포함한 클래스
-추상 클래스는 new 할 수 없음 ( 인스턴스화 할 수 없음 )

*추상 클래스 구현하기
-메서드에 구현 코드가 없으면 abstract 로 선언
-abstract로 선언된 메서드를 가진 클래스는 abstract로 선언
-모든 메서드가 구현 된 클래스라도 abstract로 선언되면 추상 클래스로 인스턴스화 할 수 없음
-추상 클래스의 추상 메서드는 하위 클래스가 상속 하여 구현
*/

//Computer Class(상위 클래스)
package ch09;

public abstract class Computer {

	public abstract void display();
	
	public abstract void typing();
	
	public void turnOn() {
		System.out.println("Computer turn on");
	}
	
	public void turnOff() {
		System.out.println("Computer turn off");
	}
}

//DeskTop Class(하위 클래스)
package ch09;

public class DeskTop extends Computer {

	@Override
	public void display() {
		System.out.println("Computer display");
	}

	@Override
	public void typing() {
		System.out.println("Computer typing");
	}

	@Override
	public void turnOn() {
		System.out.println("turn on");
	}
	
	
}


//NoteBook Class
package ch09;

public abstract class NoteBook extends Computer{
	
	@Override
	public void display() {
		System.out.println("Computer display");
	}
}


//MyNoteBook Class
package ch09;

public abstract class MyNoteBook extends NoteBook{
//추상 클래스는 강제로 만들 수 있다.	
	@Override
	public void typing() {
		System.out.println("Computer typing");
	}
}

//Test
package ch09;

public class ComputerTest {

	public static void main(String[] args) {
		
		Computer desktop = new DeskTop();
		desktop.display();//Computer display 출력
	}

}
/*템플릿 메서드
-추상 메서드나 구현 된 메서드를 활용하여 코드의 흐름(시나리오)를 정의하는 메서드
-final로 선언하여 하위 클래스에서 재정의 할 수 없게 함
-프레임워크에서 많이 사용되는 설계 패턴
*/

//Car Class
package ch10;

public abstract class Car {
//클래스에 final을 사용하면 상속을 할 수 없다.	
	public abstract void drive();
	public abstract void stop();
	public abstract void wiper();
	
	public void startCar() {
		System.out.println("Turn on the car.");
	}
	
	public void turnOff() {
		System.out.println("Turn off the car");
	}
	
	public void washCar() {}
	//구현 내용이 없는 것이다. 추상 메서드가 아니다.
	final public void run() {
		startCar();
		drive();
		wiper();
		stop();
		turnOff();
		washCar();
	}
}

//AI Car
package ch10;

public class AICar extends Car {

	@Override
	public void drive() {
		System.out.println("It drives automatically");
		System.out.println("Automatically adjusts direction.");
	}

	@Override
	public void stop() {
		System.out.println("automatically stop");
	}

	@Override
	public void wiper() {
		System.out.println("wiper turn on");
	}
	
	@Override
	public void washCar() {
		System.out.println("automatically wash car");
	}
	
	
}

//ManualCar class
package ch10;

public class ManualCar extends Car{

	@Override
	public void drive() {
		System.out.println("user drives");
	}

	@Override
	public void stop() {
		System.out.println("user breaks");
	}
	
	@Override
	public void wiper() {
		System.out.println("user turn on the wiper");
	}
	
}


//Test
package ch10;

public class CarTest {

	public static void main(String[] args) {
		Car aiCar = new AICar();
		aiCar.run();
		System.out.println("===========================");
		Car mCar= new ManualCar();
		mCar.run();
	}

}
//출력
/*
Turn on the car.
It drives automatically
Automatically adjusts direction.
wiper turn on
automatically stop
Turn off the car
automatically wash car
===========================
Turn on the car.
user drives
user turn on the wiper
user breaks
Turn off the car
*/
