package ch19;

public class CoffeeTest {

	public static void main(String[] args) {

		Coffee eCoffee =new EtiopiaAmericano();
		eCoffee.brewing();
		
		System.out.println();
		Coffee lCoffee = new Latte(eCoffee);
		lCoffee.brewing();
		
		System.out.println();
		Coffee mCoffee = new Mocha(new Latte(new EtiopiaAmericano()));
		mCoffee.brewing();
		
		System.out.println();
		Coffee wCoffee = new WhippingCream(new Mocha(new Latte(new KeyaCoffee())));
		wCoffee.brewing();

	}
} 
