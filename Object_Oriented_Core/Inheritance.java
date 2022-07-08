/*클래스 상속
-이미 구현된 클래스보다 더 구체적인 기능을 가진 클래스를 구현해야 할때 기존 클래스를 상속함
-상속의 문법 class B extends A{}
 B:하위 클래스  A:상위 클래스

상속을 활용한 멤버십 클래스 구현하기
*/

//Customemr Class
package ch02;

public class Customer {
	protected int customerId;
	protected String customerName;
	protected String customerGrade;
	//protected는 외부 클래스는 접근 할 수 없지만, 하위 클래스는 접근 할 수 있도록 protected 접근 제어자를 사용
	int bonusPoint;
	double bonusRatio;
	
	public Customer() {
		customerGrade="silver";
		bonusRatio=0.01;
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
package ch02;

public class VIPCustomer extends Customer{ //VIPCustomet가 Customer 에서 상속 받았다.
	
	//상속하는 class에는 없는 정보는 작성한다.
	double salesRatio;
	String agentId;
	
	public VIPCustomer() {
		bonusRatio=0.05;
		customerGrade="VIP";
		salesRatio=0.01;
	}
}

//main
package ch02;

public class CustomerTest {

	public static void main(String[] args) {
		Customer customerLee=new Customer();
		customerLee.setCustomerName("Lee");
		customerLee.bonusPoint=1000;
		customerLee.setCustomerId(1000);
		customerLee.calPrice(30000);
		System.out.println(customerLee.showCustomerInfo());
		
		VIPCustomer customerKim = new VIPCustomer();
		customerKim.setCustomerName("Kim");
		customerKim.setCustomerId(1001);
		customerKim.bonusPoint=10000;
		customerKim.calPrice(30000);
		System.out.println(customerKim.showCustomerInfo());
	}

}

/*하위 클래스가 생성 되는 과정
-하위 클래스를 생성하면 상위 클래스가 먼저 생성 됨
-new VIPCustomer()를 호출하면 Customer()가 먼저 호출 됨
-클래스가 상속 받은 경우 하위 클래스의 생성자에서는 반드시 상위 클래스의 생성자를 호출 함

형 변환(업캐스팅)
-상위 클래스로 변수를 선언하고 하위 클래스의 생성자로 인스턴스를 생성
-하위 클래스는 상위 클래스의 타입을 내포하고 있으므로 상위 클래스로의 묵시적 형 변환이 가능함
-상속 관계에서 모든 하위 클래스는 상위 클래스로 형 변환(업캐스팅)이 됨
*/
//Customer Class
package ch03;

public class Customer {
	protected int customerId;
	protected String customerName;
	protected String customerGrade;
	int bonusPoint;
	double bonusRatio;
	
	//디폴트 생성자
	/*public Customer() {
		customerGrade="silver";
		bonusRatio=0.01;
		System.out.println("Customer() call");
	}*/
	
	//생성자
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
package ch03;

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
	
	//디폴트 생성자가 아닌 메게변수가 있는 생성자를 사용할때
	public VIPCustomer(int customerId,String customerName) {
		super(customerId,customerName);//super()안에 변수값을 넣어준다.
		bonusRatio=0.05;
		customerGrade="VIP";
		salesRatio=0.01;
		System.out.println("VIPCustomer(int,String) call");
	}
}

//main
package ch03;

public class CustomerTest {

	public static void main(String[] args) {
		Customer customerLee=new Customer(1000,"Lee");
		customerLee.bonusPoint=1000;
		customerLee.calPrice(30000);
		System.out.println(customerLee.showCustomerInfo());
		
		VIPCustomer customerKim = new VIPCustomer(1001,"KIM");
		customerKim.bonusPoint=10000;
		customerKim.calPrice(30000);
		System.out.println(customerKim.showCustomerInfo());
		//상위 상속자의 생성자가 먼저 호출됨을 알 수 있다.
		
		Customer vc =new VIPCustomer(12345,"noname");
		//인스턴스 생성은 VIP로 했지만 타입이 Customer 이므로 실제 접근 가능한 변수나 메서드는 Customer의 변수와 메서드이다.
	}

}
