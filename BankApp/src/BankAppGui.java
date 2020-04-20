import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * 
 * BankAppGui.java is used to create the home page window of our program. This GUI is accessed when the user successfully logs in.
 * This GUI contains the primary account information, buttons with options to deposit, withdraw, transfer, and exit the application, and a list of all transactions for the account.
 * @author Rohan Murthy
 * @author Sridhar Varala
 *
 */

public class BankAppGui {

	private JFrame frame;

	private JPanel accountInfo;
	private JPanel buttons;
	private JPanel area;

	private JLabel accountNumber;
	private JLabel accountName;
	private JLabel expDate;
	public static JLabel balance;
	private JLabel accountType;

	private JButton deposit;
	private JButton withdraw;
	private JButton transfer;
	private JButton exit;
	public static JTextArea textArea;
	private JScrollPane scrollPane;
	private Account a;

	public BankAppGui(Account acc) {

		a = acc;
	}
	
	/**
	 * The layoutManager method initializes all of the panels used by BankAppGui.java.
	 */
	private void layoutManager() {

		frame = new JFrame("Bank Application");
		frame.setSize(900, 400);
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.white);
		frame.setLayout(new FlowLayout());

		accountInfo = new JPanel();
		accountInfo.setLayout(new FlowLayout());
		accountInfo.setSize(100, 300);
		frame.add(accountInfo);

		buttons = new JPanel();
		buttons.setLayout(new FlowLayout());
		buttons.setSize(50, 300);
		frame.add(buttons);
		textArea = new JTextArea(15, 50);
		scrollPane = new JScrollPane(textArea);
		
		area = new JPanel();
		area.add(scrollPane);
		area.setLayout(new FlowLayout());
		area.setSize(50, 300);
		frame.add(area);
	}

	/**
	 * The createGui method is used to initialize the GUI which contains the required panels, labels, buttons, etc.
	 */
	public void createGui() {

		layoutManager();

		accountNumber = new JLabel("Account Number: " + Integer.toString(a.getAccountNumber()) + "       ");
		accountName = new JLabel("Username: " + a.getName() + "       ");
		expDate = new JLabel("Account Expiration: " + (a.getExpiryDate()) + "       ");
		String bal = String.format("%.2f", a.getBalance());
		balance = new JLabel("Current Balance: $" + bal + "       ");
		accountType = new JLabel("Account Type: " + a.getType()+ "       ");
		
		accountInfo.add(accountName);
		accountInfo.add(accountNumber);
		accountInfo.add(accountType);
		accountInfo.add(balance);
		accountInfo.add(expDate);

		deposit = new JButton("Deposit");
		withdraw = new JButton("Withdraw");
		transfer = new JButton("Transfer");
		exit = new JButton("Exit");

		buttons.add(deposit);
		buttons.add(withdraw);
		buttons.add(transfer);
		buttons.add(exit);

        textArea.setEditable(false);
		frame.setVisible(true);

		deposit.addActionListener(new DepositMoney());
		withdraw.addActionListener(new WithdrawMoney());
		transfer.addActionListener(new TransferMoney());
		exit.addActionListener(new Exit());
	}

	/**
	 * The private class DepositMoney is called when the deposit Jbutton is clicked and opens the deposit money GUI.
	 */
	private class DepositMoney implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			new DepositGui(a).createGui();
		}
	}

	/**
	 * The private class WithdrawMoney is called when the withdraw Jbutton is clicked and opens the withdraw money GUI.
	 */
	private class WithdrawMoney implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			new WithdrawGui(a).createGui();
		}
	}
	
	/**
	 * The private class TransferMoney is called when the transfer Jbutton is clicked and opens the transfer money GUI.
	 */
	private class TransferMoney implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			new MoneyTransferGui().createGui();
		}
	}

	/**
	 * The private class Exit is called when the exit Jbutton is clicked and closes all windows currently open that are associated with the application.
	 */
	private class Exit implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			System.exit(0);	
	}
	}
}