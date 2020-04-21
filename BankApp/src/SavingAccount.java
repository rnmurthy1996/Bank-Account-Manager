
/**
 * 
 * SavingAccount.java implements the Account interface and contains the variables and methods associated with a savings account.
 * @author Rohan Murthy
 * @author Sridhar Varala
 *
 */
public class SavingAccount extends CheckingAccount implements Account {

	static int accountcount = 0;
	
	/**
	 * 
	 * The primary constructor for a savings account.
	 * @param accountNumber the account number associated with the account
	 * @param name the username for the account
	 * @param cvv the card verification value for the account
	 * @param expiryDate the expiration date of the account
	 * @param type the account type (chekcing or savings)
	 * @param password the password for the account
	 * @param balance the balance of the account
	 *
	 */
	public SavingAccount(int accountNumber, String name, int cvv, String expiryDate, String type, String password,
			double balance) {

		super(accountNumber, name, cvv, expiryDate, type, password, balance);
	}

	/**
	 * 
	 * The secondary constructor for a savings account. This is the constructor normally called in CreateAccountGui.java when a new checking account is created.
	 * @param name username for the account
	 * @param type the account type (chekcing or savings)
	 * @param password the password for the account
	 * @param balance the balance of the account
	 */
	public SavingAccount(String name, String type, String password, double balance) {

		super(name, type, password, balance);
	}

	/**
	 * The interest method is used to calculate the interest rate for the savings account.
	 */
	public void interest() {

		double interest = (SavingAccount.interestRate*0.01 * this.balance) / 12;

		this.balance = this.balance + interest;

	}
	
	/**
	 * The accountNumGenerator method is used to generate an account number upon creation of a new account. The account number formula is 800001+number of current savings accounts.
	 *@return accountNum the account number that has been generated.
	 */
	public int accountNumGenerator() {

		AccountReader ar = new AccountReader();
		ar.readAccountcsv();
		for (int i = 0; i < ar.accountlist.size(); i++) {
			if (ar.accountlist.get(i).getType().equals("Savings")) {
				accountcount++;
			}
		}
		//Saving account is a 6 digit and starts from 800001.
		int accountNum = accountcount + 800001;
		return accountNum;
	}

	/**
	 * The withdraw method is called to withdraw money from the account and charges a $5 transaction fee for withdrawal.
	 * This method also adds a withdrawal transaction to the transaction list.
	 * @param amount the amount of money that should be withdrawn.
	 */
	@Override
	public void withdraw(double amount) {

		int withdrawFee = 5;
		if (amount < balance) {
			this.balance = this.balance - amount - withdrawFee;
		}

	}

	/**
	 * The moneyTransfer method is called to transfer money from the account to another external account and charges a $2 transfer fee.
	 * This method also adds a money transfer transaction to the transaction list.
	 * @param obj the external account that money should be transferred to.
	 * @param amount the amount of money that should be transferred.ey in dollars of type double.
	 */
	public void moneyTransfer(Account obj, int amount) {

		int transferFee = 2;
		if (obj.getBalance() > amount) {
			
			this.withdraw((amount + transferFee));
			obj.deposit(amount);
		}

	}
}
