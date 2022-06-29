/*메서드 (method)
-객체의 기능을 구현하기 위해 클래스 내부에 구현되는 함수
-멤버 함수 (member function)이라고도 함
-메서드를 구현함으로써 객체의 기능이 구현 됨
-메서드의 이름은 그 객체를 사용하는 객체(클라이언트)에 맞게 짓는것이 좋음

학생 클래스의 속성을 멤버 변수로 선언하고 메서드를 구현한다
*/
package ch04;

public class Student {
	
	public String studentName;
	public int studentId;
	public String address;
	
  // 학생의 정보를 출력하는 메서드
	public void showStudentInfo() {
		System.out.println(studentId + "학번의 학생의 이름은" + studentName + "이고, 주소는"+ address);
	}
	
  //학생의 이름을 반환하는 메서드
	public String getStudentName() {
		return studentName;
	}
	
  //학생의 이름을 바꾸는 메서드
	public void setStudentName(String name) {
		studentName = name;
		
	}
	
}	


//학생 클래스를 생성하여 생성된 객체(인스턴스)에 각각 다른 이름과 주소를 대입한다
package ch04;

public class StudentTest {

	public static void main(String[] args) {
		
		Student studentLee = new Student(); //하나의 인스턴스를 제작한것이다.
		
		studentLee.studentId=12345;
		studentLee.setStudentName("Lee");
		studentLee.address="seoul";
		
		studentLee.showStudentInfo();//메서드를 불러온다.(출력은 12345 학번의 학생의 이름은 Lee이고, 주소는 seoul이다.)		
		
    Student studentKim = new Student();//다른 하나의 인스턴스를 제작한것이다.
		
		studentKim.studentId=23456;
		studentKim.setStudentName("Kim");
		studentKim.address="Busan";
		
		studentKim.showStudentInfo();//메서드를 불러온다.(출력은 223456 학번의 학새의 이름은 KIm이고, 주소는 Busan이다.)
	}

}
