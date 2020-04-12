
public interface Account {
	
	public void deposit(double amount);
	public void withdraw(double amount);
	public void moneyTransfer(Account obj, int amount);
	public boolean loginAuthentication(String name, String password);
	public String expiryDateCaluclator();
	public int cvvcaluclator();
	public int accountNumGenerator();
	public int getAccountNumber();
	public String getName();
	public int getCvv();
	public String getExpiryDate();
	public String getType();
	public String getPassword();
	public double getBalance();
}
