
/**
 * This Class is used to for account transactions.
 * 
 * @author Sridhar.Varala
 *
 */
public class Transaction {

	//Instant Variables
	private String transactionType;
	private int amount;
	private String date;
	private String place;
	private String vendor;
	private String product;
	
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
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	
	

}
