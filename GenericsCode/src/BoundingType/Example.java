package BoundingType;

class Student{
	int id;
}



 class TypeWithBound  <T extends Number>{

	
	int add(T num1, T num2) {
	
		return num1.intValue() + num2.intValue();
		
	}
			


}
 
 
 public class Example
 {
		public static void main(String[] args) {
			
			TypeWithBound  <Integer> ex1 = new TypeWithBound  <> ();
			
			System.out.println(ex1.add(new Integer(5), 7));
			

			TypeWithBound  <Double> ex2 = new TypeWithBound  <Double>();
			
			System.out.println(ex2.add(new Double(7.8), 3.6));	
			

			//TypeWithBound <Student> ex3 = new TypeWithBound<Student>();  //Will not work since Student is not a Number
			
		}
	 
	 
 }
 
