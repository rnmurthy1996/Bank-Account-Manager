import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * AccountReader.java is used to maintain the database of accounts created in
 * our program. Using AccountReader.java, we are able to create a list of all
 * existing accounts, update the list with any new accounts, and update any
 * existing accounts with new information.
 * 
 * @author Rohan Murthy
 * @author Sridhar Varala
 *
 */

public class AccountReader {

	public static ArrayList<Account> accountlist;

	public AccountReader() {

	}

	/**
	 * The readAccountcsv method is used to populate accountlist with the current
	 * accounts from accountdata.csv.
	 */
	public static void readAccountcsv() {

		try {
			// creating a new file object.
			File f = new File("accountdata.csv");
			Scanner fileScanner = new Scanner(f);
			accountlist = new ArrayList<Account>();

			// looping through the file.
			while (fileScanner.hasNext()) {

				String line = fileScanner.next();

				// Ignoring the empty lines
				if (line.equals(",,,,,,")) {
					fileScanner.next();
					continue;
				}

				// splitting the line to parse an account
				String[] lineArray = line.split(",");

				int accountNumber = Integer.parseInt(lineArray[0]);
				String name = lineArray[1];
				int cvv = Integer.parseInt(lineArray[2]);
				String expiryDate = (lineArray[3]);

				String type = lineArray[4];
				String password = lineArray[5];
				double balance = Double.parseDouble(lineArray[6]);

				// Checking type of an account.
				if (type.toUpperCase().contentEquals("CHECKING")) {

					CheckingAccount cAccount = new CheckingAccount(accountNumber, name, cvv, expiryDate, type, password,
							balance);

					// Adding the account found in to array list
					accountlist.add(cAccount);
				}
				// Checking type of an account
				if (type.toUpperCase().contentEquals("SAVINGS")) {

					SavingAccount sAccount = new SavingAccount(accountNumber, name, cvv, expiryDate, type, password,
							balance);
					// Adding the account found in to array list
					accountlist.add(sAccount);
				}
			}
			fileScanner.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}

	/**
	 * The createAccountcsv method is used to create a new account and add it to
	 * accountdata.csv.
	 * 
	 * @param account Account the account that is being created
	 */
	public static void createAccountcsv(Account account) {

		try {
			// Creating a new file object.
			File f = new File("accountdata.csv");
			Scanner sc = new Scanner(f);

			// Looping till the last line in the file.
			while (sc.hasNextLine()) {

				String line = sc.nextLine();

			}

			// Creating a print writer object.
			FileWriter fw = new FileWriter("accountdata.csv", true);
			PrintWriter p = new PrintWriter(fw);

			// Printing account details in the file.
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

	/**
	 * If any changes have been made to accountlist, the updateAccountDatabase
	 * method will go through the list and update accountdata.csv to reflect those
	 * changes.
	 */
	public static void updateAccountDatabase() {

		try {
			PrintWriter pr = new PrintWriter(new FileWriter("accountdata.csv"));
			for (int i = 0; i < accountlist.size(); i++) {
				// Printing the array list accounts in to the file.
				pr.println(accountlist.get(i).getAccountNumber() + "," + accountlist.get(i).getName() + ","
						+ accountlist.get(i).getCvv() + "," + accountlist.get(i).getExpiryDate() + ","
						+ accountlist.get(i).getType() + "," + accountlist.get(i).getPassword() + ","
						+ accountlist.get(i).getBalance());

			}
			pr.flush();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
