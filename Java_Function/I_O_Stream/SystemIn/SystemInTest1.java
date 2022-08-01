package ch13;

import java.io.IOException;
import java.io.InputStreamReader;

public class SystemInTest1 {

	public static void main(String[] args) {

		System.out.println("Write alphabet and push Enter");
		
		int i;
		try {
			InputStreamReader irs = new InputStreamReader(System.in);  //보조스트림
			//InputStreamReader:byte를 문자로 바꾸는 class(메게변수로 inputStream을 넣어준다.)
			
			while((i=irs.read()) != '\n') {
				//System.out.println(i);
				System.out.print((char)i);
			}	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
