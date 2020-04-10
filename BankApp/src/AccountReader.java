import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class is used to read existing Accounts from the given text file.
 * 
 * @author Sridhar.Varala
 *
 */
public  class AccountReader {

	// instance variables
	public static ArrayList<Account> accountlist;

	// constructor
	public   AccountReader() {

		//accountlist = new ArrayList<Account>();

	}

	/**
	 * This method is used to read available accounts in the database.
	 */
	public  static void readAccountcsv() {

		try {
			File f = new File("accountdata.csv");
			Scanner fileScanner = new Scanner(f);
			accountlist = new ArrayList<Account>();
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

				Account account = new Account(accountNumber, name, cvv, expiryDate, type, password, balance);

				accountlist.add(account);
				
			}
			fileScanner.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}
	
	/*
	 * This method is used to create a account and pass it to add in the database.
	 */

	public static void createAccountcsv(Account account) {

		try {
			
			File f = new File("accountdata.csv");
			Scanner sc = new Scanner(f);
			while (sc.hasNextLine()) {

				String line = sc.nextLine();
				
			}

			FileWriter fw = new FileWriter("accountdata.csv", true);
			PrintWriter p = new PrintWriter(fw);

			p.println();
			p.print(account.getAccountNumber() + ",");
			p.print(account.getName() + ",");
			p.print(account.getCvv() + ",");
			p.print(account.getExpiryDate() + ",");
			p.print(account.getType() + ",");
			p.print(account.getPassword() + ",");
			p.print(account.getBalance());
			p.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public static void updateAccountDatabase() {
		
		
		try {
			PrintWriter pr = new PrintWriter(new FileWriter("accountdata.csv"));
			for ( int i =0; i<accountlist.size();i++) {
				
				pr.println(accountlist.get(i).getAccountNumber()+","+accountlist.get(i).getName()+","+accountlist.get(i).getCvv()+","+accountlist.get(i).getExpiryDate()
				+","+accountlist.get(i).getType()+","+accountlist.get(i).getPassword()+","+accountlist.get(i).getBalance());
				
			}
			pr.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	
}
		

