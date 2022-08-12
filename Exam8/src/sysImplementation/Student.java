package sysImplementation;

public class Student implements Comparable<Student>{
	
	private int id;
	private int priority;

	public Student(int id, int priority) {
		if (id <100 || id>999)
			throw new IllegalArgumentException("invalid id");
		this.id =id;
		if (priority<1 || priority>900 )
			throw new IllegalArgumentException("invalid priority");
		this.priority = priority;
			
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", priority=" + priority + "]";
	}


	public int getPriority() {
		return priority;
	}


	public int compareTo(Student other) {
		return equals(other) ? 0 : (priority < other.priority ? -1 : 1);
	}


}
