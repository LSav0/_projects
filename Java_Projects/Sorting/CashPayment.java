package algorithmsS;

public class CashPayment extends Payment{

	public CashPayment(final double amount_par){

		
		super(amount_par);   
	}

	
	public void printPaymentDetails(){
		

		System.out.println(toString());
	}

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());	
		return builder.toString();
	}

}
