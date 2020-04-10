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
			File f = new File("accountdata.txt");
			Scanner fileScanner = new Scanner(f);
			accountlist = new ArrayList<Account>();
			while (fileScanner.hasNext()) {

				String line = fileScanner.next();
				
				String[] lineArray = line.split(",");
				// System.out.println(lineArray[0]);
				int accountNumber = Integer.parseInt(lineArray[0]);
				String name = lineArray[1];
				int cvv = Integer.parseInt(lineArray[2]);
				String expiryDate = (lineArray[3]);
				
				String type = lineArray[4];
				String password = lineArray[5];
				double balance = Double.parseDouble(lineArray[6]);

				Account account = new Account(accountNumber, name, cvv, expiryDate, type, password, balance);

				accountlist.add(account);
				// System.out.println(accountlist.get(0).getBalance());
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
				System.out.println(line);
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
			// p.print(account.getInterestRate()+",");
			// p.println();
			p.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public static void updateAccountDatabase() {
		
		
		try {
			PrintWriter pr = new PrintWriter(new FileWriter("accountdata.txt"));
			for ( int i =0; i<accountlist.size();i++) {
				
				System.out.println("printing");
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
		
//	try {
//			
//			File f = new File("accountdata.txt");
//			Scanner s = new Scanner(f);
//			s.useDelimiter("[,\n]");
//			PrintWriter pr = new PrintWriter(new FileWriter("accountdata.txt",true));
//			
//			while (s.hasNext()) {
//				
//				     String accountNumber =s.next();
//				     String name=s.next();
//				     String cvv=s.next();
//					 String expiryDate=s.next();
//					 String type=s.next();
//					 String password=s.next();
//					 String balance=s.next();
//				//String line = s.nextLine()=s.next();
//				//String [] array = line.split(",");
//				//if(array[0].contentEquals(Integer.toString(account.getAccountNumber())) && array[1].contentEquals(account.getName())) {
//				if(accountNumber.contentEquals(Integer.toString(account.getAccountNumber())) && name.contentEquals(account.getName())) 
//				{
//					System.out.println(name);
//					System.out.println(account.getBalance());
//					
//					
//					pr.println(account.getAccountNumber()+","+account.getName()+","+account.getCvv()+","+account.getExpiryDate()
//					+","+account.getType()+","+account.getPassword()+","+account.getBalance());
//					
//					}
//				
//				else {
//					pr.println(accountNumber+","+name+","+cvv+","+
//					expiryDate+","+type+","+password+","+balance);
//					
//					}
//				
//					
//					
//				}
//				
//			
//			pr.flush();
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
//
//}
