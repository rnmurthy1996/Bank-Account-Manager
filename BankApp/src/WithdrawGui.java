import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * 
 * DepositGui.java is used to create the withdraw GUI of our program. This GUI is accessed when the user clicks the withdraw button in the home page GUI.
 * This GUI allows the user to withdraw money from their account. The amount is determined by the user.
 * @author Rohan Murthy
 * @author Sridhar Varala
 *
 */
public class WithdrawGui {

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


	/**
	 * The layoutManager method initializes all of the panels used by WithdrawGui.java.
	 */
	private void layoutManager() {

		frame = new JFrame("Bank Application");
		frame.setSize(300, 175);
		frame.setResizable(false);
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

	/**
	 * The createGui method is used to initialize the GUI which contains the required panels, labels, buttons, etc.
	 */
	public void createGui() {

		layoutManager();

		String b = String.format("%.2f", a.getBalance());
		balanceLabel = new JLabel("Current Balance: $" + b);
		balance.add(balanceLabel);

		withdrawLabel = new JLabel("Withdrawal Amount:");
		dollarsText = new JTextField();
		dollarsText.setColumns(7);
		dot = new JLabel(".");
		centsText = new JTextField();
		centsText.setColumns(3);
		centsText.setDocument(new JTextFieldLimit(2));

		withdraw.add(withdrawLabel);
		withdraw.add(dollarsText);
		withdraw.add(dot);
		withdraw.add(centsText);

		withdrawButton = new JButton("Withdraw");
		exit = new JButton("Exit");

		buttons.add(withdrawButton);
		buttons.add(exit);

		withdrawErr = new JLabel("                                                                            ");
		incorrect.add(withdrawErr);
		withdrawErr.setAlignmentX(incorrect.CENTER_ALIGNMENT);

		frame.setVisible(true);

		withdrawButton.addActionListener(new WithdrawMoney());
		exit.addActionListener(new Exit());
	}


	/**
	 * The private class DepositMoney is called when the withdrawButton Jbutton is clicked and withdraws the user determined amount from the account.
	 * The withdrawal amount is checked in this class to ensure that it is a valid amount (no spaces, letters, negative values, etc.).
	 * The withdrawal amount is also checked against the account balance to ensure sufficient funds are available for withdrawal.
	 */
	private class WithdrawMoney implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			double withdrawAmount = 0;

			if (dollarsText.getText().isEmpty() == true) {
				withdrawErr.setText("Withdrawal Amount Field Cannot Be Empty");
				withdrawErr.setForeground(Color.red);
			} else if (withdrawPosCheck(dollarsText.getText()) == false) {
				withdrawErr.setText("Withdrawal Amount Must Be Positive");
				withdrawErr.setForeground(Color.red);
			} else if (withdrawCheck(dollarsText.getText()) == false) {
				withdrawErr.setText("Withdrawal Amount Must Be Numerical");
				withdrawErr.setForeground(Color.red);
			} else if (centsText.getText().isEmpty() == true) {
				withdrawErr.setText("Withdrawal Amount Field Cannot Be Empty");
				withdrawErr.setForeground(Color.red);
			} else if (withdrawPosCheck(centsText.getText()) == false) {
				withdrawErr.setText("Withdrawal Amount Must Be Positivee");
				withdrawErr.setForeground(Color.red);
			} else if (withdrawCheck(centsText.getText()) == false) {
				withdrawErr.setText("Withdrawal Amount Must Be Numerical");
				withdrawErr.setForeground(Color.red);
			} else {
				if (centsText.getText().length() == 1) {
					withdrawAmount = Double.parseDouble(dollarsText.getText())
							+ Double.parseDouble(centsText.getText()) / 10.00;
					withdrawErr.setText("                                                                            ");
				} else {
					withdrawAmount = Double.parseDouble(dollarsText.getText())
							+ Double.parseDouble(centsText.getText()) / 100.00;
					withdrawErr.setText("                                                                            ");
				}
			}

			if (withdrawAmount > a.getBalance()) {
				withdrawErr.setText("Insufficient Funds For Withdrawal");
				withdrawErr.setForeground(Color.red);
			} else if (withdrawAmount > 0) {
				a.withdraw(withdrawAmount);
				String bal = String.format("%.2f", a.getBalance());

				balanceLabel.setText("Current Balance: $" + bal);	
				new BankAppGui(a).balance.setText("Current Balance: $" + bal + "       ");
				
				String with = String.format("%.2f", withdrawAmount);
				String date = Transaction.DateCaluclator();
				String transaction = "Date: " + date + "          Transaction Type: Withdrawal       Amount: " + with
						+ "\n";
				new BankAppGui(a).textArea.append(transaction);
				AccountReader.updateAccountDatabase();

				String t = new BankAppGui(a).textArea.getText();

				boolean accountNotFound = true;
				for (int j = 0; j < TransactionReader.transactionList.size(); j++) {

					if (a.getName().contentEquals(TransactionReader.transactionList.get(j).account.getName())
							&& a.getAccountNumber() == TransactionReader.transactionList.get(j).account
									.getAccountNumber()) {

						TransactionReader.transactionList.get(j).transaction = t;
						accountNotFound = false;
					}

				}

				if (accountNotFound == true) {
					TransactionReader.transactionList.add(new Transaction(t, a));
				}

				TransactionReader.updateTransactionDatabase();
			}
		}
	}

	/**
	 * The private class Exit is called when the exit Jbutton is clicked and closes the withdraw money GUI.
	 * This class also initializes a new home page GUI with an updated account balance.
	 */
	private class Exit implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			String b = String.format("%.2f", a.getBalance());
			new BankAppGui(a).balance.setText("Current Balance: $" + b + "       ");
			frame.dispose();
		}
	}

	/**
	 * The withdrawCheck method checks to see if the withdrawal entered by the user only contains numbers.
	 * @param s the withdrawal that is being checked for non-numerical values.
	 * @return true if the withdrawal only contains numerical values and false otherwise.
	 */
	public boolean withdrawCheck(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * The withdrawPosCheck method checks to see if the withdrawal is positive.
	 * @param s the withdrawal that is being checked to see if it is a positive value.
	 * @return true if the withdrawal is positive and false otherwise.
	 */
	public boolean withdrawPosCheck(String s) {
		if ((s.substring(0, 1)).equals("-")) {
			return false;
		}
		return true;
	}
}