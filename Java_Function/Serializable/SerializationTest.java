package ch17;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Person implements Serializable{
	
	String name;
	//transient: 사용시 해당 멤버는 직렬화가 무조건 가능하다.
	String job;
	
	Person(String name,String job){
		this.name=name;
		this.job = job;
	}

	public String toString() {
		return name+" " +job;
	}
	
	
}
public class SerializationTest {

	public static void main(String[] args) {

		Person personLee = new Person("hunil","police");
		Person personKim = new Person("chanwoo","progamer");
		
		try(FileOutputStream fos = new FileOutputStream("serial.txt");
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
			oos.writeObject(personLee);
			oos.writeObject(personKim);
		}catch(IOException e) {
			System.out.println(e);
		}
		
		try(FileInputStream fis = new FileInputStream("serial.txt");
				ObjectInputStream ois = new ObjectInputStream(fis)){
			Person pLee=(Person) ois.readObject();
			Person pKim =(Person)ois.readObject();
			
			System.out.println(pLee);
			System.out.println(pKim);
		}catch(IOException e) {
			System.out.println(e);
		}catch(ClassNotFoundException e) {
			System.out.println(e);
		}
		
	}

}
