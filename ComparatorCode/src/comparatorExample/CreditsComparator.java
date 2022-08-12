package comparatorExample;

import java.util.Comparator;

public class CreditsComparator implements Comparator<Student> {
	public int compare(Student a, Student b) {
		/*
		 * Note: we could have written the method as return a.getCredits() -
		 * b.getCredits();
		 */
		int aCredits = a.getCredits(); /* Note: we cannot access a.credits */
		int bCredits = b.getCredits();

		if (aCredits < bCredits) {
			return -1;
		} else if (aCredits == bCredits) {
			return 0;
		} else {
			return 1;
		}
	}
}
