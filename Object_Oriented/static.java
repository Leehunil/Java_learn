/* Static
-여러 인스턴스가 공유하는 기준 값이 필요한 경우 사용한다.
-인스턴스가 생성될 때 만들어지는 변수가 아닌, 처음 프로그램이 메모리에 로딩될 때 메모리를 할당한다.
-클래스 변수, 정적변수라고도 함
-인스턴스 생성과 상관 없이 사용 가능하므로 클래스 이름으로 직접 참조


static 메서드 만들기
-static 메서드는 인스턴스 생성과 무관하게 클래스 이름으로 호출 될 수 있음
-인스턴스 생성 전에 호출 될 수 있으므로 static 메서드 내부에서는 인스턴스 변수를 사용할 수 없음
*/

//Employee class
package ch16;

public class Employee {
	private static int serialNum = 1000; //serialNum은 사원 번호로 1000을 기준값으로 두었다.
	
	private String employeeName;
	private int employeeId;
	private String department;
	
	//인스턴스 하나를 생성할때마다 사원번호를 하나씩 증가시키고 사원Id에 넣어준다. 
  public Employee() {
		serialNum++;
		employeeId=serialNum;//인스턴스 주소가 같으므로 다 같은 사원 번호가 출력되니깐 employeeId에 따로 넣어준다.
	}
	
	public static int getSerialNum() {
		return serialNum;
		//static 메서드 안에서는 일반 멤버 변수를 사용할 수 없다, 지역 변수는 사용할 수 있다.
	}

	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	
}


package ch16;

public class EmployeeTest {

	public static void main(String[] args) {
		Employee employeeLee=new Employee();//새로운 사원을 생성
		employeeLee.setEmployeeName("Lee");
		System.out.println(Employee.getSerialNum());//1001이 출력된다.
		//static 변수는 class이름으로 참조해서 사용한다.
		
		Employee employeeKim=new Employee();//새로운 사원을 생성
		employeeKim.setEmployeeName("Kim");
		
		System.out.println(employeeKim.getEmployeeName()+"'s serial number is "+employeeKim.getEmployeeId());//1002출력
		System.out.println(employeeLee.getEmployeeName()+"'s serial number is "+employeeLee.getEmployeeId());//1001출력
		
	}

}


/*변수의 유효 범위와 메모리
지역변수
-선언 위치:함수 내부에 선언
-사용 볌위:함수 내부에서만 사용
-메모리: 스택
-생성과 소멸: 함수가 호출될 때 생성되고 함수가 끝나면 소멸함

멤버변수
-선언 위치: 클래스 멤버 변수로 선언
-사용 범위: 클래스 내부에서 사용하고 private가 아니면 참조 변수로 다른 클래스에서 사용 가능
-메모리: 힙
-생성과 소멸: 인스턴스가 생성될 때 힙에 생성되고, 가비지 컬렉터가 메모리를 수거할 때 소멸됨

static변수
-선언 위치: static 예약어를 사용하여 클래스 내부에 선언
-사용 범위: 클래스 내부에서 사용하고 private가 아니면 클래스 이름으로 다른 클래스에서 사용 가능
-메모리: 데이터 영역
-생성과 소멸: 프로그램이 처음 시작할 때 상수와 함께 데이터 영역에 생성되고 프로그램이
              끝나고 메모리를 해제할 때 소멸됨
 */             
    



