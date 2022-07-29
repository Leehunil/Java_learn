package ch10;

public class PassWordException extends Exception{
	
	public PassWordException(String message) {
		super(message);
	}

}


package ch10;

public class PassWordTest {

	private String passWord;
	
	public String getPassWord() {
		return passWord;
	}
	
	public void setPassWord(String passWord) throws PassWordException{
		
		if(passWord ==null) {
			throw new PassWordException("password isn't possible null.");
		}
		
		else if(passWord.length() < 5) {
			throw new PassWordException("password isn't possible under 5");
		}
		
		else if(passWord.matches("[a-zA-z]+")) {
			throw new PassWordException("password includes number and special word");
		}
		this.passWord = passWord;
	}

	public static void main(String[] args) {

		PassWordTest test = new PassWordTest();
		String password = null;
		
		try {
			test.setPassWord(password);
			System.out.println("Not error1");
		} catch (PassWordException e) {
			System.out.println(e.getMessage());
		}
		
		password = "abc";
		try {
			test.setPassWord(password);
			System.out.println("Not error2");
		} catch (PassWordException e) {
			System.out.println(e.getMessage());
		}
		
		password = "abcde";
		try {
			test.setPassWord(password);
			System.out.println("Not error3");
		} catch (PassWordException e) {
			System.out.println(e.getMessage());
		}
		
		password = "abcde1#";
		try {
			test.setPassWord(password);
			System.out.println("Not error4");
		} catch (PassWordException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
