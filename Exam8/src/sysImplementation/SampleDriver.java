package sysImplementation;


import java.util.Random;

public class SampleDriver {

	public static void main(String[] args) {

		
		String answer = "";
		Random random = new Random(32);
		Student [] sPool = new Student[20];
		
		for (int i =0; i < 20; i++){			
			sPool[i] = new Student(random.nextInt(900)+100,random.nextInt(901));
			//System.out.println(sPool[i]);
		}
		
		RegisterationSystem rSystem = new 	RegisterationSystem(sPool);
		
		answer += "===================Part1==============================\n";
		
		answer += rSystem.registerById()+"\n";
		
	    answer += "===================Part2==============================\n";
		
		answer += rSystem.registerByPriority()+"\n";
		
	    answer += "===================Part3==============================\n";
		
		answer += rSystem.registerByCsId()+"\n";
		
		answer += "===================Part4==============================\n";
		
		sPool = new Student[9];
		
		for (int i =0; i < 9; i++){			
			sPool[i] = new Student(random.nextInt(900)+100,random.nextInt(901));
			//System.out.println(sPool[i]);
		}
		rSystem.changePool(sPool);
		
		
		answer += rSystem.registerById()+"\n";
		
	    answer += "===================Part5==============================\n";
	    
		sPool = new Student[20];
		
		for (int i =0; i < 20; i++){			
			sPool[i] = new Student(random.nextInt(900)+100,random.nextInt(901));
			//System.out.println(sPool[i]);
		}
		rSystem.changePool(sPool);
		
		
		answer += rSystem.registerById()+"\n";
		
	    answer += "===================Part6==============================\n";
		
		answer += rSystem.registerByPriority()+"\n";
		
	    answer += "===================Part7==============================\n";
		
		answer += rSystem.registerByCsId()+"\n";
		
		 
		
		System.out.println(answer);

	}

}
