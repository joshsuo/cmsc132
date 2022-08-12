package WaitandNotify;



import javax.swing.JOptionPane;

public class Example1 {

	static int account = 0;

	

	void printBalance()
	{
		Thread t = new Thread (()-> {
			
			synchronized (this)
			{	System.out.println("The balance in the account is : " + account);
			
				if (account <=0)
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				System.out.println("The balance in the account is : " + account);
				
			}
			
			
		});
		
		t.start();
	}
	
	
	void getBalance()
	{
		Thread t = new Thread (()-> {
			
			String prompt = "Enter balance: ";
			
			/* Reading values from the user */
			String valueStr = JOptionPane.showInputDialog(prompt);
			
			synchronized (this)
			{
				account =Integer.parseInt(valueStr);
				notify();
			
				
				
			}
			
			
		});
		t.start();
		
	}
	public static void main(String[] args) throws InterruptedException {
		
		Example1  e =new Example1();
	
		e.printBalance();
		Thread.sleep(1000);
		e.getBalance();
		
	
		


	}

}
