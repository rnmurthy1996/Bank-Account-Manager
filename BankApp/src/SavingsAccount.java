
public class SavingsAccount extends Account {

	public SavingsAccount(int accountNumber, String name, int cvv, String expiryDate, String type, String password,
			double balance) {
		super(accountNumber, name, cvv, expiryDate, type, password, balance);
		// TODO Auto-generated constructor stub
	}

	public SavingsAccount(String name, String type, String password, double balance) {
		super(name, type, password, balance);
		// TODO Auto-generated constructor stub
	}
	
	
	
	/**
	 * This method is used to calculate interest.
	 */
	
	public void interest() {

		double interest = (Account.interestRate * this.balance) / 12;

		this.balance = this.balance + interest;

	}

	
	/**
	 * This is the withdraw method.
	 * 
	 * @param amount
	 */
	@Override
	public void withdraw(int amount) {

		int withdrawFee =5;
		if (amount < balance) {
			this.balance = this.balance - amount-withdrawFee;
		}

	}
	
	/**
	 * This method is used to transfer money from one account to other account
	 * 
	 * @param obj
	 */
	@Override
	public void moneyTransfer(Account obj, int amount) {

		int transferFee =2;
		if (obj.balance < amount) {

			this.withdraw((amount-transferFee+5));
			obj.deposit(amount);
		}

	}

}
