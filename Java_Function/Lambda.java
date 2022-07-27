package ch03;

public interface Add {

	public int add(int x,int y);
}


package ch03;

public class AddTest {

	public static void main(String[] args) {
		/*함수형 프로그래밍: 매개변수를 받고 매개변수를 기반으로만 함수를 수행해서 안전하다.
		1.함수의 이름은 없다.
		2. 매개 변수와 매개변수를 이용한 실행문
		3. 자료형 생략 가능
		4. (), {}, return 도 생략 가능*/
		
		Add addL =(x,y)-> x+y;
		
		System.out.println(addL.add(2, 3));
	}

}


package ch04;

@FunctionalInterface
//함수형 인터페이스: 인터페이스 안에는 익명 메서드가 반드시 1개만 있어야 한다.
public interface MyNumber {
	
	int getMax(int x,int y);
}


package ch04;

public class MyNumberTest {

	public static void main(String[] args) {

		MyNumber myNumber = (x,y) -> x>y ? x:y;
		//3항 연산자: 조건 ? 참:거짓;
		System.out.println(myNumber.getMax(10, 20));
	}

}


package ch05;

public interface StringConcat {

	public void makeString(String s1,String s2);
}


package ch05;

public class StringConcatImpl implements StringConcat{

	@Override
	public void makeString(String s1, String s2) {
		
		System.out.println(s1+" , "+s2);
	}

}


package ch05;

public class StringConcatTest {

	public static void main(String[] args) {

		String s1= "Hello";
		String s2= "world";
		StringConcatImpl strImpl = new StringConcatImpl();
		strImpl.makeString(s1,s2 );
		
		StringConcat concat = (s,v)-> System.out.println(s+" , "+v);
		concat.makeString(s1, s2);
		//람다 함수는 내부적으로 입력 클래스가 하나 만들어져 사용하고 있다.
	}

}
