package explicitLockObj;

public class ExcessiveBuyer extends Thread {
	private Account account;
	private Object lockObj;
	
	public ExcessiveBuyer(Account account, Object lockObj) {
		this.account = account;
		this.lockObj = lockObj;
	}

	public void run() {
		System.out.println("Excessive buyer about to deposit");
		synchronized(lockObj) {
			account.deposit(2000);
		}
		
		System.out.println("Window shopping by Excessive buyer");
		System.out.println("Window shopping by Excessive buyer");
		System.out.println("Window shopping by Excessive buyer");
		
		System.out.println("Excessive buyer is now buying");
		synchronized(lockObj) {
			account.withdrawal(1999);
		}
	}
}
