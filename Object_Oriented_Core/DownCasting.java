/*다운 캐스팅(downcasting)
-업캐스팅된 클래스를 다시 원래의 타입으로 형 변환
-하위 클래스로의 형 변환은 명시적으로 해야 함

*instanceof를 이용하여 인스턴스의 형 체크
-원래 인스턴스의 형이 맞는지 여부를 체크하는 키워드 맞으면 true 아니면 false를 반환 함
*/

//
package ch08;

import java.util.ArrayList;

class Animal{
	
	public void move() {
		System.out.println("Animal is moving");
	}
}

class Human extends Animal{

	@Override
	public void move() {
		System.out.println("Human is walking");
	}
	
	public void readBook() {
		System.out.println("Hunman is reading a book");
	}
	
}

class Tiger extends Animal{
	
	@Override
	public void move() {
		System.out.println("Tiger is running");
	}
	
	public void hunting() {
		System.out.println("Tiger is Hunting");
	}
}

class Eagle extends Animal{
	
	@Override
	public void move() {
		System.out.println("Eagle is flying");
	}
	
	public void flying() {
		System.out.println("Eagle is flying with two wings");
	}
}
public class AnimalTest {

	public static void main(String[] args) {
		Animal hanimal = new Human();
		Animal tanimal = new Tiger();
		Animal eanimal = new Eagle();
		
		AnimalTest test = new AnimalTest();
		//test.moveAnimal(hanimal);
		//test.moveAnimal(tanimal);
		//test.moveAnimal(eanimal);
		
		ArrayList<Animal> animalList = new ArrayList<>();
		animalList.add(hanimal);
		animalList.add(tanimal);
		animalList.add(eanimal);
		
		for(Animal animal : animalList) {
			animal.move();
		}
		test.testDownCasting(animalList);
	}
	
	public void testDownCasting(ArrayList<Animal> list) {
		for(Animal animal : list) {
			if(animal instanceof Human) {//instanceof로 형 체크
				Human human = (Human)animal;//Hunman으로 다운캐스팅
				human.readBook();
			}
			else if(animal instanceof Tiger) {
				Tiger tiger =(Tiger)animal;
				tiger.hunting();
				
			}
			else if(animal instanceof Eagle) {
				Eagle eagle = (Eagle)animal;
				eagle.flying();
			}
			else {
				System.out.println("unvalid type");
			}
		}
	}
	
	public void moveAnimal(Animal animal) {
		animal.move();
	}

}
