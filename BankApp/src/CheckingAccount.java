import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * This is the Checking Account class.
 * 
 * @author Sridhar.Varala
 *
 */
public class CheckingAccount implements Account {

	private int accountNumber;
	private String name;
	private int cvv;
	private String expiryDate;
	public String type;
	private String password;
	protected double balance;
	static final public double interestRate = 2.5;
	static private int accountcount = 0;
	static public int transactionNum = 0;
	public ArrayList<String> transactions;

	// Constructor 1
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

	// Constructor 2
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
	 * @param amount - this is the the amount of money in dollars of type double.
	 */
	public void deposit(double amount) {

		this.balance = this.balance + amount;
		transactionNum++;

		String transaction = "No." + transactionNum + " " + " Deposit" + " - " + "amount-" + amount
				+ "Available balance-" + balance;

		transactions.add(transaction);

	}

	/**
	 * This is the withdraw method.
	 * 
	 * @param amount -this is the the amount of money in dollars of type double.
	 */
	public void withdraw(double amount) {

		if (amount < balance) {
			this.balance = this.balance - amount;
			transactionNum++;
			String transaction = "No." + transactionNum + " " + " withdraw" + "- " + "amount-" + amount
					+ "Available balance-" + balance;

			transactions.add(transaction);
		}

	}

	/**
	 * This method is used to transfer money from one account to other account
	 * 
	 * @param obj - this is the account object to which money has to be transferred.
	 * @param amount -this is the the amount of money in dollars of type double.
	 */

	public void moneyTransfer(Account obj, double amount) {

		if (obj.getBalance() > amount) {

			this.withdraw(amount);
			obj.deposit(amount);
			transactionNum++;
			String transaction = "No." + transactionNum + " " + " moneyTransfer" + "to account-" + obj.getName() + "- "
					+ "amount-" + amount + "Available balance-" + balance;

			transactions.add(transaction);
		}

	}

	/**
	 * This method is used to verify login credentials.
	 * @param name - this is the name of the account holder.
	 * @param password - this is the password of the account.
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

	/**
	 *  This method is used to calculate cvv of the account.
	 *  @return cvv.
	 */
	public int cvvcaluclator() {

		Random random = new Random();
		//Cvv is made of 3 digit number form 0 to 1000 range.
		int cvv = (random.nextInt(900) + 100);
		return cvv;
	}

	/*
	 * This method is used to generate account number.
	 * @return account number.
	 */

	public int accountNumGenerator() {

		AccountReader ar = new AccountReader();
		ar.readAccountcsv();
		for (int i = 0; i < ar.accountlist.size(); i++) {
			if (ar.accountlist.get(i).getType().equals("Checking")) {
				accountcount++;
			}
		}
		//Checking account number is a 6 digit and starts from 500001.
		int accountNum = accountcount + 500001;

		return accountNum;
	}

	/**
	 * This is a getter for account number.
	 * 
	 * @return accountNumber
	 */
	public int getAccountNumber() {
		return accountNumber;
	}

	/**
	 * This is the getter for the account name.
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * This is the getter for cvv of the account.
	 * 
	 * @return cvv
	 */
	public int getCvv() {
		return cvv;
	}

	/**
	 * This is the getter for the account expiry date.
	 * 
	 * @return expiryDate
	 */
	public String getExpiryDate() {
		return expiryDate;
	}

	/**
	 * This is the getter for the account type.
	 * 
	 * @return type
	 */
	public String getType() {
		return type;
	}

	/**
	 * This is the getter for the account password
	 * 
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * This is the getter for the account balance.
	 * 
	 * @return balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * This is the getter for the account interest rate.
	 * 
	 * @return interestRate
	 */
	public double getInterestRate() {
		return interestRate;
	}

}