package SyncPackage;
public class Example2 {

     static int  x = 0;
     static Object lock = new Object(); //shared lock by all instances
    
    static void task ()  
	{
		for (int i = 0; i<5000; i++)
		{	
			synchronized(lock)
			{
				x++;
			}
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
