package comparatorExample;

public class Student implements Comparable<Student> {
	private String name;
	private int id, credits;

	public Student(String name, int id, int credits) {
		this.name = name;
		this.id = id;
		this.credits = credits;
	}

	public String toString() {
		return "Name: " + name + ", Id: " + id + ", Credits: " + credits;
	}

	public int compareTo(Student other) {
		if (id < other.id) {
			return -1;
		} else if (id == other.id) {
			return 0;
		} else {
			return 1;
		}
	}

	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		} else if (!(obj instanceof Student)) {
			return false;
		} else {
			return compareTo((Student) obj) == 0;
		}
	}

	public int hashCode() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public int getCredits() {
		return credits;
	}
}