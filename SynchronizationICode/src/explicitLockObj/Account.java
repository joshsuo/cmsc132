package explicitLockObj;

public class Account {
	private double balance = 0;
	
	public void deposit(double amt)  {
		double local = balance;
		
		//remove comment to see data race when not synchronized
	/*	try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
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
