package sysImplementation;

import java.util.Iterator;


public class SampleDriver {

	public static void main(String[] args) {

		
		String answer = "";
		answer += "===================Part1==============================\n";
		Roster r1= new Roster(new int[] {565,432,332,231,275,456,225,798}, "CMSC131");
		Roster r2= new Roster(new int[] {563,234,222,451,273,201,202,203}, "CMSC132");
		answer += r1+ "\n";
		answer += r2+ "\n";
	
		
		answer += "===================Part2==============================\n";
		answer += r1.compareTo(r2)+ "\n";
		answer += r2.compareTo(r1)+ "\n";
		answer += r1.compareTo(new Roster(new int[] {224,225,226}, "CS1"))+ "\n";
		
		answer += "===================Part3==============================\n";
		
		r2=r1.clone();
		answer += r1+ "\n";
		answer += r2+ "\n";
		r1.badRoster();
		answer += r1+ "\n";
		answer += r2+ "\n";
		
		answer += "===================Part4==============================\n";
		
		
		 for (Integer i: r2)
		 {
				answer += i+ " ";
		 }
		 answer+="\n";
		 
		 
		Iterator<Integer> i1 =  r2.iterator();
		Iterator<Integer> i2 =  r2.iterator();
		
		answer+=i1.hasNext()+ "\n";
		answer+=i1.hasNext()+ "\n"; 
		answer+=i1.next()+ "\n";

		answer+=i2.hasNext()+ "\n";
		answer+=i2.next()+ "\n";
		answer+=i2.hasNext()+ "\n";
		answer+=i2.next()+ "\n";
		answer+=i2.hasNext()+ "\n";
		answer+=i2.next()+ "\n";
		answer+=i2.hasNext()+ "\n";  //since it is false, a call to next has undefined behavior
	

		
		System.out.println(answer);

	}

}
