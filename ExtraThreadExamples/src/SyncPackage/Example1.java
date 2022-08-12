package SyncPackage;
public class Example1 {

     static int  x = 0;
    
     synchronized static void task ()    //since method is static will lock on the Example1 class 
	{
		for (int i = 0; i<5000; i++)
		{	
			x++;
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println(Thread.currentThread().getName() +": "+ x);
	}
	
	
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread t1 = new Thread (()-> {task();});
		Thread t2 = new Thread (()-> {task();});
		
		long startTime = System.currentTimeMillis(); // starting the clock
		t1.start();
		t2.start();
		
		t1.join();
	    t2.join();
	    long elapsed = System.currentTimeMillis() - startTime; // stopping the clock
	    
	    System.out.println("Time elapsed in milliseconds: " + elapsed);
		System.out.println(x); //should be 10,000
		
		
		
	}

}
