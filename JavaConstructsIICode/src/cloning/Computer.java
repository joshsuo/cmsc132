package cloning;

/* See what happens when you remove implements Cloneable */
/* and try to run the example again */
 
public class Computer implements Cloneable {
	private String brand;
	private Mouse mouse;

	public Computer(String brand, Mouse mouse) {
		this.brand = brand;
		this.mouse = mouse;
	}

	public Mouse getMouse() {
		return mouse;
	}

	@Override
	public Computer clone() {
		Computer obj = null;

		try {
			obj = (Computer) super.clone();
			if (mouse != null) {
			obj.mouse = mouse.clone(); /* computer has its own mouse */
			
			}
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		return obj;
	}

	public String toString() {
		return "Brand: " + brand + ", Mouse: " + mouse;
	}

	public static void main(String[] args) {
		Computer s1 = new Computer("Dell", new Mouse("Optical"));
		Computer s2 = s1.clone();

		s2.getMouse().moveMouse(10, 20);

		System.out.println(s1);
		System.out.println(s2);
	}
}