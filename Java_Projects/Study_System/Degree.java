package homeWork3_v1;

import java.util.ArrayList;
import java.util.List;


public class Degree {


	private static final int MAX_COURSES = 50;
	private int count = 0;
	private String degreeTitle = ConstantValues.NO_TITLE;
	private String titleOfThesis = ConstantValues.NO_TITLE;
	List <StudentCourse> myCourses = new ArrayList<>();


	public Degree() {

		this.degreeTitle = ConstantValues.NO_TITLE;
		this.titleOfThesis = ConstantValues.NO_TITLE;  
		count = 0;

	}

	public List <StudentCourse> getCourses(){

		return myCourses;


	}
	public void addStudentCourses(List<StudentCourse>
	courses){


		if(courses != null) {

			for(StudentCourse course: courses) {

				addStudentCourse(course);


			}	
		}		
	}
	public boolean addStudentCourse (StudentCourse course){

		if(course != null){

			if(count < MAX_COURSES) {

				myCourses.add(course);
				count++;

				return true;
			}

		}

		return false;


	}
	public String getdegreeTitle(){


		if(degreeTitle != null) {

			return degreeTitle; 

		}
		return ConstantValues.NO_TITLE;

	}
	public void setDegreeTitle(String degreeTitle){

		if(degreeTitle != null && !degreeTitle.isEmpty()) { 
			this.degreeTitle = degreeTitle;	
		}		

	}

	public String getTitleOfThesis(){


		if(titleOfThesis != null) {

			return titleOfThesis;
		}


		return ConstantValues.NO_TITLE;  	


	}
	public void setTitleOfThesis(String titleOfThesis){

		if(titleOfThesis != null && !titleOfThesis.isEmpty()) { 
			this.titleOfThesis = titleOfThesis;	
		}		

	}
	public double getCreditsByBase (Character base){

		double sum = 0.0;


		for(int i = 0; i < myCourses.size(); i++) { 


			if(base != null && isCourseCompleted(myCourses.get(i))) { 

				if(myCourses.get(i).getCourse().getCourseBase() == base) {  

					sum += myCourses.get(i).getCourse().getCredits(); 

				}

			}
		}
		return sum; 
	}

	public double getCreditsByType(final int courseType){


		double sum = 0.0;


		for(int i = 0; i < myCourses.size(); i++) {


			if(isCourseCompleted(myCourses.get(i))) {

				if(myCourses.get(i).getCourse().getCourseType() == courseType){

					sum += myCourses.get(i).getCourse().getCredits();
				}
			}
		}
		return sum;
	}  	

	public double getCredits(){


		double sum = 0.0;	


		for(int i = 0; i < myCourses.size(); i++) {


			if(myCourses.get(i) != null) {

				if(isCourseCompleted(myCourses.get(i))) {

					sum += myCourses.get(i).getCourse().getCredits();	
				}		
			}

		}
		return sum;
	}

	private boolean isCourseCompleted (StudentCourse c){


		if(c.isPassed() && c != null) {

			return true;

		}

		return false;

	}
	public void printCourses(){


		for (int i = 0; i < myCourses.size(); i++) {

			StudentCourse course = myCourses.get(i);

			if (course != null) {


				System.out.println(course);

			}
		}	  	    
	}  

	public List <Double> getGPA (int type){


		double sumOptional = 0.0; 
		double sumAll = 0.0;
		double sumMandatory = 0.0; 


		double count1 = 0;
		double count2 = 0;
		double count3 = 0;


		double GpaOptional = 0.0;
		double GpaMandatory = 0.0;
		double GpaAll = 0.0;



		for (int i = 0; i < myCourses.size(); i++) { 

			if(myCourses.get(i) != null) { 

				if(myCourses.get(i).getCourse().isNumericGrade()){

					if(type == ConstantValues.OPTIONAL && myCourses.get(i).getCourse().getCourseType() 
							== ConstantValues.OPTIONAL) {

						sumOptional += myCourses.get(i).getGradeNum();  
						count1++;  

					}else if(type == ConstantValues.MANDATORY && myCourses.get(i).getCourse().getCourseType()
							== ConstantValues.MANDATORY) {

						sumMandatory += myCourses.get(i).getGradeNum(); 
						count2++;

					}else if(type == ConstantValues.ALL) {

						sumAll += myCourses.get(i).getGradeNum();
						count3++;
					}
				} 
			}	  	
		}


		if(count1 > 0) {
			GpaOptional =  sumOptional / count1;
		}

		if(count2 > 0) {
			GpaMandatory =  sumMandatory / count2;
		}
		if(count3 > 0) {
			GpaAll =  sumAll / count3;
		}

		List <Double> GPA = new ArrayList<>();	


		if(type == ConstantValues.OPTIONAL) {


			GPA.add(sumOptional);
			GPA.add(count1);
			GPA.add(GpaOptional);

		}else if(type == ConstantValues.MANDATORY) {

			GPA.add(sumMandatory);
			GPA.add(count2);
			GPA.add(GpaMandatory);

		}else {

			GPA.add(sumAll);
			GPA.add(count3);
			GPA.add(GpaAll);

		}


		return GPA;

	}

	private String printLineCount() {

		String mjono = "";

		for (int i = 0; i < myCourses.size(); i++) {
			if (myCourses.get(i) != null) {

				mjono = mjono +  (i+1)+ ". " + myCourses.get(i).toString()+"\n";
			}	
		}
		return mjono;
	}    

	@Override
	public String toString() {


		StringBuilder stringBuilder = new StringBuilder();

	    String line1 = "\n" + "Degree [Title: " + '"' + getdegreeTitle() + '"' + " (courses: " + myCourses.size() + ")" + "\n";
	    String line2 = "Thesis title: " + '"' + getTitleOfThesis() + '"' + "\n";
	    String line3 = "" + printLineCount();

	    stringBuilder.append(line1)
	                 .append(line2)
	                 .append(line3);

	    return stringBuilder.toString();

	}

}
