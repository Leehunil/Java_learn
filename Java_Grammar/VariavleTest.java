/*bit(1비트) : 컴퓨터가 표현하는 데이터의 최소 단위로 2진수 하나의 값을 저장할 수 있는 메모리의 크기
byte(바이트) : 1byte = 8bit
ex)8bit로 5를 표현
    00000101
    맨앞에 비트는 부호를 나타내는 비트이다.
*/
package ch04;

public class BinaryTest {

	public static void main(String[] args) {
		int num = 10;
		int bNum = 0B1010; //2진수로 표현
		int oNum = 012; //8진수로 표현
		int xNum = 0XA; //16진수로 표현
		
		System.out.println(num);
		System.out.println(bNum);
		System.out.println(oNum);
		System.out.println(xNum);
	}

}


/*변수
: 이 변수가 가지는 데이터의 형에 맞는 크기에 해당되는 메모리
-영문자,숫자,$,_만 사용가능
-숫자 먼저 사용은 금지
-가독성이 좋은 변수를 사용

변수와 메모리
변수를 선언하면 해당되는 자료형의 크기 만큼 메모리가 할당
변수는 할당된 메모리를 가리키는 이름
ex)int level = 10; // 4바이트 정수형 메모리가 level 이라는 이름으로 할당 됨

정수 자료형
자료형   바이트 크기   수의 범위
byte            1           -2**7~2**7-1
short           2           -2**15~2**15
int              4           -2**31~2**31-1
long            8           -2**63~2**63-1
byte:1바이트 단위의 자료형 동영상, 음악 파일, 실행 파일의 자료를 처리할때
short: 2바이트 단위의 자료형 C/C++ 언어와 호환 시 사용
int: 4바이트 단위의 자료형 프로그램에서 사용하는 모든 숫자는 int로 저장됨
long: 8바이트 자료형으로 숫자의 두에 알파벳 L을 써서 long임을 표시
float:4바이트 숫자뒤에 f를 표시
*/

package ch06;

public class VariableTest {

	public static void main(String[] args) {
		byte bnum = 127;//byte의 범위는 127까지 이다.
		
		System.out.println(bnum);
		
		//int num = 12345678900;//수의 범위가 넘어가서 에러가 뜬다
		long lNum = 12345678900L;//long 변수를 사용하기 위해서 숫자 뒤에 L을 쓴다.
		System.out.println(lNum);
	}

}


/*부동소수점
실수는 정수 보다 정밀하기 때문에 정수와는 다른 방식으로 표현해야 함
지수와 가수로 나뉘어서 표현함
ex)0.1은 1.0 * 10**-1로 표현
정규화 : 가수가 밑수보다 작은 한 자리까지 가수로 표현 되는 것
ex)0.2 표현 0.4 X 2-1  정규화 하면 1.6 X 2-3
float는 4byte, double은 8byte
*/
package ch07;

public class DoubleTest {

	public static void main(String[] args) {
		double dnum = 3.14;
		float fnum = 3.14F;//실수는 기본적으로 double에 저장이 된다.
		                   //따라서 float를 나타내는 F를 뒤에 꼭 붙혀야한다.
		
		System.out.println(dnum);
		System.out.println(fnum);
	}

}


/*문자인코딩: 문자가 숫자로 변환되는 것
디코딩: 숫자에서 다시 문자로 변환되는 것
문자세트: 각 문자를 얼마로 표현할 것인지 코드 값을 모아둔 것
ASKII: 8bit 로 알파벳과 수자 특수 문자들을 1바이트에 표현하는데 사용하는 문자세트
UNICODE: 전 세계 표준으로 만든 문자 세트 (utf-8, utf-16)
java에서는 utf-16을 쓴다.
'A': 2byte 문자
"A": 문자열 
*/
package ch08;

public class CharacterTest {

	public static void main(String[] args) {
		char ch1 = 'A';
		System.out.println(ch1);//A가 출력됨
		System.out.println((int)ch1);//65가 출력됨
		
		char ch2 = 66;
		System.out.println(ch2); //B가 출력됨
		System.out.println((char)ch2);//B가 출력됨
		
		int ch3 = 67;
		System.out.println(ch3); //67이 출력됨
		System.out.println((char)ch3);//C가 출력됨
		
		char han = '한';
		char ch = '\uD55C';
		
		System.out.println(han);//한 출력
		System.out.println(ch);//한 출력
	}

}


/* 논리형
-true(참), false(거짓) 두 가지만 나타냄,1바이트를 사용 함

지역변수
-추론 가능한 변수에 대한 자료형을 선언하지 않음
-한번 선언하여 추론 된 변수는 다른 타입의 값을 대입 할 수 없음
*/
package ch09;

public class LocalVariableInter {

	public static void main(String[] args) {
		var i = 10; 
		var j =10.0;
		var str = "test";
		
		System.out.println(i);//다른 변수 없이 정수로 출력
		System.out.println(j);//다른 변수 없이 실수로 출력
		System.out.println(str);//다른 변수 없이 문자 출력
		
		var str2 = str;
		System.out.println(str2);//다른 변수에 넣어도 출력값이 같다.
	}

}


/*변하지 않는 상수와 리터럴
상수:변하지 않는 수
-final 예약어를 사용하여 선언
-상수를 사용하면 변하지 않는 값을 반복하여 사용할 때 의미있는 문자로 인식하기 쉽고 혹, 
 변하더라도 선언한 부분만 변경하면 되므로 여러부분을 수정할 필요가 없음
*/
package ch10;

public class ConstantTest {

	public static void main(String[] args) {
		final int MAX_NUM = 100;
		final int MIN_NUM;
		MIN_NUM = 0;
		System.out.println(MAX_NUM);// 100상수가 출력
		System.out.println(MIN_NUM);// 0 상수가 출력
		
	}

}


/*리터럴
-프로그램에서 사용하는 숫자, 문자, 논리값을 뜻함
-리터럴은 상수 풀(constant pool)에 있음(상수 풀:하드디스크에 프로그램을 실행시키면 메모리에 로드 된다.하지만
                                        상수, static 변수는 프로그램이 로드됬다는 이유만으로 메모리에 영역을 잡는다.)
-정수 리터럴은 int 로 실수 리터럴은 double 로 저장됨
 정수의 범위가 넘어가는 경우는 L,l을 float로 사용하려는 경우는 F,f 식별자를 써줘야 함
 
 형 변환
-서로 다른 자료형 간에 연산등의 수행을 위해 하나의 자료형으로 통일하는 것
-묵시적 형 변환: 자동으로 형변환
 (작은 자료형에서 큰 자료형으로 변환,덜 정밀한 자료형에서 더 정밀한 자료형으로 변환)
-명시적 형 변환: 강제적인 형변환
 */
 package ch10;

public class TypeConversionTest {

	public static void main(String[] args) {
		/*byte bNum = 125;
		int iNum = bNum;
		System.out.println(iNum);//int의 자료형이 더 크기 때문에 125출력
		
		int Num = 255;
		byte cNum = (byte)Num;
		System.out.println(cNum);//-1출력 원하는 값이 출력이 안됨
		
		double dNum = 3.14;
		int inum = (int)dNum;
		System.out.println(inum);//3이 출력된다. 
		*/
		double dNum = 1.2;
		float fNum = 0.9F;
		
		int iNum1 = (int)dNum + (int)fNum;
		int iNum2 = (int)(dNum+ fNum);
		System.out.println(iNum1);//소수점을 버리고 더했기 때문에 1이 출려됨
		System.out.println(iNum2);//더하고 소수점을 버렸기 때문에 2가 출력됨
	}

}
