package ch19;

public class Mocha extends Decorate{

	public Mocha(Coffee coffee) {
		super(coffee);
	}
	
	public void brewing() {
		super.brewing();
		System.out.print(" adding mocha syrup");
	}

}
