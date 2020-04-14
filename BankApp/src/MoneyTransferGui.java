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
	
	private JPanel accType;
	private JPanel amount;
	
	private JLabel Accountusername;
	private JTextField usernameText;
	private JLabel AccountNumber;
	private JTextField AccountNumberText;
	private JLabel accountTypeText;
	private JComboBox accountType;
	private JLabel Amount;
	private JTextField AmountText;
	
	private JButton send;
	private JButton exit;
	
	
	
	

	/**
	 * This method is used to design the layout for the GUI.
	 */
	private void layoutManager() {
		
		frame = new JFrame("Money Transfer form");
		frame.setSize(400, 300);
		frame.getContentPane().setBackground(Color.white);
		frame.setLayout(new FlowLayout());
		
		balance = new JPanel();
		balance.setLayout(new FlowLayout());
		balance.setSize(100, 300);
		frame.add(balance);
		
		name = new JPanel();
		name.setLayout(new FlowLayout());
		name.setSize(50, 200);
		frame.add(name);
		
		number = new JPanel();
		number.setLayout(new FlowLayout());
		number.setSize(50, 200);
		frame.add(number);
		
		accType = new JPanel();
		accType.setLayout(new FlowLayout());
		accType.setSize(50, 200);
		frame.add(accType);
		
		amount = new JPanel();
		amount.setLayout(new FlowLayout());
		amount.setSize(50, 200);
		frame.add(amount);
		
		buttons = new JPanel();
		buttons.setLayout(new FlowLayout());
		buttons.setSize(50, 200);
		frame.add(buttons);
		
			}

	/*
	 * This method creates and perform various actions associated with in the GUI.
	 */
	public void createGui() {

		layoutManager() ;
		
		Accountusername = new JLabel("Enter name of the Account holder:");
		AccountNumber = new JLabel("Enter Account Number:");
		usernameText = new JTextField();
		AccountNumberText = new JTextField();
		usernameText.setColumns(10);
		AccountNumberText.setColumns(10);

		name.add(Accountusername);
		name.add(usernameText);
		number.add(AccountNumber);
		number.add(AccountNumberText);
		
		accountTypeText = new JLabel("Select Account Type:");
		String [] at = {"Checking", "Saving"};
		accountType = new JComboBox(at);
		accType.add(accountTypeText);
		accType.add(accountType);
		
		Amount = new JLabel("Enter the amount to transfer:");
		AmountText = new JTextField();
		AmountText.setColumns(10);
		amount.add(Amount);
		amount.add(AmountText);
		
		send = new JButton("Send");
		exit = new JButton("Exit");
		
		buttons.add(send);
		buttons.add(exit);
		
			
		frame.setVisible(true);
		
		send.addActionListener(new transfer());
		exit.addActionListener(new Exit());
	}

	//Internal class to perform action associated to the button.
	private class transfer implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			// implement the Code to handle button click goes here
			
				String name = usernameText.getText();
				int number = Integer.parseInt(AccountNumberText.getText());
				String accType = accountType.getSelectedItem().toString();
				int amount = Integer.parseInt(AmountText.getText());
				
			
				for(int i=0; i < AccountReader.accountlist.size(); i++) {
					
					String aName = AccountReader.accountlist.get(i).getName();
					int aNumber =AccountReader.accountlist.get(i).getAccountNumber();
					String aType =AccountReader.accountlist.get(i).getType();
					
					Account toAccount =AccountReader.accountlist.get(i);
					 Account fromAccount = new LoginGui().workingAccount;
					
					if(name.contentEquals(aName)&& number == aNumber && accType.contentEquals(aType)) {
						
						fromAccount.moneyTransfer(toAccount,amount);
						String bal = String.format("%.2f", fromAccount.getBalance());
						new BankAppGui(fromAccount).balance.setText("Account Balance: " + bal + "       ");
						
						String date =	 Transaction.DateCaluclator();
						String transaction = "Date-"+date +", Type- transfer, Amount-"+amount+", To Account - "+toAccount.getName()+"\n";
						new BankAppGui(fromAccount).textArea.append(transaction);		
						
						
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
}
