/*접근 제어 지시자 (accesss modifier)
-클래스 외부에서 클래스의 멤버 변수, 메서드, 생성자를 사용할 수 있는지 여부를 지정하는 키워드
-private : 같은 클래스 내부에서만 접근 가능 ( 외부 클래스, 상속 관계의 클래스에서도 접근 불가)
-아무것도 없음 (default) : 같은 패키지 내부에서만 접근 가능 ( 상속 관계라도 패키지가 다르면 접근 불가)
-protected : 같은 패키지나 상속관계의 클래스에서 접근 가능하고 그 외 외부에서는 접근 할 수 없음
-public : 클래스의 외부 어디서나 접근 할 수 있음

get()/ set() 메서드
-private 으로 선언된 멤버 변수 (필드)에 대해 접근, 수정할 수 있는 메서드를 public으로 제공
-get() 메서드만 제공 되는 경우 read-only 필드
-이클립스에서 자동으로 생성됨

정보 은닉
-private으로 제어한 멤버 변수도 public 메서드가 제공되면 접근 가능하지만 변수가 public으로 공개되었을 때보다
 private 일때 각 변수에 대한 제한을 public 메서드에서 제어 할 수 있다.
 */


 package ch10;

public class BirthDay {
	private int day;//private로 사용자가 임의로 날짜를 지정할 수 없게 오류를 줄여준다.
	private int month;
	private int year;
	
	private boolean isValid;//isValid는 이 안에서만 값이 유효한지 안유효한지만 중요하기 때문에 밖에 나갈 필요가 없다.
	
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day=day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		if (month<1 || month>12) {//if문으로 1월 미만 12월 초과는 false로 한다.
			isValid=false; 
		}
		else {
			isValid = true;
			this.month = month;
		}
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public void showDate() {
		if (isValid) {//isValid가 true인지 false인지 확인
			System.out.println("Birthday is "+year+"."+month+"."+day);
		}
		else {
			System.out.println("Unvalid");
		}
	}
}


package ch10;

public class BirthDayTest {

	public static void main(String[] args) {
		
		BirthDay date=new BirthDay();
		date.setMonth(12);//13을 입력하게 되면 Unvalid 가 출력된다.
		date.setDay(30);
		date.setYear(2021);
		
		date.showDate();

	}

}


/*정보 은닉을 활용한 캡슐화
-꼭 필요한 정보와 기능만 외부에 오픈함
-대부분의 멤버 변수와 메서드를 감추고 외부에 통합된 인터페이스만은 제공하여 일관된 기능을 구현 하게 함
-각각의 메서드나 멤버 변수를 접근함으로써 발생하는 오류를 최소화 한다.
*/

package ch11;

public class MakeReport {
	StringBuffer buffer= new StringBuffer(); //Stringbuffer는 문자열을 계속해서 추가해서 나중에 return 할때 쓴다.
	private String line ="=======================================\n";
	private String title="name\t   address\t\t  phonenumber   \n";
	private void makeHeader() {
		
		buffer.append(line);
		buffer.append(title);
		buffer.append(line);
		
	}
	private void generateBody() {
		
		buffer.append("James \t");
		buffer.append("seoul \t");
		buffer.append("010-2456-3756 \n");
		
		buffer.append("Tom \t");
		buffer.append("Busan \t");
		buffer.append("010-1235-4567 \n");
	}
	private void makeFooter() {
		buffer.append(line);
		
	}
	//사용자는 이 메서드만 보이게 된다.
	public String getReport() {
		makeHeader();
		generateBody();
		makeFooter();
		return buffer.toString();//toString()은 추가한 String을 return할때 쓴다.
	}
}



package ch11;

public class MakeReportTest {

	public static void main(String[] args) {
		MakeReport builder= new MakeReport();
		String report=builder.getReport();
		System.out.println(report);

	}

}
