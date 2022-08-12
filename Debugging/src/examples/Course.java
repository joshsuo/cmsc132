package examples;

import java.util.ArrayList;

public class Course {
	private String name;
	private int maxCapacity, enrolled;
	private ArrayList<Student> list;

	public Course(String name, int maxCapacity) {
		this.name = name;
		this.maxCapacity = maxCapacity;
		list = new ArrayList<Student>(); /* Set breakpoint and see contents of list */
	}

	public boolean canEnroll(Student s) {
		return enrolled < maxCapacity ? true : false;
	}

	public void enroll(Student s) {
		if (canEnroll(s)) {
			list.add(s);
			enrolled++; /* Set breakpoint and see contents of ArrayList */
		}
	}

	public String[] justNames() {
		String[] result = new String[list.size()];

		int i = 0;
		for (Student student : list) {
			result[i++] = student.getName();
		}

		/* Set a breakpoint here see contents of the Array */
		return result;
	}

	public String toString() {
		String result = "Name: " + name;

		result += " Capacity: " + maxCapacity + "\n";
		for (int i = 0; i < list.size(); i++) {
			result += list.get(i) + "\n";
		}

		return result;
	}

	public static void main(String[] args) {
		Course course = new Course("cmsc999", 35);

		Student s1 = new Student("Mary", 1);
		boolean canEnroll = course.canEnroll(s1);
		System.out.println("Enrollment possible? " + (canEnroll ? "Yes" : "No"));

		course.enroll(s1);
		System.out.println(course);

		course.enroll(new Student("Peter", 2));
		course.enroll(new Student("George", 3));
		System.out.println(course);

		System.out.println("Names");
		String[] allNames = course.justNames();
		for (String name : allNames) {
			System.out.println(name);
		}
	}
}