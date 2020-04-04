
/**
 * This Class is used to for account transactions.
 * 
 * @author Sridhar.Varala
 *
 */
public class Transaction {

	//Instant Variables
	String transactionType;
	int amount;
	String date;
	String place;
	String vendor;
	String product;
	
	// Constructor1
	public Transaction(String transactionType, int amount, String date, String place, String vendor, String product) {

		this.transactionType = transactionType;
		this.amount = amount;
		this.date = date;
		this.place = place;
		this.vendor = vendor;
		this.product = product;
		
	}
	//constructor2
	public Transaction(int amount, String date, String vendor, String product) {

		
		this.amount = amount;
		this.date = date;
		this.vendor = vendor;
		this.product = product;
		
	}
	
	

}
