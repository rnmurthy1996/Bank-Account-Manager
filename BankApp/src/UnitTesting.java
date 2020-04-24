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
	 * Test for deposit method in CheckingAccount class.
	 */
	void test1() {

		CheckingAccount ca = new CheckingAccount("UnitTesting", "Checking", "Password", 1000);
		ca.deposit(500);
		assertEquals(ca.getBalance(), 1500);
	}
	
	@Test
	/**
	 * Test for withdraw method in CheckingAccount class.
	 */
	void test2() {

		CheckingAccount ca = new CheckingAccount("UnitTesting", "Checking", "Password", 1000);
		ca.withdraw(500);
		assertEquals(ca.getBalance(), 500);
	}

	@Test
	/**
	 * Test for moneyTransfer method in CheckingAccount class.
	 */
	void test3() {

		CheckingAccount from = new CheckingAccount("From", "Checking", "Password", 1000);
		CheckingAccount to = new CheckingAccount("To", "Checking", "Password", 1000);
		from.moneyTransfer(to, 500);
		assertEquals(from.getBalance(), 500);
		assertEquals(to.getBalance(), 1500);
	}
	
	@Test
	/**
	 * Test for loginAuthentication method in CheckingAccount class.
	 */
	void test4() {

		CheckingAccount ca = new CheckingAccount("UnitTesting", "Checking", "Password", 1000);
		assertEquals(ca.loginAuthentication("UnitTesting", "Password"), true);
	}
	
	@Test
	/**
	 * Test for interest method in CheckingAccount class.
	 */
	void test5() {

		CheckingAccount ca = new CheckingAccount("UnitTesting", "Checking", "Password", 1000);
		ca.interest();
		assertEquals(ca.getBalance(), 1000.2083333333334);
	}
	
	@Test
	/**
	 * Test for withdraw method in SavingAccount class.
	 */
	void test6() {

		SavingAccount sa = new SavingAccount("UnitTesting", "Savings", "Password", 1000);
		sa.withdraw(500);
		assertEquals(sa.getBalance(), 495);
	}

	
	@Test
	/**
	 * Test for moneyTransfer method in SavingAccount class.
	 */
	void test7() {

		SavingAccount from = new SavingAccount("From", "Savings", "Password", 1000);
		SavingAccount to = new SavingAccount("To", "Savings", "Password", 1000);
		from.moneyTransfer(to, 500);
		assertEquals(from.getBalance(), 498);
		assertEquals(to.getBalance(), 1500);
	}
	
	@Test
	/**
	 * Test for interest method in SavingAccount class.
	 */
	void test8() {

		SavingAccount sa = new SavingAccount("UnitTesting", "Savings", "Password", 1000);
		sa.interest();
		assertEquals(sa.getBalance(), 1002.0833333333334);
	}
	
	@Test
	/**
	 * Test for userNameCheck method in DepositGui class.
	 */
	void test9() {

		String un1 = "Valid";
		String un2 = "Not Valid";

		SavingAccount s = new SavingAccount("UnitTesting", "Savings", "Password", 1000);
		DepositGui dg = new DepositGui(s);
		assertEquals(dg.userNameCheck(un1), true);
		assertEquals(dg.userNameCheck(un2), false);
	}
	
	@Test
	/**
	 * Test for depositCheck method in DepositGui class.
	 */
	void test10() {

		String dep1 = "10000";
		String dep2 = "1jd93nd";

		SavingAccount s = new SavingAccount("UnitTesting", "Savings", "Password", 1000);
		DepositGui dg = new DepositGui(s);
		assertEquals(dg.depositCheck(dep1), true);
		assertEquals(dg.depositCheck(dep2), false);
	}
	
	@Test
	/**
	 * Test for depositPosCheck method in DepositGui class.
	 */
	void test11() {

		String dep1 = "10000";
		String dep2 = "-10000";

		SavingAccount s = new SavingAccount("UnitTesting", "Savings", "Password", 1000);
		DepositGui dg = new DepositGui(s);
		assertEquals(dg.depositPosCheck(dep1), true);
		assertEquals(dg.depositPosCheck(dep2), false);
	}
	
	@Test
	/**
	 * Test for creatAccountcsv method in AccountReader class.
	 */
	void test12() {

		CheckingAccount ca = new CheckingAccount("Test14", "Checking", "Password", 1000);
		AccountReader ar = new AccountReader();
		ar.createAccountcsv(ca);
		ar.readAccountcsv();
		assertEquals(ar.accountlist.get(ar.accountlist.size() - 1).getBalance(), 1000);
	}
	
	@Test
	/**
	 * Test for readAccountcsv method in AccountReader class.
	 */
	void test13() {

		AccountReader ar = new AccountReader();
		ar.readAccountcsv();
		assertEquals(ar.accountlist.get(0).getAccountNumber(), 500001);
	}
	
	@Test
	/**
	 * Test for updateAccountDatabase method in AccountReader class.
	 */
	void test14() {

		CheckingAccount ca = new CheckingAccount("Test15", "Checking", "Password", 1000);
		AccountReader ar = new AccountReader();
		ar.createAccountcsv(ca);
		ar.readAccountcsv();
		ar.accountlist.get(ar.accountlist.size() - 1).deposit(500);
		ar.updateAccountDatabase();

		AccountReader ar2 = new AccountReader();
		ar2.readAccountcsv();
		double balance = 0;
		for (int i = 0; i < ar2.accountlist.size() - 1; i++) {
			if (ar2.accountlist.get(i).getName().equals("Test15")) {
				balance = ar2.accountlist.get(i).getBalance();
			}
		}
		assertEquals(balance, 1500);
	}
	
	@Test
	/**
	 * Test for checking the methods in TransactionReader class.
	 */
	void test15() {
		CheckingAccount account = new CheckingAccount("varala", "Checking", "passcode", 5000);
		Transaction t = new Transaction("deposit", account);
		TransactionReader.transactionList.add(t);
		for (int i = 0; i < TransactionReader.transactionList.size(); i++) {

			if (TransactionReader.transactionList.get(i).account.getName().equals("varala")) {
				assertEquals(TransactionReader.transactionList.get(i).transaction, "deposit");
			}
		}
	}
	
}