package ch01;

class Book{
	
	private String title;
	private String author;
	
	public Book(String title,String author) {
		this.title=title;
		this.author=author;
	}

	@Override
	public String toString() {
		
		return title + "," +author;
	}
	//객체에 대한 정보를 오버라이딩 할때 tostring을 사용한다.
	
}




public class BookTest {

	public static void main(String[] args) {
		
		Book book = new Book("Harry Poter","Lee");
		
		System.out.println(book);//ch01.Book@156643d4출력
		// 클래스의 이름과 메모리의 위치에 대한 가상 메모리값이 나온다.
		
		String str = new String("test");
		System.out.println(str);//test가 출력된다.
		System.out.println(str.toString());//test 출력
		//이미 재정의가 되어있어서 같다.
	}

}
