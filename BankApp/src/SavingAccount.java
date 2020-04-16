
/**
 * This is the Account class.
 * 
 * @author Sridhar.Varala
 *
 */
public class SavingAccount extends CheckingAccount implements Account {
	
	static int accountcount =0;
	
	// Constructor
	public SavingAccount(int accountNumber, String name, int cvv, String expiryDate, String type, String password,
			double balance) {

	super(accountNumber,name,cvv,expiryDate,type,password,balance);
	}

	public SavingAccount(String name, String type, String password, double balance) {

		super(name,type,password,balance);	}

	/**
	 * This method is used to calculate interest.
	 */
	
	public void interest() {

		double interest = (SavingAccount.interestRate * this.balance) / 12;

		this.balance = this.balance + interest;

	}
	/*
	 * This method is used to generate account number.
	 */

	public int accountNumGenerator() {
		
		AccountReader ar = new AccountReader();
		ar.readAccountcsv();
		for(int i = 0; i < ar.accountlist.size(); i++) {
			if(ar.accountlist.get(i).getType().equals("Savings")) {
				accountcount++;
			}
		}
		int accountNum = accountcount+800001;
		return accountNum;
	}
	
	/**
	 * This is the withdraw method.
	 * 
	 * @param amount
	 */
	@Override
	public void withdraw(double amount) {

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
	
	public void moneyTransfer( Account obj, int amount) {

		
		int transferFee =2;
		if (obj.getBalance() > amount) {

			this.withdraw((amount-transferFee+5));
			obj.deposit(amount);
		}

	}
}


