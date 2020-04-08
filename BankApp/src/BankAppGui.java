import javax.swing.JLabel;
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
public class BankAppGui {

	// instance variables

	JFrame frame; // used to create frame
	JPanel p ;
	JPanel buttons;
	JLabel label1; // used to label for Account number
	JLabel label2; // used to label account balance
	JLabel label3; // used to label for Account name;
	JLabel label4; // used to label account expire date
	JButton button1; // used for Deposit (action method is needed when user clicks the button)
	JButton button2; // used for Withdraw (action method is needed when user clicks the button)
	JButton button3; // used for money transfer(action method is needed when user clicks the button)
	JButton button4; // used to exit gui (action method is needed when user clicks the button)
	JComboBox<String> box; // used to select account number
	Account a;
	
	/**
	 * 
	 * Add any extra instant variables here.
	 * 
	 * 
	 * 
	 */
	

	/**
	 * This method is used to design the layout for the GUI.
	 */
	
	public BankAppGui(Account acc) {
		a = acc;
	}
	
	private void layoutManager() {
		frame = new JFrame("Bank Application");
		frame.setSize(700, 400);
		frame.getContentPane().setBackground(Color.white);
		frame.setLayout(new FlowLayout());
		
		p = new JPanel();
		p.setLayout(new FlowLayout());
		p.setSize(50, 300);
		frame.add(p);
		
		buttons = new JPanel();
		buttons.setLayout(new FlowLayout());
		p.setSize(50, 300);
		frame.add(buttons);
	/**
	 * 
	 * 
	 * Add your code to augment the design layout
	 * please use GROUP Layout or Grid layout which ever makes appearance good.
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	}

	/*
	 * This method creates and perform various actions associated with in the GUI.
	 */
	public void createGui() {

		layoutManager() ;
		
		button1 = new JButton("Deposit");
		button2 = new JButton("Withdraw");
		button3 = new JButton("Transfer");
		button4 = new JButton("Exit");
		
		
		label1 = new JLabel("Account Number: " + Integer.toString(a.getAccountNumber()) + "       ");
		label2 = new JLabel("Account Name: " + a.getName() + "       ");
		label3 = new JLabel("Expire Date: " + Integer.toString(a.getExpiryDate()).substring(0,2) 
							+ "/" + Integer.toString(a.getExpiryDate()).substring(2,4) +
							"/" + Integer.toString(a.getExpiryDate()).substring(4) + "       ");
		String balance = String.format("%.2f", a.getBalance());
		label4 = new JLabel("Account Balance: " + balance + "       ");
		
		p.add(label1);
		p.add(label2);
		p.add(label3);
		p.add(label4);
		
		buttons.add(button1);
		buttons.add(button2);
		buttons.add(button3);
		buttons.add(button4);

		frame.setVisible(true);
		button1.addActionListener(new DepositMoney());
		button2.addActionListener(new WithdrawMoney());
		button3.addActionListener(new TransferMoney());
		button4.addActionListener(new Exit());
		
		/*
		 * Add your code here to create further interface.
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		
	}

//Internal class to perform action associated to the button.
	private class DepositMoney implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			// implement the Code to handle button click goes here
			
			
			
			
			
			
			
			
			
		}
	}

	//Internal class to perform action associated to the button.
	private class WithdrawMoney implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			// implement the Code to handle button click goes here
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
	}

	//Internal class to perform action associated to the button.
	private class TransferMoney implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			// implement the Code to handle button click goes here
			
			
			
			
			
			
			
			
			
			
			
			
		}
	}

	//Internal class to perform action associated to the button.
	private class Exit implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			// implement the Code to handle button click goes here
			frame.dispose();
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
	}

	/**
	 * Add your code to perform any extra action items.
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	
}
