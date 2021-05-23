
public class Account {

	private String code;
	private double balance;
	private double interest;
	
	public Account(String code, double balance, double interest) {
		this.code = code;
		this.balance = balance;
		this.interest = interest;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getInterest() {
		return interest;
	}
	public void setInterest(double interest) {
		this.interest = interest;
	}
	
	
}
