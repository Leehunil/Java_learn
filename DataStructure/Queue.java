package ch05;

import ch03.MyLinkedList;
import ch03.MyListNode;

//큐 메서드 인터페이스를 만들어준다.
interface Queue{
	public void enQueue(String data);
	public String deQueue();
	public void printQueue();
}
//MyLinkedList를 상속한다.
public class MyLinkedQueue extends MyLinkedList implements Queue{

	//queue에는 front와 rear을 정의한다.
	MyListNode front;
	MyListNode rear;
	
	//enqueue 메서드 재정의
	@Override
	public void enQueue(String data) {
		
		MyListNode newNode;
		if(isEmpty()) {               //queue가 비어있으면
			newNode=addElement(data);
			front=newNode;            //현재 노드가 첫번째이자 마지막이다.
			rear=newNode;
		}
		else {                        //그렇지 않으면 현재 노드는 마지막이다.
			newNode=addElement(data);
			rear=newNode;
		}
	}
	
	//dequeue 메서드 재정의
	@Override
	public String deQueue() {
		
		if(isEmpty()) {      //queue가 비어있으면 null return.
			return null;
		}
		
		String data = front.getData();   //front의 데이터를 data에 넣어주고
		front=front.next;                //front를 front의 next로 바꿔준다.
		
		if(front==null) {                //queue가 비어지면
			rear=null;                   //rear도 null로 바꾼다.
		}
		return data;
	}

	@Override
	public void printQueue() {
		
		printAll();
	}

}



package ch05;

public class MyListQueueTest {

	public static void main(String[] args) {

		MyLinkedQueue listQueue = new MyLinkedQueue();
		listQueue.enQueue("A");
		listQueue.enQueue("B");
		listQueue.enQueue("C");
		
		listQueue.printAll();
		
		System.out.println(listQueue.deQueue());
	}

}
