package synchronizedMethods;

public class Account {
	private double balance = 0;

	public synchronized void deposit(double amt) {
		double local = balance;
		
		local = local + amt;
		balance = local;
	}

	public synchronized void withdrawal(double amt) {
		double local = balance;
		
		local = local - amt;
		balance = local;

	}

	public synchronized double getBalance() {
		return balance;	
	}
}