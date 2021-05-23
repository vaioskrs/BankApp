import javax.swing.DefaultListModel;


public class Main {
	
	public static void main(String...args){
		
		Branch b1 = new Branch("123", "Tsimiski 18");
		Branch b2 = new Branch("666", "B. Olgas 158");
		Branch b3 = new Branch("859", "Egnatia 124");
		
		DefaultListModel listModel = new DefaultListModel();
		
		listModel.addElement(b1);
		listModel.addElement(b2);
		listModel.addElement(b3);
				
		new MainFrame(listModel);
		
	}

}
