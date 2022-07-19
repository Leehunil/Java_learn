package ch04;

public class Person {
	
	private String name;
	private int age;
	
	public Person() {}
	
	public Person(String name, int age) {
		this.name=name;
		this.age=age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString() {
		return name;
	}
	
}


package ch04;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ClassTest {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {

		Class c1 = Class.forName("ch04 Person");
		
		Person person =(Person)c1.newInstance();
		
		person.setName("Lee");
		System.out.println(person);
		
		Class c2 = person.getClass();
		Person p=(Person)c2.newInstance();
		System.out.println(p);
		
		Class[] parameterTypes = {String.class};
		Constructor cons =c2.getConstructor(parameterTypes);
		
		Object[] initargs = {"kim"};
		Person kimPerson =(Person)cons.newInstance(initargs);
		System.out.println(kimPerson);
	}

}


package ch04;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class StringTest {

	public static void main(String[] args) throws ClassNotFoundException {

		Class c = Class.forName("java.lang.String");
		
		Constructor[] cons = c.getConstructors();
		for(Constructor co : cons) {
			System.out.println(co);
		}
		
		Method[] m =c.getMethods();
		for(Method mo:m) {
			System.out.println(mo);
		}
	}

}
