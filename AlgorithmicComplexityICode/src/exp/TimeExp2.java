package exp;
import java.util.Scanner;

/**
 * Example relies on System.currentTimeMillis() (from Unix Epoch)
 * 
 * @author cmsc132
 *
 */
public class TimeExp2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		for (long n : new long[] {2048, 4096, 8192, 16384, 32768, 65536}) {
			long sum = 0;
			long startTime = System.currentTimeMillis();
			for (long row = 1; row <= n; row++) {
				for (long col = 1; col <= n; col++) {
					sum += row + col;
				}
			}
			long endTime = System.currentTimeMillis();
			long duration = endTime - startTime;
			System.out.printf("n: %10d, time: %10d, sum: %20d\n", n, duration, sum);
		}
		scanner.close();
	}

}
