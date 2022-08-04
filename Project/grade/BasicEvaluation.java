package grade;

public class BasicEvaluation implements GradeEvaluation{

	@Override
	public String getGrade(int point) {

		String grade;
		
		if(point>=90) {
			grade="A";
		}
		else if(80<=point &&  point<90) {
			grade="B";
		}
		else if(70<=point && point<80) {
			grade="C";
		}
		else if(55<=point && point<70) {
			grade ="D";
		}
		else{
			grade="F";
		}
		
		return grade;
	}

}
