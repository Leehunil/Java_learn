/* 학생의 정보(키, 몸무게, 나이, 이름)을 출력하는 클래스*/
package ch08;

public class Student {
	public int studentHeight;
	public int studentWeight;
	public String studentName;
	public int studentAge;
	
	//생성자
  public Student(int studentHeight,int studentWeight,int studentAge,String studentName) {
		
		this.studentHeight=studentHeight;
		this.studentWeight=studentWeight;
		this.studentName=studentName;
		this.studentAge=studentAge;
		
	}
	
  //메서드
	public String showStudentInfo() {
		
		return studentName+"'s height is "+studentHeight+"and weigh is "+studentWeight+" and age is "+ studentAge;
	}
}

package ch08;

public class Test {

	public static void main(String[] args) {
		Student studentLee = new Student(180,78,37,"Tomas");
		System.out.println(studentLee.showStudentInfo());//출력은 Tomas's height is 180 and weigh is 78 and age is 37.
		
	}

}
