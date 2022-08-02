package ch17;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;


class Persona implements Externalizable{
	
	String name;
	//transient: 사용시 해당 멤버는 직렬화가 무조건 가능하다.
	String job;
	
	Persona(String name,String job){
		this.name=name;
		this.job = job;
	}

	public String toString() {
		return name+" " +job;
	}

	@Override
	public void writeExternal(ObjectOutput obj) throws IOException {

		obj.writeUTF(name);
		obj.writeUTF(job);
	}

	@Override
	public void readExternal(ObjectInput obj) throws IOException, ClassNotFoundException {

		name=obj.readUTF();
		job=obj.readUTF();
	}
	
	
}
public class ExternalizationTest {

	public static void main(String[] args) {

		Persona personLee = new Persona("hunil","police");
		Persona personKim = new Persona("chanwoo","progamer");
		
		try(FileOutputStream fos = new FileOutputStream("serial.txt");
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
			oos.writeObject(personLee);
			oos.writeObject(personKim);
		}catch(IOException e) {
			System.out.println(e);
		}
		
		try(FileInputStream fis = new FileInputStream("serial.txt");
				ObjectInputStream ois = new ObjectInputStream(fis)){
			Persona pLee=(Persona) ois.readObject();
			Persona pKim =(Persona)ois.readObject();
			
			System.out.println(pLee);
			System.out.println(pKim);
		}catch(IOException e) {
			System.out.println(e);
		}catch(ClassNotFoundException e) {
			System.out.println(e);
		}
		
	}

}
