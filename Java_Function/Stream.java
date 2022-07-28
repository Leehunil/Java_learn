package ch06;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ArrayListStreamTest {

	public static void main(String[] args) {

		List<String> sList = new ArrayList<String>();
		sList.add("hunil");
		sList.add("gunhee");
		sList.add("chanwoo");
		
		Stream<String> stream = sList.stream();
		stream.forEach(s->System.out.println(s));
		
		sList.stream().sorted().forEach(s->System.out.print(s + "\t"));
		System.out.println();
		sList.stream().map(s->s.length()).forEach(n->System.out.print(n + "\t"));
		System.out.println();
		sList.stream().filter(s->s.length()>=6).forEach(s->System.out.print(s + "\t"));
	}

}


package ch06;

import java.util.Arrays;
import java.util.stream.IntStream;

public class IntArrayStreamTest {

	public static void main(String[] args) {

		int[] arr = {1,2,3,4,5};
		
		for(int num: arr) {
			System.out.println(num);
		}
		
		//Stream 사용
		System.out.println();
		IntStream is = Arrays.stream(arr);
		//Arrays.stream(넣을 배열):IntStream으로 반환해준다,
		is.forEach(n->System.out.println(n));
		//forEach(꺼낸 인자로 할 action)는 하나씩 꺼낸다, 이렇게 연산이 끝나면 소모가 되기 때문에 다시 is를 사용할 수 없다.
		
		int sum = Arrays.stream(arr).sum();
		System.out.println(sum);
		
	}

}
