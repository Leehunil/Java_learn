/*조건문
-주어진 조건에 따라 다른 실행이 이루어 지도록 구현
-if문 문법
 if(조건식){
	수행문;
}
*/
package ch14;

public class IfElseTest {

	public static void main(String[] args) {
		int age = 7;
		if(age >= 8) {
			System.out.println("school");
		}
		else {
			System.out.println("No school");
		}
		System.out.println("I like play");
	
	}

}


/*if-else if-else 문
하나의 상황에 대한 조건이 여러개로 나뉘고 각 조건에 다른 수행이 이루어져야 할 경우 사용
*/
package ch15;

public class IfElseIfTest {

	public static void main(String[] args) {
		int age = 17;
		int charge;
		
		if (age < 8) {
			charge = 1000;
			System.out.println("baby");
		}
		else if (age < 14) {
			charge = 2000;
			System.out.println("elementary student");
		}
		else if (age < 20) {
			charge = 3000;
			System.out.println("high school student");
		}
		else {
			charge = 4000;
			System.out.println("adult");
		}
		System.out.println("charge is "+ charge);
	}
}


/* switch - case 문
-if - else if - else 문을 사용할 때 복잡하고 번거로운 부분을 가독성 좋게 구현
-비교 조건이 특정 값이나 문자열인 경우 사용
-break 문을 사용하여 각 조건이 만족되면 switch 블럭을 빠져나오도록 함
*/
package ch16;

import java.util.Scanner;

public class SwitchCaseTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int month = scanner.nextInt();//month 입력받는다.
		
		int day;//day 선언해주고
		switch(month) {
			case 1: case 3: case 5: case 7: case 8: case 10: case 12://case의 값이 다 같을 경우 다음과 같이 뛰어쓰기로 표현할 수 있다.
				day = 31;
				break;//break를 꼭 써야 멈춘다. 안쓰면 밑에까지 확인 한다.
			case 2: 
				day = 28;
				break;
			case 4: case 6: case 9: case 11: 
				day = 30;
				break;
			default://그 외에 나머지 경우
				System.out.println("No Month");
				day = -1;
				break;
		}
		System.out.println(month+" Month's day is "+ day);//입력에 맞는 case의 값이 출력 된다.
	}

}


/*Java 14 부터 지원 되는 Switch Expression
-간단하게 쉼표(,)로 조건 구분
-식으로 표현 하여 반환 값을 받을 수 있음. 리턴 값이 없는 경우는 오류가 생김
-yield 키워드 사용
*/package ch16;

import java.util.Scanner;

public class SwithchCaseUpgradeTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int month = scanner.nextInt();
		
		
		int day = switch(month) {
			case 1,3,5,7,8,10,12->// ,로 구분하고 :대신에 ->사용 
				31;//return 값이다.		
			case 2-> 
				28;
			case 4,6,9,11-> 
				30;
			default->{  //안에 return 값말고도 더 쓰고 싶으면{}를 사용해서 묶어준다.
				System.out.println("No Month");
				yield -1; //case에서는 return 대신에 yield를 사용한다.
			}
		}; // ; 잊지말고 써줘야 한다.
		System.out.println(month+" Month's day is "+ day);
	}

}

