package ch03;

public class MyListNode {

	private String data;        //들어오는 데이터
	public MyListNode next;     //다음노드
	
	//디폴트 생성자
	public MyListNode() {      
		data=null;
		next=null;
	}
	
	//data를 알고있는 생성자
	public MyListNode(String data) {
		this.data=data;
		this.next=null;
	}
	
	//data와 link를 아는 생성자
	public MyListNode(String data,MyListNode link) {
		this.data=data;
		this.next=link;
	}
	
	//데이터 반환 메서드
	public String getData() {
		return data;
	}
}


package ch03;

public class MyLinkedList {

	private MyListNode head;               //head와 count가 정의됨
	int count;
	
	//생성자
	public MyLinkedList() {    
		head=null;
		count=0;
	}
	
	//값을 추가하는 메서드
	public MyListNode addElement(String data) {
		
		MyListNode newNode;                  //새로운 노드하나를 만든다
		if(head == null) {                   //아무것도 없을때
			newNode = new MyListNode(data);  //새로운 노드가 head가 된다. 
			head = newNode;
		}
		else {                               //그전에 값이 있을때
			newNode = new MyListNode(data);  
			MyListNode temp = head;          //temp는 head라고 하고   
			while(temp.next != null) {       //while문으로 head부터 끝을 찾는다.
				temp=temp.next;
			}
			temp.next=newNode;               //찾은 노드의 다음 링크를 새로운 노드로 연결해준다.
		}
		
		count++;							 				
		return newNode;
	}
	
	//원하는 위치에 값을 추가하는 메서드
	public MyListNode insertElement(int position, String data) {
		int i;						
		MyListNode tempNode = head;
		MyListNode preNode = null;
		
		MyListNode newNode = new MyListNode(data);
		
		if(position <0 || position > count) {
			return null;
		}
		
		if(position ==0) {        //추가하려는 위치가 첫번째이면
			newNode.next=head;    //새로운 노드의 링크를 원래의 head로 하고
			head=newNode;         //head는 새로운 노드로 한다.
		}
		else {					  		//그렇지 않으면 원하는 위치를 찾고 그전 노드를 정의해준다.
			for(i=0;i<position;i++) {
				preNode=tempNode;
				tempNode=tempNode.next;
			}
			
			newNode.next=preNode.next; // 새로운 노드의 링크는 그전 노드의 링크로 걸어준다.
			preNode.next=newNode;      //그전 노드의 링크는 새로운 노드이다.
			
		}
		
		count++;
		return newNode;
		
	}
	
	//원하는 위치의 값을 제거하는 메서드
	public MyListNode removeElement(int position) {
		int i;
		MyListNode tempNode = head;
		MyListNode preNode = null;
		
		if(position <0 || position > count) {
			return null;
		}
		
		if(position == 0) {    //원하는 위치가 0일 경우 head만 그다음 노드로 하면된다.
			head=tempNode.next;
		}
		else {
			for(i=0;i<position;i++) {
				preNode=tempNode;
				tempNode=tempNode.next;
			}
			
			preNode.next=tempNode.next; //그전 노드의 연결을 현재 노드의 다음 노드로 연결한다.
		}
		
		count--;
		
		return tempNode;
	}
}
