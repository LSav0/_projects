package homeWork3_v1;

import java.util.Calendar;
import java.util.Locale;

public class Employee extends Person implements Payment {

	private String empId;
	private int startYear;
	private double salary;



	public Employee(String lname, String fname) {


		super(lname, fname);


		Calendar now = Calendar.getInstance();
		int currentYear = now.get(Calendar.YEAR); 

		this.startYear = currentYear;
		this.empId = getEmployeeIdString() +getRandomId(ConstantValues.MIN_EMP_ID, ConstantValues.MAX_EMP_ID);

	}

	public String getIdString(){

		return empId;

	}

	public int getStartYear(){

		Calendar now = Calendar.getInstance();
		int currentYear = now.get(Calendar.YEAR);

		if(startYear < 2000 || currentYear < startYear) {

			return currentYear; 

		}else { 

			return startYear; 
		}		 


	}
	public void setStartYear(final int startYear){

		Calendar now = Calendar.getInstance();
		int currentYear = now.get(Calendar.YEAR);

		if(startYear > 2000 && startYear <= currentYear) { 
			this.startYear = startYear; 

		}else { 
			this.startYear = currentYear; 
		} 
	} 

	public double getSalary(){

		return salary; 

	}
	public void setSalary(final double salary){

		if(salary > 0.0) {

			this.salary = salary;

		}
	}
	public double calculatePayment(){


		return salary * 1.5;	 

	}

	public String getEmployeeIdString(){

		return "OY_"; 

	}

	@Override
	public String toString() {


		StringBuilder stringBuilder = new StringBuilder();

	    stringBuilder.append(" Employee id: ").append(empId).append(" \n");
	    stringBuilder.append("     ").append("First name: ").append(getFirstName()).append(", Last name: ")
	    .append(getLastName()).append(" \n");
	    stringBuilder.append("     ").append("Birthdate: ").append(getBirthDate()).append(" \n");
	    stringBuilder.append("     ").append("Start year: ")
	    .append(getStartYear()).append(" \n");
	    stringBuilder.append("     ").append("Salary: ").append(String.format(Locale.US, "%.2f", calculatePayment())).append(" \n");

	    return stringBuilder.toString();
	}

}
