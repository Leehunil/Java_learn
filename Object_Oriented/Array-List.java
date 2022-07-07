/*java.util 패키지에서 제공되는 ArrayList
-기존의 배열 선언과 사용 방식은 배열의 길이를 정하고 요소의 개수가 배열의 길이보다 커지면 배열을 재할당하고 복사해야 했음
-배열의 요소를 추가하거나 삭제하면 다른 요소들의 이동에 대한 구현을 해야 함
-ArrayList는 객체 배열을 좀더 효율적으로 관리하기 위해 자바에서 제공해 주는 클래스
-이미 많은 메서드들이 최적의 알고리즘으로 구현되어 있어 각 메서드의 사용 방법만 익히면 유용하게 사용할 수 있음

*ArrayList의 주요 메서드
boolean add(E e) : 요소 하나를 배열에 추가합니다. E는 요소의 자료형을 의미한다.
int size() : 배열에 추가된 요소 전체 개수를 반환합니다.
E get(int index) : 배열의 index 위치에 있는 요소 값을 반환합니다.
E remove(int index) : 배열의 index 위치에 있는 요소 값을 제거하고 그 값을 반환합니다.
boolean isEmpty() : 배열이 비어 있는지 확인합니다.
*/

package ch23;

import java.util.ArrayList;

import ch21.Book;// import는 class를 가져온다.

public class ArrayListTest {

	public static void main(String[] args) {
		
		ArrayList<Book> library =new ArrayList<>();//<>안에는 생성자 Book이 들어가야 맞지만 안써도 된다.
		
		library.add(new Book("Harry Poter1","Lee"));
		library.add(new Book("Harry Poter2","Lee"));
		library.add(new Book("Harry Poter3","Lee"));
		library.add(new Book("Harry Poter4","Lee"));
		library.add(new Book("Harry Poter5","Lee"));
		library.add(new Book("Harry Poter6","Lee"));
		
		for(int i=0;i<library.size();i++) {//ArrayList.size()는 배열의 크기를 알려준다.
			library.get(i).showInfo();//ArrayList.get()은 배열의 값을 가져온다.
		}
	}

}

/* ArrayList를 활용한 간단한 성적 산출 프로그램

1001학번 Lee와 1002학번 Kim, 두 학생이 있습니다. 
Lee 학생은 국어와 수학 2과목을 수강했고, Kim 학생은 국어, 수학, 영어 3 과목을 수강하였습니다.
Lee 학생은 국어 100점, 수학 50점입니다. 
Kim 학생은 국어 70점, 수학 85점, 영어 100점입니다. 
Student와 Subject 클래스를 만들고 ArrayList를 활용하여 두 학생의 과목 성적과 총점을 출력하세요

출력
Lee'skorean's score is 100
Lee'smath's score is 50
Lee's total is 150
====================
Kim'skorean's score is 70
Kim'smath's score is 85
Kim'sEnglish's score is 100
Kim's total is 255
*/
//Student Class

package ch24;

import java.util.ArrayList;

public class Student {
	int studentId;
	String studentName;
	
	ArrayList<Subject> subjectList;//Subject class에 관한 리스트를 하나 만든다.

	Student(int studentId, String studentName){
		this.studentId=studentId;
		this.studentName=studentName;
		
		subjectList=new ArrayList<>();//학생을 생성할때 그 학생에 관한 과목 배열리스트도 하나 생성한다.
	}
	
	public void addSubject(String name,int point) {//메서드에 Subject 생성자를 넣는다.
		Subject subject=new Subject();
		subject.setSubjectName(name);
		subject.setSubjectScore(point);
		
		subjectList.add(subject);//만들어놓은 배열리스트에 과목 정보를 넣는다.
	}

	
	
	public void showScoreInfo() {
		int total = 0;
		
		for(Subject subject:subjectList) {
			total+=subject.getSubjectScore();
			System.out.println(studentName+"'s"+subject.getSubjectName()+"'s score is "+subject.getSubjectScore());
		}
		System.out.println(studentName+"'s total is "+ total);
	}
}

//Subject Class

package ch24;

public class Subject {
	private String subjectName;
	private int subjectScore;
	
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public int getSubjectScore() {
		return subjectScore;
	}
	public void setSubjectScore(int subjectScore) {
		this.subjectScore = subjectScore;
	}
	
	
}

//Test

package ch24;

public class StudentSubjectTest {

	public static void main(String[] args) {
		Student studentLee=new Student(1001,"Lee");
		
		studentLee.addSubject("korean", 100);
		studentLee.addSubject("math", 50);
		
		Student studentKim=new Student(1002,"Kim");
		
		studentKim.addSubject("korean", 70);
		studentKim.addSubject("math", 85);
		studentKim.addSubject("English", 100);
		
		studentLee.showScoreInfo();
		System.out.println("====================");
		studentKim.showScoreInfo();
	}

}

