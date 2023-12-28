package homeWork3_v1;



public class PersonID {



	private String birthDate = ConstantValues.NO_BIRTHDATE;



	public String getBirthDate() {

		if(birthDate != null) {

			return this.birthDate;

		}else {

			return "\""+ConstantValues.NO_BIRTHDATE +"\"";
		}	 

	} 

	public String setPersonID(final String personId) {



		if (!checkPersonIDNumber(personId)) {
			return ConstantValues.INVALID_BIRTHDAY;  
		}
		else {


			String birthdate = "";
			birthdate += personId.substring(0,2);
			birthdate += ".";
			birthdate += personId.substring(2,4);
			birthdate += ".";

			switch(personId.charAt(6)){

			case '+':
				birthdate += "18";
				break;

			case '-':
				birthdate += "19";
				break;

			case 'A':
				birthdate += "20";
				break;



			}
			birthdate += personId.substring(4,6);


			if (!checkBirthdate(personId)) {

				return ConstantValues.INVALID_BIRTHDAY;  
			}

			else if (!checkValidCharacter(personId)) {

				return ConstantValues.INCORRECT_CHECKMARK;
		

			
			}else {


				this.birthDate = birthdate;

				return "ok";

			}			
		} 
	}  

	private boolean checkPersonIDNumber(final String personId) {

		boolean retVal = true;

		if(personId.length() != 11) {

			retVal = false;
		}
		else {

			switch (personId.charAt(6)) {

			case'+': 
			case'-':
			case'A':
				break;

			default:

				retVal = false;
			}
		} 
		return retVal;	 
	}

	private boolean checkLeapYear(int year) {

		boolean retVal = true;

		if (year % 4 != 0) {
			retVal = false;
		}
		else {

			if ((year % 100 == 0) 
					&& (year % 400 != 0))
				retVal = false;
		}

		return retVal;
	}


	private boolean checkValidCharacter(String personId) {

		String checkString = "0123456789ABCDEFHJKLMNPRSTUVWXY";

		String numStr = personId.substring(0,6);

		numStr += personId.substring(7,10);

		int number = Integer.parseInt(numStr);

		int res = number % 31;

		return (checkString.charAt(res) == personId.charAt(10));


	}

	private boolean checkBirthdate(final String personId) {

		boolean retVal = true;

		int day = Integer.parseInt(personId.substring(0,2));
		int month = Integer.parseInt(personId.substring(2,4));
		int year = Integer.parseInt(personId.substring(4,6));



		if (year < 0 
				|| month < 1 
				|| month > 12 
				|| day < 1 
				|| day > 31) {

			retVal = false;
		}
		else {

			switch(month){
			case 4:
			case 6:
			case 9:
			case 11:

				if (day == 31)
					retVal = false;
				break;

			case 2:

				if (day > 29)
					retVal = false;
				if (day == 29)
					retVal = checkLeapYear(year);
				break;
			}
		}
		return retVal;
	}	
}
