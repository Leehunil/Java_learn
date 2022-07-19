package ch03;

public class TextBlockTest {

	public static void main(String[] args) {

		String textBlocks = """
				Hello,
				hi,
				how r u
				""";
		System.out.println(textBlocks);
		System.out.println(getBlockOfHtml());
	}
	
	public static String getBlockOfHtml() {
		return """
				<html>
					
					<body>
						<span>example text</span>
					</body>
				</html>
				""";
	}

}


package ch03;

public class StringTest {

	public static void main(String[] args) {
		
		String java = new String("java");
		String android = new String("android");
		
		System.out.println(System.identityHashCode(java));
		java=java.concat(android);//원래 java와 주소값이 다르다.
		//concat string을 연결시켜준다.
		System.out.println(java);//javaandroid가 출력된다.
		System.out.println(System.identityHashCode(java));
	}

}


package ch03;

public class StringBiulderTest {

	public static void main(String[] args) {

		String java = new String("java");
		String android = new String("android");
		
		StringBuilder buffer = new StringBuilder(java);
		System.out.println(System.identityHashCode(buffer));
		buffer.append(android);
		System.out.println(System.identityHashCode(buffer));
		//주소값은 동일함을 알 수 있다.
		
		String test = buffer.toString();
		System.out.println(test);
	}

}
