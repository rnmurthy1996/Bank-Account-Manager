import javax.swing.JLabel;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * 
 * LoginGui.java is used to create the login GUI of our program. This GUI is
 * accessed when BankAppRunner.java is run. This GUI allows the user to login to
 * their account. If they do not have an account, the can click on the create
 * account button to create a new account.
 * 
 * @author Rohan Murthy
 * @author Sridhar Varala
 *
 */
public class LoginGui {

	private JFrame frame;

	private JPanel un;
	private JPanel pw;
	private JPanel buttons;
	private JPanel incorrect;

	private JLabel username;
	private JTextField usernameText;
	private JLabel password;
	private JTextField passwordText;

	private JButton login;
	private JButton createAccount;
	private JButton exit;

	private JLabel incorrectMessage;

	public static Account workingAccount;

	/**
	 * The layoutManager method initializes all of the panels used by
	 * DepositGui.java.
	 */
	private void layoutManager() {

		frame = new JFrame("Bank Application");
		frame.setSize(300, 175);
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

		buttons = new JPanel();
		buttons.setLayout(new FlowLayout());
		buttons.setSize(50, 200);
		frame.add(buttons);

		incorrect = new JPanel();
		incorrect.setBackground(Color.white);
		incorrect.setLayout(new FlowLayout());
		incorrect.setSize(50, 200);
		frame.add(incorrect);
	}

	/**
	 * The createGui method is used to initialize the GUI which contains the
	 * required panels, labels, buttons, etc.
	 */
	public void createGui() {

		layoutManager();

		username = new JLabel("Username:");
		password = new JLabel("Password:");
		usernameText = new JTextField();
		passwordText = new JPasswordField();
		usernameText.setColumns(10);
		passwordText.setColumns(10);

		un.add(username);
		un.add(usernameText);
		pw.add(password);
		pw.add(passwordText);

		login = new JButton("Login");
		createAccount = new JButton("Create Account");
		exit = new JButton("Exit");

		buttons.add(login);
		buttons.add(createAccount);
		buttons.add(exit);

		incorrectMessage = new JLabel("                                  ");
		incorrectMessage.setAlignmentX(incorrect.CENTER_ALIGNMENT);
		incorrect.add(incorrectMessage);

		frame.setVisible(true);

		login.addActionListener(new Login());
		createAccount.addActionListener(new CreateAccount());
		exit.addActionListener(new Exit());
	}

	/**
	 * The private class Login is called when the login Jbutton is clicked. This
	 * class logs the user into their account and opens the home page GUI. The
	 * values entered in the username and password fields are checked for
	 * verification with the account database in this class to ensure proper
	 * credentials.
	 */
	private class Login implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			String user = usernameText.getText();
			String pass = passwordText.getText();

			AccountReader.readAccountcsv();

			for (int i = 0; i < AccountReader.accountlist.size(); i++) {
				if (AccountReader.accountlist.get(i).loginAuthentication(user, pass) == true) {
					workingAccount = AccountReader.accountlist.get(i);

					new BankAppGui(AccountReader.accountlist.get(i)).createGui();
					TransactionReader.readTransactioncsv();
					for (int j = 0; j < TransactionReader.transactionList.size(); j++) {

						if (workingAccount.getName()
								.contentEquals(TransactionReader.transactionList.get(j).account.getName())
								&& workingAccount.getAccountNumber() == TransactionReader.transactionList.get(j).account
										.getAccountNumber()) {
							new BankAppGui(workingAccount).textArea
									.append(blankLineRemove(TransactionReader.transactionList.get(j).transaction));
						}

					}

					frame.dispose();
				}
			}
			incorrectMessage.setText("Incorrect Username or Password");
			incorrectMessage.setForeground(Color.red);
		}
	}

	/**
	 * The private class CreateAccount is called when the createAccount Jbutton is
	 * clicked and opens the create account GUI.
	 */
	private class CreateAccount implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			new CreateAccountGui().createGui();
			frame.dispose();
		}
	}

	/**
	 * The private class Exit is called when the exit Jbutton is clicked and closes
	 * the login GUI.
	 */
	private class Exit implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			frame.dispose();
		}
	}
	
	public String blankLineRemove(String s) {
		String out = s.replace(" \n", "");
		out = out.replace("\n\n", "\n");
		out = out.replace("\n Date", "Date");
		return out;
	}
}