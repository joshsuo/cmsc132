package sysImplementation;


public class SampleDriver {

	public static void main(String[] args) {
	
		String answer = "";
		
		

		answer += "===================Output of linearSearchLast=======================\n";

		answer += Utilities.linearSearchLast(null, 8)+"\n";
		answer += Utilities.linearSearchLast(new int[] {2,4,6,8,8}, 8)+"\n";
		answer += Utilities.linearSearchLast(new int[] {2,4,6,8,8}, 7)+"\n";	
		
				
		
		
		System.out.println(answer);
		
	}

}
