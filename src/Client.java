import java.util.ArrayList;


public class Client {

	private String name;
	private String AFM;
	
	private ArrayList<Account> accounts;
	
	public Client(String name, String afm) {
		this.name = name;
		AFM = afm;
		accounts = new ArrayList<Account>();
	}
	
	public void addAccount(Account a){
		accounts.add(a);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAFM() {
		return AFM;
	}

	public void setAFM(String afm) {
		AFM = afm;
	}

	public void printAllAccounts() {
		for(Account c : accounts){
			System.out.println("   code: "+c.getCode()+" Balance: "+c.getBalance());
		}
	}
	
	
	
}
