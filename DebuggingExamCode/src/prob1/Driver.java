package prob1;

public class Driver {

	
	public static void main(String[] args) {
		
		boolean valid;
		
		valid = Restaurant.validDrink("Debugging soda", 160);
		
		System.out.println(valid);
		Restaurant restaurant1 = new Restaurant("CMSC132 Cafe", 5);
		
		restaurant1.addDrink("CMSC 132 soda", 165);
		restaurant1.addDrink("water", 0).addDrink("tea", 40);
		
		System.out.println(restaurant1);
		restaurant1.setName("The Bug-Free Cafe");
		System.out.println(restaurant1);
		
		
	}
}
