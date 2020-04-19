import java.awt.BorderLayout;
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

	// Instance variables

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
		// scrollPane.setLayout(new BorderLayout());

		area = new JPanel();
		area.add(scrollPane);
		area.setLayout(new FlowLayout());
		area.setSize(50, 300);
		frame.add(area);

	}

	// This method creates and perform various actions associated with in the GUI.
	public void createGui() {

		layoutManager();

		accountNumber = new JLabel("Account Number: " + Integer.toString(a.getAccountNumber()) + "       ");
		accountName = new JLabel("Username: " + a.getName() + "       ");
		expDate = new JLabel("Account Expiration: " + (a.getExpiryDate()) + "       ");
		String bal = String.format("%.2f", a.getBalance());
		balance = new JLabel("Account Balance: " + bal + "       ");
		accountType = new JLabel("Account Type: " + a.getType() + "       ");

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

		// textArea.setText("Your Transactions:"+"\n");
		// textArea.append(write);
		textArea.setEditable(false);

		frame.setVisible(true);

		deposit.addActionListener(new DepositMoney());
		withdraw.addActionListener(new WithdrawMoney());
		transfer.addActionListener(new TransferMoney());
		exit.addActionListener(new Exit());
	}

	// Internal class to perform action associated to the button.
	private class DepositMoney implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			new DepositGui(a).createGui();
		}
	}

	// Internal class to perform action associated to the button.
	private class WithdrawMoney implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			new WithdrawGui(a).createGui();
		}
	}

	// Internal class to perform action associated to the button.
	private class TransferMoney implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			new MoneyTransferGui().createGui();
		}
	}

	// Internal class to perform action associated to the button.
	private class Exit implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			// implement the Code to handle button click goes here
			System.exit(0);

		}
	}
}