package ch19;

public class Latte extends Decorate{

	public Latte(Coffee coffee) {
		super(coffee);
	}
	
	public void brewing() {
		super.brewing();
		System.out.print(" adding Milk");
	}

}
