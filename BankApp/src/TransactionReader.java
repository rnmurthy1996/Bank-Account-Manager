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

	ArrayList<Transaction> transactionList;

	TransactionReader() {

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
				if(Integer.toString(month).contentEquals(transactionList.get(i).date.substring(0, 2)) 
						&& Integer.toString(year).contentEquals(transactionList.get(i).date.substring(4,8))) {
				p.print(transactionList.get(i).amount + " ");
				p.print(transactionList.get(i).date + " ");
				p.print(transactionList.get(i).vendor + " ");
				p.print(transactionList.get(i).product + " ");
				p.println();
				}
			}
			p.close();

		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
