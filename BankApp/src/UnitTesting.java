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
	 * Test case for checking the methods in the AccountReader class.
	 */
	void test2() {

		AccountReader list = new AccountReader();
		list.readAccountcsv();
		Account account = list.accountlist.get(0);
		TransactionReader.readTransactioncsv();
		assertEquals(account.getBalance(), 397.79);

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
	 * Test Case for checking the methods in the SavingAccount Class.
	 */
	void test4() {

		SavingAccount one = new SavingAccount(123, "sri", 456, "2013", "checking", "password", 5000.0);

		one.deposit(500);
		one.withdraw(20);

		assertEquals(one.getBalance(), 5475);

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

	@Test
	/**
	 * Test case for checking the Money transfer functions in Checking and 	Saving accounts.
	 */
	void test6() {

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

	@Test
	void test7() {
	
	}

	@Test
	void test8() {

	}

	@Test
	/**
	 * Test case for checking the methods in BankAppGui class.
	 */
	void test9() {

	}

	@Test
	/**
	 * Test case for checking the methods in CreateAccountGui class.
	 */
	void test10() {

	}

	@Test
	/**
	 * Test case for checking the methods in DepositGui class.
	 */
	void test11() {

	}

	@Test
	/**
	 * Test case for checking the methods in WithdrawGui class.
	 */
	void test12() {

	}

	@Test
	/**
	 * Test case for checking the methods in LoginGui class.
	 */
	void test13() {

	}

	@Test
	void test14() {

	}

	@Test
	void test15() {

	}

	@Test
	void test16() {

	}

}