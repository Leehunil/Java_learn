/*싱글톤 패턴
-프로그램에서 인스턴스가 단 한 개만 생성되어야 하는 경우 사용하는 디자인 패턴
-static 변수, 메서드를 활용하여 구현 할 수 있음
*/
//싱글톤 패턴으로 회사 객체 구현하기



package ch18;

public class Company {
	
	private static Company instance= new Company();//유일한 인스턴스는 내부에 만든다.
	private Company() {
	//생성자는 private로 선언
	}
	
	public static Company getInstance() { //외부에서 인스턴스를 만들지 않고 바로 사용할 수 있게 static으로 만들어준다.
		if(instance == null) {
			instance=new Company();
		}
		return instance;
	}
}
//Test

package ch18;

import java.util.Calendar;

public class CompanyTest {

	public static void main(String[] args) {
		Company company1=Company.getInstance();//클래스 이름으로 바로 사용할 수 있다.
		Company company2=Company.getInstance();
		
		System.out.println(company1);
		System.out.println(company2);//2개의 주소가 같다.
		
		Calendar calendar= Calendar.getInstance();
	}

}
