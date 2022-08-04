package school;

import java.util.ArrayList;

import utills.Define;

public class Subject {

	private String subjectName;
	private int subjectId;
	private int gradeType;
	
	private ArrayList<Student> studentList = new ArrayList<>();
	
	public Subject(String subjectName,int subjectId) {
		this.subjectId=subjectId;
		this.subjectName=subjectName;
		this.gradeType= Define.AB_TYPE;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public int getGradeType() {
		return gradeType;
	}

	public void setGradeType(int gradeType) {
		this.gradeType = gradeType;
	}

	public ArrayList<Student> getSudentList() {
		return studentList;
	}

	public void setSudentList(ArrayList<Student> sudentList) {
		this.studentList = sudentList;
	}
	
	public void register(Student student) {
		studentList.add(student);
	}
	
}
