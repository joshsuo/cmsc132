package lockObjInAccount;

public class ExcessiveBuyer extends Thread {
	private Account account;
	
	public ExcessiveBuyer(Account account) {
		this.account = account;
	}

	public void run() {
		System.out.println("Excessive buyer about to deposit");
		account.deposit(2000);
		
		System.out.println("Window shopping by Excessive buyer");
		System.out.println("Window shopping by Excessive buyer");
		System.out.println("Window shopping by Excessive buyer");
		
		System.out.println("Excessive buyer is now buying");
		account.withdrawal(1999);
	}
}
