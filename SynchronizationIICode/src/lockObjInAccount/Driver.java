package lockObjInAccount;

public class Driver {
	public static void main(String[] args) {
		Account sharedAccount = new Account();
		Thread excessiveBuyer = new ExcessiveBuyer(sharedAccount);
		Thread normalBuyer = new NormalBuyer(sharedAccount);
		
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
