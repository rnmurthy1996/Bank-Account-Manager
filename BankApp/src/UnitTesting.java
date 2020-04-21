import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class UnitTesting {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	/**
	 * Test case for checking the methods in CheckingAccount class
	 */
	void test1() {

		CheckingAccount one = new CheckingAccount(123, "sri", 456, "2013", "checking", "password", 5000.0);

		one.deposit(500);
		one.withdraw(20);

		assertEquals(one.getBalance(), 5480);

	}

	@Test
	/**
	 * Test for updateAccountDatabase method in AccountReader class.
	 */
	void test2() {
		
		CheckingAccount ca = new CheckingAccount("Test15", "Checking", "Password", 1000);
		AccountReader ar = new AccountReader();
		ar.createAccountcsv(ca);
		ar.readAccountcsv();
		ar.accountlist.get(ar.accountlist.size()-1).deposit(500);
		ar.updateAccountDatabase();
		
		AccountReader ar2 = new AccountReader();
		ar2.readAccountcsv();
		double balance = 0;
		for(int i = 0; i < ar2.accountlist.size()-1; i++) {
			if(ar2.accountlist.get(i).getName().equals("Test15")) {
				balance = ar2.accountlist.get(i).getBalance();
			}
		}
		assertEquals(balance, 1500);
	}

	@Test
	/**
	 * Test case for checking the methods in the AccountReader class.
	 */
	void test3() {
		
		
		
		AccountReader ar = new AccountReader();
		CheckingAccount account = new CheckingAccount("varala" ,"Checking" , "passcode",5000);
		
		ar.createAccountcsv(account);
		
		ar.readAccountcsv();
		
		for ( int i =0 ; i<ar.accountlist.size();i++) {
		
			if(ar.accountlist.get(i).getName().equals("varala")){
				assertEquals(account.getBalance() , 5000 );
			}
		}
	}

	@Test
	/**
	 * Test for userNameCheck method in DepositGui class.
	 */
	void test4() {

		String un1 = "Valid";
		String un2 = "Not Valid";

		SavingAccount s = new SavingAccount("UnitTesting", "Savings", "Password", 1000);
		DepositGui dg = new DepositGui(s);
		assertEquals(dg.userNameCheck(un1), true);
		assertEquals(dg.userNameCheck(un2), false);
	}

	@Test
	/**
	 * Test case for checking the methods in TransactionReader class.
	 */
	void test5() {
		CheckingAccount account = new CheckingAccount("varala" ,"Checking" , "passcode",5000);
		Transaction t = new Transaction("deposit",account);
		TransactionReader.transactionList.add(t);
		for ( int i =0 ; i<TransactionReader.transactionList.size();i++) {
			
			if(TransactionReader.transactionList.get(i).account.getName().equals("varala")){
				assertEquals(TransactionReader.transactionList.get(i).transaction ,"deposit" );
			}
		}
	}
		
	/*
	 * Test for depositCheck method in DepositGui class.
	 */
	void test6() {

		String dep1 = "10000";
		String dep2 = "1jd93nd";

		SavingAccount s = new SavingAccount("UnitTesting", "Savings", "Password", 1000);
		DepositGui dg = new DepositGui(s);
		assertEquals(dg.depositCheck(dep1), true);
		assertEquals(dg.depositCheck(dep2), false);
	}

	@Test
	/**
	 * Test case for checking the Money transfer functions in Checking and 	Saving accounts.
	 */
	void test7() {

		CheckingAccount cOne = new CheckingAccount("sri1", "checking", "password", 5000.0);
		CheckingAccount cTwo = new CheckingAccount("sri2", "checking", "password", 6000.0);
		SavingAccount sOne = new SavingAccount("arvind1",  "checking", "password", 5000.0);
		SavingAccount sTwo = new SavingAccount("arvind2",  "checking", "password", 6000.0);
		
		
		cOne.moneyTransfer(cTwo, 100);
		assertEquals(cTwo.getBalance(), 6100);
		assertEquals(cOne.getBalance(), 4900);
		
		cOne.moneyTransfer(sOne, 100);
		assertEquals(sOne.getBalance(), 5100);
		assertEquals(cOne.getBalance(), 4800);
		
		sOne.moneyTransfer(sTwo, 100);
		assertEquals(sTwo.getBalance(), 6100);
		assertEquals(sOne.getBalance(), 5100-100-2);
		
		sOne.moneyTransfer(cOne, 100);
		assertEquals(cOne.getBalance(), 4900);
		assertEquals(sOne.getBalance(), 4896);
		
	}
	/*
	 * Test for depositPosCheck method in DepositGui class.
	 */
	void test8() {

		String dep1 = "10000";
		String dep2 = "-10000";

		SavingAccount s = new SavingAccount("UnitTesting", "Savings", "Password", 1000);
		DepositGui dg = new DepositGui(s);
		assertEquals(dg.depositPosCheck(dep1), true);
		assertEquals(dg.depositPosCheck(dep2), false);

	}

	@Test
	/**
	 * Test for moneyTransfer method in SavingAccount class.
	 */
	void test9() {


		
		SavingAccount from = new SavingAccount("From", "Savings", "Password", 1000);
		SavingAccount to = new SavingAccount("To", "Savings", "Password", 1000);
		from.moneyTransfer(to, 500);
		assertEquals(from.getBalance(), 493);
		assertEquals(to.getBalance(), 1500);

	}

	@Test
	/**
	 * Test for moneyTransfer method in CheckingAccount class.
	 */
	void test10() {

		CheckingAccount from = new CheckingAccount("From", "Checking", "Password", 1000);
		CheckingAccount to = new CheckingAccount("To", "Checking", "Password", 1000);
		from.moneyTransfer(to, 500);
		assertEquals(from.getBalance(), 500);
		assertEquals(to.getBalance(), 1500);
	}

	@Test
	/**
	 * Test for interest method in SavingAccount class.
	 */
	void test11() {
		
		SavingAccount sa = new SavingAccount("UnitTesting", "Savings", "Password", 1000);
		sa.interest();
		assertEquals(sa.getBalance(), 1002.0833333333334);
	}

	@Test
	/**
	 * Test for deposit method in CheckingAccount class.
	 */
	void test12() {

		CheckingAccount ca = new CheckingAccount("UnitTesting", "Checking", "Password", 1000);
		ca.deposit(500);
		assertEquals(ca.getBalance(), 1500);
	}

	@Test
	/**
	 * Test for withdraw method in CheckingAccount class.
	 */
	void test13() {

		CheckingAccount ca = new CheckingAccount("UnitTesting", "Checking", "Password", 1000);
		ca.withdraw(500);
		assertEquals(ca.getBalance(), 500);
	}

	@Test
	/**
	 * Test for loginAuthentication method in CheckingAccount class.
	 */
	void test14() {

		CheckingAccount ca = new CheckingAccount("UnitTesting", "Checking", "Password", 1000);
		assertEquals(ca.loginAuthentication("UnitTesting", "Password"), true);
	}

	@Test
	/**
	 * Test for readAccountcsv method in AccountReader class.
	 */
	void test15() {

		AccountReader ar = new AccountReader();
		ar.readAccountcsv();
		assertEquals(ar.accountlist.get(0).getAccountNumber(), 500001);
	}

	@Test
	/**
	 * Test for creatAccountcsv method in AccountReader class.
	 */
	void test16() {
		
		CheckingAccount ca = new CheckingAccount("Test14", "Checking", "Password", 1000);
		AccountReader ar = new AccountReader();
		ar.createAccountcsv(ca);
		ar.readAccountcsv();
		assertEquals(ar.accountlist.get(ar.accountlist.size()-1).getBalance(), 1000);
	}



}