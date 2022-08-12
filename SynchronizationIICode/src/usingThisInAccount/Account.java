package usingThisInAccount;

public class Account {
	private double balance = 0;
	
	public void deposit(double amt) {
		synchronized(this) {
			double local = balance;
			
			local = local + amt;
			balance = local;
		}
	}

	public void withdrawal(double amt) {
		synchronized(this) {
			double local = balance;
			
			local = local - amt;
			balance = local;
		}
	}
	
	public double getBalance() {
		synchronized(this) {
			return balance;
		}
	}
}