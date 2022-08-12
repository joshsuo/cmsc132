package staticBlock;

/**
 * Initializations executed in order of number
 *
 */
public class VariableInitialization {
	static {
		A = 1;
	}
	static int A = 2;
	static {
		A = 3;
	}
	{
		B = 4;
	}
	private int B = 5;
	{
		B = 6;
	}

	VariableInitialization() {
		System.out.println("A: " + A);
		System.out.println("B: " + B);
	}

	public static void main(String[] args) {
		new VariableInitialization();
	}
}
