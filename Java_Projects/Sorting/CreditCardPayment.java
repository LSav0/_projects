package algorithmsS;

public class CreditCardPayment extends Payment {

private String cardNumber;
	
	public CreditCardPayment(final double amount_par, String cardNumber_par){
		
		super(amount_par);
		cardNumber = cardNumber_par;	  	   
	}

	public void setCardNumber(String cardNumber_par){
		cardNumber = cardNumber_par;
	}

	public String getCardNumber(){
		return cardNumber;
	}

	
	public void printPaymentDetails(){

		System.out.println(toString());
	}

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString() + ", " + cardNumber);	
		return  builder.toString();
	}
}
