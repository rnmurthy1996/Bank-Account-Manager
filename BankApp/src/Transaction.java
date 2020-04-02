
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
	String vendor;
	String product;
	
	// Constructor1
	public Transaction(String transactionType, int amount, int date, String place, String vendor, String product) {

		this.transactionType = transactionType;
		this.amount = amount;
		this.date = date;
		this.place = place;
		this.vendor = vendor;
		this.product = product;
		
	}
	//constructor2
	public Transaction(int amount, int date, String vendor, String product) {

		
		this.amount = amount;
		this.date = date;
		this.vendor = vendor;
		this.product = product;
		
	}
	
	

}
