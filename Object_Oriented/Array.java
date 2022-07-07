/* 배열
-동일한 자료형의 순차적 자료 구조
-인덱스 연산자[]를 이용하여 빠른 참조가 가능
-물리적 위치와 논리적 위치가 동일
-배열의 순서는 0부터 시작
-자바에서는 객체 배열을 구현한 ArrayList를 많이 활용함

*배열 초기화 하기
배열은 선언과 동시에 자료형에 따라 초기화 됨 ( 정수는 0, 실수는 0.0, 객체는 null)
필요에 따라 초기값을 지정할 수 있음

*/

package ch20;

public class ArryayTest {

	public static void main(String[] args) {
		
		int[] arr =new int[10];
		int total =0;
		
		for(int i=0, num=1; i<arr.length;i++) {
			arr[i]=num++;
		}
		
		//enhanced for문으로 처음부터 끝까지 순회할때 사용한다.
		for(int num:arr) {//for(변수:배열){}
			total+=num;
		}
		
		System.out.println(total);
	}

}
//문자 배열 만들기

package ch20;

public class CharArrayTest {

	public static void main(String[] args) {
		char[] alphabets = new char[26];
		char ch ='A';
		
		for(int i=0; i<alphabets.length;i++) {
			alphabets[i]=ch++;
		}
		
		for(char alpha:alphabets) {
			System.out.println(alpha+","+(int)alpha);
		}
	}

}


/* 객체 배열 선언과 구현
기본 자료형 배열은 선언과 동시에 배열의 크기만큼의 메모리가 할당되지만,
객체 배열의 경우엔 요소가 되는 객체의 주소가 들어갈(4바이트, 8바이트) 메모리만 할당되고(null) 각 요소 객체는 생성하여 저장해야 함
*/
package ch21;

public class Book {
	private String author;
	private String title;
	
	public Book() {}
	public Book(String author,String title) {
		this.author=author;
		this.title=title;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void showInfo() {
		System.out.println(author+","+title);
	}
	 
}


package ch21;

public class BookTest {

	public static void main(String[] args) {
		
		Book[] library = new Book[5];
		
		//for(int i=0;i<library.length;i++) {
			//System.out.println(library[i]); 
		//}
		
		library[0]= new Book("Harry Poter1","Lee");
		library[1]= new Book("Harry Poter2","Lee");
		library[2]= new Book("Harry Poter3","Lee");
		library[3]= new Book("Harry Poter4","Lee");
		library[4]= new Book("Harry Poter5","Lee");
		
		for(Book book :library) {
			System.out.println(book);
			book.showInfo();
		}
		
	}

}

/*객체 배열 복사하기
-System.arrayCopy(src, srcPos, dest, destPos, length) 자바에서 제공되는 배열 복사 메서드
-얕은 복사
 객체 주소만 복사되어 한쪽 배열의 요소를 수정하면 같이 수정 됨 
 즉, 두 배열이 같은 객체를 가리킴
-깊은 복사
 각각의 객체를 생성하여 그 객체의 값을 복사하여 배열이 서로 다른 객체를 가리키도록 함
*/

package ch21;

public class ObjectCopyTest {

	public static void main(String[] args) {
		Book[] library = new Book[5];
		Book[] copylibrary=new Book[5];		
		
		library[0]= new Book("Harry Poter1","Lee");
		library[1]= new Book("Harry Poter2","Lee");
		library[2]= new Book("Harry Poter3","Lee");
		library[3]= new Book("Harry Poter4","Lee");
		library[4]= new Book("Harry Poter5","Lee");
		
		//copylibrary에 새로운 주소를 주고
		copylibrary[0] = new Book();
		copylibrary[1] = new Book();
		copylibrary[2] = new Book();
		copylibrary[3] = new Book();
		copylibrary[4] = new Book();
		
		//각 배열에 값만 복사시킨다.
		for(int i=0;i<library.length;i++) {
			copylibrary[i].setAuthor(library[i].getAuthor());
			copylibrary[i].setTitle(library[i].getTitle());
			
		}
		
		//배열을 복사하는것으로 System.arraycopy(복사할배열,복사할 배열의 시작,붙여넣을 배열,붙여넣을 배열의 시작,복사할 배열의 수)
		//System.arraycopy(library, 0, copylibrary, 0, 5);//이것은 주소까지 복사가 되어 값 변경시에 다른 배열의 값도 변경된다.
		
		System.out.println("===library=========");
		for(Book book :library) {
			System.out.println(book);
			book.showInfo();
	    }
		
		System.out.println("===copylibrary======");
		for(Book book:copylibrary) {
			System.out.println(book);
			book.showInfo();
		}
	}	

}


/*다차원 배열
-이차원 이상으로 구현 된 배열
-평면 (이차원 배열) 이나 공간(삼차원 배열)을 활용한 프로그램 구현
*/

package ch22;

public class TwoDimensionTest {

	public static void main(String[] args) {
		//2차 배열
		int[][] arr= {{1,2,3},{1,2,3,4}};//new int[3][4]로 사용할 수도 있다. 이경우에는 값을 넣어주어야 한다.
		int i,j;
		
		for(i=0;i<arr.length;i++) {
			for(j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j]+",");
			}
			System.out.println("\t"+arr[i].length);
		}
	}

}
