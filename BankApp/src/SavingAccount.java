
/**
 * This is the Saving Account class.
 * 
 * @author Sridhar.Varala
 *
 */
public class SavingAccount extends CheckingAccount implements Account {

	static int accountcount = 0;

	// Constructor 1
	public SavingAccount(int accountNumber, String name, int cvv, String expiryDate, String type, String password,
			double balance) {

		super(accountNumber, name, cvv, expiryDate, type, password, balance);
	}
	// Constructor 2
	public SavingAccount(String name, String type, String password, double balance) {

		super(name, type, password, balance);
	}

	/**
	 * This method is used to calculate interest.
	 */

	public void interest() {

		double interest = (SavingAccount.interestRate * this.balance) / 12;

		this.balance = this.balance + interest;

	}
	/*
	 * This method is used to generate account number.
	 * @return accountNumber.
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
	 * This is the withdraw method.
	 * 
	 * @param amount - this is the amount of money of type double.
	 */
	@Override
	public void withdraw(double amount) {

		int withdrawFee = 5;
		if (amount < balance) {
			this.balance = this.balance - amount - withdrawFee;
		}

	}

	/**
	 * This method is used to transfer money from one account to other account
	 * 
	 * @param obj- this is the account object to which amount has to be transferred.
	 * @param amount - this is the amount that need to be transferred of type double.
	 */

	public void moneyTransfer(Account obj, int amount) {

		int transferFee = 2;
		if (obj.getBalance() > amount) {
			//withdraw fee is added back since only transfer fee is deducted.
			this.withdraw((amount - transferFee + 5));
			obj.deposit(amount);
		}

	}
}
