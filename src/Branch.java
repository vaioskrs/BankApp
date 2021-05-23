import java.util.ArrayList;


public class Branch {
	private String code;
	private String address;
	
	private ArrayList<Client> clients;
	
	public Branch(String code, String address) {
		this.code = code;
		this.address = address;
		clients = new ArrayList<Client>();
	}
	
	public void addClient(Client c){
		clients.add(c);
	}
	
	public Client getClientWithAFM(String afm){
		for(Client c : clients){
			if(c.getAFM().equals(afm)){
				return c;
			}
		}
		return null;
	}
	
	public boolean containsClientWithAFM(String afm){
		for(Client c : clients){
			if(c.getAFM().equals(afm)){
				return true;
			}
		}
		return false;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String toString(){
		return code;
	}

	public void printAllAccounts() {
		for(Client c : clients){
			System.out.println("Client "+c.getName());
			c.printAllAccounts();
		}
	}

}
