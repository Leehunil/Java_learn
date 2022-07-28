package ch08;

public class TravelCustomer {

	private String name;
	private int age;
	private int price;
	
	public TravelCustomer(String name,int age, int price) {
		this.name = name;
		this.age = age;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public String toString() {
		return "name: " + name + " age: " + age + " price: " + price;
	}
	
}


package ch08;

import java.util.ArrayList;
import java.util.List;

public class TravelCustomerTest {

	public static void main(String[] args) {

		TravelCustomer customerLee = new TravelCustomer("hunil", 24, 100);
		TravelCustomer customerKim = new TravelCustomer("sejun", 20, 100);
		TravelCustomer customerHong = new TravelCustomer("gildong", 13, 50);
		
		List<TravelCustomer> customerList = new ArrayList<>();
		customerList.add(customerLee);
		customerList.add(customerKim);
		customerList.add(customerHong);
		
		System.out.println("-------Customer List-------");
		customerList.stream().map(c->c.getName()).forEach(s -> System.out.println(s));
		
		System.out.println("-------Travel Cost-------");
		System.out.println(customerList.stream().mapToInt(c->c.getPrice()).sum());
		
		System.out.println("-------Over 20 Customer-------");
		customerList.stream().filter(c->c.getAge() >=20).map(c->c.getName()).sorted().forEach(s->System.out.println(s));
	}

}
