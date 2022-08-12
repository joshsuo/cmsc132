package Deadlock;

public class SimpleDeadlock extends Thread{
	
	Object a;
	Object b;
	
	SimpleDeadlock(Object a, Object b)
	{
		this.a=a;
		this.b=b;
	}

	void swap(Object a, Object b) {
	     Object local;
	     synchronized(a) {
	    	try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	          synchronized(b) {
	               local = a; a = b; b = local;
	          }
	     }
	     System.out.println(Thread.currentThread().getName()+" is done!");
	}
	
	public void run()
	{
		swap(a,b);
	}

	public static void main(String[] args) {
		
		Object o1= new Object();
		Object o2= new Object();
		
		new SimpleDeadlock(o1,o2).start();
		new SimpleDeadlock(o2,o1).start();
		
		
		

	}

}
