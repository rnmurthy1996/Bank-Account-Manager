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
	public void printTransactions(int month, int year) {

		try {
			File f = new File("Statement.csv");
			FileWriter fw = new FileWriter(f);
			PrintWriter p = new PrintWriter(fw, true);
			for (int i = 0; i < transactionList.size(); i++) {
				// sysoutInteger.toString(month)
				if(Integer.toString(month).contentEquals(transactionList.get(i).getDate().substring(0, 2)) 
						&& Integer.toString(year).contentEquals(transactionList.get(i).getDate().substring(4,8))) {
				p.print(transactionList.get(i).getAmount() + " ");
				p.print(transactionList.get(i).getDate() + " ");
				p.print(transactionList.get(i).getVendor() + " ");
				p.print(transactionList.get(i).getProduct() + " ");
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
