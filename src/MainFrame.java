import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class MainFrame extends JFrame{
	
	private JTextField afmTXT;
	private JTextField clientNameTXT;
	private JList branchList;
	private JButton addClientButton;
	private JButton addAccountButton;
	private JButton printAccountsButton;

	public MainFrame(DefaultListModel dlm){
		super("Branch and Client Manager System");
		JPanel masterPanel = new JPanel();
		JPanel leftPanel = new JPanel();
		JPanel rightPanel = new JPanel();
		BoxLayout boxLayout = new BoxLayout(rightPanel,BoxLayout.Y_AXIS);
		rightPanel.setLayout(boxLayout);
		
		afmTXT = new JTextField(30);
		clientNameTXT = new JTextField(30);
		addClientButton = new JButton("Καταχώρηση πελάτη");
		addClientButton.addActionListener(new AddClientListener());
		addAccountButton = new JButton("Καταχώρηση Λογαριασμού");
		addAccountButton.addActionListener(new AddAccountListener());
		printAccountsButton = new JButton("Εμφάνιση Λογαριασμών");
		printAccountsButton.addActionListener(new PrintListener());
		
		rightPanel.add(new JLabel("ΑΦΜ:"));
		rightPanel.add(afmTXT);
		rightPanel.add(new JLabel("Ονοματεπώνυμο Πελάτη:"));
		rightPanel.add(clientNameTXT);
		rightPanel.add(addClientButton);
		rightPanel.add(addAccountButton);
		rightPanel.add(printAccountsButton);
		
		branchList = new JList();
		branchList.setModel(dlm);
		leftPanel.add(branchList);
		
		masterPanel.add(leftPanel, BorderLayout.LINE_START);
		masterPanel.add(rightPanel, BorderLayout.LINE_END);
		
		this.setContentPane(masterPanel);
		
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);		
	}
	
	class AddClientListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(branchList.getSelectedIndex() != -1){
				Object o = branchList.getSelectedValue();
				Branch branch = (Branch)o;
				if(afmTXT.getText().length() > 0) {
					String afm = afmTXT.getText();
					String name = clientNameTXT.getText();
					if(!branch.containsClientWithAFM(afm)){
						Client c = new Client(name, afm);
						branch.addClient(c);
						JOptionPane.showMessageDialog(null, "Επιτυχής δημιουργία πελάτη!");
					}
					else{
						JOptionPane.showMessageDialog(null, 
								"Ο πελάτης με ΑΦΜ "+afm+" υπάρχει ήδη!");
					}
				}
			}
		}
	}
	
	class AddAccountListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(afmTXT.getText().length() > 0 && branchList.getSelectedIndex() != -1){
				Branch branch = (Branch)branchList.getSelectedValue();
				Client client = branch.getClientWithAFM(afmTXT.getText());
				AddAccount frame = new AddAccount(client);
			}
		}
	}
	
	class PrintListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(branchList.getSelectedIndex() != -1){
				Branch branch = (Branch)branchList.getSelectedValue();
				branch.printAllAccounts();
			}
			
		}
		
	}
	
	
}
