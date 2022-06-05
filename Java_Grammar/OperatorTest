/*대입 연산자
-변수에 다른 변수나 값을 대입하는 연산자(ex: =)
-이항 연산자 중 우선 순위가 가장 낮은 연산자들

부호 연산자
-단항 연산자
-변수의 부호를 유지하거나 바꿈

증가 감소 연산자
-단항연산자
-변수의 값을 1더하거나 1뺄때 사용
-연산자가 항의 앞에 있는가 뒤에 있는가에 따라 달라짐
- var = ++num; (먼저 num값이 1증가한 후 val 변수에 대입)
- var = num++; (val 변수에 기존 num값을 대입한 후 num값 1 증가)
*/
package ch11;

public class OperatorTest {

	public static void main(String[] args) {
		int mynum = 10;
		int yournum = 20;
		
		mynum+=yournum;
		System.out.println(mynum);//mynum과 yournum이 더해진 30이 출력됨
		
		int gameScore = 150;
		
		int lastScore = gameScore++;
		System.out.println(lastScore);//150이 출력된다.
		System.out.println(gameScore);//151이 출력된다.
	}

}


/*관계연산자
-이항 연산자
-비교 연산자라고도 한다.

논리 연산자
-논리 곱(&&): 두항이 모두 참인 경우에만 결과 값이 참입니다.
-논리 합(||): 두항 중 하나의 항만 참이면 참
-부정(!): 참인 경우 거짓 ,거짓인 경우 참으로 바꿔준다.

논리 연산에서 모든 항이 실행되지 않는 경우
--논리 곱(&&)은 두 항의 결과가 모두 true일 때만 결과가 true
앞의 항의 결과가 false이면 뒤 항의 결과를 평가하지 않음
--논리 합(||)은 두 항의 결과가 모두 false일 때만 결과가 false
앞의 항의 결과가 true이면 뒤 항의 결과를 평가하지 않음
*/
package ch12;

public class LogicalTest {

	public static void main(String[] args) {
		int num1 = 10;
		int i =2;
		 boolean value = ((num1+=10)<10)&&((i+=2)<10);
		 System.out.println(value);//false가 출력된다
		 System.out.println(num1);//20이 출력된다.
		 System.out.println(i);//앞이 이미 false이기 때문에 뒤에 연산자는 실행 되지 않는다.따라서 2가 출력이된다.
	}

}


/*조건연산자
-삼항 연산자
- 조건식 ? 결과1 : 결과2;(조건식이 참이면 결과1, 거짓이면 결과2가 선택된다.)

비트 연산자
-대입연산자와 다른 연산자가 함께 쓰임
-마스크 : 특정 비트를 가리고 몇 개의 비트 값만 사용할 때
-비트켜기 : 특정 비트들만을 1로 설정해서 사용하고 싶을 때
예)  & 00001111 ( 하위 4비트 중 1인 비트만 꺼내기)
-비트끄기 : 특정 비트들만을 0으로 설정해서 사용하고 싶을 때
예)  | 11110000 ( 하위 4비트 중 0 인 비트만 0으로 만들기)
-비트 토글 :  모든 비트들을 0은 1로, 1은 0으로 바꾸고 싶을 때
*/
package ch13;

public class BitOperationTest {

	public static void main(String[] args) {
		int num1 = 5;//00000101
		int num2 = 10;//00001010
		System.out.println(num1|num2);//00001111
		System.out.println(num1&num2);//00000000
		System.out.println(num1^num2);
		System.out.println(~num1);
		
		System.out.println(num1<<2);//num1의 값은 변하지 않는다
		System.out.println(num1 <<=2);//대입 연산자가 있어야 변한다.
		System.out.println(num1>>1);
	}

}

package ch13;

import java.util.Scanner;

public class ConitionTest {

	public static void main(String[] args) {
		int max;
		System.out.println("두 수를 입력 받아서 더 큰 수를 출력하세요\n");
		Scanner scanner= new Scanner(System.in);//입력받는다
		int num1= scanner.nextInt();
		int num2= scanner.nextInt();
		
		max = (num1>num2)? num1 : num2;
		System.out.println(max);
		
	}

}
