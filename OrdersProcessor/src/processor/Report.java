package processor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Scanner;
import java.util.TreeMap;

public class Report implements Runnable{

	private int order;
	private TreeMap<String, Double> items;
	private TreeMap<String, Integer> itemsOrdered;
	private String baseName;
	private String resultName;
	private TreeMap<Integer, TreeMap<String, Integer>> allClientOrders;
	private Object lock;
	
	public Report(int order, TreeMap<String, Double> items, String baseName,
			TreeMap<String, Integer> itemsOrdered, TreeMap<Integer, 
			TreeMap<String, Integer>> allClientOrders, Object lock)
	{
		this.order = order;
		this.items = items;
		this.baseName = baseName;
		this.itemsOrdered = itemsOrdered;
		this.allClientOrders = allClientOrders;
		this.lock = lock;
	}
	
	
	@Override
	public void run()
	{
		TreeMap <String, Integer> clientOrders = new TreeMap<>();
		String result = "";
		double totalCost = 0;
		String item = "";
		String date = "";
		
		System.out.println("Reading order for client with id: " + (1000 + this.order));
	
		
		//Scanner file = null;
		try {
			//String fileName = (this.baseName + this.order) + ".txt";
			Scanner file = new Scanner(new File((this.baseName + this.order) + ".txt"));
			
			String name = file.next();
			String clientId = file.next();
			
			while(file.hasNextLine())
			{
				item = file.next();
				date = file.next();
				
				if(!(clientOrders.containsKey(item)))
				{
					clientOrders.put(item, 1);
				}
				else
				{
					clientOrders.put(item, clientOrders.get(item) + 1);
				}
				
			}
			file.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		synchronized(lock) {
			
			for(String itemName : clientOrders.keySet())
			{
				if(!(itemsOrdered.containsKey(itemName)))
				{
					itemsOrdered.put(itemName, clientOrders.get(itemName));
				}
				else
				{
					itemsOrdered.put(itemName, itemsOrdered.get(itemName) + clientOrders.get(itemName));
				}
			}
			
			allClientOrders.put(this.order, clientOrders);
		}
				
	}
	
	
}
