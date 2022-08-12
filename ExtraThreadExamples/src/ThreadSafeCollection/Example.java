package ThreadSafeCollection;

import java.util.ArrayList;
import java.util.Vector;

public class Example {
	
	static ArrayList <Integer> myArrList = new ArrayList<Integer>(); //not Thread-Safe
	static Vector <Integer> myVector =  new Vector<Integer>(); //Thread-Safe

	
	public static void main(String[] args) throws InterruptedException {
		//Just adds a 1000 random value to the unsafe arrayList and safe vector
				Thread t1 = new Thread(new Runnable() {
					
					public void run()
					{
						for (int i =0 ; i <1000; i++)
						{
							
								myArrList.add((int)Math.random()*10);
								myVector.add((int)Math.random()*10);
					
							
							
						}
						
					}
					
					
				});
				
				
				//Just adds a 1000 random value to the unsafe arrayList and safe vector
				Thread t2 =new Thread(new Runnable() {
					
					public void run()
					{
						for (int i =0 ; i <1000; i++)
						{
								myArrList.add((int)Math.random()*10);
								myVector.add((int)Math.random()*10);
						
							
						}
						
					}
					
					
				});
				
				t1.start();
				t2.start();
				t1.join();
				t2.join();

		System.out.println(myArrList.size());  //should be 2000
		System.out.println(myVector.size());   //should be 2000

		
		

	}
	
}
