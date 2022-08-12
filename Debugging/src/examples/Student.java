package examples;

public class Student implements Comparable<Student> {
	private String name;
	private int id;

	public Student(String name, int id) {
		this.name = name;
		if (validId(id)) {
			this.id = id;
		} else {
			throw new IllegalArgumentException("Invalid id");
		}
	}

	public String toString() {
		return "Name: " + name + ", Id: " + id;
	}

	public int compareTo(Student other) {
		int answer = id - other.id;

		/* Set a breakpoint here and look at the parameter */
		/* and the current object */
		return answer;
	}

	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Student)) {
			return false;
		}
		Student student = (Student) obj; /* Set a breakpoint here */

		return name.equals(student.name);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	private boolean validId(int id) {
		return id > 0;
	}
	
	public static void main(String[] args) {
		Student s1 = new Student("Bob", 2);
		Student s2 = new Student("Laura", 3);
		Student s3 = new Student("Laura", 3);
		
		/* See the contents of s1 using the debugger */
		System.out.println(s1.equals(s2));
		System.out.println(s2.equals(s3));
		System.out.println(s1.compareTo(s3));
	}
}