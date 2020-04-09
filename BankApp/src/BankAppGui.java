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

	private JFrame frame; // used to create frame
	
	private JPanel accountInfo;
	private JPanel buttons;
	
	private JLabel accountNumber;
	private JLabel accountName;
	private JLabel expDate;
	private JLabel balance;
	
	private JButton deposit;
	private JButton withdraw;
	private JButton transfer;
	private JButton exit;
	
	private Account a;
	
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
		
		accountInfo = new JPanel();
		accountInfo.setLayout(new FlowLayout());
		accountInfo.setSize(50, 300);
		frame.add(accountInfo);
		
		buttons = new JPanel();
		buttons.setLayout(new FlowLayout());
		buttons.setSize(50, 300);
		frame.add(buttons);
	}

	/*
	 * This method creates and perform various actions associated with in the GUI.
	 */
	public void createGui() {

		layoutManager() ;
		
		accountNumber = new JLabel("Account Number: " + Integer.toString(a.getAccountNumber()) + "       ");
		accountName = new JLabel("Account Name: " + a.getName() + "       ");
		expDate = new JLabel("Expire Date: " + (a.getExpiryDate()).substring(0,2) 
							+ "/" + (a.getExpiryDate()).substring(2,4) +
							"/" + (a.getExpiryDate()).substring(4) + "       ");
		String bal = String.format("%.2f", a.getBalance());
		balance = new JLabel("Account Balance: " + bal + "       ");
		
		accountInfo.add(accountNumber);
		accountInfo.add(accountName);
		accountInfo.add(expDate);
		accountInfo.add(balance);
		
		deposit = new JButton("Deposit");
		withdraw = new JButton("Withdraw");
		transfer = new JButton("Transfer");
		exit = new JButton("Exit");
		
		buttons.add(deposit);
		buttons.add(withdraw);
		buttons.add(transfer);
		buttons.add(exit);

		frame.setVisible(true);
		
		deposit.addActionListener(new DepositMoney());
		withdraw.addActionListener(new WithdrawMoney());
		transfer.addActionListener(new TransferMoney());
		exit.addActionListener(new Exit());
	}

//Internal class to perform action associated to the button.
	private class DepositMoney implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
			
			
		}
	}

	//Internal class to perform action associated to the button.
	private class WithdrawMoney implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
			
			
		}
	}

	//Internal class to perform action associated to the button.
	private class TransferMoney implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
			
			
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
