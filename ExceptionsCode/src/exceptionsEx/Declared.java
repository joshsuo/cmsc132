package exceptionsEx;
import javax.swing.*;

public class Declared {
	public static void main(String[] args) throws NotPayingAttentionException {
		test();
	}
	
	public static void test() throws NotPayingAttentionException {
		String message = "Percentage material understood";
		/* Double.parseDouble throws an unchecked exception we don't need to handle */
		double value = Double.parseDouble(JOptionPane.showInputDialog(message));
		if (value < 70) {
			System.out.println("Problem");
			throw new NotPayingAttentionException("Lower than 70%");
		} else {
			System.out.println("Good Progress");
		}
	}
}
