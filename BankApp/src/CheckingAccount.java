import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * This is the Account class.
 * 
 * @author Sridhar.Varala
 *
 */
public class CheckingAccount implements Account  {

	private int accountNumber;
	private String name;
	private int cvv;
	private String expiryDate;
	private String type;
	private String password;
	protected double balance;
	static final public double interestRate =2.5;
	static private int accountcount=0;
	static public int transactionNum=0;
	public ArrayList<String>transactions;
	
	
	
	// Constructor
	public CheckingAccount(int accountNumber, String name, int cvv, String expiryDate, String type, String password,
			double balance) {

		this.accountNumber = accountNumber;
		this.name = name;
		this.cvv = cvv;
		this.expiryDate = expiryDate;
		this.type = type;
		this.password = password;
		this.balance = balance;
		transactions = new ArrayList<String>();
	}

	public CheckingAccount(String name, String type, String password, double balance) {

		this.accountNumber = accountNumGenerator();
		this.name = name;
		this.cvv = cvvcaluclator();
		this.expiryDate = expiryDateCaluclator();
		this.type = type;
		this.password = password;
		this.balance = balance;
		transactions = new ArrayList<String>();
	}

	/**
	 * This is the deposit method.
	 * 
	 * @param amount
	 */
	public void deposit(double amount) {

		this.balance = this.balance + amount;
		transactionNum++;
		
		String transaction = "No."+transactionNum+ " "+" Deposit" +" - " +"amount-"+amount+"Available balance-"+balance;
		
		transactions.add(transaction);
		
	}

	/**
	 * This is the withdraw method.
	 * 
	 * @param amount
	 */
	public void withdraw(double amount) {

		if (amount < balance) {
			this.balance = this.balance - amount;
			transactionNum++;
			String transaction = "No."+transactionNum+ " "+" withdraw" +"- " +"amount-"+amount+"Available balance-"+balance;
			
			transactions.add(transaction);
		}

	}

	/**
	 * This method is used to transfer money from one account to other account
	 * 
	 * @param obj
	 */

	public void moneyTransfer(Account obj, double amount) {
		
		
		
		
		
		if (obj.getBalance() > amount) {

			this.withdraw(amount);
			obj.deposit(amount);
			transactionNum++;
			String transaction = "No."+transactionNum+ " "+" moneyTransfer" +"to account-"+obj.getName()+"- " +"amount-"+amount+"Available balance-"+balance;
			
			transactions.add(transaction);
		}

	}


	/**
	 * This method is used to verify login credentials.
	 * 
	 * @param password
	 * @param accountNumber
	 */

	public boolean loginAuthentication(String name, String password) {

		if (this.name.contentEquals(name) && this.password.contentEquals(password)) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * This method is used to compute account expire date.
	 */
	public String expiryDateCaluclator() {

		Date today = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		String expiryDate = month + "/" + dayOfMonth + "/" + (year + 2);
		return expiryDate;
	}

	public int cvvcaluclator() {

		Random random = new Random();
		
		int cvv = (random.nextInt(900)+100);
		return cvv;
	}

	/*
	 * This method is used to generate account number.
	 */

	public int accountNumGenerator() {
		
		
		int accountNum = accountcount+500001;
		
		accountcount++;
		return accountNum;
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
	 * This is the getter for the account name.
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * This is the getter for cvv of the account.
	 * 
	 * @return
	 */
	public int getCvv() {
		return cvv;
	}

	/**
	 * This is the getter for the account expiry date.
	 * 
	 * @return
	 */
	public String getExpiryDate() {
		return expiryDate;
	}

	/**
	 * This is the getter for the account type.
	 * 
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * This is the getter for the account password
	 * 
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * This is the getter for the account balance.
	 * 
	 * @return
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * This is the getter for the account interest rate.
	 * 
	 * @return
	 */
	public double getInterestRate() {
		return interestRate;
	}

	
	

}