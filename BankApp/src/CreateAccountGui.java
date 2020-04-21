import javax.swing.JLabel;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * 
 * CreateAccountGui.java is used to create the create account GUI of our program. This GUI is accessed when the user clicks the create account button in the login GUI.
 * This GUI allows the user to create a new account by entering the required information including username, password, account type, and initial balance.
 * @author Rohan Murthy
 * @author Sridhar Varala
 *
 */

public class CreateAccountGui {

	private JFrame frame;
	private JPanel un;
	private JPanel pw;
	private JPanel buttons;
	private JPanel incorrect;
	private JPanel accType;
	private JPanel id;

	private JLabel username;
	private JTextField usernameText;
	private JLabel password;
	private JTextField passwordText;

	private JButton login;
	private JButton createAccount;
	private JButton exit;

	private JLabel accountTypeText;
	private JComboBox accountType;

	private JLabel initialDeposit;
	private JTextField dollarsText;
	private JLabel dot;
	private JTextField centsText;

	private JLabel usernameErr;
	private JLabel passwordErr;
	private JLabel depositErr;

	/**
	 * The layoutManager method initializes all of the panels used by CreateAccountGui.java.
	 */
	private void layoutManager() {

		frame = new JFrame("Bank Application");
		frame.setSize(300, 285);
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.white);
		frame.setLayout(new FlowLayout());

		un = new JPanel();
		un.setLayout(new FlowLayout());
		un.setSize(50, 200);
		frame.add(un);

		pw = new JPanel();
		pw.setLayout(new FlowLayout());
		pw.setSize(50, 200);
		frame.add(pw);

		accType = new JPanel();
		accType.setLayout(new FlowLayout());
		accType.setSize(50, 200);
		frame.add(accType);

		id = new JPanel();
		id.setLayout(new FlowLayout());
		id.setSize(50, 200);
		frame.add(id);

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

	/**
	 * The createGui method is used to initialize the GUI which contains the required panels, labels, buttons, etc.
	 */
	public void createGui() {

		layoutManager();

		username = new JLabel("Create Username:");
		password = new JLabel("Create Password:");
		usernameText = new JTextField();
		passwordText = new JPasswordField();
		usernameText.setColumns(10);
		passwordText.setColumns(10);

		un.add(username);
		un.add(usernameText);
		pw.add(password);
		pw.add(passwordText);

		accountTypeText = new JLabel("Select Account Type:");
		String[] at = { "Checking", "Savings" };
		accountType = new JComboBox(at);
		accType.add(accountTypeText);
		accType.add(accountType);
		
		initialDeposit = new JLabel("Initial Deposit: $");
		dollarsText = new JTextField();
		dollarsText.setColumns(7);
		dot = new JLabel(".");
		centsText = new JTextField();
		centsText.setColumns(3);
		centsText.setDocument(new JTextFieldLimit(2));
		id.add(initialDeposit);
		id.add(dollarsText);
		id.add(dot);
		id.add(centsText);

		createAccount = new JButton("Create Account");
		exit = new JButton("Exit");

		buttons.add(createAccount);
		buttons.add(exit);

		usernameErr = new JLabel("                                  ");
		usernameErr.setAlignmentX(incorrect.CENTER_ALIGNMENT);
		incorrect.add(usernameErr);
		passwordErr = new JLabel("                                  ");
		passwordErr.setAlignmentX(incorrect.CENTER_ALIGNMENT);
		incorrect.add(passwordErr);
		depositErr = new JLabel("                                  ");
		depositErr.setAlignmentX(incorrect.CENTER_ALIGNMENT);
		incorrect.add(depositErr);

		frame.setVisible(true);

		createAccount.addActionListener(new CreateAccount());
		exit.addActionListener(new Exit());
	}

	/**
	 * The private class CreateAccount is called when the createAccount Jbutton is clicked and creates a new account
	 * The required information entered by the user is also checked for validity (username contains no spaces, initial deposit is numerical, etc.).
	 */
	private class CreateAccount implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
			String name = "";
			String pw = "";
			double balance = 0;

			boolean taken = false;
			AccountReader check = new AccountReader();
			check.readAccountcsv();
			for (int i = 0; i < check.accountlist.size(); i++) {
				if (usernameText.getText().equals(check.accountlist.get(i).getName())) {

					usernameErr.setText("Username Is Already Taken");
					usernameErr.setForeground(Color.red);
					taken = true;
				}
			}
			if (usernameText.getText().isEmpty() == true) {
				usernameErr.setText("Username Field Cannot Be Empty");
				usernameErr.setForeground(Color.red);
			} else if (userNameCheck(usernameText.getText()) == false) {
				usernameErr.setText("Username Cannot Contain Spaces");
				usernameErr.setForeground(Color.red);
			} else if (taken == false) {
				name = usernameText.getText();
				usernameErr.setText("                                  ");
			}

			if (passwordText.getText().isEmpty() == true) {
				passwordErr.setText("Password Field Cannot Be Empty");
				passwordErr.setForeground(Color.red);
			} else {
				pw = passwordText.getText();
				passwordErr.setText("                                  ");
			}

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
				depositErr.setText("Deposit Amount Field Cannot Be Empty");
				depositErr.setForeground(Color.red);
			} else if (depositPosCheck(centsText.getText()) == false) {
				depositErr.setText("Deposit Amount Must Be Positive");
				depositErr.setForeground(Color.red);
			} else if (depositCheck(centsText.getText()) == false) {
				depositErr.setText("Deposit Amount Must Be Numerical");
				depositErr.setForeground(Color.red);
			} else {
				if (centsText.getText().length() == 1) {
					balance = Double.parseDouble(dollarsText.getText()) + Double.parseDouble(centsText.getText()) / 10;
					depositErr.setText("                                                                            ");
				} else {
					balance = Double.parseDouble(dollarsText.getText()) + Double.parseDouble(centsText.getText()) / 100;
					depositErr.setText("                                                                            ");
				}
			}

			String accType = accountType.getSelectedItem().toString();

			if (!(name.equals("")) && !(pw.equals("")) && balance > 0) {

				if (accType.toUpperCase().contentEquals("SAVINGS")) {
					SavingAccount newAccount = new SavingAccount(name, accType, pw, balance);
					AccountReader ar = new AccountReader();
					ar.createAccountcsv(newAccount);
					frame.dispose();
					new LoginGui().createGui();
				}

				else {
					CheckingAccount newAccount = new CheckingAccount(name, accType, pw, balance);

					AccountReader ar = new AccountReader();
					ar.createAccountcsv(newAccount);
					frame.dispose();
					new LoginGui().createGui();
				}
			}
		}
	}
	
	
	/**
	 * The private class Exit is called when the exit Jbutton is clicked and closes the create account GUI.
	 * This class also initializes a new login GUI.
	 */
	private class Exit implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			// implement the Code to handle button click goes here
			frame.dispose();
			new LoginGui().createGui();
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
	 * @return true if the initial deposit only contains numerical values and false otherwise.
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
	 * The depositPosCheck method checks to see if the initial deposit is positive.
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
