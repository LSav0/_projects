package homeWork3_v1;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.ArrayList;


public class Student extends Person {


	Calendar now = Calendar.getInstance();

	private int currentYear = now.get(Calendar.YEAR);

	private int id;

	private int startYear = currentYear;

	private int graduationYear;

	private List <Degree> degrees = new ArrayList<>();




	public Student(String lname, String fname) {

		super(lname, fname);

		degrees.add(new Degree());
		degrees.add(new Degree());
		degrees.add(new Degree());

		id = getRandomId(ConstantValues.MIN_STUDENT_ID, ConstantValues.MAX_STUDENT_ID);

		this.startYear = currentYear;

	}

	public int getId() {

		return this.id;

	}   

	public void setId(final int id) {


		if(id <=  ConstantValues.MAX_ID && id >= ConstantValues.MIN_ID) {
			this.id = id; 

		}
	}

	public int getStartYear() {

		Calendar now = Calendar.getInstance();
		int currentYear = now.get(Calendar.YEAR);

		if(startYear < 2000 || currentYear < startYear) {
			return currentYear;

		}else { 


			return startYear; 
		}	 
	}   

	public void setStartYear(final int startYear) {

		Calendar now = Calendar.getInstance();
		int currentYear = now.get(Calendar.YEAR);

		if(startYear > 2000 && startYear <= currentYear) { 
			this.startYear = startYear; 

		}else { 

			this.startYear = currentYear; 

		} 
	}   

	public int getGraduationYear() {


		return this.graduationYear;

	} 
	public String setGraduationYear(final int graduationYear) {

		Calendar now = Calendar.getInstance();
		int currentYear = now.get(Calendar.YEAR);


		if(degrees.get(0).getCredits() + degrees.get(1).getCredits() >= ConstantValues.MAX_CREDITS) { 	


			if(degrees.get(0).getdegreeTitle() != ConstantValues.NO_TITLE
					&& degrees.get(1).getdegreeTitle() != ConstantValues.NO_TITLE) {


				if(graduationYear >= startYear && graduationYear <= currentYear) {

					this.graduationYear = graduationYear;
				}
			}

		} if (!hasGraduated()) { 

			return "Check graduation year";

		} else if(!canGraduate()){ 

			return "Check amount of required credits";

		}else {

			return "ok";

		}
	}   
	public void setDegreeTitle(final int i, String dName) {

		if(degrees != null) {

			if (i >= 0 && i < 3 && dName != null) {

				if(degrees.get(i) != null) {

					degrees.get(i).setDegreeTitle(dName);
				}
			}	 
		}		 
	}
	public boolean addCourse(final int i, StudentCourse course) {

		if(course != null) {	

			if(i >= 0 && i < degrees.size()){

				return degrees.get(i).addStudentCourse(course);	
			}
		}		 
		return false;
	}

	public int addCourses(final int i, List<StudentCourse> courses) {

		int count = 0;


		if(courses != null) { 

			if(i >= 0 && i < degrees.size()){

				for(int k = 0; k < courses.size(); k++) { 

					StudentCourse course = courses.get(k);

					if(degrees.get(i).addStudentCourse(course)) {

						count++;
					}
				}
			}	  
		}
		return count;
	}

	public void printCourses(){



		if(degrees != null) {


			for(int i = 0; i < degrees.size(); i++) {

				degrees.get(i).printCourses();

			}

		}

	}

	public void printDegrees(){

		if(degrees == null) {

			return;

		}

		for(int i = 0; i < degrees.size(); i++) {

			System.out.print(degrees.get(i).toString());

		}

	}	  


	public void setTitleOfThesis(final int i, String title) {

		if (degrees != null) {

			if (i >= 0 && i < 3 && title != null) { 

				if(degrees.get(i) != null) {

					degrees.get(i).setTitleOfThesis(title);
				}
			}		 	 
		}
	}		 

	private boolean hasGraduated() {

		Calendar now = Calendar.getInstance();
		int currentYear = now.get(Calendar.YEAR);     

		boolean graduationyear = true;

		if(canGraduate() &&
				graduationYear > 2000 &&
				graduationYear <= currentYear) {
			graduationyear = true;

		}else {
			graduationyear = false; 
		}	 

		return graduationyear;

	}


	private boolean canGraduate() {


		boolean BachelorCredits = false;
		boolean MasterCredits = false;


		if (degrees.get(0).getCreditsByType(1) >= ConstantValues.BACHELOR_MANDATORY
				&& degrees.get(0).getCredits()  >= ConstantValues.BACHELOR_CREDITS 
				&& degrees.get(0).getTitleOfThesis() != ConstantValues.NO_TITLE){

			BachelorCredits = true;

		}

		if (degrees.get(1).getCreditsByType(1) >= ConstantValues.MASTER_MANDATORY
				&& degrees.get(1).getCredits()  >= ConstantValues.MASTER_CREDITS 
				&& degrees.get(1).getTitleOfThesis() != ConstantValues.NO_TITLE) {

			MasterCredits = true;
		}

		if(BachelorCredits == true && MasterCredits == true) {

			return true;

		}

		return false;
	} 	  


	private int getStudyYears() {

		Calendar now = Calendar.getInstance();
		int currentYear = now.get(Calendar.YEAR);


		if(degrees.get(0).getCredits() + degrees.get(1).getCredits() 
				>= ConstantValues.MAX_CREDITS && graduationYear >= startYear)	{

			return graduationYear - startYear;


		}else  {	

			return currentYear - startYear;

		}   	 
	}   

