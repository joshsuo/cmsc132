package explicitLockObj;

public class NormalBuyer extends Thread {
	private Account account;
	private Object lockObj;
	
	public NormalBuyer(Account account, Object lockObj) {
		this.account = account;
		this.lockObj = lockObj;
	}

	public void run() {
		System.out.println("Normal buyer about to deposit");
		synchronized(lockObj) {
	
			account.deposit(999);
		}
		
		System.out.println("Window shopping by Normal buyer");
		
		System.out.println("Normal buyer is now buying");
		synchronized(lockObj) {
			account.withdrawal(100);
		}		
	}
}