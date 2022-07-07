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