	private String printStatus() {


		double graduated = 0.0;

		graduated = (degrees.get(0).getCredits() + degrees.get(1).getCredits());


		if(graduated >= ConstantValues.MAX_CREDITS && graduationYear >= startYear){


			return "The student has graduated in " + this.graduationYear+ "";

		}

		return "The student has not graduated, yet";

	}

	private String printBachelorCreditStatus() {


		double Missingcredits = 0.0; 



		if(degrees.get(0).getCredits() >= ConstantValues.BACHELOR_CREDITS) {


			return "Total bachelor credits completed " +"(" +degrees.get(0).getCredits()+"/180.0)";


		}else {

			Missingcredits = ConstantValues.BACHELOR_CREDITS - degrees.get(0).getCredits();

			return "Missing bachelor credits " +Missingcredits  +"("+degrees.get(0).getCredits()+"/180.0)";

		}


	}	

	private String printMastersCreditStatus() {



		if(degrees.get(1).getCredits() >= ConstantValues.MASTER_CREDITS) {


			return "Total master's credits completed " + "(" +degrees.get(1).getCredits()+"/120.0)";


		}else {

			double Missingcredits = 0.0;

			Missingcredits = ConstantValues.MASTER_CREDITS - degrees.get(1).getCredits();

			return "Missing master's credits " +Missingcredits  +" ("+degrees.get(1).getCredits()+"/120.0)";

		}


	}

	private String printBachelorMandatoryStatus() {

		double MissingMandatoryCredits = 0.0;


		if(degrees.get(0).getCreditsByType(1) >= ConstantValues.BACHELOR_MANDATORY) {


			return "All mandatory bachelor credits completed " + "(" +degrees.get(0).getCreditsByType(1)+"/150.0)";


		}else {


			MissingMandatoryCredits = ConstantValues.BACHELOR_MANDATORY - degrees.get(0).getCreditsByType(1);

			return "Missing mandatory bachelor credits " +MissingMandatoryCredits + "(" +degrees.get(0).getCreditsByType(1)+"/150.0)";
		}


	}	

	private String printMastersMandatoryStatus() {


		double MissingMandatoryCredits = 0.0;

		if(degrees.get(1).getCreditsByType(1) >= ConstantValues.MASTER_MANDATORY) {


			return "All mandatory master credits completed "+"(" +degrees.get(1).getCreditsByType(1)+"/50.0)";

		}else {


			MissingMandatoryCredits = ConstantValues.MASTER_MANDATORY - degrees.get(1).getCreditsByType(1);

			return "Missing mandatory master credits " +MissingMandatoryCredits + " (" +degrees.get(1).getCreditsByType(1)+"/50.0)";
		}


	}

	private double CountGPA() {


		double TotalGPAsum = 0.0;
		double GPAcount = 0;
		double TotalGpa = 0.0;



		TotalGPAsum = (degrees.get(0).getGPA(2).get(0) + degrees.get(1).getGPA(2).get(0));

		GPAcount = (degrees.get(0).getGPA(2).get(1) + degrees.get(1).getGPA(2).get(1));

		if(GPAcount > 0) {

			TotalGpa = (TotalGPAsum / GPAcount);
		} 

		return TotalGpa;


	}


	@Override
	public String getIdString() {

		return "Student id: " +id;  

	} 


	@Override
	public String toString() {



		StringBuilder stringBuilder = new StringBuilder();

		String row = "\n" + getIdString() + "\n";
		String row1 = "     " + "First name: " + getFirstName() + ", " + "Last name: " + getLastName() + "\n";
		String row2 = "     " + "Date of birth: " + getBirthDate() + "\n";
		String row3 = "     " + "Status: " + printStatus() + "\n";
		String row4 = "     " + "Start year: " + getStartYear() + " (studies have lasted for " + getStudyYears() + " years)" + "\n";
		String row5 = "     " + "Total credits: " + (degrees.get(0).getCredits() + degrees.get(1).getCredits()) + " (GPA = " + String.format(Locale.US, "%.2f", CountGPA()) + ")" + "\n";
		String row6 = "     " + "Bachelor credits: " + degrees.get(0).getCredits() + "\n";
		String row7 = "          " + printBachelorCreditStatus() + "\n";
		String row8 = "          " + printBachelorMandatoryStatus() + "\n";
		String row9 = "          " + "GPA of Bachelor studies: " + String.format(Locale.US, "%.2f", degrees.get(0).getGPA(2).get(2)) + "\n";
		String row10 = "          " + "Title of BSc Thesis: " + '"' + degrees.get(0).getTitleOfThesis() + '"' + "\n";
		String row11 = "     " + "Master credits: " + degrees.get(1).getCredits() + "\n";
		String row12 = "          " + printMastersCreditStatus() + "\n";
		String row13 = "          " + printMastersMandatoryStatus() + "\n";
		String row14 = "          " + "GPA of Master studies: " + String.format(Locale.US, "%.2f", degrees.get(1).getGPA(2).get(2)) + "\n";
		String row15 = "          " + "Title of MSc Thesis: " + '"' + degrees.get(1).getTitleOfThesis() + '"' + "\n";

		stringBuilder.append(row)
		.append(row1)
		.append(row2)
		.append(row3)
		.append(row4)
		.append(row5)
		.append(row6)
		.append(row7)
		.append(row8)
		.append(row9)
		.append(row10)
		.append(row11)
		.append(row12)
		.append(row13)
		.append(row14)
		.append(row15);

		return stringBuilder.toString();

	}
}
