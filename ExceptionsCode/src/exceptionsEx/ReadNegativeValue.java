package exceptionsEx;

import javax.swing.JOptionPane;

public class ReadNegativeValue {
	public static int totalAttempts = 0;
	
	public static int getNegativeInteger() {
		String prompt = "Enter negative integer value";
		String errorMessage = "You must provide a negative integer value";
		
		while (true) {
			int value = 0;
			try {
				value = Integer.parseInt(JOptionPane.showInputDialog(prompt));
				if (value < 0) {
					return value;
				}
				JOptionPane.showMessageDialog(null, errorMessage);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "In method catch clause: " + errorMessage);
			} finally {
				totalAttempts++;
			}
		}
	}

	public static void main(String[] args) {
		String report = "Value Provided: " + getNegativeInteger();
		
		report += "\nTotal Attempts: " + ReadNegativeValue.totalAttempts;
		JOptionPane.showMessageDialog(null, report);
	}
}