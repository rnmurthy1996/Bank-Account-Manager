import java.util.Calendar;
import java.util.Date;

/**
 * This is the Account class.
 * 
 * @author Sridhar.Varala
 *
 */
public class Account {

	private int accountNumber;
	private String name;
	private int cvv;
	private String expiryDate;
	private String type;
	private String password;
	private double balance;
	private double interestRate;

	// Constructor
	public Account(int accountNumber, String name, int cvv, String expiryDate, String type, String password,
			double balance) {

		this.accountNumber = accountNumber;
		this.name = name;
		this.cvv = cvv;
		this.expiryDate = expiryDate;
		this.type = type;
		this.password = password;
		this.balance = balance;

	}

	/**
	 * This is the deposit method.
	 * 
	 * @param amount
	 */
	public void deposit(int amount) {

		this.balance = this.balance + amount;
	}

	/**
	 * This is the withdraw method.
	 * 
	 * @param amount
	 */
	public void withdraw(int amount) {

		if (amount < balance) {
			this.balance = this.balance - amount;
		}

	}

	/**
	 * This method is used to transfer money from one account to other account
	 * 
	 * @param obj
	 */

	public void moneyTransfer(Account obj, int amount) {

		if (obj.balance < amount) {

			this.withdraw(amount);
			obj.deposit(amount);
		}

	}

	/**
	 * This method is used to calculate interest.
	 */
	public void interest() {

		double interest = (this.interestRate * this.balance) / 12;

		this.balance = this.balance + interest;

	}

	/**
	 * This method is used to verify login credentials.
	 * 
	 * @param password
	 * @param accountNumber
	 */

	public boolean  loginAuthentication(String name, String password) {

		if (this.name.contentEquals(name) && this.password.contentEquals(password)) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
	/*
	 * This method is used to compute account expire date.
	 */
	public String expiryDateCaluclator ( ) {
		
		Date today = new Date();  
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(today); 
		int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH); 
		int month = cal.get(Calendar.MONTH);  
		int year = cal.get(Calendar.YEAR); 
	    String expiryDate = dayOfMonth+"/"+month+"/"+(year+2);
	    return expiryDate;
	}
	
	
	/*
	 * This method is used to generate account number.
	 */
	
	public int accountNumGenerator() {
		
		
		
		
		return 0;
	}

	/**
	 * This is a getter for account number.
	 * 
	 * @return
	 */
	public int getAccountNumber() {
		return accountNumber;
	}

	/**
	 * This is a setter for account number.
	 * 
	 * @param accountNumber
	 */
//	public void setAccountNumber(int accountNumber) {
//		this.accountNumber = accountNumber;
//	}

	/**
	 * This is the getter for the account name.
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * This is the setter for the account name.
	 * 
	 * @param name
	 */
//	public void setName(String name) {
//		this.name = name;
//	}

	/**
	 * This is the getter for cvv of the account.
	 * 
	 * @return
	 */
	public int getCvv() {
		return cvv;
	}

	/**
	 * This is the setter for the cvv of the account.
	 * 
	 * @param cvv
	 */
//	public void setCvv(int cvv) {
//		this.cvv = cvv;
//	}

	/**
	 * This is the getter for the account expiry date.
	 * 
	 * @return
	 */
	public String  getExpiryDate() {
		return expiryDate;
	}

	/**
	 * This isi the setter for the account expiry date.
	 * 
	 * @param expiryDate
	 */
//	public void setExpiryDate(String expiryDate) {
//		this.expiryDate = expiryDate;
//	}

	/**
	 * This is the getter for the account type.
	 * 
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * This is the setter for the account type.
	 * 
	 * @param type
	 */
//	public void setType(String type) {
//		this.type = type;
//	}

	/**
	 * This is the getter for the account password
	 * 
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * This is the setter for the account password
	 * 
	 * @param password
	 */
//	public void setPassword(String password) {
//		this.password = password;
//	}

	/**
	 * This is the getter for the account balance.
	 * 
	 * @return
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * This is the setter for the account balance.
	 * 
	 * @param balance
	 */
//	public void setBalance(double balance) {
//		this.balance = balance;
//	}

	/**
	 * This is the getter for the account interest rate.
	 * 
	 * @return
	 */
	public double getInterestRate() {
		return interestRate;
	}

	/**
	 * This is the setter for the account interest rate.
	 * 
	 * @param interestRate
	 */
//	public void setInterestRate(double interestRate) {
//		this.interestRate = interestRate;
//	}
}
