import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * 
 * MoneyTransferGui.java is used to create the money transfer GUI of our
 * program. This GUI is accessed when the user clicks the money transfer button
 * in the home page GUI. This GUI allows the user to transfer money from their
 * account to another external account.
 * 
 * @author Rohan Murthy
 * @author Sridhar Varala
 *
 */
public class MoneyTransferGui {

	private JFrame frame;

	private JPanel balance;
	private JPanel number;
	private JPanel buttons;

	private JPanel accType;
	private JPanel amount;
	private JPanel error;

	private JLabel balanceLabel;
	private JLabel AccountNumber;
	private JTextField AccountNumberText;
	private JLabel accountTypeText;
	private JComboBox accountType;

	private JLabel transferLabel;
	private JTextField dollarsText;
	private JLabel dot;
	private JTextField centsText;

	private JButton send;
	private JButton exit;

	private JLabel transferErr;
	private JLabel accErr;
	private JLabel fundsErr;

	/**
	 * The layoutManager method initializes all of the panels used by
	 * DepositGui.java.
	 */
	private void layoutManager() {

		frame = new JFrame("Bank Application");
		frame.setSize(300, 265);
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.white);
		frame.setLayout(new FlowLayout());

		balance = new JPanel();
		balance.setLayout(new FlowLayout());
		balance.setSize(100, 300);
		frame.add(balance);

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

