package comparatorExample;

import java.util.Comparator;

public class NameComparator implements Comparator<Student> {
	public int compare(Student a, Student b) {
		return (a.getName().compareTo(b.getName()));
	}
}
