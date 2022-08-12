package synchronizedMethods;

public class NormalBuyer extends Thread {
	private Account account;

	public NormalBuyer(Account account) {
		this.account = account;
	}

	public void run() {
		System.out.println("Normal buyer about to deposit");
		account.deposit(999);

		System.out.println("Window shopping by Normal buyer");

		System.out.println("Normal buyer is now buying");
		account.withdrawal(100);		
	}
}