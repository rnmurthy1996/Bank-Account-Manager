import java.util.Calendar;
import java.util.Date;

/**
 * 
 * Transaction.java contains the variables and methods associated with a transaction.
 * @author Rohan Murthy
 * @author Sridhar Varala
 *
 */
public class Transaction {

	public String transaction;

	public Account account;

	/**
	 * 
	 * The constructor for a transaction.
	 * @param transaction the information associated with the transaction including transaction type, amount, date, etc.
	 * @param account the account that the transaction is for
	 *
	 */
	public Transaction(String transaction, Account account) {

		this.transaction = transaction;
		this.account = account;

	}

	/**
	 * The DateCalculator method is used to calculate date of the transaction.
	 */
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