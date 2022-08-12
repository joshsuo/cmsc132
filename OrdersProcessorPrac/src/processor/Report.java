package processor;


import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

public class Report implements Runnable {

	private Object lockObj; // Not static

	private int orderNumber;
	private String baseFileName;
	private TreeMap<String, Double> items;
	private TreeMap<Integer, TreeMap<String, Integer>> orders;
	private TreeMap<String, Integer> summary;
	
	public Report(int orderNumber, String baseFileName, TreeMap<String, Double> items,TreeMap<Integer, TreeMap<String, Integer>> orders,TreeMap<String, Integer> summary, Object lockObj) {
		this.orderNumber = orderNumber;
		this.items = items;
		this.baseFileName = baseFileName;
		this.orders = orders;
		this.summary = summary;
		this.lockObj = lockObj;
	}

	@Override
	public void run() {
 
		String itemName;
		String date;
		String clientId="";


		TreeMap<String, Integer> itemsOrdered = new TreeMap<String, Integer>();
		
		System.out.println("Reading order for client with id: " + (1000 + this.orderNumber));
		
		try {
			Scanner fileScanner = new Scanner(new File(this.baseFileName + this.orderNumber + ".txt"));
			if(fileScanner.hasNextLine()) {
				String caption = fileScanner.next();
				if(caption.equals("ClientId:")) {
					clientId =  fileScanner.next();
				}
			}
			
			while (fileScanner.hasNextLine()) {
				itemName = fileScanner.next();
				date = fileScanner.next();  //ignore
									 
				if(!itemsOrdered.containsKey(itemName)) {
					itemsOrdered.put(itemName, 1);
				} else {
					itemsOrdered.put(itemName, itemsOrdered.get(itemName) + 1);
				}
			}	
			fileScanner.close();	
			
		}catch(IOException ex) {
			System.err.println(ex.getMessage());
		}
		
		synchronized(this.lockObj) {
			for(String item : itemsOrdered.keySet())
			{
				if(!summary.containsKey(item))
				{
					summary.put(item, itemsOrdered.get(item));
				}else {
					summary.put(item, summary.get(item) + itemsOrdered.get(item));
				}	
			}		
			
			this.orders.put(this.orderNumber, itemsOrdered);
		}
				
	}
	
	
}
