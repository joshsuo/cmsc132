package sysImplementation;

public class SampleDriver {

	public static void main(String[] args) {

		
		String answer = "";
		
		ListOfCoordinates myList = new ListOfCoordinates ();
		answer += myList.getSize()+ "\n";;
		answer += myList.getCapacity()+ "\n";;
		answer += myList+ "\n";;
		myList.add(3, 5);
		answer += myList+ "\n";
		myList.add(7, 8);
		answer += myList+ "\n";
		myList.add(-5, 14);
		answer += myList+ "\n";
		myList.add(-7, 65);
		answer += myList+ "\n";
		myList.add(12, -35);
		answer += myList+ "\n";
		answer += myList.getSize()+ "\n";;
		answer += myList.getCapacity()+ "\n";;
		answer += myList.remove(-1)+ "\n";;
		answer += myList.remove(5)+ "\n";;
		answer += myList.getSize()+ "\n";;
		answer += myList.getCapacity()+ "\n";;
		answer += myList.remove(0)+ "\n";;
		answer += myList+ "\n";
		answer += myList.getSize()+ "\n";;
		answer += myList.getCapacity()+ "\n";;
		answer += myList.remove(2)+ "\n";;
		answer += myList+ "\n";
		answer += myList.getSize()+ "\n";;
		answer += myList.getCapacity()+ "\n";;
		myList.add(5, 5);
		answer += myList+ "\n";
		answer += myList.getSize()+ "\n";;
		answer += myList.getCapacity()+ "\n";;
		myList.add(8, 8);
		answer += myList+ "\n";
		answer += myList.getSize()+ "\n";;
		answer += myList.getCapacity()+ "\n";;
		myList.add(51, 51);
		answer += myList+ "\n";
		answer += myList.getSize()+ "\n";;
		answer += myList.getCapacity()+ "\n";;
		myList.add(513, 513);
		answer += myList+ "\n";
		answer += myList.getSize()+ "\n";;
		answer += myList.getCapacity()+ "\n";;
		answer += myList.remove(2)+ "\n";;
		answer += myList+ "\n";
		answer += myList.getSize()+ "\n";;
		answer += myList.getCapacity()+ "\n";
		answer += myList.changeY(-1, 32)+ "\n";
		answer += myList.changeY(6, 32)+ "\n";
		answer += myList.changeY(5, 3000)+ "\n";
		answer += myList.changeY(0, 2000)+ "\n";
		answer += myList+ "\n";
		answer += "==================================================\n";
////		
		
		System.out.println(answer);

	}

}
