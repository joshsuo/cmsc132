package exp;
import java.util.Scanner;

/**
 * Example relies on System.nanoTime() System.nanoTime() - returns the current
 * value of the running Java Virtual Machine's high-resolution time source
 * 
 * @author Nelson
 *
 */
public class TimeExp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		for (long n : new long[] { 64, 128, 256 }) {
			long sum = 0;
			long startTime = System.nanoTime();
			for (long row = 1; row <= n; row++) {
				for (long col = 1; col <= n; col++) {
					sum += row + col;
				}
			}
			long endTime = System.nanoTime();
			long duration = endTime - startTime;
			System.out.printf("n: %4d, time: %8d, sum: %8d\n", n, duration, sum);
			// System.out.println("n: " + n + ", Time: " + duration + ", Sum: " + sum);
		}
		scanner.close();
	}

}
