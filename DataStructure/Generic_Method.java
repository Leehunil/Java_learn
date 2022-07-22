package ch08;

public class Point<T,V> {
//generic 클래스 메게변수를 2개로 할 수 도 있다.
	T x;
	V y;
	
	//생성자
	Point(T x,V y){
		this.x=x;
		this.y=y;
	}
	
	public T getX() {
		return x;
	}
	
	public V getY() {
		return y;
	}
}


package ch08;

public class GenericMethod {

	public static <T,V> double makeRectangle(Point<T,V> p1,Point<T,V> p2) {
	//Generic 메서드로 p1,p2가 들어가면 x값과 y값을 구해준다.
		double left = ((Number)p1.getX()).doubleValue();
		double right = ((Number)p2.getX()).doubleValue();
		double top = ((Number)p1.getY()).doubleValue();
		double bottom = ((Number)p2.getY()).doubleValue();
		
		double width = right-left;    //길이
		double height = bottom -top;  //높이
		
		return width * height;        //넓이  
	}
	
	public static void main(String[] args) {

		Point<Integer,Double> p1 =new Point<Integer,Double>(0,0.0);
		Point<Integer,Double> p2 =new Point<>(10,10.0);
		//<>안에 안써도 된다.
		
		double size = GenericMethod.makeRectangle(p1, p2);
		System.out.println(size); //100 출력
	}

}
