package processor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Scanner;
import java.util.TreeMap;


public class OrdersProcessor {

	private String fileName;
	private String isMultiThread;
	private int orders;
	private String baseName;
	private String resultName;
	private TreeMap<String, Double> items;
	//private TreeMap<String, Integer> itemsOrdered;
	//private TreeMap<Integer, TreeMap<String, Integer>> allClientOrders;
	
	public OrdersProcessor(String fileName, String isMultiThread, int orders, String baseName, String resultName)
	{
		this.fileName = fileName;
		this.isMultiThread = isMultiThread;
		this.orders = orders;
		this.baseName = baseName;
		this.resultName = resultName;
		this.items = new TreeMap<String, Double>();
		//this.itemsOrdered = new TreeMap<>();
		//this.allClientOrders = new TreeMap<>();
	}
	
	public void process()
	{
		
		TreeMap<Integer, TreeMap<String, Integer>> allClientOrders = new TreeMap<>();
		TreeMap<String, Integer> itemsOrdered = new TreeMap<>();
		
		//Read data file
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(this.fileName));
			String line;
			
			while ((line = bufferedReader.readLine()) != null) {
				String[] array = line.split(" ");
				
				items.put(array[0], Double.parseDouble(array[1]));
			}
			bufferedReader.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

		Object lockObj = new Object(); // all threads use lockObj’s lock
		
		long startTime = 0;
		
		if(isMultiThread.compareTo("y") != 0) {
			startTime = System.currentTimeMillis();
			for(int i = 1; i <= this.orders; i++)
			{
				Report report = new Report(i, this.items, this.baseName, 
						itemsOrdered, allClientOrders, lockObj);
				report.run();
			}
		}
		else
		{
			Thread[] allThreads = new Thread[this.orders];
			
			for (int i = 0; i < allThreads.length; i++) {
				allThreads[i] = new Thread(new Report(i+1, this.items, this.baseName, 
						itemsOrdered, allClientOrders, lockObj));
			}
			
			startTime = System.currentTimeMillis();
			
			for (Thread thread : allThreads) {
				thread.start();
			}
			
			
			try {
				for (Thread t : allThreads)
				{
					t.join();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Processing time (msec): " + (endTime - startTime));
		
		String result = "";
		double totalCost = 0;
		
		for(int orderNum : allClientOrders.keySet())
		{
			result += "----- Order details for client with Id: " + (1000 + orderNum) + " -----\n";
			
			TreeMap<String, Integer> clientOrder = allClientOrders.get(orderNum);
			for(String key : clientOrder.keySet())
			{
				double cost = items.get(key);
				int quantity = clientOrder.get(key);
				
				totalCost += (cost * quantity);
				
				result += "Item's name: "
						+ key
						+ ", Cost per item: "
						+ NumberFormat.getCurrencyInstance().format(cost)
						+ ", Quantity: "
						+ quantity
						+ ", Cost: "
						+ NumberFormat.getCurrencyInstance().format(cost * quantity) + "\n";
			}
			result += "Order Total: " + NumberFormat.getCurrencyInstance().format(totalCost) + "\n";
			
			totalCost = 0;		
		}

		result += "***** Summary of all orders *****\n";
		
		for(String key : itemsOrdered.keySet())
		{
			double cost = items.get(key);
			int quantity = itemsOrdered.get(key);
			
			result += "Summary - Item's name: "
					+ key
					+ ", Cost per item: "
					+ NumberFormat.getCurrencyInstance().format(cost)
					+ ", Number sold: "
					+ quantity
					+ ", Item's Total: "
					+ NumberFormat.getCurrencyInstance().format(cost * quantity) + "\n";
			
			totalCost += (cost * quantity);
			
		}
		result += "Summary Grand Total: " + NumberFormat.getCurrencyInstance().format(totalCost);
		
		try {
			FileWriter fileWriter = new FileWriter(resultName);
		
			fileWriter.write(result);
			
			fileWriter.close();
			System.out.println("Results can be found in the file: " + this.resultName);
			
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		
	}
	
//	private void summary()
//	{
//		String result = "";
//		double totalCost = 0;
//		
//		for(int orderNum : allClientOrders.keySet())
//		{
//			result += "----- Order details for client with Id: " + (1000 + orderNum) + " -----\n";
//			
//			TreeMap<String, Integer> clientOrder = allClientOrders.get(orderNum);
//			for(String key : clientOrder.keySet())
//			{
//				double cost = items.get(key);
//				int quantity = clientOrder.get(key);
//				
//				totalCost += (cost * quantity);
//				
//				result += "Item's name: "
//						+ key
//						+ ", Cost per item: "
//						+ NumberFormat.getCurrencyInstance().format(cost)
//						+ ", Quantity: "
//						+ quantity
//						+ ", Cost: "
//						+ NumberFormat.getCurrencyInstance().format(cost * quantity) + "\n";
//			}
//			result += "Order Total: " + NumberFormat.getCurrencyInstance().format(totalCost) + "\n";
//			
//			totalCost = 0;		
//		}
//
//		result += "***** Summary of all orders *****\n";
//		
//		for(String key : itemsOrdered.keySet())
//		{
//			double cost = items.get(key);
//			int quantity = itemsOrdered.get(key);
//			
//			result += "Summary - Item's name: "
//					+ key
//					+ ", Cost per item: "
//					+ NumberFormat.getCurrencyInstance().format(cost)
//					+ ", Number sold: "
//					+ quantity
//					+ ", Item's Total: "
//					+ NumberFormat.getCurrencyInstance().format(cost * quantity) + "\n";
//			
//			totalCost += (cost * quantity);
//			
//		}
//		result += "Summary Grand Total: " + NumberFormat.getCurrencyInstance().format(totalCost);
//		
//		try {
//			FileWriter fileWriter = new FileWriter(resultName);
//		
//			fileWriter.write(result);
//			
//			fileWriter.close();
//			System.out.println("Results can be found in the file: " + this.resultName);
//			
//		} catch (IOException e) {
//			System.err.println(e.getMessage());
//		}
//		
//	}
	
	public static void main(String args[])
	{
//		Scanner input = new Scanner(System.in);
//		
//		System.out.println("Enter item's data file name: ");
//		String fileName = input.next();
//		
//		System.out.println("Enter 'y' for multiple threads, any other character otherwise: ");
//		String isMulti = input.next();
//		
//		System.out.println("Enter number of orders to process: ");
//		int orders = input.nextInt();
//		
//		System.out.println("Enter order's base filename: ");
//		String baseName = input.next();
//		
//		System.out.println("Enter result's filename: ");
//		String resultName = input.next();
//		
//		input.close();
		
		//OrdersProcessor processor = new OrdersProcessor(fileName, isMulti, orders, baseName, resultName);
		
		OrdersProcessor processor = new OrdersProcessor("itemsData.txt", "y", 100, "DataSetThree", "myTest.txt");
		
		processor.process();
		//processor.summary();
	}
	
	
	
}
