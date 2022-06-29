/*객체 (Object)
-의사나 행위가 미치는 대상 
-구체적, 추상적 데이터의 단위 

객체의 속성은 클래스의 멤버 변수(member variable)로 선언 함

객체 지향 프로그램은 어떻게 구현하는가?
-객체를 정의 하고
-각 객체의 속성을 멤버 변수로 역할을 메서드로 구현하고
-각 객체간의 협력을 구현합니다.

클래스 코딩하기
-클래스는 대문자로 시작하는것이 좋음
-java 파일 하나에 클래스는 여러 개가 있을 수 있지만, public 클래스는 하나이고, public 클래스와 .java 파일의 이름은 동일함
*/
//주문 클래스
package ch02;

public class Order {
	int orderId;
	String buyerId;
	String sellerId;
	int productId;
	String orderDate;
	
}

//학생 클래스
package ch02;

public class Student {
	//public: 어디서든지 접근이 가능하다.
	int studentNumber;
	String studentName;
	int majorCode;
	String majorName;
	int grade;
}

//회원 클래스
package ch02;

public class UserInfo {
	
	String userId;
	String userPassword;
	String userName;
	String address;
	int phoneNumber;
	
}
