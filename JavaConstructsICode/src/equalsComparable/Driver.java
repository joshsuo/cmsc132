package equalsComparable;

import java.util.ArrayList;
import java.util.Collections;

public class Driver {
	public static void main(String[] args) {
		ArrayList<Student> roster = new ArrayList<Student>();

		roster.add(new Student("Mary", 10));
		roster.add(new Student("Bob", 1));
		roster.add(new Student("Laura", 17));
		roster.add(new Student("Albert", 34));

		/* Collection is sorted by id */
		Collections.sort(roster);
		for (Student s : roster) {
			System.out.println(s);
		}
		
		/* equals method tests */
		Student s1 = new Student("John", 10);
		Student s2 = new Student("John", 10);
		Student s3 = new Student("Mary", 20);

		System.out.println(s1.equals(s2));
		System.out.println(s2.equals(s1));
		System.out.println(s1.equals(s3));
		System.out.println(s1.equals(null));
	}
}
