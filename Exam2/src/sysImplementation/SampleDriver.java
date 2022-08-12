package sysImplementation;

import java.util.ArrayList;
import java.util.Arrays;


public class SampleDriver {

	public static void main(String[] args) {

		
		String answer = "";
		answer += "===================Part1==============================\n";
		ArrayList <Integer> localIds = new ArrayList<Integer> ();
		localIds.add(271); localIds.add(343); localIds.add(251); localIds.add(456); 
		localIds.add(756); localIds.add(545); localIds.add(255); 

	
		answer += localIds+ "\n";
		
		Roster r=null;
		
		
		try {
			r = new Roster (localIds, 5);
		} catch (InvalidListException e) {
			answer += e.getMessage()+ "\n";
		}
		
		
		
		try {
			r = new Roster (localIds, 8);
			answer += r+ "\n";
			answer += r.enroll(343)+ "\n";  //already in the roster
			answer += r.enroll(543)+ "\n";  //ok
			answer += r.enroll(544)+ "\n";  //no more seats
			answer += r.remove(544)+ "\n";  //544 not in list to remove
			answer += r.remove(456)+ "\n";  //ok
			
			
			
			
			answer += localIds+ "\n";  //no change to local list from main
			localIds.clear();
			
			ArrayList <Integer> localCopy = r.getRoster();
			localCopy.add(-100000);  //Invalid id, but does not corrupt Roster data
			answer += localCopy+ "\n";  
		
			answer += r+ "\n";  //changes to Roster data are here
			
		} catch (InvalidListException e) {
			e.printStackTrace();
		}
		
		answer += "===================Part2==============================\n";
		
		Roster copy =null;
		try {
			copy = new Roster (r);
			answer += r.equals(copy)+ "\n"; 
			copy.remove(545);
			answer += r.equals(copy)+ "\n"; 
		} catch (InvalidListException e) {
			e.printStackTrace();
		}
		answer += "===================Part3==============================\n";
		
		CSRoster csR = null;
		try {
			
			localIds.add(271); localIds.add(343); localIds.add(251); localIds.add(456); 
			localIds.add(756); localIds.add(545); localIds.add(255); //add data back since cleared
			
			csR = new CSRoster(localIds, 8, "Java");
			answer +=csR+ "\n";
			answer +=csR.toString(true) +"\n"; //call overloaded version, same as toString()
			answer +=csR.toString(false) +"\n"; //just the id #s
		} catch (InvalidListException e) {
			e.printStackTrace();
		}
		answer += "===================Part4==============================\n";
	
		Roster r1 = null;
		CSRoster csR1 = null;
		
		try {
			localIds.add(275); localIds.add(345); 
			csR1 =new CSRoster(localIds, 10, "C");
			localIds.clear();
			localIds.add(201);localIds.add(202);localIds.add(301);
			r1 = new Roster(localIds, 7);
			answer +=csR+ "\n";  //as as in part 3
			answer +=r1+ "\n";
			answer += csR1+ "\n";

		} catch (InvalidListException e) {
			e.printStackTrace();
		}
			
		Roster []input= {csR,r1,csR1};
		
		answer +=Arrays.toString(CSRoster.getStudentsinCS(input, false))+ "\n";;
		answer +=Arrays.toString(CSRoster.getStudentsinCS(input, true))+ "\n";;
		
		
		
		
		System.out.println(answer);

	}

}
