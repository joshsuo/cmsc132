package comparatorExample;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainDriver {
	public static void printRoster(String tag, Collection<Student> collection) {
		System.out.println(tag);
		for (Student s : collection) {
			System.out.println(s);
		}
	}

	public static void main(String[] args) {
		ArrayList<Student> roster = new ArrayList<>();

		roster.add(new Student("Mary", 10, 15));
		roster.add(new Student("Bob", 1, 18));
		roster.add(new Student("Laura", 17, 12));
		roster.add(new Student("Albert", 34, 6));

		/* Collection is sorted by id */
		Collections.sort(roster);
		printRoster("***** By Id *****", roster);

		/* Collection is sorted By Name */
		Collections.sort(roster, new NameComparator());
		printRoster("\n***** By Name *****", roster);

		/* Collection is sorted By Credits */
		Collections.sort(roster, new CreditsComparator());
		printRoster("\n***** By Credits *****", roster);
	}
}