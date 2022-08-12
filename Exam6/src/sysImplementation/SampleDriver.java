package sysImplementation;

public class SampleDriver {

	public static void main(String[] args) {

		String answer = "";
		answer += "===================Part1==============================\n";
		int [] ids = { 120, 220, 345, 756, 32, 1444, 239, 243, 220, 383, 382};
		
		HashSetID set =new HashSetID(7);
		
		answer += set.getSize()+ " "+set.getCapacity()+ "\n";
		
		
		for(int i = 0; i<ids.length; i++)
		{
			answer +=set.insert(ids[i])+"\n";   
			answer += set.showMeTable()+ "\n";
			if (i==4)
				answer += String.format("%.2f", set.loadFactor())+"\n"; //just prints 2 decimal places
		}
		
		answer += set.contains(382)+"\n";
		answer += set.contains(220)+"\n";
		answer += set.contains(-435)+"\n";
		answer += String.format("%.2f", set.loadFactor())+"\n";
		
		answer += set.remove(382)+"\n";
		answer += set.remove(220)+"\n";
		answer += set.remove(-435)+"\n";
		answer += String.format("%.2f", set.loadFactor())+"\n";
		answer += set.showMeTable()+ "\n";
		
		
		answer += "===================Part2==============================\n";
		
		
		HashSetID set1 =new HashSetID(29);
		
		answer += set1.getSize()+ " "+set1.getCapacity()+ "\n";
		for(int i = 100; i<=112; i++)
		{
			set1.insert(i);   
	
		}
		answer += set1.showMeTable()+ "\n";

		answer += String.format("%.2f", set1.loadFactor())+"\n"; //just prints 2 decimal places
		
		for(int i = 100; i<=112; i++)
		{
			set1.remove(i);   
		}
	
		answer += set1.showMeTable()+ "\n";

		answer += String.format("%.2f", set1.loadFactor())+"\n"; //just prints 2 decimal places
		
		set1.insert(110); 
		answer += set1.showMeTable()+ "\n";
		
		set1.insert(103); 
		answer += set1.showMeTable()+ "\n";
		
		set1.insert(215); 
		answer += set1.showMeTable()+ "\n";
		
		set1.insert(216); 
		answer += set1.showMeTable()+ "\n";
		
		set1.insert(216); 
		answer += set1.showMeTable()+ "\n";
		
		
		System.out.println(answer);

	
	}
}
