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
		assertEquals(account.getBalance(), 5480);

	}

	@Test
	/**
	 * Test case for checking the methods in the TransactionReader class.
	 */
	void test3() {
		
		TransactionReader tr = new TransactionReader();
		
		AccountReader li = new AccountReader();
		
	
		CheckingAccount account = new CheckingAccount(45678, "varala", 356 ,"9132022" ,"checking" , "passcode",5000);
		
		li.createAccountcsv(account);
		
		

		 assertEquals(account.getBalance() , 6000 );
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
	void test5() {

	}

	@Test
	void test6() {

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