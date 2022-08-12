package exceptionsEx;

import javax.swing.JOptionPane;

public class ReadNegativeValueRethrow {
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
				String message = "In method catch clause: " + errorMessage;
						
				JOptionPane.showMessageDialog(null, message);
				throw e;
			} finally {
				totalAttempts++;
			}
		}
	}

	public static void main(String[] args) {
		String report = "";
		
		try {
			report = "Value Provided: " + getNegativeInteger();
		} catch(NumberFormatException e) {
			report += "In main (catch clause)\n";
		}
		report += "\nTotal Attempts: " + ReadNegativeValueRethrow.totalAttempts;
		
		JOptionPane.showMessageDialog(null, report);
	}
}