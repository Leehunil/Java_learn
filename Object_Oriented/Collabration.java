/* 객체 지향 프로그래밍에서의 협력
-객체 지향 프로그램에서 객체 간에는 협력이 이루어짐
-협력을 위해서는 필요한 메세지를 전송하고 이를 처리하는 기능이 구현되어야 함
-매개 변수로 객체가 전달되는 경우가 발생

버스와 지하철을 타는 예제 프로그래밍
-James와 Tomas는 각각 버스와 지하철을 타고 학교에 갑니다.
-James는 5000원을 가지고 있었고, 100번 버스를 타면서 1000원을 지불합니다.
-Tomas는 10000원을 가지고 있었고, 초록색 지하철을 타면서 1200원을 지불합니다.

두 학생이 버스와 지하철을 타는 상황을 구현해 봅시다.
*/



//Bus Class
package ch14;

public class Bus {
	int busNumber;
	int passengerCount;
	int money;
	
	//생성자에는 버스숫자 정보만 들어간다.
  public Bus(int busNumber) {
		this.busNumber=busNumber;
		
	}
	
	//take 메서드
  public void take(int money) {
		this.money+=money;//this.money는 버스의 돈 money는 들어오는 돈이다.
		passengerCount++;//승객 1명을 추가한다.
	}
	
	public void showBusInfo() {
		System.out.println(busNumber+" Bus's money is "+money+" and passenger is "+ passengerCount);
	}
}



//Train Class
package ch14;

public class Train {
	int trainNumber;
	int passengerCount;
	int money;
	
	public Train(int trainNumber) {
		this.trainNumber=trainNumber;
	}
	
	public void take(int money) {
		this.money+=money;
		passengerCount++;
	}
	
	public void showTrainInfo() {
		System.out.println(trainNumber+" train's money is "+money+" passenger is "+ passengerCount);
	}
}



//Student class
package ch14;

public class Student {
	String studentName;
	int money;
	
	//생성자에는 학생의 이름과 학생이 가지고 있는 돈의 정보가 들어간다.
  public Student(String studentName,int money) {
		this.studentName=studentName;
		this.money=money;
	}
	
	//버스를 타는 메서드로 참조 변수로 어떤 버스를 탈지 고르고
  public void takeBus(Bus bus) {
		bus.take(1000);//Bus take 함수를 수행한다.
		this.money-=1000;//학생이 가지고 있는 돈을 버스에 지불할 돈만큼 뺀다.
	}
	public void takeTrain(Train train) {
		train.take(1200);
		this.money-=1200;
	}
	public void showStudentInfo() {
		System.out.println(studentName+"'s money is "+money);
	}
}


//main 
package ch14;

public class TakeTransTest {

	public static void main(String[] args) {
		//학생 2명을 새로운 인스턴스로 생성한다.
    Student studentJ =new Student("James",5000);
		Student studentT = new Student("Tomas",10000);
		
    //100번 버스와 그린 지하철을 생성한다.
		Bus bus_100=new Bus(100);
		studentJ.takeBus(bus_100);//James는 버스를 탄다.
		Train train_green = new Train(2);
		studentT.takeTrain(train_green);//Tomas는 지하철을 탄다.
		
		studentJ.showStudentInfo();
		studentT.showStudentInfo();
		bus_100.showBusInfo();
		train_green.showTrainInfo();

	}

}

