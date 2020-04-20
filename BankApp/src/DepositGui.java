import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * 
 * DepositGui.java is used to create the deposit window of our program. This GUI is accessed when the user clicks the deposit button in the home page GUI.
 * This GUI allows the user to deposit money into their account. The amount is determined by the user.
 * @author Rohan Murthy
 * @author Sridhar Varala
 *
 */

public class DepositGui {

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
	
	/**
	 * The layoutManager method initializes all of the panels used by DepositGui.java.
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

	/**
	 * The createGui method is used to initialize the GUI which contains the required panels, labels, buttons, etc.
	 */
	public void createGui() {

		layoutManager();

		String b = String.format("%.2f", a.getBalance());
		balanceLabel = new JLabel("Current Balance: $" + b);
		balance.add(balanceLabel);

		depositLabel = new JLabel("Deposit Amount:");
		dollarsText = new JTextField();
		dollarsText.setColumns(7);
		dot = new JLabel(".");
		centsText = new JTextField();
		centsText.setColumns(3);
		centsText.setDocument(new JTextFieldLimit(2));

		deposit.add(depositLabel);
		deposit.add(dollarsText);
		deposit.add(dot);
		deposit.add(centsText);

		depositButton = new JButton("Deposit");
		exit = new JButton("Exit");

		buttons.add(depositButton);
		buttons.add(exit);

		depositErr = new JLabel("                                                                            ");
		incorrect.add(depositErr);
		depositErr.setAlignmentX(incorrect.CENTER_ALIGNMENT);

		frame.setVisible(true);

		depositButton.addActionListener(new DepositMoney());
		exit.addActionListener(new Exit());
	}

	/**
	 * The private class DepositMoney is called when the depositButton Jbutton is clicked and deposits the user determined amount into the account.
	 * The amount is also first checked in this class to ensure that it is a valid amount (no spaces, letters, negative values, etc.)
	 */
	private class DepositMoney implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			double depositAmount = 0;

			if (dollarsText.getText().isEmpty() == true) {
				depositErr.setText("Deposit Amount Field Cannot Be Empty");
				depositErr.setForeground(Color.red);
			} else if (depositPosCheck(dollarsText.getText()) == false) {
				depositErr.setText("Deposit Amount Must Be Positive");
				depositErr.setForeground(Color.red);
			} else if (depositCheck(dollarsText.getText()) == false) {
				depositErr.setText("Deposit Amount Must Be Numerical");
				depositErr.setForeground(Color.red);
			} else if (centsText.getText().isEmpty() == true) {
				depositErr.setText("Deposit Amount Field Cannot Be Emptyy");
				depositErr.setForeground(Color.red);
			} else if (depositPosCheck(centsText.getText()) == false) {
				depositErr.setText("Deposit Amount Must Be Positive");
				depositErr.setForeground(Color.red);
			} else if (depositCheck(centsText.getText()) == false) {
				depositErr.setText("Deposit Amount Must Be Numerical");
				depositErr.setForeground(Color.red);
			} else {
				if (centsText.getText().length() == 1) {
					depositAmount = Double.parseDouble(dollarsText.getText())
							+ Double.parseDouble(centsText.getText()) / 10.00;
					depositErr.setText("                                                                            ");
				} else {
					depositAmount = Double.parseDouble(dollarsText.getText())
							+ Double.parseDouble(centsText.getText()) / 100.00;
					depositErr.setText("                                                                            ");
				}
			}

			if (depositAmount > 0) {
				a.deposit(depositAmount);
				String bal = String.format("%.2f", a.getBalance());
				balanceLabel.setText("Current Balance: $" + bal);	
				new BankAppGui(a).balance.setText("Current Balance: $" + bal + "       ");
				
				String dep = String.format("%.2f", depositAmount);
				String date = Transaction.DateCaluclator();
				String transaction = "Date: " + date + "          Transaction Type: Deposit       Amount: " + dep
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
				// TransactionReader.transactionList.add(new Transaction(t,a));
				TransactionReader.updateTransactionDatabase();
			}
		}
	}

	/**
	 * The private class Exit is called when the exit Jbutton is clicked and closes the deposit money window.
	 * This class also initializes a new home page GUI with an updated account balance.
	 */
	private class Exit implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			// implement the Code to handle button click goes here
			String b = String.format("%.2f", a.getBalance());
			new BankAppGui(a).balance.setText("Current Balance: $" + b + "       ");
			frame.dispose();
		}
	}
	
	/**
	 * The userNameCheck method checks to see if the username entered by the user contains any spaces.
	 * @param s the username that is being checked for spaces.
	 * @return true if the username does not contain any spaces and false otherwise.
	 */
	public boolean userNameCheck(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * The depositCheck method checks to see if the initial deposit entered by the user only contains numbers.
	 * @param s the initial deposit that is being checked for non-numerical values.
	 * @return true if the initial deposit only contains numberical values and false otherwise.
	 */
	public boolean depositCheck(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * The depositCheck method checks to see if the initial deposit is positive.
	 * @param s the initial deposit that is being checked to see if it is a positive value.
	 * @return true if the initial deposit is positive and false otherwise.
	 */
	public boolean depositPosCheck(String s) {
		if ((s.substring(0, 1)).equals("-")) {
			return false;
		}
		return true;
	}
}