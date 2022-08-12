package examples;

/*
 * Try setting useString to false to see efficiency of StringBuffer.
 *  
 */
import javax.swing.JOptionPane;

public class StringVsStringBuffer {
	private static long NANOSECONDS_IN_A_SEC = 1000000000;

	public static void main(String[] args) {
		long defaultValue = 60000;
		String basicString = "Terps", appended = "";
		StringBuffer stringBuffer = new StringBuffer();
		boolean useString = true, printOutput = false;

		long iterations = Long.parseLong(JOptionPane.showInputDialog("Enter number of iterations", defaultValue));
		System.out.println("Computing...");
		long startTime = System.nanoTime();
		if (useString) {
			for (int i = 1; i <= iterations; i++) {
				appended += basicString;
			}
		} else {
			for (int i = 1; i <= iterations; i++) {
				stringBuffer.append(basicString);
			}
		}

		long elapsed = System.nanoTime() - startTime;
		System.out.println("Time elapsed in nanoseconds: " + elapsed);
		System.out.println("Time elapsed in seconds: " + (double) elapsed / NANOSECONDS_IN_A_SEC);
		
		if (printOutput) {
			System.out.println("String: " + appended);
			System.out.println("StringBuffer: " + stringBuffer);
		}
	}
}