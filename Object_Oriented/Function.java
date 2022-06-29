/*함수란 (function)
-하나의 기능을 수행하는 일련의 코드
-구현된(정의된) 함수는 호출하여 사용하고 호출된 함수는 기능이 끝나면 제어가 반환됨
-함수로 구현된 하나의 기능은 여러 곳에서 동일한 방식으로 호출되어 사용될 수 있음
-함수는 이름, 매개 변수, 반환 값, 함수 몸체(body)로 구성됨
*/

package ch03;

public class FunctionTest {
	
  //매게변수와 반환값 모두 있는 것
  public static int addNum(int num1, int num2) {
		
		int result;
		result = num1+num2;
		return result;
	}
	
  //매게변수는 있지만 반환값이 없는 것
	public static void sayHello(String greeting) {
		
		System.out.println(greeting);
	}
	
  //매게변수는 없고 반환값이 있는 것
	public static int calcSum() {
		int sum=0;
		int i;
		for(i=0; i<=100; i++) {
			sum+=i;
		}
		return sum;
	}
	
  //함수 불러오기
  public static void main(String[] args) {
		int n1 = 10;
		int n2 = 20;
		int total = addNum(n1,n2);
		System.out.println(total);//30 출력
		
		sayHello("Hello");//Hello 출력
		
		total= calcSum();
		System.out.println(total); //5050 출력

	}

}


/*
함수 호출과 스택 메모리
:main함수에서 add함수를 불러 오면 add()함수가 사용할 메모리 공간이 
 스택에 생성되고 return되면 자동으로 사라진다.
*/
