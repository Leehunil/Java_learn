//for문


/*
package ch21;
public class ForEx {
	public static void main(String[] args) {
		int sum=0;
		int count=1;
		
		for(int i=0; i<10; i++,count++) {   //for(초기값을 초기화; 범위;증감) --> 처음에는 초기값과 범위를 비교한다 그리고 나서 증감을 한 후 범위와 증감을 계속 비교해 가면서 반복한다.
			sum+=count;
			
		}
		
		System.out.println(sum);
	}
}
*/



//while문


/*
package ch21;
public class WhileEx {
	public static void main(String[] args) {
		int sum = 0;
		int num = 1;
		
		while(num<=10) {
			sum+=num;
			num++;    // 따로 증감을 해줘야한다.
			
		}
		System.out.println(sum);
	}
}  */



//Do while 문



/*
package ch21;
import java.util.Scanner;
public class DoWhile {
	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		int sum=0;
		int input;
		do {
			input =scanner.nextInt();     // 먼저 실행되고 나서   do가 먼저 실행된 후에 while문에서 조건을 만족한다면 실행
			sum+=input;
			
		}
		while(input!=0);    // 여기에 걸리는지 확인해서 
		System.out.println(sum); 
			 
			
			
		
	}
}
*/



//break

/*
package ch21;
public class BreakEx {
	public static void main(String[] args) {
		int num = 1;
		int sum =0;
		for(;;num++) {   // 초기화가 이미 되어있다면 비어 놓는다 ; 범위는 for문안에 적는다면 비어놓아도 된다;
			sum+=num;
			if (sum>=100) {
				break;    // for문 탈출
				
			}
			
		}
		System.out.println(sum);
		System.out.println(num);
		
	}
}
*/


//continue

/*
package ch21;
public class ContinueEx {
	public static void main(String[] args) {
		int num;
		for(num=1; num<=100;num++) {
			if( (num%3) != 0 )
				continue;    // if문을 만족하면 현재를 중지하고 증감으로 이동한다.
			System.out.println(num);	
			
			
		}
	}
}
*/


//이중 for /while 문

/*
package ch21;
public class MultiplicationTable {
	public static void main(String[] args) {
		int dan=2;
		int count=1;
		
		for(; dan<=9;dan++) {
			
			
			for(count=1;count<=9;count++) {
				
				System.out.println(dan+"*"+count+'='+ dan*count);
				
			}
			System.out.println();
			
		}
		
		dan=2;
		count=1;
		while(dan<=9) {
			count=1;    // 초기화가 필요한 변수 꼭 생각해서 해주기
			while(count<=9) {
				System.out.println(dan+"*"+count+'='+ dan*count);
				count++;
			}
			dan++;   
			System.out.println();	
		}
	}
}
*/
