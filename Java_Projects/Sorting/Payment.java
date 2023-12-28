package algorithmsS;


abstract class Payment implements Comparable <Payment>{

	private double amount = 0;
	private static double total = 0.0;

	public Payment(final double amount){

		this.amount = amount;
		total += this.amount;
	}

	public void setAmount(final double amount_par){

		total = total - amount; 
		this.amount = amount_par;
		total = total + this.amount;
	}

	public double getAmount(){
		return this.amount;
	}

	public void printPaymentDetails(){
		System.out.println("Maksun maara: "+ this.amount);
	}


	public static double getTotal(){
		return total;
	}

	@Override
	public String toString() {
		
		 StringBuilder builder = new StringBuilder();
		 builder.append("[" +amount+" euros]");
		 return builder.toString();
	}

	public int compareTo(Payment p) {

		return Compare(p);
	}


	private int Compare(Payment p) {


		if (amount < p.amount) {
			return -1;
		}
		else if (amount > p.amount) {
			return 1;
		}
		else {
			return 0;
		}
	}
}
