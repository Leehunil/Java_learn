package ch07;

public class Plastic extends Material{

	public String toString() {
		return "Material is Plastic.";
	}

	@Override
	public void doPrinting() {
		// TODO Auto-generated method stub
		
	}
}


package ch07;

public class Powder extends Material{

	public String toString() {
		return "Material is Powder.";
	}

	@Override
	public void doPrinting() {
		// TODO Auto-generated method stub
		
	}
}


package ch07;

public abstract class Material {

	public abstract void doPrinting();
}


package ch07;

public class GenericPrinter<T extends Material> {
//이 클래스에 상속받은 클래스만이 이 T대신에 쓸 수 있다.
//따라서 Material을 상속받은 Plastic과 Powder만이 T를 대신할 수 있다.
	
	private T material;

	public T getMaterial() {
		return material;
	}

	public void setMaterial(T material) {
		this.material = material;
	}
	
	public String toString() {
		return material.toString();
	}
}


package ch07;

public class GenericPrinterTest {

	public static void main(String[] args) {

		Powder powder = new Powder();
		GenericPrinter<Powder> powderPrinter =new GenericPrinter<>();
		powderPrinter.setMaterial(powder);
		
		Powder p =powderPrinter.getMaterial();
		System.out.println(powderPrinter.toString());
		
		
	}

}
