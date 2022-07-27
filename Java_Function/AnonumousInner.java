package ch02;

class Outer2{
	
	int outNum = 100;
	static int sNum =200;
	
	//Runnable은 Class를 thred화 할때 필요한 Run 메서드를 구현할 때 필요한 인터페이스이다.
	//getRunnable 메서드
	Runnable getRunnable(int i){
	//지역 내부 클래스에서 사용하는 메서드의 지역 변수나 매개 변수는 final로 선언된다.
		int num = 10;
		
		return new Runnable(){

			int localNum = 1000;
			
			@Override
			public void run() {
				
				System.out.println("i = "+i);
				System.out.println("num = "+num);
				System.out.println("localNum = "+localNum);
				
				System.out.println("outNum = "+outNum);
				System.out.println("Outer2.sNum = "+Outer2.sNum);
			}	
		};
	}
	
	Runnable runnable = new Runnable() {

		@Override
		public void run() {
			System.out.println("Runnable Class");
		}
		
	};
}


public class AnonumousInnerTest {

	public static void main(String[] args) {

		Outer2 out = new Outer2();
		Runnable runner = out.getRunnable(100);
		//Runnalble함수는 호출이 끝났기 때문에 스택에서 없어진다.
		runner.run();
		//이쪽에서 i와 num이 불린다. 따라서 run() 함수 안에는 i와 num은 정의할 수 없다.
		
		out.runnable.run();	
	}

}
