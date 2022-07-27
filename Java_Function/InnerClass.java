package ch01;

class OutClass{
	
	private int num =10;
	private static int sNum =20;
	private InClass inClass;
	
	public OutClass() {
		inClass = new InClass();
		//InClass 인스턴스가 생성되기 위해서는 OutClass 인스턴스가 먼저 생성되고 생성되는 것을 알 수 있다.
	}
	
	class InClass{
		//InClass 내부에서는 정적 변수를 사용할 수 없다.(static)
		int iNum = 100;
		
		void inTest() {
			
			System.out.println("OutClass num = "+num);   //외부 클래스의 인스턴스 변수
			System.out.println("OutClass sNum = "+sNum); //외부 클래스의 스태틱 변수
			System.out.println("OutClass iNum = "+iNum); //내부 클래스의 인스턴스 변수
		}
	}
	
	public void usingClass() {
		inClass.inTest();
	}
	
	static class InstaticClass{
		
		int iNum = 100;
		static int sInNum =200;
		
		void inTest() {
			
			//System.out.println("OutClass num = "+num); 정적클래스에서는 외부클래스의 인스턴스 변수 사용은 불가능하다.
			System.out.println("InClass iNum = "+sNum); //내부 클래스의 인스턴스 변수
			System.out.println("OutClass sNum = "+sNum); //외부 클래스의 스태틱 변수
			System.out.println("InClass SiNum = "+sInNum); //내부 클래스의 스태틱 변수
		}
		
		static void sTest() {
			
			//System.out.println("InClass iNum = "+sNum); //정적 메서드에서는 정적 클래스의 인스턴스 변수는 사용할 수 없다.
			System.out.println("OutClass sNum = "+sNum); //외부 클래스의 스태틱 변수
			System.out.println("InClass SiNum = "+sInNum); //내부 클래스의 스태틱 변수
		}
	}
}


public class InnerTest {

	public static void main(String[] args) {
		
		OutClass outClass = new OutClass();
		outClass.usingClass();
		
		System.out.println();
		//InClass에 private가 없을 경우 외부에서 인클래스를 호출을 할 수는 있다.
		OutClass.InClass inner =outClass.new InClass();
		inner.inTest();
		
		System.out.println();
		//static class 호출
		OutClass.InstaticClass sInClass = new OutClass.InstaticClass();
		sInClass.inTest();
		
		System.out.println();
		//static Method
		OutClass.InstaticClass.sTest();
	}

}
