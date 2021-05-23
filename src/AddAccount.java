import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class AddAccount extends JFrame{
	
	private JTextField codeTXT, balanceTXT;
	private JButton addAccountButton;
	private Client client;
	
	public AddAccount(Client c){
		super("Καταχώρηση Λογαριασμού");
		this.client = c;
		JPanel masterPanel = new JPanel();
		masterPanel.setLayout(new 
						BoxLayout(masterPanel, BoxLayout.Y_AXIS));
		codeTXT = new JTextField(10);
		balanceTXT = new JTextField(10);
		addAccountButton = new JButton("Καταχώρηση");
		addAccountButton.addActionListener(new MyListener());
		masterPanel.add(new JLabel("Αριθμός"));
		masterPanel.add(codeTXT);
		masterPanel.add(new JLabel("Υπόλοιπο"));
		masterPanel.add(balanceTXT);
		masterPanel.add(addAccountButton);
		
		this.setContentPane(masterPanel);
		this.pack();
		this.setVisible(true);
	}
	
	class MyListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String accCode = codeTXT.getText();
			String accBals = balanceTXT.getText();
			double balance = Double.parseDouble(accBals);
			Account ac = new Account(accCode, balance, 0.1);
			client.addAccount(ac);
		}
		
	}
	
	

}
