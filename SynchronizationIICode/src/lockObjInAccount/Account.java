package lockObjInAccount;

public class Account {
	private double balance = 0;
	private Object lockObj = new Object();
	
	public void deposit(double amt) {
		synchronized(lockObj) {
			double local = balance;
			
			local = local + amt;
			balance = local;
		}
	}

	public void withdrawal(double amt) {
		synchronized(lockObj) {
			double local = balance;
			
			local = local - amt;
			balance = local;
		}
	}
	
	public double getBalance() {
		synchronized(lockObj) {
			return balance;
		}
	}
}