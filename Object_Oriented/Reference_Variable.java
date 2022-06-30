/* 참조 변수형
-클래스형으로 변수를 선언
-기본 자료형은 사용하는 메모리의 크기가 정해져 있지만, 참조 자료형은 클래스에 따라 다름
-참조 자료형을 사용 할때는 해당 변수에 대해 생성하여야 함  
 (String 클래스는 예외적으로 생성하지 않고 사용할 수 있음)
 */


 package ch09;

public class Subject {
	//subject 클래스를 만들고 안에는 과목이름, 점수, 과목Id가 들어간다.
	String subjectName;
	int score;
	int subjectId;
}


package ch09;

public class Student {
	int studentId;
	String studentName;
	
	Subject korea;//참조 변수를 멤버 변수로 사용 
	Subject math;
	
	//생성자
	Student(int studentId, String studentName){
		this.studentId=studentId;
		this.studentName=studentName;
		
		//Subject를 사용하기 위해서는 생성을 해야한다.
		korea=new Subject();
		math=new Subject();
		
	}
	//국어성적 메서드에는 이름과 성적이 들어간다.
	public void setKoreaSubject(String name,int score) {
		korea.subjectName=name;
		korea.score=score;
	}
	//수학성적 메서드
	public void setMathSubject(String name, int score) {
		math.subjectName=name;
		math.score=score;
	}
	//성적 확인 메서드
	public void showScoreInfo() {
		int total = korea.score + math.score;//total에 둘 성적을 더하고
		System.out.println(studentName+"'s total is "+ total);//출력
	}
}


package ch09;

public class SubjectTest {

	public static void main(String[] args) {
		
		Student studentLee=new Student(10,"Lee");
		studentLee.setKoreaSubject("korea", 100);
		studentLee.setMathSubject("math",95);
		
		Student studentKim=new Student(10,"Kim");
		studentLee.setKoreaSubject("korea", 65);
		studentLee.setMathSubject("math",55);
		
		studentLee.showScoreInfo();
		studentKim.showScoreInfo();
	}

}
 
