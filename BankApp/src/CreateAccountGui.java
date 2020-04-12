import javax.swing.JLabel;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * This class is for building the Gui for the Bank App.
 * 
 * @author Sridhar.Varala
 *
 */
public class CreateAccountGui {

	// instance variables

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
	 * This method is used to design the layout for the GUI.
	 */
	private void layoutManager() {
		
		frame = new JFrame("Bank Application");
		frame.setSize(300, 300);
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

	/*
	 * This method creates and perform various actions associated with in the GUI.
	 */
	public void createGui() {

		layoutManager() ;
		
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
		String [] at = {"Checking", "Saving"};
		accountType = new JComboBox(at);
		accType.add(accountTypeText);
		accType.add(accountType);
		
		initialDeposit = new JLabel("Initial Deposit:");
		dollarsText = new JTextField();
		dollarsText.setColumns(7);
		dot = new JLabel(".");
		centsText = new JTextField();
		centsText.setColumns(3);
		id.add(initialDeposit);
		id.add(dollarsText);
		id.add(dot);
		id.add(centsText);
		
		createAccount = new JButton("Create Account");
		exit = new JButton("Exit");
		
		buttons.add(createAccount);
		buttons.add(exit);
		
		usernameErr = new JLabel("");
		incorrect.add(usernameErr);
		usernameErr.setAlignmentX(incorrect.CENTER_ALIGNMENT);
		passwordErr = new JLabel("");
		incorrect.add(passwordErr);
		passwordErr.setAlignmentX(incorrect.CENTER_ALIGNMENT);
		depositErr = new JLabel("");
		incorrect.add(depositErr);
		depositErr.setAlignmentX(incorrect.CENTER_ALIGNMENT);
		
		frame.setVisible(true);
		
		createAccount.addActionListener(new CreateAccount());
		//exit.addActionListener(new Exit());
	}

	//Internal class to perform action associated to the button.
	private class CreateAccount implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			// implement the Code to handle button click goes here
			
			String name = "";
			String pw = "";
			double balance = 0;
			
			if(usernameText.getText().isEmpty() == true) {
				usernameErr.setText("Username is empty");
				usernameErr.setForeground(Color.red);
			}
			else if(userNameCheck(usernameText.getText()) == false){
				usernameErr.setText("Username cannot contain spaces");
				usernameErr.setForeground(Color.red);
			}
			else {
				name = usernameText.getText();
				usernameErr.setText("");
			}
			
			if(passwordText.getText().isEmpty() == true) {
				passwordErr.setText("Password is empty");
				passwordErr.setForeground(Color.red);
			}
			else {
				pw = passwordText.getText();
				passwordErr.setText("");
			}
			
			if(dollarsText.getText().isEmpty() == true) {
				depositErr.setText("Deposit is empty");
				depositErr.setForeground(Color.red);
			}
			else if(depositPosCheck(dollarsText.getText()) == false) {
				depositErr.setText("Deposit must be positive");
				depositErr.setForeground(Color.red);
			}
			else if(depositCheck(dollarsText.getText()) == false) {
				depositErr.setText("Deposit must be numerical");
				depositErr.setForeground(Color.red);
			}
			else if(centsText.getText().isEmpty() == true) {
				depositErr.setText("Deposit is empty");
				depositErr.setForeground(Color.red);
			}
			else if(depositPosCheck(centsText.getText()) == false) {
				depositErr.setText("Deposit must be positive");
				depositErr.setForeground(Color.red);
			}
			else if(depositCheck(centsText.getText()) == false) {
				depositErr.setText("Deposit must be numerical");
				depositErr.setForeground(Color.red);
			}
			else {
				balance = Double.parseDouble(dollarsText.getText()) + Double.parseDouble(centsText.getText())/100;
				depositErr.setText("");
			}
			
			String accType = accountType.getSelectedItem().toString();
			
			if(!(usernameText.getText().equals("")) && !(passwordText.getText().equals("")) && balance > 0) {
				if(accType.toUpperCase().contentEquals("SAVING"))
				{
				SavingAccount newAccount = new SavingAccount(name, accType, pw, balance);
				
				AccountReader ar = new AccountReader();
				ar.createAccountcsv(newAccount);
				frame.dispose();
				new LoginGui().createGui();
				}
				else {
					
					if(accType.toUpperCase().contentEquals("CHECKING"))
					{
					CheckingAccount newAccount = new CheckingAccount(name, accType, pw, balance);
					
					AccountReader ar = new AccountReader();
					ar.createAccountcsv(newAccount);
					frame.dispose();
					new LoginGui().createGui();
				}
			}
		}
	}
	}
	
	//Internal class to perform action associated to the button.
	private class Exit implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			// implement the Code to handle button click goes here
			frame.dispose();
			new LoginGui().createGui();
		}
	}
	
	public boolean userNameCheck(String s) {
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == ' ') {
				return false;
			}
		}
		return true;
	}
	
	public boolean depositCheck(String s) {
		for(int i = 0; i < s.length(); i++) {
			if(Character.isDigit(s.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}
	
	public boolean depositPosCheck(String s) {
		if((s.substring(0,1)).equals("-")) {
			return false;
		}
		return true;
	}
	
}
