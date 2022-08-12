package enumeratedTypes;

public class ColorEnumDriver {

	public static void main(String[] args) {
		/* Possible values */
		for (Color c : Color.values()) {
			System.out.println(c);
		}
		
		Color x = Color.Green;
		System.out.println("Name: " + x.name());
		System.out.println("Ordinal: " + x.ordinal());
		
		if (Color.Red.compareTo(Color.Blue) < 0) {
			System.out.println("Red precedes Blue");
		} else {
			System.out.println("Blue precedes Red");
		}
		
		/* We can use equals method to compare them */
	}
}
