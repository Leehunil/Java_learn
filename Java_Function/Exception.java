package ch09;

public class ArrayIndexException {

	public static void main(String[] args) {

		int[] arr = {1,2,3,4,5};
		
		//index의 범위를 넘었을때 나오는 에러를 예외처리한 것이다.
		try {
			
			for(int i=0;i<=5;i++) {
				System.out.println(arr[i]);
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
			System.out.println(e.toString());
		}
	}

}


package ch09;

public class AutoCloseableObj implements AutoCloseable{

	@Override
	public void close() throws Exception {

		System.out.println("closing...");
	}

}


package ch09;

public class AutoCloseTest {

	public static void main(String[] args) {

		AutoCloseableObj obj = new AutoCloseableObj();
		 try(obj){
			 //이 수행이 끝나면 Autoclose가 불린다.
			 throw new Exception();    //강재로 exception이 불린다.
		 }catch(Exception e) {
			 System.out.println("exception");
		 }
		 
		 System.out.println("end");
	}

}


package ch09;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileExceptionHandling {

	public static void main(String[] args) {
/*
		FileInputStream fis = null;
		
		//파일을 읽어올 수 없을때의 에러를 예외처리한 것
		try {
			fis = new FileInputStream("a.txt");
			System.out.println("read");
		} catch (FileNotFoundException e) {
			System.out.println(e);
			return;
		} finally {
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
					//어디서 에러가 났는지 추적한다.
				}
			}
			System.out.println("finally");
			//return을 했음에도 finally가 출력되는것으로 보아 try를 사용하게 되면 Finally는 무조건 호출이 된는 것을 알 수 있다.
			
		}
		System.out.println("end");
*/		
		//File 여는 것과 닫는 예외처리를 한꺼번에 해준다.
		try(FileInputStream fis = new FileInputStream("a.txt")){
			System.out.println("read");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("end");
	}

}


package ch09;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ThrowsExeption {

	public Class loadClass(String fileName,String className) throws ClassNotFoundException, FileNotFoundException {
		
		//throws는 이 메서드에서 예외처리하지 않고 미루겠다는 것이다.
		FileInputStream fis = new FileInputStream(fileName);
		
		Class c = Class.forName(className);
		return c;
	}
	
	
	public static void main(String[] args) {

		ThrowsExeption test = new ThrowsExeption();
		
		try {
			test.loadClass("a.txt","abc");
		} catch (ClassNotFoundException e) {
			System.out.println(e);          //a.txt라는 파일이 없으면 예외처리된다.
		} catch (FileNotFoundException e) {
			System.out.println(e);          //abc라는 Class가 없으면 예외처리된다.
		} catch(Exception e) {
			//디폴트 exception이다.(제일 마지막에 위치해야한다.)
		}
		System.out.println("end");
		
	}

}


