package priorityQueueEx;

public class Patient implements Comparable<Patient> {
	private String name;
	private int priority;

	public Patient(String name, int priority) {
		this.name = name;
		this.priority = priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String toString() {
		return "Name: " + name + " Priority: " + priority;
	}

	/*
	 * From Java API: The natural ordering for a class C is said to be
	 * consistent with equals if and only if (e1.compareTo((Object)e2) == 0) has
	 * the same boolean value as e1.equals((Object)e2) for every e1 and e2 of
	 * class C. It is strongly recommended (though not required) that natural
	 * orderings be consistent with equals.
	 */
	public int compareTo(Patient p) {
		return equals(p) ? 0 : (priority < p.priority ? -1 : 1);
	}

	/* Do we need to provide the next two methods? */
	public boolean equals(Object obj) {
		if (obj != null && getClass() == obj.getClass())
			return name.equals(((Patient) obj).name);
		return false;
	}

	public int hashCode() {
		return name.charAt(0);
	}
}