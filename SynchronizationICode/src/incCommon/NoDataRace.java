package incCommon;

public class NoDataRace extends Thread{
	
	static int common = 0;
	Object lockObj; // Not static
	
	public NoDataRace(Object lockObj) {
	 this.lockObj = lockObj; }
	
	public void run() { 
		synchronized(lockObj) 
		{
			// only one thread will be allowed 
			// data race eliminated
		
			int local = common; 
			try {
				sleep((int) ((Math.random() * 3000)));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			local = local + 1; 
			common = local;
	}
	
	} 

	public static void main(String[] args) throws InterruptedException{
	Object lockObj = new Object(); // all threads use lockObj’s lock 
	int max = 3;
	
	NoDataRace[] allThreads = new NoDataRace[max];
	for (int i = 0; i < allThreads.length; i++)
		allThreads[i] = new NoDataRace(lockObj);
	for (NoDataRace thread : allThreads)
		thread.start();
	for (NoDataRace t : allThreads)
		t.join(); 
	System.out.println(common); // will be 3
}
}