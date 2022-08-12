package cloning;

/* Notice it is not implementing Cloneable */
public class SuperComputer extends Computer {
	private StringBuffer users;
	private int coolingFactor;
	
	public SuperComputer(String brand, Mouse mouse, int coolingFactor) {
		super(brand, mouse);
		this.coolingFactor = coolingFactor;
		users = new StringBuffer();
	}
	
	public int getCoolingFactor() {
		return coolingFactor;
	}
	
	public void addUser(String name) {
		users.append(name);
	}
	
	public void printUsers() {
		System.out.println("Users: " + users);
	}
	
	@Override
	public SuperComputer clone() {
		SuperComputer obj = (SuperComputer) super.clone();
		obj.users = new StringBuffer(users);
		
		return obj;
	}
	
	public static void main(String[] args) {
		Mouse mouse = new Mouse("Optical");
		SuperComputer superComputer = new SuperComputer("ibm", mouse, 10), copy;
		
		superComputer.addUser("John");
		copy = superComputer.clone();
		copy.addUser("Mary");
		
		
		
		superComputer.printUsers();
		copy.printUsers();
	}
}
