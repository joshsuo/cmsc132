package examples;

public class ElapsedTimeNanoseconds {
	private static long NANOSECONDS_IN_A_SEC = 1000000000;

	public static void main(String[] args) {
		String basicString = "Terps", appended = "";
		long iterations = 30000;

		long startTime = System.nanoTime(); // starting the clock
		for (int i = 1; i <= iterations; i++) {
			appended += basicString;
		}
		long elapsed = System.nanoTime() - startTime; // stopping the clock

		System.out.println("Time elapsed in nanoseconds: " + elapsed);
		System.out.println("Time elapsed in seconds: " + (double) elapsed / NANOSECONDS_IN_A_SEC);
	}
}