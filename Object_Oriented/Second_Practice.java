/*Edward는 지각을 해서 택시를 타야 했습니다. 
20000원을 가지고 있었는데 10000원을 택시비로 사용했습니다.
택시는 'good taxi' 회사 택시를 탔습니다.

출력
Edward's money is 16700
good taxi's taxi's money is 10000
*/

//Taxi class
package ch15;

public class Taxi {
	String taxiName;
	int money;
	
	public Taxi(String taxiName) {
		this.taxiName=taxiName;
	}
	
	public void take(int money) {
		this.money+=money;
	}
	
	public void showTaxiInfo() {
		System.out.println(taxiName+"'s taxi's money is "+ money);
	}
}


//Student class
package ch15;

public class Student {
	String studentName;
	int money;
	
	public Student(String studentName,int money) {
		this.studentName=studentName;
		this.money=money;
	}
	
	public void takeTaxi(Taxi taxi) {
		taxi.take(10000);
		this.money-=3300;
	}
	
	public void showStudentInfo() {
		System.out.println(studentName+"'s money is "+ money);
	}
}

//main
package ch15;

public class Test {

	public static void main(String[] args) {
		Student student_E =new Student("Edward",20000);
		Taxi gtaxi=new Taxi("good taxi");
		student_E.takeTaxi(gtaxi);
		
		student_E.showStudentInfo();
		gtaxi.showTaxiInfo();

	}

}
