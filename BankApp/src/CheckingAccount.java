import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * 
 * CheckingAccount.java implements the Account interface and contains the variables and methods associated with a checking account.
 * @author Rohan Murthy
 * @author Sridhar Varala
 *
 */

public class CheckingAccount implements Account  {

	private int accountNumber;
	private String name;
	private int cvv;
	private String expiryDate;
	public String type;
	private String password;
	protected double balance;
	static final public double interestRate =2.5;
	static private int accountcount=0;
	static public int transactionNum=0;
	public ArrayList<String>transactions;
	
	
	
	/**
	 * 
	 * The primary constructor for a checking account.
	 * @param accountNumber the account number associated with the account
	 * @param name the username for the account
	 * @param cvv the card verification value for the account
	 * @param expiryDate the expiration date of the account
	 * @param type the account type (chekcing or savings)
	 * @param password the password for the account
	 * @param balance the balance of the account
	 *
	 */
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
	
	/**
	 * 
	 * The secondary constructor for a checking account. This is the constructor normally called in CreateAccountGui.java when a new checking account is created.
	 * @param name username for the account
	 * @param type the account type (chekcing or savings)
	 * @param password the password for the account
	 * @param balance the balance of the account
	 */
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
	 * The deposit method is called to deposit money into the account.
	 * This method also adds a deposit transaction to the transaction list.
	 * @param amount amount of money that should be deposited.
	 */
	public void deposit(double amount) {

		this.balance = this.balance + amount;
		transactionNum++;

		String transaction = "No." + transactionNum + " " + " Deposit" + " - " + "amount-" + amount
				+ "Available balance-" + balance;

		transactions.add(transaction);

	}

	/**
	 * The withdraw method is called to withdraw money from the account.
	 * This method also adds a withdrawal transaction to the transaction list.
	 * @param amount the amount of money that should be withdrawn.
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
	 * The moneyTransfer method is called to transfer money from the account to another external account.
	 * This method also adds a money transfer transaction to the transaction list.
	 * @param obj the external account that money should be transferred to.
	 * @param amount the amount of money that should be transferred.ey in dollars of type double.
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
	 * The loginAuthentication method is used to verify login credentials for the account.
	 * @param name the username that is being checked for authentication.
	 * @param password the password that is being checked for authentication.
	 * @return returns true if login credentials are good and false otherwise.
	 */
	public boolean loginAuthentication(String name, String password) {

		if (this.name.contentEquals(name) && this.password.contentEquals(password)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * The loginAuthentication method is used to verify login credentials for the account.
	 * @param name the username that is being checked for authentication
	 * @param password the password that is being checked for authentication
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

	/**
	 * The accountNumGenerator method is used to generate an account number upon creation of a new account. The account number formula is 500001+number of current checking accounts.
	 *@return accountNum the account number that has been generated.
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
	 * Getter for the account number.
	 * @return accountNumber the account number associated with the account.
	 */
	public int getAccountNumber() {
		return accountNumber;
	}

	/**
	 * Getter for the username.
	 * @return name the username for the account.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter for the card verification value.
	 * @return cvv the card verification value for the account
	 */
	public int getCvv() {
		return cvv;
	}

	/**
	 * Getter for the account expiration date.
	 * @return expiryDate the expiration date of the account
	 */
	public String getExpiryDate() {
		return expiryDate;
	}

	/**
	 * Getter for the account type.
	 * @return type the account type (checking or savings)
	 */
	public String getType() {
		return type;
	}

	/**
	 * Getter for the password.
	 * @return password the password for the account
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Getter for the account balance.
	 * @return balance the balance of the account.
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * Getter for the interest rate. Set at 2.5% for checking accounts.
	 * @return interestRate the interest rate of the account.
	 */
	public double getInterestRate() {
		return interestRate;
	}
}