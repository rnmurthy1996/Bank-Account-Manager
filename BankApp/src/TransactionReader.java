import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * TransactionReader.java is used to maintain the database of transactions
 * created in our program stored in Transactiondatabase.txt. Using
 * TransactionReader.java, we are able to create a list of all existing
 * transactions, update the list with any new transactions, and reflect those
 * changes in the database.
 * 
 * @author Rohan Murthy
 * @author Sridhar Varala
 *
 */
public class TransactionReader {

	public static ArrayList<Transaction> transactionList = new ArrayList<Transaction>();

	/**
	 * The readTransaction method is used to add a new transaction to the
	 * transaction list.
	 */
	public void readTransaction(Transaction obj) {

		transactionList.add(obj);

	}

	/**
	 * The readTransactioncsv method is used populate the transaction list with all
	 * transactions currently in Transactiondatabase.txt.
	 */
	public static void readTransactioncsv() {

		try {
			File f = new File("Transactiondatabase.txt");
			Scanner fileScanner = new Scanner(f);
			// Looping through the file.
			while (fileScanner.hasNext()) {

				String line = fileScanner.next();
				String[] lineArray = line.split(",");

				// Parsing the account information
				int accountNumber = Integer.parseInt(lineArray[0]);
				String name = lineArray[1];
				int cvv = Integer.parseInt(lineArray[2]);
				String expiryDate = (lineArray[3]);

				String type = lineArray[4];
				String password = lineArray[5];
				double balance = Double.parseDouble(lineArray[6]);

				// Checking type of account.
				if (type.toUpperCase().contentEquals("CHECKING")) {

					CheckingAccount cAccount = new CheckingAccount(accountNumber, name, cvv, expiryDate, type, password,
							balance);

					String t3 = " ";
					// Looping to parse the transactions of the account.
					while (fileScanner.hasNext()) {

						String l = fileScanner.nextLine();

						if (l.contentEquals("end")) {

							break;
						}

						if (l.contentEquals(" ")) {
							fileScanner.nextLine();
							continue;
							// t3 = l;

						} else {
							t3 = t3 + "\n" + l;
						}

					}
					// Adding account and transaction parsed to the transaction list.
					Transaction t = new Transaction(t3, cAccount);
					transactionList.add(t);

				}
				// Checking the type of account.
				if (type.toUpperCase().contentEquals("SAVING")) {

					SavingAccount sAccount = new SavingAccount(accountNumber, name, cvv, expiryDate, type, password,
							balance);
					String t1 = "";
					// Looping to parse the transactions of the account.
					while (fileScanner.hasNext() && !fileScanner.hasNext("end")) {

						String l = fileScanner.nextLine();

						if (l.contentEquals("end")) {

							break;
						}

						if (t1.contentEquals(" ")) {
							fileScanner.nextLine();
							continue;
							// t1 = l;
						} else {
							t1 = t1 + "\n" + l;
						}

					}

					// Adding account and transaction parsed to the transaction list.
					Transaction t = new Transaction(t1, sAccount);
					transactionList.add(t);
					fileScanner.nextLine();
				}
			}
			fileScanner.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}

	/**
	 * The printTransactions method is used to print a list of transactions for a
	 * specific user.
	 */
	public void printTransactions(Transaction obj) {

		try {

			// creating a new file
			File f = new File("Transactionsdatabase.txt");
			FileWriter fw = new FileWriter(f);
			PrintWriter p = new PrintWriter(fw, true);
			for (int i = 0; i < transactionList.size(); i++) {
				// printing the lines with transactions.
				p.println();
				p.print(obj.account.getAccountNumber() + ",");
				p.print(obj.account.getName() + ",");
				p.print(obj.account.getCvv() + ",");
				p.print(obj.account.getExpiryDate() + ",");
				p.print(obj.account.getType() + ",");
				p.print(obj.account.getPassword() + ",");
				p.print(obj.account.getBalance());
				p.print(transactionList.get(i).transaction + " ");
				p.println();
				p.flush();

			}
			p.close();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	/**
	 * The updateTransactionDatabase method is used to update
	 * Transactiondatabase.txt with any new transactions that have occured.
	 */
	public static void updateTransactionDatabase() {

		try {

			// Creating a print writer object with the file.
			PrintWriter pr = new PrintWriter(new FileWriter("Transactiondatabase.txt"));
			for (int i = 0; i < transactionList.size(); i++) {
				// Printing the transaction objects in the file.
				pr.println(transactionList.get(i).account.getAccountNumber() + ","
						+ transactionList.get(i).account.getName() + "," + transactionList.get(i).account.getCvv() + ","
						+ transactionList.get(i).account.getExpiryDate() + ","
						+ transactionList.get(i).account.getType() + "," + transactionList.get(i).account.getPassword()
						+ "," + transactionList.get(i).account.getBalance());
				pr.println(transactionList.get(i).transaction);
				pr.println("end");
			}
			pr.flush();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	/**
	 * Getter for the transaction list.
	 * 
	 * @return transactionlist the list of all transactions that have occured.
	 */
	public ArrayList<Transaction> getTransactionList() {
		return transactionList;
	}

	/**
	 * Setter for the transaction list.
	 * 
	 * @param transactionlist the list of all transactions that have occured.
	 */
	public void setTransactionList(ArrayList<Transaction> transactionList) {
		this.transactionList = transactionList;
	}

}