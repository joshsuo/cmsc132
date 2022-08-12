package priorityQueueEx;

import java.util.PriorityQueue;

public class EmergencyRoom {
	private PriorityQueue<Patient> queue = new PriorityQueue<Patient>();

	public void addPatient(Patient p) {
		queue.offer(p);
	}

	public Patient nextPatient() {
		return queue.poll();
	}

	public void updatePriority(Patient p, int newPriority) {
		queue.remove(p);
		p.setPriority(newPriority);
		queue.offer(p);
	}

	public String toString() {
		String r = "";
		for (Patient p : queue)
			r += p + "\n";
		return r;
	}

	public static void main(String[] args) {
		String[] names = { "John", "Mary", "Peter", "Kelly", "Mike" };
		int[] priorities = { 10, 2, 4, 8, 11 };
		EmergencyRoom er = new EmergencyRoom();

		for (int i = 0; i < names.length; i++)
			er.addPatient(new Patient(names[i], priorities[i]));

		System.out.println("**** Patients Waiting:\n" + er);

		System.out.println("**** After updating Peter's priority");
		int newPriority = 3;
		er.updatePriority(new Patient("Peter", 2), newPriority);
		System.out.println("**** Patients Waiting:\n" + er);

		System.out.println("Next Patient:\n" + er.nextPatient());
	}
}
