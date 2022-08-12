package threadsinterrupt;

import javax.swing.JOptionPane;

public class InterruptExample extends Thread {
	private int power;

	public InterruptExample(int power) {
		this.power = power;
	}

	public void run() {
		int value = 1;
		String answer;

		while (!interrupted()) {
			answer = getName() + value + " raised to power " + power + ": ";
			answer += Math.pow(value, power);
			System.out.println(answer);
			value = ++value % 100;
		}
	}

	public static void main(String[] args) {
		Thread t1 = new InterruptExample(2);
		t1.setName("FIRST-->");

		Thread t2 = new InterruptExample(3);
		t2.setName("SECOND-->");

		t1.start();
		t2.start();

		JOptionPane.showMessageDialog(null, "Press OK to stop.");
		t1.interrupt();
		t2.interrupt();

		JOptionPane.showMessageDialog(null, "Thank you for using our system.");
	}
}
