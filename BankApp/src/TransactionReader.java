import java.util.ArrayList;

public class TransactionReader {
	
	ArrayList<Transaction>transactionList;
	
	TransactionReader(){
		
		transactionList = new ArrayList<Transaction>();
	}
	
	
	public void readTransaction( Transaction obj) {
		
		transactionList.add(obj);
		
	}
	
	
	public void printTransactions(int month , int year) {
		
		
		
	}
	
}
