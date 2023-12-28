package homeWork3_v1;


public class Course {


	private String name = ConstantValues.NO_TITLE;
	private String courseCode = ConstantValues.NOT_AVAILABLE;
	private Character courseBase = ' ';
	private int courseType;
	private int period;
	private double credits;
	private boolean numericGrade;


	Course(){



	}
	Course(String name, final int code, Character courseBase, final int type, final int period, final
			double credits, boolean
			numericGrade){

		setName(name);
		setCourseCode(code, courseBase);
		setCourseType(type);
		setPeriod(period);
		setCredits(credits);
		setNumericGrade(numericGrade);

	}
	public Course(Course course){

		this.name = course.name;
		this.courseCode = course.courseCode;
		this.courseBase = course.courseBase;
		this.courseType = course.courseType;
		this.period = course.period;
		this.credits = course.credits;
		this.numericGrade = course.numericGrade;	


	}
	public String getName(){

		return name;	

	}
	public void setName(String name){

		if (name != null && !name.isEmpty()) { 
			this.name = name;	
		}	


	}
	public String getCourseTypeString(){



		if(courseType == ConstantValues.OPTIONAL) {
			return "Optional";

		}else if(courseType == ConstantValues.MANDATORY) {

			return "Mandatory";	
		}
		return ".";
	}		

	public int getCourseType(){

		if(courseType == ConstantValues.OPTIONAL) { 
			return 0;
		}
		else if(courseType == ConstantValues.MANDATORY) {
			return 1;
		}

		return 0; 

	}  
	public void setCourseType(final int type){

		if(type == ConstantValues.MANDATORY || type == ConstantValues.OPTIONAL) {

			this.courseType = type;
		}	

	}
	public String getCourseCode(){

		return courseCode;  

	}	   
	public void setCourseCode (final int courseCode, Character courseBase){


		if(courseCode > 0 && courseCode < 1000000){


			if(Character.toLowerCase(courseBase) == 'a'){
				courseBase = 'A';
			}


			if(Character.toLowerCase(courseBase) == 'p'){
				courseBase = 'P';
			}

			if(Character.toLowerCase(courseBase) == 's'){
				courseBase = 'S';
			}


			if(courseBase == 'A' || courseBase == 'P' || courseBase == 'S'){

				String strcourseCode = String.format("%d%c", courseCode, courseBase);

				this.courseCode = strcourseCode;
				this.courseBase = courseBase;
			}
		}


	}
	public char getCourseBase(){

		return courseBase;

	}

	public int getPeriod (){

		return this.period;

	}	    
	public void setPeriod (final int period){

		if(ConstantValues.MIN_PERIOD <= period && period <= ConstantValues.MAX_PERIOD) {
			this.period = period;
		}

	}  
	public double getCredits(){

		return credits;	   


	}		   

	private void setCredits (final double credits){

		if(credits >= ConstantValues.MIN_CREDITS && credits <= ConstantValues.MAX_COURSE_CREDITS) {
			this.credits = credits;

		}

	}		   
	public boolean isNumericGrade(){


		return numericGrade;

	}			   
	public void setNumericGrade (boolean numericGrade){



		this.numericGrade = numericGrade;

	}
	@Override
	public String toString() {


		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append(" [")
		.append(getCourseCode())
		.append(String.format(" (%5.2f cr), ", getCredits()))
		.append('"')
		.append(getName())
		.append('"')
		.append(". ")
		.append(getCourseTypeString())
		.append(", period: ")
		.append(getPeriod())
		.append(".")
		.append("] ");
		

		return stringBuilder.toString();
	}



}
