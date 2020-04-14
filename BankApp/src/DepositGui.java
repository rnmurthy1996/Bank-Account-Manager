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
public class DepositGui {

	// Instance variables

	private JFrame frame;
	
	private JPanel balance;
	private JPanel deposit;
	private JPanel buttons;
	private JPanel incorrect;
	
	private JLabel balanceLabel;
	private JLabel depositLabel;
	private JTextField dollarsText;
	private JLabel dot;
	private JTextField centsText;
	
	private JButton depositButton;
	private JButton exit;
	
	private JLabel depositErr;
	
	private Account a;
	
	public DepositGui(Account acc) {
		
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
		
		deposit = new JPanel();
		deposit.setLayout(new FlowLayout());
		deposit.setSize(100, 300);
		frame.add(deposit);
		
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
		
		depositLabel = new JLabel("Deposit Amount:");
		dollarsText = new JTextField();
		dollarsText.setColumns(7);
		dot = new JLabel(".");
		centsText = new JTextField();
		centsText.setColumns(3);
		
		deposit.add(depositLabel);
		deposit.add(dollarsText);
		deposit.add(dot);
		deposit.add(centsText);
		
		depositButton = new JButton("Deposit");
		exit = new JButton("Exit");
		
		buttons.add(depositButton);
		buttons.add(exit);
		
		depositErr = new JLabel("");
		incorrect.add(depositErr);
		depositErr.setAlignmentX(incorrect.CENTER_ALIGNMENT);

		frame.setVisible(true);
		
		depositButton.addActionListener(new DepositMoney());
		exit.addActionListener(new Exit());
	}

	//Internal class to perform action associated to the button.
	private class DepositMoney implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
			double depositAmount = 0;
			
			
			if(dollarsText.getText().isEmpty() == true) {
				depositErr.setText("Deposit field cannot be empty");
				depositErr.setForeground(Color.red);
			}
			else if(depositPosCheck(dollarsText.getText()) == false) {
				depositErr.setText("Deposit must be positive");
				depositErr.setForeground(Color.red);
			}
			else if(depositCheck(dollarsText.getText()) == false) {
				depositErr.setText("Deposit must be numerical");
				depositErr.setForeground(Color.red);
			}
			else if(centsText.getText().isEmpty() == true) {
				depositErr.setText("Deposit field cannot be empty");
				depositErr.setForeground(Color.red);
			}
			else if(depositPosCheck(centsText.getText()) == false) {
				depositErr.setText("Deposit must be positive");
				depositErr.setForeground(Color.red);
			}
			else if(depositCheck(centsText.getText()) == false) {
				depositErr.setText("Deposit must be numerical");
				depositErr.setForeground(Color.red);
			}
			else {
				depositAmount = Double.parseDouble(dollarsText.getText()) + Double.parseDouble(centsText.getText())/100;
				depositErr.setText("");
			}
			
			if(depositAmount > 0) {
				a.deposit(depositAmount);
				String bal = String.format("%.2f", a.getBalance());
				balanceLabel.setText("Current Balance:" + a.getBalance());	
				new BankAppGui(a).balance.setText("Account Balance: " + a.getBalance() + "       ");
				
				
				String date =	 Transaction.DateCaluclator();
				String transaction = "Date-"+date +", Type- Deposit, Amount-"+depositAmount+"\n";
				new BankAppGui(a).textArea.append(transaction);
			
				AccountReader.updateAccountDatabase();
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
