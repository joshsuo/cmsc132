package example1;

public class Car {
	private int id;
	private StringBuffer history; /* would our code change if we use String */
	private static int total = 0; /* global for all instances of the class */
	
	public Car(int id) {
		this.id = id;
		history = new StringBuffer();
		total++;
	}

	/**
	 * Default constructor
	 */
	public Car() {
		this(0);
	}
	
	public String toString() {
		return "Id: " + id + ", History: " + history;
	}
	
	public StringBuffer getHistory() {
		/* returning copy to avoid privacy leak */
		return new StringBuffer(history); 
	}
	
	public void addHistory(String item) {
		history.append(item);
	}
	
	public static void referenceCopy(Car car1, Car car2) {
		System.out.println("Reference Copy Example");
		
		car1 = car2;
		
		System.out.println(car1);
		System.out.println(car2);
		
		System.out.println("End Reference Copy Example");	
	}

	public static void shallowCopy(Car car1, Car car2) {
		System.out.println("Shallow Copy Example");
		
		car1.id = car2.id;
		car1.history = car2.history;
		
		System.out.println(car1);
		System.out.println(car2);
		
		System.out.println("End Shallow Copy Example");
	}

	public static void deepCopy(Car car1, Car car2) {
		System.out.println("Deep Copy Example");
		
		car1.id = car2.id;
		car1.history = new StringBuffer(car2.history);
		
		System.out.println(car1);
		System.out.println(car2);
		
		System.out.println("End Deep Copy Example");
	}

	public static int getTotal() {
		return total;
	}
	
	public static void main(String[] args) {
		Car car1 = new Car(10), car2 = new Car(20);
		car1.addHistory(",oil change");
		car1.addHistory(",fix door");		
		car2.addHistory(", paint car");
		System.out.println(car1);
		
		referenceCopy(car1, car2);
		shallowCopy(car1, car2);
		deepCopy(car1, car2);
		
		System.out.println("Total Cars: " + getTotal());
	}
}
