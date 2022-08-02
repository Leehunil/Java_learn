package ch19;

public abstract class Decorate extends Coffee{

	Coffee coffee;
	
	public Decorate(Coffee coffee){
		this.coffee=coffee;
	}
	
	@Override
	public void brewing() {

		coffee.brewing();
	}

}
