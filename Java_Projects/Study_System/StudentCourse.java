package homeWork3_v1;

import java.util.Calendar;


public class StudentCourse {



	private Course course;
	private int gradeNum;
	private int yearCompleted;


	StudentCourse(){



	}
	StudentCourse( Course course, final int
			gradeNum, final int
			yearCompleted){

		setCourse(course);
		setGrade(gradeNum);
		setYear(yearCompleted);


	}

	public Course getCourse(){

		return course;

	}
	public void setCourse(Course course){

		if(course != null){

			this.course = course;	   
		} 
	} 
	public int getGradeNum(){

		return gradeNum;

	} 
	protected void setGrade(int gradeNum){

		Calendar now = Calendar.getInstance();
		int currentYear = now.get(Calendar.YEAR);   

		if(course != null) {	

				if(checkGradeValidity(gradeNum)) {

					if(course.isNumericGrade()){
					
					if(gradeNum >= ConstantValues.MIN_GRADE 
							&& gradeNum <= ConstantValues.MAX_GRADE) {

						this.gradeNum = gradeNum;
					}
				
				}else if (gradeNum == ConstantValues.GRADE_ACCEPTED 
						|| gradeNum == ConstantValues.GRADE_FAILED 
						|| gradeNum == 'a' || gradeNum == 'f') {  


					this.gradeNum = gradeNum;	

				}
				
			}
		}
	if(yearCompleted == 0) {

			this.yearCompleted = currentYear;
		}	
	}


	private boolean checkGradeValidity(final int gradeNum){


		if(course != null){

			if(course.isNumericGrade()){

				if(gradeNum >= ConstantValues.MIN_GRADE 
						&& gradeNum <= ConstantValues.MAX_GRADE) {

					return true;

				} else {	   
					return false;
				}

			}else

				if (gradeNum == ConstantValues.GRADE_ACCEPTED 
				|| gradeNum == ConstantValues.GRADE_FAILED  
				|| gradeNum == 'a' 
				|| gradeNum == 'f') {   


					return true;
			}
		  }
		return false; 	   
	   }
	public boolean isPassed(){


	 	if(gradeNum == ConstantValues.MIN_GRADE || gradeNum == ConstantValues.GRADE_FAILED || gradeNum == 'f') {
			return false;

		}

		return true;


	}

	public int getYear(){
		
		return yearCompleted;		
	
	}
	public void setYear(final int year){

		Calendar now = Calendar.getInstance();
		int currentYear = now.get(Calendar.YEAR);


		if(year > 2000 && year <= currentYear) {
			this.yearCompleted = year;
		}

	}
	public String printGradeStatus(int gradeNum) {


		if(gradeNum == ConstantValues.MIN_GRADE) {

			return "\"Not graded\"";


		}

		if(gradeNum == ConstantValues.GRADE_FAILED || gradeNum == 'f') {

			return "F";


		}

		if(gradeNum == ConstantValues.GRADE_ACCEPTED || gradeNum == 'a') {

			return "A";


		}
		return String.valueOf(gradeNum);
	
	} 

	@Override
	public String toString() {


		 StringBuilder stringBuilder = new StringBuilder();

		    stringBuilder.append(" [")
		                 .append(course.getCourseCode())
		                 .append(String.format(" (%5.2f cr), ", course.getCredits()))
		                 .append('"')
		                 .append(course.getName())
		                 .append('"')
		                 .append(". ")
		                 .append(course.getCourseTypeString())
		                 .append(", period: ")
		                 .append(course.getPeriod())
		                 .append(".]")
		                 .append(" Year: ")
		                 .append(getYear())
		                 .append(", Grade: ")
		                 .append(printGradeStatus(gradeNum))
		                 .append(".]");

		    return stringBuilder.toString();

	}


}
