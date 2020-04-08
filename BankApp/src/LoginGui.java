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
public class LoginGui {

	// instance variables

	JFrame frame; // used to create frame
	JPanel p ;
	JPanel p2 ;
	JPanel p3 ;
	JLabel label1; // used to label for Account number
	JTextField field1; //
	JLabel label2; // used to label account balance
	JTextField field2; // used to display account balance
	JLabel label3; // used to label for Account name;
	JTextField field3;// used to display Account name;
	JLabel label4; // used to label account expire date
	JTextField field4; // used to display account expire date
	JButton button1; // used for Deposit (action method is needed when user clicks the button)
	JButton button2; // used for Withdraw (action method is needed when user clicks the button)
	JButton button3; // used for money transfer(action method is needed when user clicks the button)
	JButton button4; // used to exit gui (action method is needed when user clicks the button)
	JComboBox<String> box; // used to select account number
	
	
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
	private void layoutManager() {
		frame = new JFrame("Bank Application");
		frame.setSize(250, 150);
		frame.getContentPane().setBackground(Color.white);
		frame.setLayout(new FlowLayout());
		p = new JPanel();
		p.setLayout(new FlowLayout());
		p.setSize(50, 200);
		frame.add(p);
		p2 = new JPanel();
		p2.setLayout(new FlowLayout());
		p2.setSize(50, 200);
		frame.add(p2);
		p3 = new JPanel();
		p3.setLayout(new FlowLayout());
		p3.setSize(50, 200);
		frame.add(p3);
	/**
	 * 
	 * 
	 * Add your code to augment the design layout
	 * please use GROUP Layout or Grid layout which ever makes appearance good.
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	}

	/*
	 * This method creates and perform various actions associated with in the GUI.
	 */
	public void createGui() {

		layoutManager() ;
		
		label1 = new JLabel("Username:");
		label2 = new JLabel("Password:");

		field1 = new JTextField();
		field2 = new JTextField();
		field1.setColumns(10);
		field2.setColumns(10);

		p.add(label1);
		p.add(field1);
		p2.add(label2);
		p2.add(field2);



		
		button1 = new JButton("Login");
		p3.add(button1);
		
		frame.setVisible(true);
		button1.addActionListener(new Login());
		
		
		/*
		 * Add your code here to create further interface.
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		
	}

//Internal class to perform action associated to the button.
	private class Login implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			// implement the Code to handle button click goes here
			String username = field1.getText();
			String password = field2.getText();
			
			AccountReader ar = new AccountReader();
			ar.readAccountcsv();
			for(int i=0; i < ar.accountlist.size(); i++) {
				if(username.equals(ar.accountlist.get(i).getName()) && password.equals(ar.accountlist.get(i).getPassword())) {
					new BankAppGui(ar.accountlist.get(i)).createGui();
				}
			}
			
			
			
		}
	}

	//Internal class to perform action associated to the button.
	private class WithdrawMoney implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			// implement the Code to handle button click goes here
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
	}

	//Internal class to perform action associated to the button.
	private class TransferMoney implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			// implement the Code to handle button click goes here
			
			
			
			
			
			
			
			
			
			
			
			
		}
	}

	//Internal class to perform action associated to the button.
	private class Exit implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			// implement the Code to handle button click goes here
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
	}

	/**
	 * Add your code to perform any extra action items.
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	
}
