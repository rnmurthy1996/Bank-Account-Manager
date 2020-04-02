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
	private int expiryDate;
	private String type;
	private String password;
	private double balance;
	private double interestRate;

	// Constructor
	public Account(int accountNumber, String name, int cvv, int expiryDate, String type, String password, double balance) {

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

	
		if(amount <balance) {
		this.balance = this.balance - amount;
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
	 * This method is used to verify login creditionals.
	 * 
	 * @param password
	 * @param accountNumber
	 */

	public void loginAuthentication(String password, int accountNumber) {

		if (this.password == password && this.accountNumber == accountNumber) {

			System.out.println("Account is valid");
		} else {
			System.out.println("Account is invalid");
		}
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
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
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
	 * This is the setter for the account name.
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
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
	 * This is the setter for the cvv of the account.
	 * 
	 * @param cvv
	 */
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	/**
	 * This is the getter for the account expiry date.
	 * 
	 * @return
	 */
	public int getExpiryDate() {
		return expiryDate;
	}

	/**
	 * This isi the setter for the account expiry date.
	 * 
	 * @param expiryDate
	 */
	public void setExpiryDate(int expiryDate) {
		this.expiryDate = expiryDate;
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
	 * This is the setter for the account type.
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
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
	 * This is the setter for the account password
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
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
	 * This is the setter for the account balance.
	 * 
	 * @param balance
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

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
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
}
