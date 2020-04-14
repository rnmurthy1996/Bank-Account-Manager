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
public class MoneyTransferGui {

	// instance variables

	private JFrame frame;
	
	private JPanel balance;
	private JPanel name;
	private JPanel number;
	private JPanel buttons;	
	private JPanel incorrect;

	
	private JPanel accType;
	private JPanel accTypeTo;
	private JPanel transfer;
	
	private JLabel balanceText;
	private JLabel Accountusername;
	private JTextField usernameText;
	private JLabel AccountNumber;
	private JTextField AccountNumberText;
	private JLabel accountTypeText;
	private JComboBox accountType;
	private JLabel transferLabel;
	private JTextField AmountText;
	private JComboBox accountTypeTo;
	private JLabel accountTypeToText;
	
	private JTextField dollarsText;
	private JLabel dot;
	private JTextField centsText;
	
	private JButton send;
	private JButton exit;
	
	private JLabel transferErr;
	
	private Account a;
	
	public MoneyTransferGui(Account acc) {
		
		a = acc;
	}

	/**
	 * This method is used to design the layout for the GUI.
	 */
	private void layoutManager() {
		
		frame = new JFrame("Bank Application");
		frame.setSize(375, 300);
		frame.getContentPane().setBackground(Color.white);
		frame.setLayout(new FlowLayout());
		
		balance = new JPanel();
		balance.setLayout(new FlowLayout());
		balance.setSize(100, 300);
		frame.add(balance);
		
		accType = new JPanel();
		accType.setLayout(new FlowLayout());
		accType.setSize(50, 200);
		frame.add(accType);
		
		accTypeTo = new JPanel();
		accTypeTo.setLayout(new FlowLayout());
		accTypeTo.setSize(50, 200);
		frame.add(accTypeTo);
		
		number = new JPanel();
		number.setLayout(new FlowLayout());
		number.setSize(50, 200);
		frame.add(number);
		
		transfer = new JPanel();
		transfer.setLayout(new FlowLayout());
		transfer.setSize(50, 200);
		frame.add(transfer);
		
		buttons = new JPanel();
		buttons.setLayout(new FlowLayout());
		buttons.setSize(50, 200);
		frame.add(buttons);
		
		incorrect = new JPanel();
		incorrect.setBackground(Color.white);
		incorrect.setLayout(new BoxLayout(incorrect, BoxLayout.Y_AXIS));
		incorrect.setSize(50, 200);
		frame.add(incorrect);
		
			}

	/*
	 * This method creates and perform various actions associated with in the GUI.
	 */
	public void createGui() {

		layoutManager() ;
		
		balanceText = new JLabel("Current Balance: " + a.getBalance());
		balance.add(balanceText);
		
		accountTypeText = new JLabel("Select Account Type To Transfer From:");
		String [] at = {"Checking", "Saving"};
		accountType = new JComboBox(at);
		accType.add(accountTypeText); 
		accType.add(accountType);
		
		accountTypeToText = new JLabel("Select Account Type To Transfer To:");
		String [] at2 = {"Checking", "Saving"};
		accountTypeTo = new JComboBox(at);
		accTypeTo.add(accountTypeToText); 
		accTypeTo.add(accountTypeTo);
		
		AccountNumber = new JLabel("Enter Account Number To Transfer To:");
		AccountNumberText = new JTextField();
		AccountNumberText.setColumns(10);
		
		number.add(AccountNumber);
		number.add(AccountNumberText);
		
		
		transferLabel = new JLabel("Deposit Amount:");
		dollarsText = new JTextField();
		dollarsText.setColumns(7);
		dot = new JLabel(".");
		centsText = new JTextField();
		centsText.setColumns(3);
		
		transfer.add(transferLabel);
		transfer.add(dollarsText);
		transfer.add(dot);
		transfer.add(centsText);
		
		send = new JButton("Send");
		exit = new JButton("Exit");
		
		buttons.add(send);
		buttons.add(exit);
		
		transferErr = new JLabel("");
		incorrect.add(transferErr);
		transferErr.setAlignmentX(incorrect.CENTER_ALIGNMENT);
			
		frame.setVisible(true);
		
		send.addActionListener(new transfer());
		exit.addActionListener(new Exit());
	}

	//Internal class to perform action associated to the button.
	private class transfer implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			// implement the Code to handle button click goes here
			
			double transferAmount = 0;
			
			if(dollarsText.getText().isEmpty() == true) {
				transferErr.setText("Deposit field cannot be empty");
				transferErr.setForeground(Color.red);
			}
			else if(depositPosCheck(dollarsText.getText()) == false) {
				transferErr.setText("Deposit must be positive");
				transferErr.setForeground(Color.red);
			}
			else if(depositCheck(dollarsText.getText()) == false) {
				transferErr.setText("Deposit must be numerical");
				transferErr.setForeground(Color.red);
			}
			else if(centsText.getText().isEmpty() == true) {
				transferErr.setText("Deposit field cannot be empty");
				transferErr.setForeground(Color.red);
			}
			else if(depositPosCheck(centsText.getText()) == false) {
				transferErr.setText("Deposit must be positive");
				transferErr.setForeground(Color.red);
			}
			else if(depositCheck(centsText.getText()) == false) {
				transferErr.setText("Deposit must be numerical");
				transferErr.setForeground(Color.red);
			}
			else {
				transferAmount = Double.parseDouble(dollarsText.getText()) + Double.parseDouble(centsText.getText())/100;
				transferErr.setText("");
			}
			
				int number = Integer.parseInt(AccountNumberText.getText());
				String accTypeTo = accountTypeTo.getSelectedItem().toString();
				
			
				for(int i=0; i < AccountReader.accountlist.size(); i++) {
					
					String aName = AccountReader.accountlist.get(i).getName();
					int aNumber =AccountReader.accountlist.get(i).getAccountNumber();
					String aType =AccountReader.accountlist.get(i).getType();
					
					Account toAccount =AccountReader.accountlist.get(i);
					
					if(number == aNumber && accTypeTo.contentEquals(aType)) {
						
						a.moneyTransfer(toAccount,transferAmount);
						String bal = String.format("%.2f", a.getBalance());
						new BankAppGui(a).balance.setText("Account Balance: " + bal + "       ");
						AccountReader.updateAccountDatabase();
						frame.dispose();
							
					}
					
				}
					
//			a.transfer(amount, other);
//			String bal = String.format("%.2f", a.getBalance());
//			balance.setText(bal);
//			
		
		}
	}
	
	//Internal class to perform action associated to the button.
	private class Exit implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			// implement the Code to handle button click goes here
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
