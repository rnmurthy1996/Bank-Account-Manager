import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * This Class is used to store Transactions and provides methods to read and
 * print transactions.
 * 
 * @author sridharvarala
 *
 */
public class TransactionReader {

	//Instant Variables
	private ArrayList<Transaction> transactionList;
	
	//constructor
	public TransactionReader() {

		transactionList = new ArrayList<Transaction>();

	}

	/*
	 * Method to read account transactions
	 */
	public void readTransaction(Transaction obj) {

		transactionList.add(obj);

	}

	/*
	 * Method to print monthly account transactions
	 */
	public void printTransactions(Account account, String transaction) {

		try {
			File f = new File("Statement.csv");
			FileWriter fw = new FileWriter(f);
			PrintWriter p = new PrintWriter(fw, true);
			for (int i = 0; i < transactionList.size(); i++) {
				
				if(transactionList.get(i).account.equals(account)) {
						 
				p.print(transactionList.get(i).transaction + " ");
				p.println();
				p.flush();
				}
			}
			p.close();

		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}
	
	//getter	
	public ArrayList<Transaction> getTransactionList() {
		return transactionList;
	}
	//Setter
	public void setTransactionList(ArrayList<Transaction> transactionList) {
		this.transactionList = transactionList;
	}

}
