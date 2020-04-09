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
public class CreateAccountGui {

	// instance variables

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

	/**
	 * This method is used to design the layout for the GUI.
	 */
	private void layoutManager() {
		
		frame = new JFrame("Bank Application");
		frame.setSize(400, 200);
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

	/*
	 * This method creates and perform various actions associated with in the GUI.
	 */
	public void createGui() {

		layoutManager() ;
		
		username = new JLabel("Create Username:");
		password = new JLabel("Create Password:");
		usernameText = new JTextField();
		passwordText = new JTextField();
		usernameText.setColumns(10);
		passwordText.setColumns(10);

		un.add(username);
		un.add(usernameText);
		pw.add(password);
		pw.add(passwordText);
		
		createAccount = new JButton("Create Account");
		exit = new JButton("Exit");
		
		buttons.add(createAccount);
		buttons.add(exit);
		
		incorrectMessage = new JLabel("");
		incorrect.add(incorrectMessage);
		
		frame.setVisible(true);
		
		createAccount.addActionListener(new CreateAccount());
		exit.addActionListener(new Exit());
	}

	//Internal class to perform action associated to the button.
	private class CreateAccount implements ActionListener {
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
}
