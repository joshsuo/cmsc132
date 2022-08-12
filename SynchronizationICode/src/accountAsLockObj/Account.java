package accountAsLockObj;

public class Account {
	private double balance = 0;
	
	public void deposit(double amt) {
		double local = balance;
		local = local + amt;
		balance = local;
	}

	public void withdrawal(double amt) {
		double local = balance;	
		local = local - amt;
		balance = local;
	}
	
	public double getBalance() {
		return balance;
	}
}