		error = new JPanel();
		error.setBackground(Color.white);
		error.setLayout(new BoxLayout(error, BoxLayout.Y_AXIS));
		error.setSize(50, 200);
		frame.add(error);

	}

	/**
	 * The createGui method is used to initialize the GUI which contains the
	 * required panels, labels, buttons, etc.
	 */
	public void createGui() {

		layoutManager();

		String b = String.format("%.2f", new LoginGui().workingAccount.getBalance());
		balanceLabel = new JLabel("Current Balance: $" + b);
		balance.add(balanceLabel);

		AccountNumber = new JLabel("Select Account Number:");
		AccountNumberText = new JTextField();
		AccountNumberText.setColumns(10);
		number.add(AccountNumber);
		number.add(AccountNumberText);

		accountTypeText = new JLabel("Select Account Type:");
		String[] at = { "Checking", "Saving" };
		accountType = new JComboBox(at);
		accType.add(accountTypeText);
		accType.add(accountType);

		transferLabel = new JLabel("Transfer Amount:");
		dollarsText = new JTextField();
		dollarsText.setColumns(7);
		dot = new JLabel(".");
		centsText = new JTextField();
		centsText.setColumns(3);
		centsText.setDocument(new JTextFieldLimit(2));

		amount.add(transferLabel);
		amount.add(dollarsText);
		amount.add(dot);
		amount.add(centsText);

		send = new JButton("Send");
		exit = new JButton("Exit");

		buttons.add(send);
		buttons.add(exit);

		transferErr = new JLabel("                                                                            ");
		error.add(transferErr);
		transferErr.setAlignmentX(error.CENTER_ALIGNMENT);

		accErr = new JLabel("                                                                            ");
		error.add(accErr);
		accErr.setAlignmentX(error.CENTER_ALIGNMENT);

		fundsErr = new JLabel("                                                                            ");
		error.add(fundsErr);
		fundsErr.setAlignmentX(error.CENTER_ALIGNMENT);

		frame.setVisible(true);

		send.addActionListener(new transfer());
		exit.addActionListener(new Exit());
	}

	/**
	 * The private class transfer is called when the send Jbutton is clicked. This
	 * class transfers money from theor account to a seprate external account. The
	 * account number is checked in this class for validity with the account
	 * database. The transfer amount is a checked in this class to ensure that it is
	 * a valid amount (no spaces, letters, negative values, etc.) and that
	 * sufficient funds are available for transfer.
	 */
	private class transfer implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			double transferAmount = 0;

			if (dollarsText.getText().isEmpty() == true) {
				transferErr.setText("Tranfer Amount Field Cannot Be Empty");
				transferErr.setForeground(Color.red);
			} else if (transferPosCheck(dollarsText.getText()) == false) {
				transferErr.setText("Transfer Amount Must Be Positive");
				transferErr.setForeground(Color.red);
			} else if (transferCheck(dollarsText.getText()) == false) {
				transferErr.setText("Transfer Amount Must Be Numerical");
				transferErr.setForeground(Color.red);
			} else if (centsText.getText().isEmpty() == true) {
				transferErr.setText("Tranfer Amount Field Cannot Be Empty");
				transferErr.setForeground(Color.red);
			} else if (transferPosCheck(centsText.getText()) == false) {
				transferErr.setText("Transfer Amount Must Be Positive");
				transferErr.setForeground(Color.red);
			} else if (transferCheck(centsText.getText()) == false) {
				transferErr.setText("Transfer Amount Must Be Numerical");
				transferErr.setForeground(Color.red);
			} else {
				if (centsText.getText().length() == 1) {
					transferAmount = Double.parseDouble(dollarsText.getText())
							+ Double.parseDouble(centsText.getText()) / 10;
					transferErr.setText("                                                                            ");
				} else {
					transferAmount = Double.parseDouble(dollarsText.getText())
							+ Double.parseDouble(centsText.getText()) / 100;
					transferErr.setText("                                                                            ");
				}
			}

			Account toAccount = null;

			Account fromAccount = new LoginGui().workingAccount;
			int number = 0;
			boolean accCheck = false;

			if (AccountNumberText.getText().isEmpty() == true) {
				accErr.setText("Account Information Invalid");
				accErr.setForeground(Color.red);
			} else if (transferCheck(AccountNumberText.getText()) == false) {
				accErr.setText("Account Information Invalid");
				accErr.setForeground(Color.red);
			} else {
				number = Integer.parseInt(AccountNumberText.getText());
				accErr.setText("                                                                            ");
			}

			String accType = accountType.getSelectedItem().toString();

			for (int i = 0; i < AccountReader.accountlist.size(); i++) {

				int aNumber = AccountReader.accountlist.get(i).getAccountNumber();
				String aType = AccountReader.accountlist.get(i).getType();
				if (number == aNumber && accType.contentEquals(aType)) {

					toAccount = AccountReader.accountlist.get(i);

					accCheck = true;

				}

			}

			if (transferAmount > new LoginGui().workingAccount.getBalance()) {
				transferErr.setText("Insufficient Funds For Transfer");
				transferErr.setForeground(Color.red);
			} else if (transferAmount != 0) {
				transferErr.setText("                                                                            ");
			}

			if (accCheck == false) {
				accErr.setText("Account Information Invalid");
				accErr.setForeground(Color.red);
			}

			else if (transferAmount > 0 && transferAmount <= new LoginGui().workingAccount.getBalance()
					&& accCheck == true) {

				fromAccount.moneyTransfer(toAccount, transferAmount);
				String bal = String.format("%.2f", fromAccount.getBalance());

				new BankAppGui(fromAccount).balance.setText("Current Balance: $" + bal + "       ");
				balanceLabel.setText("Current Balance: $" + bal);

				String ta = String.format("%.2f", transferAmount);
				String date = Transaction.DateCaluclator();
				String transaction = "Date: " + date + "          Transaction Type: Transfer      Amount: " + ta
						+ "       Destination Account: " + toAccount.getName() + "\n";
				new BankAppGui(fromAccount).textArea.append(transaction);

				transferErr.setText(" ");
				accErr.setText("                                                                          ");
				fundsErr.setText("                                                                            ");

				AccountReader.updateAccountDatabase();

				String t = new BankAppGui(fromAccount).textArea.getText();

				boolean accountNotFound = true;
				for (int j = 0; j < TransactionReader.transactionList.size(); j++) {

					if (fromAccount.getName().contentEquals(TransactionReader.transactionList.get(j).account.getName())
							&& fromAccount.getAccountNumber() == TransactionReader.transactionList.get(j).account
									.getAccountNumber()) {

						TransactionReader.transactionList.get(j).transaction = t;
						accountNotFound = false;
					}

				}

				if (accountNotFound == true) {
					TransactionReader.transactionList.add(new Transaction(t, fromAccount));
				}

				TransactionReader.updateTransactionDatabase();
			}

		}
	}

	/**
	 * The private class Exit is called when the exit Jbutton is clicked and closes
	 * the money transfer GUI.
	 */
	private class Exit implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			frame.dispose();
		}
	}

	/**
	 * The transferCheck method checks to see if the transfer amount entered by the
	 * user only contains numbers.
	 * 
	 * @param s the transfer amount that is being checked for non-numerical values.
	 * @return true if the transfer amount only contains numerical values and false
	 *         otherwise.
	 */
	public boolean transferCheck(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}

	/**
	 * The transferPosCheck method checks to see if the transfer amount is positive.
	 * 
	 * @param s the transfer amount that is being checked to see if it is a positive
	 *          value.
	 * @return true if the transfer amount is positive and false otherwise.
	 */
	public boolean transferPosCheck(String s) {
		if ((s.substring(0, 1)).equals("-")) {
			return false;
		}
		return true;
	}
}