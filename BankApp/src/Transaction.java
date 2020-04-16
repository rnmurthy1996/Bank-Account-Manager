import java.util.Calendar;
import java.util.Date;

/**
 * This Class is used to for account transactions.
 * 
 * @author Sridhar.Varala
 *
 */
public class Transaction {

	//Instant Variables
	public String transaction;
	
	public Account account;
	
	// Constructor1
	public Transaction(String transaction, Account account) {

		this.transaction = transaction;
		this.account =account;
		
	}
	
	
	public static String DateCaluclator() {

		Date today = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		String Date = month + "/" + dayOfMonth + "/" + (year);
		return Date;
	}

}