import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class is used to read existing Accounts from the given text file.
 * 
 * @author Sridhar.Varala
 *
 */
public class AccountReader {

	ArrayList<Account> accountlist;

	public AccountReader() {

		accountlist = new ArrayList<Account>();

	}

	void readAccountcsv() {
		
		try {
			File f = new File ("Accounts.txt");
			Scanner fileScanner = new Scanner(f);
			
			while(fileScanner.hasNextLine())
			{
				
				String line = fileScanner.next();
				
				String [] lineArray = line.split("<>");
				
				int accountNumber = Integer.parseInt(lineArray[0]);
				String name = lineArray[1];
				int cvv = Integer.parseInt(lineArray[2]);
				int expiryDate =Integer.parseInt(lineArray[3]);;
				String type =lineArray[4];
				String password = lineArray[5];
				double balance= Double.parseDouble(lineArray[6]);
			
				Account account = new Account( accountNumber , name , cvv , expiryDate , type , password , balance);
				
				accountlist.add(account);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
