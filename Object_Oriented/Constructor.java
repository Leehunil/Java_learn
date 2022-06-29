/*생성자
-생성자 기본 문법 <class_name>([<argument_list]){
[<statements]
}
-객체를 생성할 때 new 키워드와 함께 사용   - new Student();
-생성자는 일반 함수처럼 기능을 호출하는 것이 아니고 객체를 생성하기 위해 new 와 함께 호출 됨
-객체가 생성될 때 변수나 상수를 초기화 하거나 다른 초기화 기능을 수행하는 메서드를 호출 함
-생성자는 반환 값이 없고, 클래스의 이름과 동일
-대부분의 생성자는 외부에서 접근 가능하지만, 필요에 의해 private 으로 선언되는 경우도 있음

기본 생성자 (default constructor)
-클래스에는 반드시 적어도 하나 이상의 생성자가 존재
-클래스에 생성자를 구현하지 않아도 new 키워드와 함께 생성자를 호출할 수 있음
-클래스에 생성자가 하나도 없는 경우 컴파일러가 생성자 코드를 넣어 줌
 public Student(){}
-매개 변수가 없음, 구현부가 없음

생성자 정의 하기
-생성자를 구현해서 사용할 수 있음
-클래스에 생성자를 따로 구현하면 기본 생성자 (default constructor)는 제공되지 않음
-생성자를 호출하는 코드(client 코드)에서 여러 생성자 중 필요에 따라 호출해서 사용할 수 있음
*/

//컴파일러가 제공해 주는 기본 생성자외에 필요에 의해 생성자를 직접 구현 할 수 있음

package ch06;

public class Student {
	public String studentName;
	public int studentNumber;
	public int grade;
	
  //디폴트 생성자는 class에 생성자가 없을때만 사용가능하지만 컴파일러가 사용하고 싶으면 디폴트 생성자를 생성한다
	public Student() {} 
	
  //생성자
  public Student(int studentNumber,int grade,String studentName) {
		this.studentNumber = studentNumber;//this.멤버 변수= 메게 변수
		this.studentName=studentName;
		this.grade=grade;
	}
	public String showStudentInfo() {
		
		return studentName + "'s number is" + studentNumber + "'s grade is " + grade;
	}

}

package ch06;

public class StudentTest {

	public static void main(String[] args) {
		
		Student studentLee = new Student();//디폴트 생성자를 인스턴스로 불러옴
		System.out.println(studentLee.showStudentInfo());
		
		Student studentKim = new Student(12345,5,"Kim");//생성자를 이용해서 불러옴
		System.out.println(studentKim.showStudentInfo());
	}

}
