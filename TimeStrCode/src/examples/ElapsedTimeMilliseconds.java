package examples;

public class ElapsedTimeMilliseconds {
	private static long MILLISECONDS_IN_A_SEC = 1000;

	public static void main(String[] args) {
		String basicString = "Terps", appended = "";
		long iterations = 30000;

		long startTime = System.currentTimeMillis(); // starting the clock
		for (int i = 1; i <= iterations; i++) {
			appended += basicString;
		}
		long elapsed = System.currentTimeMillis() - startTime; // stopping the clock

		System.out.println("Time elapsed in milliseconds: " + elapsed);
		System.out.println("Time elapsed in seconds: " + (double) elapsed / MILLISECONDS_IN_A_SEC);
	}
}