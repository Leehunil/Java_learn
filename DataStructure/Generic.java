package ch06;

public class Plastic {

	public String toString() {
		return "Material is Plastic.";
	}
}


package ch06;

public class Powder {

	public String toString() {
		return "Material is Powder.";
	}
}


package ch06;

public class ThreeDPrinter1 {

	private Powder material;
	
	public Powder getMaterial() {
		return material;
	}

	public void setMaterial(Powder material) {
		this.material = material;
	}

	public String toString() {
		return "Material is Powder.";
	}
}


package ch06;

public class ThreeDPrinter2 {

	private Plastic material;
	
	public Plastic getMaterial() {
		return material;
	}

	public void setMaterial(Plastic material) {
		this.material = material;
	}

	public String toString() {
		return "Material is Plastic";
	}
}


//object를 사용한 클래스
package ch06;

public class ThreeDPrinter3 {

	private Object material;
	
	public Object getMaterial() {
		return material;
	}

	public void setMaterial(Object material) {
		this.material = material;
	}

	public String toString() {
		return "Material is Powder.";
	}
}


package ch06;

public class ThreeDPrinterTest {

	public static void main(String[] args) {

		Powder powder = new Powder();
		ThreeDPrinter3 printer = new ThreeDPrinter3();
		
		printer.setMaterial(powder);
		
		Powder p =(Powder)printer.getMaterial();
		//Object는 형 변환을 해야한다.
	}

}


//generic을 사용한 클래스
package ch06;

public class GenericPrinter<T> {

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


package ch06;

public class GenericPrinterTest {

	public static void main(String[] args) {

		Powder powder = new Powder();
		GenericPrinter<Powder> powderPrinter =new GenericPrinter<>();
		//<>:다이아몬드 연산자
		powderPrinter.setMaterial(powder);
		
		Powder p =powderPrinter.getMaterial();
		//형 변환을 하지 않아도 된다.
		//이유는 컴파일될 때 알아서 GenericPrinter의 T를 Powder로 바꾸어 준다.
		System.out.println(powderPrinter.toString());
	}

}
