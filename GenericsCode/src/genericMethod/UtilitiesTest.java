package genericMethod;

import static org.junit.Assert.*;

import org.junit.Test;

public class UtilitiesTest {

	@Test
	public void testMaximum() {
		Integer x = 10, y = 20;
		assertTrue(y == Utilities.maximum(x, y));
		
		int a = 10, b = 20; // works with primitives
		assertTrue(b == Utilities.<Integer>maximum(a, b));  //notice syntax to tell compiler the type passed in
		
		String n1 = "Emily", n2 = "Albert";
		assertTrue(n1 == Utilities.maximum(n1,  n2));
	}
	
	@Test
	public void testIncresing() {
		assertTrue(Utilities.isIncreasing(10, 20, 30));
		assertFalse(Utilities.isIncreasing(10, 7, 30));
		assertTrue(Utilities.isIncreasing("Albert", "Bob", "Rachel"));
		assertFalse(Utilities.isIncreasing("Bob", "Albert", "Rachel"));
	}
}
