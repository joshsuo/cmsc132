package explicitLockObj;

public class Driver {
	public static void main(String[] args) {
		Account sharedAccount = new Account();
		Object lockObj = new Object();
		Thread excessiveBuyer = new ExcessiveBuyer(sharedAccount, lockObj);
		Thread normalBuyer = new NormalBuyer(sharedAccount, lockObj);
		
		excessiveBuyer.start();
		normalBuyer.start();
		try {
			excessiveBuyer.join();
			normalBuyer.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(sharedAccount.getBalance());
	}
}
