package homeWork3_v1;

import java.util.Random;


public abstract class Person {

	private String firstName = ConstantValues.NO_NAME;
	private String lastName = ConstantValues.NO_NAME;
	private String birthDate =  ConstantValues.NO_BIRTHDATE;



	public Person (String lname, String fname) {

		setFirstName(fname);
		setLastName(lname);


	}

	public String getFirstName() {


		return firstName;

	}
	public void setFirstName(String firstName) { 

		if(firstName != null) {

			this.firstName = firstName;

		}
	}
	public String getLastName() {


		return lastName;

	}

	public void setLastName(String lastName) {


		if(lastName != null) {

			this.lastName = lastName;

		}

	}

	public String getBirthDate() {


		return birthDate;

	}

	public String setBirthDate(String personId) {

		PersonID p = new PersonID();	 

		if(personId == null 
				|| p.setPersonID(personId) == ConstantValues.INVALID_BIRTHDAY) {	

			return "No change"; 
		}

		if(p.setPersonID(personId) != null) {
			this.birthDate = p.getBirthDate();

		}
		return birthDate; 

	}

	protected int getRandomId(final int min, final int max) {


		Random random = new Random();


		int range = max - min + 1;

		int randomNum = random.nextInt(range) + min;

		return randomNum;

	}

	public abstract String getIdString();


}
