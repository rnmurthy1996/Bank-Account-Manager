import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * This class is for building the Gui for the Bank App.
 * 
 * @author Sridhar.Varala
 *
 */
public class WithdrawGui {

	// Instance variables

	private JFrame frame;
	
	private JPanel balance;
	private JPanel withdraw;
	private JPanel buttons;
	private JPanel incorrect;
	
	private JLabel balanceLabel;
	private JLabel withdrawLabel;
	private JTextField dollarsText;
	private JLabel dot;
	private JTextField centsText;
	
	private JButton withdrawButton;
	private JButton exit;
	
	private JLabel withdrawErr;
	
	private Account a;
	
	public WithdrawGui(Account acc) {
		
		a = acc;
	}
	
	private void layoutManager() {
		
		frame = new JFrame("Bank Application");
		frame.setSize(300, 200);
		frame.getContentPane().setBackground(Color.white);
		frame.setLayout(new FlowLayout());
		
		balance = new JPanel();
		balance.setLayout(new FlowLayout());
		balance.setSize(100, 300);
		frame.add(balance);
		
		withdraw = new JPanel();
		withdraw.setLayout(new FlowLayout());
		withdraw.setSize(100, 300);
		frame.add(withdraw);
		
		buttons = new JPanel();
		buttons.setLayout(new FlowLayout());
		buttons.setSize(50, 300);
		frame.add(buttons);
		
		incorrect = new JPanel();
		incorrect.setBackground(Color.white);
		incorrect.setLayout(new BoxLayout(incorrect, BoxLayout.Y_AXIS));
		incorrect.setSize(50, 200);
		frame.add(incorrect);
	}

	//This method creates and perform various actions associated with in the GUI.
	public void createGui() {

		layoutManager() ;
		
		balanceLabel = new JLabel("Current Balance:" + a.getBalance());
		balance.add(balanceLabel);
		
		withdrawLabel = new JLabel("Withdrawal Amount:");
		dollarsText = new JTextField();
		dollarsText.setColumns(7);
		dot = new JLabel(".");
		centsText = new JTextField();
		centsText.setColumns(3);
		
		withdraw.add(withdrawLabel);
		withdraw.add(dollarsText);
		withdraw.add(dot);
		withdraw.add(centsText);
		
		withdrawButton = new JButton("Withdraw");
		exit = new JButton("Exit");
		
		buttons.add(withdrawButton);
		buttons.add(exit);
		
		withdrawErr = new JLabel("");
		incorrect.add(withdrawErr);
		withdrawErr.setAlignmentX(incorrect.CENTER_ALIGNMENT);

		frame.setVisible(true);
		
		withdrawButton.addActionListener(new DepositMoney());
		exit.addActionListener(new Exit());
	}

	//Internal class to perform action associated to the button.
	private class DepositMoney implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
			double withdrawAmount = 0;
			
			
			if(dollarsText.getText().isEmpty() == true) {
				withdrawErr.setText("Withdrawal Amount Field Cannot Be Empty");
				withdrawErr.setForeground(Color.red);
			}
			else if(depositPosCheck(dollarsText.getText()) == false) {
				withdrawErr.setText("Withdrawal Amount Must Be Positive");
				withdrawErr.setForeground(Color.red);
			}
			else if(depositCheck(dollarsText.getText()) == false) {
				withdrawErr.setText("Withdrawal Amount Must Be Numerical");
				withdrawErr.setForeground(Color.red);
			}
			else if(centsText.getText().isEmpty() == true) {
				withdrawErr.setText("Withdrawal Amount Field Cannot Be Empty");
				withdrawErr.setForeground(Color.red);
			}
			else if(depositPosCheck(centsText.getText()) == false) {
				withdrawErr.setText("Withdrawal Amount Must Be Positivee");
				withdrawErr.setForeground(Color.red);
			}
			else if(depositCheck(centsText.getText()) == false) {
				withdrawErr.setText("Withdrawal Amount Must Be Numerical");
				withdrawErr.setForeground(Color.red);
			}
			else {
				withdrawAmount = Double.parseDouble(dollarsText.getText()) + Double.parseDouble(centsText.getText())/100;
				withdrawErr.setText("");
			}
			
			if(withdrawAmount > a.getBalance()) {
				withdrawErr.setText("Insufficient Funds For Withdrawal");
				withdrawErr.setForeground(Color.red);
			}
			else if(withdrawAmount > 0) {
				a.withdraw(withdrawAmount);
				String bal = String.format("%.2f", a.getBalance());
				balanceLabel.setText("Current Balance:" + a.getBalance());	
				new BankAppGui(a).balance.setText("Account Balance: " + a.getBalance() + "       ");
				
				String date =	 Transaction.DateCaluclator();
				String transaction = "Date-"+date +", Type- Withdraw, Amount-"+withdrawAmount+"\n";
				new BankAppGui(a).textArea.append(transaction);
				AccountReader.updateAccountDatabase();
				
				String t =	new BankAppGui(a).textArea.getText();
				
				new TransactionReader().transactionList.add(new Transaction(t,a));
				 TransactionReader.updateTransactionDatabase();
			}
		}
	}

	//Internal class to perform action associated to the button.
	private class Exit implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			// implement the Code to handle button click goes here
			new BankAppGui(a).balance.setText("Account Balance: " + a.getBalance() + "       ");
			frame.dispose();
		}
	}
	
	public boolean userNameCheck(String s) {
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == ' ') {
				return false;
			}
		}
		return true;
	}
	
	public boolean depositCheck(String s) {
		for(int i = 0; i < s.length(); i++) {
			if(Character.isDigit(s.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}
	
	public boolean depositPosCheck(String s) {
		if((s.substring(0,1)).equals("-")) {
			return false;
		}
		return true;
	}
}