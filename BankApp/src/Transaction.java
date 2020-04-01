
/**
 * This Class is used to for account transactions.
 * 
 * @author Sridhar.Varala
 *
 */
public class Transaction {

	String transactionType;
	int amount;
	int date;
	String place;
	String Vendor;
	String product;
	
	// Constructor
	public Transaction(String transactionType, int amount, int date, String place, String vendor, String product) {

		this.transactionType = transactionType;
		this.amount = amount;
		this.date = date;
		this.place = place;
		this.Vendor = vendor;
		this.product = product;
		
	}
	

	

}
