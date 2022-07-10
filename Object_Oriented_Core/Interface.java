/*인터페이스
-모든 메서드가 추상 메서드로 선언됨 public abstract
-모든 변수는 상수로 선언됨 public static final

인터페이스가 하는 일
-클래스나 프로그램이 제공하는 기능을 명시적으로 선언
-일종의 클라이언트 코드와의 약속이며 클래스나 프로그램이 제공하는 명세
-클라이언트 프로그램은 인터페이스에 선언된 메서드 명세만 보고 이를 구현한 클래스를 사용할 수 있음
-어떤 객체가 하나의 인터페이스 타입이라는 것은 그 인터페이스가 제공하는 모든 메서드를 구현했다는 의미임
-인터페이스를 구현한 다양한 객체를 사용함 - 다형성
*/

//Calc interface
package ch11;

public interface Calc {
	double pi=3.14;
	int ERROR = -999999999;
	
	int add(int num1,int num2);
	int substract(int num1,int num2);
	int times(int num1,int num2);
	int divide(int num1,int num2);
}

//Calculator Class Calc interface 상속
package ch11;

public abstract class Calculator implements Calc{

	@Override
	public int add(int num1, int num2) {
		return num1 + num2;
	}

	@Override
	public int substract(int num1, int num2) {
		return num1-num2;
	}
	
}

//CompleteCalc Class Calculator Class 상속
package ch11;

public class CompleteCalc extends Calculator{

	@Override
	public int times(int num1, int num2) {
		return num1 * num2;
	}

	@Override
	public int divide(int num1, int num2) {
		return num1 /num2;
	}
	
	public void showInfo() {
		System.out.println("Complete calculator");
	}
}

//Test
package ch11;

public class CalculatorTest {

	public static void main(String[] args) {
		
		Calc calc=new CompleteCalc();//CompleteCalc가 Calc의 타입상속을 했기 때문에 Calc를 사용 가능하다.
		
		int num1=10;
		int num2=2;
		System.out.println(calc.add(num1,num2));//12
		System.out.println(calc.substract(num1,num2));//8
		System.out.println(calc.times(num1,num2));//20
		System.out.println(calc.divide(num1,num2));//5
	
	}

}
