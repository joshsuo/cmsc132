package VolatilePackage;


public class Example1 {

//what happens if no volatile keyword here?
	
private volatile static boolean running = true;  


public static void main(String[] args) throws InterruptedException {
	
	
	Thread t1 = new Thread (() ->
	
	{
		int x =1;
		
		while (running)
		{
			x *= x;
			
		}
	
		System.out.println("END.  Result is " + x);
		
	});
	
	t1.start();
	
	Thread.sleep(1000);
	
	System.out.println("Stop it");
		
	
	running = false;
	
	System.out.println("Thread should print end message soon since running is false now.");
	
}

}
