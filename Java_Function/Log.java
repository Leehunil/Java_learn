package ch11;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MyLogger {

	Logger logger = Logger.getLogger("my logger");
	private static MyLogger instance = new MyLogger();
	
	public static final String errorLog = "log.txt";
	public static final String warningLog = "warning.txt";
	public static final String fineLog = "fine.txt";
	
	private FileHandler logFile = null;
	private FileHandler warningFile = null;
	private FileHandler fineFile = null;
	
	private MyLogger() {
		try {
			logFile = new FileHandler(errorLog,true);
			warningFile = new FileHandler(warningLog,true);
			fineFile = new FileHandler(fineLog,true);
		} catch(SecurityException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		logFile.setFormatter(new SimpleFormatter());
		warningFile.setFormatter(new SimpleFormatter());
		fineFile.setFormatter(new SimpleFormatter());
		
		logger.setLevel(Level.ALL);
		fineFile.setLevel(Level.FINE);
		warningFile.setLevel(Level.WARNING);
		
		logger.addHandler(logFile);
		logger.addHandler(warningFile);
		logger.addHandler(fineFile);
	}
	
	public static MyLogger getLogger() {
		return instance;
	}
	
	public void log(String msg) {
		
		logger.finest(msg);
		logger.finer(msg);
		logger.fine(msg);
		logger.config(msg);
		logger.info(msg);
		logger.warning(msg);
		logger.severe(msg);
		
	}
	
	public void fine(String msg) {
		logger.fine(msg);
	}
	
	public void warning(String msg) {
		logger.warning(msg);
	}
	
}


package ch11;

public class MyLoggerTest {

	public static void main(String[] args) {

		MyLogger logger = MyLogger.getLogger();
		logger.log("log test");
	}

}


package ch11;

public class Student {

	private String studentName;
	MyLogger myLogger = MyLogger.getLogger();
	
	public Student(String studentName) {
		
		if(studentName == null) {
			
			throw new StudentNameFormatException("name must not be null");
		}
		if(studentName.split(" ").length >3)  
			throw new StudentNameFormatException("name is too long");
		
		this.studentName=studentName;
	}
	
	public String getStudentName() {
		
		myLogger.fine("begin getStudentName()");
		
		return studentName;
	}
}



package ch11;

public class StudentNameFormatException extends IllegalArgumentException {
	
	public StudentNameFormatException(String message) {
		super(message);
	}
	
}


package ch11;

public class StudentTest {

	public static void main(String[] args) {

		MyLogger myLogger = MyLogger.getLogger();
		
		String name =null;
		try {
			Student student = new Student(name);
		} catch(StudentNameFormatException e) {
			myLogger.warning(e.getMessage());
		}
		
		try {
			Student student = new Student("Edward Hun Lee Test");
		} catch(StudentNameFormatException e) {
			myLogger.warning(e.getMessage());
		}
		
		Student student = new Student("James");
		
		String sName = student.getStudentName();
	}

}
