package algorithmsS;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		CashPayment cashPayment1 = new CashPayment(0.55);	    
		CashPayment cashPayment2 = new CashPayment(1050);
		CashPayment cashPayment3 = new CashPayment(500);
		CashPayment cashPayment4 = new CashPayment(400.45);
		CashPayment cashPayment5 = new CashPayment(0.75);
		CreditCardPayment creditCardPayment1 = new CreditCardPayment(305.30, "1234-1234-1234-1234");
		CreditCardPayment creditCardPayment2 = new CreditCardPayment(20.12, "1000-2000-3000-4000");
		CreditCardPayment creditCardPayment3 = new CreditCardPayment(5000, "2000-3000-4000-5000");
		CreditCardPayment creditCardPayment4 = new CreditCardPayment(757.00, "6000-7000-8000-9000");
		CreditCardPayment creditCardPayment5 = new CreditCardPayment(300.00, "4321-4321-4321-4321");


		Payment [] allPayments = new Payment [] {cashPayment1, cashPayment2, cashPayment3, 
				cashPayment4,cashPayment5,creditCardPayment1, creditCardPayment2, creditCardPayment3,
				creditCardPayment4,creditCardPayment5  
		};



		System.out.println("\n*** Before sorting arrays...");
		printPayments(allPayments);
		System.out.println();


		Algorithms.insertionSort(allPayments);;


		System.out.println("\n*** After sorting with insertion sort...");
		printPayments(allPayments);
		System.out.println();



		Algorithms.reverse(allPayments);

		System.out.println("\n*** After reversing...");
		printPayments(allPayments);
		System.out.println();


		Algorithms.quickSort(allPayments, 0, allPayments.length - 1);


		System.out.println("\n*** After sorting with quicksort...");
		printPayments(allPayments);
		System.out.println();
		
		Algorithms.heapsort(allPayments, allPayments.length);


		System.out.println("\n*** After sorting with heapsort...");
		printPayments(allPayments);
		System.out.println();

	}

	public static void printPayments(Payment [] myPayments) {


		for(int i = 0; i < myPayments.length; i++) {

			myPayments[i].printPaymentDetails();

		}

	}
	
}


