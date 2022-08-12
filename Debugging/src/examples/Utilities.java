package examples;

import java.util.*;

public class Utilities {
	static private int DIV = 2;  /* Look at this value in the debugger */
	
	public static boolean valid(int value) {
		return value % DIV == 0;
	}

	public static int getMax(int x, int y) {
		int max;

		if (x > y) { 	/* Set a break point here */
			max = x; 	/* Display values of x and y */
		} else { 		/* Show stack; change to stack of caller */
			max = y;
		}

		return max;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a, b;
		
		System.out.println("Enter two integer values: ");
		a = scanner.nextInt();
		b = scanner.nextInt();

		/* Set a breakpoint here and look at the values of a and b */
		if (!valid(a) || !valid(b)) {
			System.out.println("Invalid values");
		} else {
			int maximum = getMax(a, b); /* Set a break point here */

			System.out.println("Maximum value is " + maximum);
		}

		scanner.close();
	}
}
