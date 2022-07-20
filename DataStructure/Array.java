package ch01;

public class MyArray {

	int[] intArr; //int array
	int count;    //개수
	
	public int ARRAY_SIZE;                           //배열 사이즈
	public static final int ERROR_NUM = -999999999;  //에러 넘버
	
	//디폴트 생성자
	public MyArray() {     
		count=0;                       //count를 0으로 둔다.
		ARRAY_SIZE=10;                 //사이즈는 10
		intArr = new int[ARRAY_SIZE];  //새로운 배열을 만든다.
	}
	
	//생성자
	public MyArray(int size) {
		count=0;                       
		ARRAY_SIZE=size;               //사이즈는 size로 한다.
		intArr=new int[size];          
	}
	
	//배열에 값을 넣는 메서드
	public void addElement(int num) {
		if(count >= ARRAY_SIZE) {                     //count가 배열사이즈보다 크거나 같을 경우
			System.out.println("not enough memory");  //오류 메세지와 함께 return
			return;
		}
		intArr[count++]=num;                          //현재 count의 배열에 들어온 값을 넣어준다.
	}
	
	//넣고 싶은 자리에 값을 넣는 메서드
	public void insertElement(int position, int num) {
		int i;                                //i값을 생성
		if(position <0 || position >count) {  //위치가 0보다 작거나 count보다 크면 제외
			return;
		}
		if(count >= ARRAY_SIZE) {             //또한 count가 배열사이즈보다 크거나 같으면 제외
			return;
		}
		for(i=count-1;i>=position;i--) {      //시작은 count-1이고 i가 원하는 위치보다 작아지면 멈춘다.
			intArr[i+1]=intArr[i];            //앞에 노드에 그전 노드의 값을 넣어준다.
		}
		intArr[position]=num;
		count++;
	}
	
	//원하는 위치에 값을 제거하는 메서드
	public int removeElement(int position) {
		int ret = ERROR_NUM;                      //에러값을 넣어주고
		if(isEmpty()) {                           //배열이 있는지 확인
			System.out.println("Array is empty");
			return ret;
		}
		if(position<0 || position >count-1) {     
			return ret;
		}
		
		ret = intArr[position];                   //position의 값을 정의해주고
		
		for(int i=position;i<count-1;i++) {       //position부터 count-1까지 
			intArr[i]=intArr[i+1];                //insert와 반대로 해준다.
		}
		count--;                                   
		
		return ret;								  //마지막 ret 반환
	}
	
	public boolean isEmpty() {
		if(count ==0) {
			return true;
		}
		return false;
	}
}
