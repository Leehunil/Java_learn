/*다형성(polymorphism) 이란?
-하나의 코드가 여러 자료형으로 구현되어 실행되는 것
-같은 코드에서 여러 다른 실행 결과가 나옴
-정보은닉, 상속과 더불어 객체지향 프로그래밍의 가장 큰 특징 중 하나임
-다형성을 잘 활용하면 유연하고 확장성있고, 유지보수가 편리한 프로그램을 만들수 있음

*다형성을 사용하는 이유?
-상속과 메서드 재정의를 활용하여 확장성 있는 프로그램을 만들 수 있음
-그렇지 않는 경우 많은 if-else if문이 구현되고 코드의 유지보수가 어려워짐
-상위 클래스에서는 공통적인 부분을 제공하고 하위 클래스에서는 각 클래스에 맞는 기능 구현
-여러 클래스를 하나의 타입(상위 클래스)으로 핸들링 할 수 있음
*/

//Animal class
package ch06;

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
		
		//AnimalTest test = new AnimalTest();
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
	}
	
	public void moveAnimal(Animal animal) {
		animal.move();
	}

}

//Gold memebership 만들기
//Customer Class
package ch06;

public class Customer {
	protected int customerId;
	protected String customerName;
	protected String customerGrade;
	
	int bonusPoint;
	double bonusRatio;
	
	/*public Customer() {
		customerGrade="silver";
		bonusRatio=0.01;
		System.out.println("Customer() call");
	}*/
	
	
	public Customer(int customerId,String customerName) {
		this.customerId=customerId;
		this.customerName=customerName;
		
		customerGrade="silver";
		bonusRatio=0.01;
	}
	
	public int calPrice(int price) {
		bonusPoint+=price * bonusRatio;
		return price;
	}
	
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerGrade() {
		return customerGrade;
	}

	public void setCustomerGrade(String customerGrade) {
		this.customerGrade = customerGrade;
	}

	public String showCustomerInfo() {
		return customerName+" customer's grade is "+customerGrade+" and bonus point is "+bonusPoint;
	}
}

//VIPCustomer
package ch06;

public class VIPCustomer extends Customer{ 
	
	
	double salesRatio;
	String agentId;
	
	/*public VIPCustomer() {
		super();//상위 상속 class의 참조값을 가지게 된다, super()는 쓰지 않아도 자동으로 호출된다.
		bonusRatio=0.05;
		customerGrade="VIP";
		salesRatio=0.01;
		
		System.out.println("VIPCustomer() call");
	}*/
	
	
	public VIPCustomer(int customerId,String customerName) {
		super(customerId,customerName);
		bonusRatio=0.05;
		customerGrade="VIP";
		salesRatio=0.01;
	}

	@Override
	public int calPrice(int price) {
		bonusPoint +=price * bonusRatio;
		price-= (int)(price*salesRatio);
		return price;
	}
	
	
}

//GoldCustomer
package ch06;

public class GoldCustomer extends Customer {
	double salesRatio;
	
	public GoldCustomer(int customerId, String customerName) {
		super(customerId,customerName);
		bonusRatio=0.02;
		customerGrade="Gold";
		salesRatio=0.1;
	}
	
	public int calPrice(int price) {
		bonusPoint +=price * bonusRatio;
		return price -(int)(price * salesRatio);
	}

}

//Test
package ch06;

import java.util.ArrayList;

public class CustomerTest {

	public static void main(String[] args) {
		
		ArrayList<Customer> customerList = new ArrayList<>();
		
		Customer customerH = new Customer(1000,"Hunil");
		Customer customerJ = new Customer(1001,"Junjang");
		Customer customerG = new GoldCustomer(1002,"Gunhee");
		Customer customerC = new GoldCustomer(1000,"Chanwoo");
		Customer customerS = new VIPCustomer(1000,"Sejun");
		
		customerList.add(customerH);
		customerList.add(customerJ);
		customerList.add(customerG);
		customerList.add(customerC);
		customerList.add(customerS);
		
		for(Customer customer:customerList) {
			System.out.println(customer.showCustomerInfo());
		}
		
		int price=10000;
		for(Customer customer:customerList) {
			int cost=customer.calPrice(price);
			System.out.println(customer.getCustomerName()+"'s price is "+cost);
			System.out.println(customer.getCustomerName()+"'s bonusPoint is "+customer.bonusPoint);
		}
		
	}

}
