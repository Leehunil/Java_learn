package ch04;

import ch01.MyArray;

public class MyArrayStack {

	MyArray arrayStack;        //배열을 가져온다.
	int top;                   
	
	//생성자
	public MyArrayStack() {
		top=0;
		arrayStack=new MyArray();
	}
	
	public MyArrayStack(int size) {
		top=0;
		arrayStack=new MyArray(size);
	}
	
	//push 메서드
	public void push(int data) {
		if(isFull()) {
			System.out.println("Stack is Full");
			return;
		}
		arrayStack.addElement(data);    
		top++;
	}
	
	//stack이 다 찼는지 확인하는 메서드
	public boolean isFull() {
		
		if(top == arrayStack.ARRAY_SIZE) {
			return true;
		}
		return false;
	}
	
	//pop메서드
	public int pop() {
		if(isEmpty()) {	
			return MyArray.ERROR_NUM;
		}
		return arrayStack.removeElement(--top);
		
	}
	
	//stack이 비어있는지 확인하는 메서드
	public boolean isEmpty() {
		if(top==0) {
			System.out.println("Stack is empty");
			return true;
		}
		return false;
	}
	
	//하나를 확인 메서드
	public int peek() {
		if(isEmpty()) {	
			return MyArray.ERROR_NUM;
		}
		return arrayStack.getElement(--top);
	}
	
	public void printAll() {
		arrayStack.printAll();
	}
}


package ch04;

public class MyArrayStackTest {

	public static void main(String[] args) {

		MyArrayStack stack= new MyArrayStack(3);
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		
		stack.printAll();
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.peek());
	}

}
