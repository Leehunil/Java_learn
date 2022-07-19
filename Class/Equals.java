package ch02;

public class Student implements Cloneable{
	
	private int studentNum;
	private String studentName;
	
	public Student(int studentNum,String studentName) {
		this.studentNum= studentNum;
		this.studentName=studentName;
	}
	public void setStudentName(String name) {
		this.studentName=name;
	}
	
	public String tostring() {
		return studentNum +","+studentName;
	}

	//hashcode도 같게 재정의 하여야 한다.
	@Override
	public int hashCode() {
		return studentNum;
	}

	//equals()메서드
	//두 인스턴스의 주소 값을 비교하여 true/False를 반환하는 메서드
	//인스턴스가 다르더라도 논리적으로 동일한 경우 true를 반환하도록 재정의할 수 있다.
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student std =(Student)obj;
			if(this.studentNum==std.studentNum) 
				return true;
			else return false;
		}
		
		return false;
	}
	
	//clone() 메서드
	//객체의 원본을 복제하는데 사용하는 메서드
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
}


package ch02;

public class EqualsTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		Student std1=new Student(100,"Lee");
		Student std2=new Student(100,"Lee");
		
		System.out.println(std1==std2);
		System.out.println(std1.equals(std2));
		
		System.out.println(std1.hashCode());
		System.out.println(std2.hashCode());
		
		System.out.println(System.identityHashCode(std1));
		System.out.println(System.identityHashCode(std2));
		//진짜 hashcode를 반환해주는 메서드
		
		std1.setStudentName("Kim");
		Student copyStudent = (Student)std1.clone();
		System.out.println(copyStudent.tostring()); 
	}

}
