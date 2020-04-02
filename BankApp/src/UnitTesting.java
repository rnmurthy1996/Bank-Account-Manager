import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class UnitTesting {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void test1() {
		//fail("Not yet implemented");
		
		Account one = new Account (123,"sri",456, 2013, "checking", "password", 5000.0);
		
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
		TransactionReader tr = new TransactionReader();
		tr.readTransaction(new Transaction(50 ,2029,"walmart","bodywash"));
		tr.readTransaction(new Transaction(50 ,2029,"amazon","soap"));
		tr.printTransactions(5, 0);
		
		//assertEquals(account.getBalance() , 6000 );
		
	}

}
