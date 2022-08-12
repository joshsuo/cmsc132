package sysImplementation;

import java.util.Arrays;
import java.util.Random;

public class SampleDriver {

	public static void main(String[] args) {

		
		String answer = "";
		Random random = new Random(-357328372);
		
		answer += "===================Part1==============================\n";
		
		
		int [] r1 = {500, 225, 304, 226, 227, 351};
		int [] r2 = {227,226,225,303};
		int [] r3 = {500, 225, 304, 227, 227, 351};
		int [] r4 = new int [500];
		int [] r5 = new int [500];
		answer += RosterTree.reversableRosters(r1,r2)+"\n";
		answer += RosterTree.reversableRosters(r2,r1)+"\n";
		answer += RosterTree.reversableRosters(r1,r3)+"\n";
		
		
		for (int i =0; i < 500; i++){			
			r5[i] = r4[i]= random.nextInt(900)+100;  //add a random id to array - might have duplicates
	
		}
		
		answer += RosterTree.reversableRosters(r4,r5)+"\n";  //for sure false due to random generation
		
		for (int i=499, j=0; i>=0; i--,j++)
		{
			r5[j] =r4[i];        //reverse r4 and place in r5
		}
		
		answer += RosterTree.reversableRosters(r4,r5)+"\n";
		
		answer += "===================Part2==============================\n";
		
		RosterTree tree1 =  RosterTree.makeRosterTree(375, 500);
		RosterTree tree2 =  RosterTree.makeRosterTree(324234, 100);
		
		int []tree1Count = tree1.countCSIdParents();
		int []tree2Count = tree2.countCSIdParents();
		
		answer += Arrays.toString(tree1Count)+"\n";
		answer += (tree1Count[0]+tree1Count[1]+tree1Count[2] == tree1.getSize())+"\n";
		answer += Arrays.toString(tree2Count)+"\n";
		answer += (tree2Count[0]+tree2Count[1]+tree2Count[2] == tree2.getSize())+"\n";
		
		
		answer += "===================Part3==============================\n";
		
		answer += tree1.csIdPerLevel()+"\n";
		answer += tree2.csIdPerLevel()+"\n";
		
		
		System.out.println(answer);

	}

}
