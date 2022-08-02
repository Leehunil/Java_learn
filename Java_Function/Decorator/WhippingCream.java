package ch19;

public class WhippingCream extends Decorate{

	public WhippingCream(Coffee coffee) {
		super(coffee);
	}
	
	public void brewing() {
		super.brewing();
		System.out.print(" adding whipping Cream");
	}

}
