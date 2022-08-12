package comparatorExample;

import java.util.Comparator;

public class SecondDriver {
	public static void main(String[] args) {
		Student s1 = new Student("Mary", 10, 15);
		Student s2 = new Student("Bob", 1, 18);

		CreditsComparator creditsComparator = new CreditsComparator();
		int result = creditsComparator.compare(s1, s2);
		String answer = "Comparing\n" + s1 + "\nagainst\n" + s2 + "\nbased on credits " + result;
		System.out.println(answer);

		/* String class comparator */
		Comparator<String> caseInsensitiveComparator = String.CASE_INSENSITIVE_ORDER;
		String name1 = "JOSE", name2 = "joSe";
		System.out.println("Using compareTo: " + name1.compareTo(name2));
		System.out.println("Using compare: " + caseInsensitiveComparator.compare(name1, name2));
	}
}