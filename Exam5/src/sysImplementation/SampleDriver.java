package sysImplementation;

public class SampleDriver {

	public static void main(String[] args) {

		
		String answer = "";
		answer += "===================Part1==============================\n";
		Roster r1= new Roster("CMSC131",257);
		answer += r1+ " "+r1.getFirstId()+ " "+r1.getLastId()+ "\n";
		r1.add(125);
		answer += r1+ " "+r1.getFirstId()+ " "+r1.getLastId()+ "\n";
		r1.add(345);
		answer += r1+ " "+r1.getFirstId()+ " "+r1.getLastId()+ "\n";
		r1.add(475);
		answer += r1+ " "+r1.getFirstId()+ " "+r1.getLastId()+ "\n";
		r1.add(225);
		answer += r1+ " "+r1.getFirstId()+ " "+r1.getLastId()+ "\n";
		r1.add(245);
		answer += r1+ " "+r1.getFirstId()+ " "+r1.getLastId()+ "\n";
		r1.add(575);
		answer += r1+ " "+r1.getFirstId()+ " "+r1.getLastId()+ "\n";
		answer += r1.getCSIds()+ "\n";
	
		
		answer += "===================Part2==============================\n";
		Roster r2= new Roster("CMSC132",357);
		answer += r2+ " "+r2.getFirstId()+ " "+r2.getLastId()+ "\n";
		r2.add(235);
		answer += r2+ " "+r2.getFirstId()+ " "+r2.getLastId()+ "\n";
		r2.add(200);
		answer += r2+ " "+r2.getFirstId()+ " "+r2.getLastId()+ "\n";
		r2.add(299);
		answer += r2+ " "+r2.getFirstId()+ " "+r2.getLastId()+ "\n";
		r2.add(100);
		answer += r2+ " "+r2.getFirstId()+ " "+r2.getLastId()+ "\n";
		r2.add(105);
		answer += r2+ " "+r2.getFirstId()+ " "+r2.getLastId()+ "\n";
		r2.add(341);
		answer += r2+ " "+r2.getFirstId()+ " "+r2.getLastId()+ "\n";
		answer += r2.getCSIds()+ "\n";

		
		
		answer += "===================Part3==============================\n";
		Roster r3= new Roster("CMSC216",357);
		r3.add(358);
		answer += r3.getCSIds()+ "\n";

		
		answer += "===================Part4==============================\n";
		Roster r4= new Roster("CMSC330",257);
		r4.add(258);
		answer += r4.getCSIds()+ "\n";

		
		System.out.println(answer);

	}

}
