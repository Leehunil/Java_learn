package ch14;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest2 {

	public static void main(String[] args) throws FileNotFoundException {
		
		FileOutputStream fos = new FileOutputStream("output2.txt",true);
		//뒤에 true를 붙히면 append되어서 쓴다.
		try(fos){
			byte[] bs = new byte[26];
			
			byte data =65;
			for(int i=0;i<bs.length;i++) {
				bs[i]=data++;
			}
			
			fos.write(bs,2,10);
			//2부터 10까지 쓴다.
		} catch(IOException e) {
			System.out.println(e);
		}
		System.out.println("End");
	}
}
