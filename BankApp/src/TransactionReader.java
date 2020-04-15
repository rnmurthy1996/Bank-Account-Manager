import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This Class is used to store Transactions and provides methods to read and
 * print transactions.
 * 
 * @author sridharvarala
 *
 */
public class TransactionReader {

	//Instant Variables
	public static ArrayList<Transaction> transactionList;
	
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
	public static void readTransactioncsv() {

		try {
			File f = new File("Transactiondatabase.csv");
			Scanner fileScanner = new Scanner(f);
			transactionList = new ArrayList<Transaction>();
			while (fileScanner.hasNext()) {

				String line = fileScanner.next();
				
				String[] lineArray = line.split(",");
				
				int accountNumber = Integer.parseInt(lineArray[0]);
				String name = lineArray[1];
				int cvv = Integer.parseInt(lineArray[2]);
				String expiryDate = (lineArray[3]);
				
				String type = lineArray[4];
				String password = lineArray[5];
				double balance = Double.parseDouble(lineArray[6]);
				
				if(type.toUpperCase().contentEquals("CHECKING")) {
				
				CheckingAccount cAccount = new CheckingAccount(accountNumber, name, cvv, expiryDate, type, password, balance);
				String t1 ="";
				Transaction t = new Transaction (t1,cAccount);
				transactionList.add(t);
				}
				
				if(type.toUpperCase().contentEquals("SAVING")) {
					
					SavingAccount sAccount = new SavingAccount(accountNumber, name, cvv, expiryDate, type, password, balance);
					String t1 ="";
					Transaction t = new Transaction (t1,sAccount);
					transactionList.add(t);
					
				}
			}
			fileScanner.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}
	/*
	 * Method to print monthly account transactions
	 */
	public void printTransactions(Transaction obj) {

		try {
			File f = new File("Transactionsdatabase.csv");
			FileWriter fw = new FileWriter(f);
			PrintWriter p = new PrintWriter(fw, true);
			for (int i = 0; i < transactionList.size(); i++) {
				
				
					
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
	
public static void updateTransactionDatabase() {
		
		
		try {
			PrintWriter pr = new PrintWriter(new FileWriter("Transactiondatabase.csv"));
			for ( int i =0; i<transactionList.size();i++) {
				
				pr.println(transactionList.get(i).account.getAccountNumber()+","+transactionList.get(i).account.getName()+","
				+transactionList.get(i).account.getCvv()+","+transactionList.get(i).account.getExpiryDate()
				+","+transactionList.get(i).account.getType()+","+transactionList.get(i).account.getPassword()
				+","+transactionList.get(i).account.getBalance());
				pr.println(transactionList.get(i).transaction);
			}
			pr.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
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