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
	void test1() {
		//fail("Not yet implemented");
		
		CheckingAccount one = new CheckingAccount (123,"sri",456, "2013", "checking", "password", 5000.0);
		
		one.deposit(500);
		one.withdraw(20);
		
		assertEquals(one.getBalance() , 5480 );
		
	}
	@Test
	void test2() {
		//fail("Not yet implemented");
		AccountReader list = new AccountReader();
		list.readAccountcsv();
		Account account = list.accountlist.get(0);
		
		assertEquals(account.getBalance() , 6000 );
		
	}
	
	@Test
	void test3() {
		//fail("Not yet implemented");
//		TransactionReader tr = new TransactionReader();
//		tr.readTransaction(new Transaction(50 ,"09312029","walmart","bodywash"));
//		tr.readTransaction(new Transaction(50 ,"10232029","amazon","soap"));
//		tr.readTransaction(new Transaction(50 ,"10232029","amazon","coffee"));
//		tr.printTransactions(10, 2029);
//
//		AccountReader li = new AccountReader();
//		
//	
//		CheckingAccount account = new CheckingAccount(45678, "varala", 356 ,"9132022" ,"checking" , "passcode",5000);
//		
//		li.createAccountcsv(account);
//		
//		
		
	 
		
		//assertEquals(account.getBalance() , 6000 );	
	}
	

}
