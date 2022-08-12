package processor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class OrdersProcessor 
{
	private String itemsFileName;
	private int orderCount;
	private String baseFileName;
	private String resultFileName;
	private boolean multiThreads;
	

	
	public OrdersProcessor(String itemsFileName, int orderCount, String baseFileName,
			String resultFileName, boolean multiThreads )
	{
		this.itemsFileName = itemsFileName;
		this.orderCount = orderCount;
		this.baseFileName = baseFileName;
		this.resultFileName = resultFileName;
		this.multiThreads = multiThreads;
	}
	 
	private TreeMap<String, Double> ReadDataFile()
	{
		TreeMap<String, Double> items = new TreeMap<String, Double>();
		try {
			
			Scanner fileScanner = new Scanner(new File(this.itemsFileName));

			while (fileScanner.hasNextLine()) {
				String itemName = fileScanner.next();
				Double cost = fileScanner.nextDouble();
				items.put(itemName, cost);
			}
			fileScanner.close();
			
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		
		return items;
	} 
	
	

	public String reportOrder(int orderNumber, TreeMap<String, Double> items, 
			TreeMap<String, Integer> itemsOrdered)
	{
		String result = "";
		result += "----- Order details for client with Id: "+(1000 + orderNumber)+" -----\n";
		Double orderTotal = 0.0;
		
		for (Map.Entry<String, Integer> entry : itemsOrdered.entrySet())
		{
			String itemName = entry.getKey();
			Double cost = items.get(itemName);
			Integer qty = entry.getValue();
			orderTotal += cost*qty;		
		
			result +="Item's name: "+entry.getKey()+", Cost per item: "+
			NumberFormat.getCurrencyInstance().format(cost)+", Quantity: "+qty+", Cost: " + 
					NumberFormat.getCurrencyInstance().format(qty*cost) + "\n";
			
		}	 
		result += "Order Total: " + NumberFormat.getCurrencyInstance().format(orderTotal) + "\n";
		 
		return result;
	}
	
	
	public String reportSummary(TreeMap<String, Double> items, TreeMap<String, Integer> allClientOrders)
	{
		String result = "";
		Double orderTotal = 0.0;
 		
		result += "***** Summary of all orders *****" + "\n";
		for (Map.Entry<String, Integer> entry : allClientOrders.entrySet())
		{
			String itemName = entry.getKey();
			Double cost = items.get(itemName);
			Integer qty = entry.getValue();
			orderTotal += cost*qty;
			result += "Summary - Item's name: "+entry.getKey()+", Cost per item: "+
			NumberFormat.getCurrencyInstance().format(cost)+", Number sold: "+qty+
			", Item's Total: " + NumberFormat.getCurrencyInstance().format(qty*cost) + "\n";
		}
		
		result += "Summary Grand Total: " + NumberFormat.getCurrencyInstance().format(orderTotal) + "\n";

		return result;
	}
	
	
	public void process()
	{
		Object lockObj = new Object();
		
	
		TreeMap<Integer, TreeMap<String, Integer>> orders = new TreeMap<Integer, TreeMap<String, Integer>>();
			
		TreeMap<String, Integer> allClientOrders = new TreeMap<String, Integer>();
		
		//Read Data File
		TreeMap<String, Double> items = this.ReadDataFile();
		
		long startTime = System.currentTimeMillis();
		
		if(this.multiThreads) {
			
			Thread[] allThreads = new Thread[this.orderCount];
			for (int i = 0; i < allThreads.length ; i++)
			{
				allThreads[i] = new Thread(new Report(i+1,this.baseFileName, items,orders,
						allClientOrders, lockObj));
			}				
			for (Thread thread : allThreads)
			{
				thread.start();
			}
			
			try {
				for (Thread thread : allThreads)
				{
					thread.join(); 
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}else {

			for(int i=1; i<=this.orderCount; i++)
			{
				Report worker = new Report(i, this.baseFileName, items,orders,
						allClientOrders, lockObj);
				worker.run();
			}
			
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("Processing time (msec): " + (endTime - startTime));
		
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(this.resultFileName));
			 
			for(int orderNumber : orders.keySet())
			{
				writer.append(reportOrder(orderNumber,items, orders.get(orderNumber)));
			}
			writer.append(reportSummary(items, allClientOrders));
			writer.close();
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) 
	{

		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter item's data file name: ");
		String dataFileName = scanner.nextLine();
		
		System.out.print("Enter 'y' for multiple threads, any other character otherwise: ");
		String isMultiThread = scanner.nextLine();

		System.out.print("Enter number of orders to process: ");
		String orderCount = scanner.nextLine();
		int iOrderCount = Integer.parseInt(orderCount);
		
		System.out.print("Enter order's base filename: ");
		String baseFilename = scanner.nextLine();

		System.out.print("Enter result's filename: ");
		String resultFilename = scanner.nextLine();
		
		scanner.close();
			
		OrdersProcessor processor = new OrdersProcessor(
				dataFileName,
				iOrderCount,
				baseFilename,
				resultFilename,
				isMultiThread.equals("y") || isMultiThread.equals("Y")
				);
		 
		processor.process();
		
		
		
	}
	
	
}
