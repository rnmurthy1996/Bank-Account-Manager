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
public class BankAppGui {

	// instance variables

	JFrame frame; // used to create frame
	JPanel p ;
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
		frame.setSize(700, 400);
		frame.getContentPane().setBackground(Color.pink);
		frame.setLayout(new FlowLayout());
		p = new JPanel();
		p.setSize(50, 300);
		frame.add(p);
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
		
		button1 = new JButton("Deposit");
		button2 = new JButton("Withdraw");
		button3 = new JButton("Transfer");
		button4 = new JButton("Exit");
		p.add(button1);
		p.add(button2);
		p.add(button3);
		p.add(button4);
		label1 = new JLabel("Account Number:");
		label2 = new JLabel("Account Name:");
		label3 = new JLabel("Expire Date:");
		label4 = new JLabel("Account Balance:");
		p.add(label1);
		p.add(label2);
		p.add(label3);
		p.add(label4);

		field1 = new JTextField();
		field2 = new JTextField();
		field3 = new JTextField();
		field4 = new JTextField();
		p.add(field1);
		p.add(field2);
		p.add(field3);
		p.add(field4);

		frame.setVisible(true);
		button1.addActionListener(new DepositMoney());
		button1.addActionListener(new WithdrawMoney());
		button1.addActionListener(new TransferMoney());
		button1.addActionListener(new Exit());
		
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
	private class DepositMoney implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			// implement the Code to handle button click goes here
			
			
			
			
			
			
			
			
			
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
