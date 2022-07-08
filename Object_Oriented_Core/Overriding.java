/*하위 클래스에서 메서드 재정의 하기
-오버라이딩(overriding) : 상위 클래스에 정의된 메서드의 구현 내용이 하위 클래스에서 구현할 내용과 맞지 않는 경우
 하위 클래스에서 동일한 이름의 메서드를 재정의 할 수 있음
*/
//Customer Class
package ch04;

public class Customer {
	protected int customerId;
	protected String customerName;
	protected String customerGrade;
	
	int bonusPoint;
	double bonusRatio;
	
	/*public Customer() {
		customerGrade="silver";
		bonusRatio=0.01;
		System.out.println("Customer() call");
	}*/
	
	
	public Customer(int customerId,String customerName) {
		this.customerId=customerId;
		this.customerName=customerName;
		
		customerGrade="silver";
		bonusRatio=0.01;
		System.out.println("Customer(int, String) call");
	}
	
	public int calPrice(int price) {
		bonusPoint+=price * bonusRatio;
		return price;
	}
	
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerGrade() {
		return customerGrade;
	}

	public void setCustomerGrade(String customerGrade) {
		this.customerGrade = customerGrade;
	}

	public String showCustomerInfo() {
		return customerName+" customer's grade is "+customerGrade+" and bonus point is "+bonusPoint;
	}
}

//VIPCustomer Class
package ch04;

public class VIPCustomer extends Customer{ //VIPCustomet가 Customer 에서 상속 받았다.
	
	
	double salesRatio;
	String agentId;
	
	/*public VIPCustomer() {
		super();//상위 상속 class의 참조값을 가지게 된다, super()는 쓰지 않아도 자동으로 호출된다.
		bonusRatio=0.05;
		customerGrade="VIP";
		salesRatio=0.01;
		
		System.out.println("VIPCustomer() call");
	}*/
	
	
	public VIPCustomer(int customerId,String customerName) {
		super(customerId,customerName);
		bonusRatio=0.05;
		customerGrade="VIP";
		salesRatio=0.01;
		System.out.println("VIPCustomer(int,String) call");
	}

	@Override//컴파일러에게 이것은 오버라이딩 된 메서드다 라고 알려주는 에노테이션이다.(재졍의 메서드)
	public int calPrice(int price) {
		price-= (int)(price*salesRatio);
		return price;
	}
	
	
}

//main
package ch04;

public class CustomerTest {

	public static void main(String[] args) {
		Customer customerLee=new Customer(1000,"Lee");
		customerLee.bonusPoint=1000;
		System.out.println(customerLee.calPrice(1000));
		System.out.println(customerLee.showCustomerInfo());
		
		VIPCustomer customerKim = new VIPCustomer(1001,"KIM");
		customerKim.bonusPoint=10000;
		System.out.println(customerKim.calPrice(1000));
		System.out.println(customerKim.showCustomerInfo());
		
		
		Customer vc=new VIPCustomer(12345,"noname");
		System.out.println(vc.calPrice(1000));
		//990이 출력됨을 알 수 있다.(가상 매서드)
		
	}

}

/*메서드는 어떻게 호출되고 실행 되는가?
-메서드(함수)의 이름은 주소값을 나타냄
-메서드는 명령어의 set 이고 프로그램이 로드되면 메서드 영역(코드 영역)에 명령어 set이 위치
-해당 메서드가 호출 되면 명령어 set 이 있는 주소를 찾아 명령어가 실행됨
-이때 메서드에서 사용하는 변수들은 스택 메모리에 위치 하게됨
-따라서 다른 인스턴스라도 같은 메서드의 코드는 같으므로 같은 메서드가 호출됨
-인스턴스가 생성되면 변수는 힙 메모리에 따로 생성되지만, 메서드 명령어 set은 처음 한번만 로드 됨

가상 메서드의 원리
-가상 메서드 테이블에서 해당 메서드에 대한 address를 가지고 있음
-재정의된 경우는 재정의 된 메서드의 주소를 가리킴
*/
