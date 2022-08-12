package progressBar;

/* Notes: 
 * 1. Place mouse pointer over progress bar to see waiting cursor
 * 2. What will happen if we call completeTask() instead of completeTaskInTheBackground? 
 * 3. Why "final" JTextArea textArea?
 */
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

public class ProgressBarExample extends JPanel {
	public static final int MINIMUM = 0, DEFAULT_MAXIMUM = 200, ORIENTATION = SwingConstants.HORIZONTAL;
	private static final int FRAME_WIDTH = 400, FRAME_HEIGHT = 300;
	private static final long serialVersionUID = 8016418091174982986L;
	private static final int SCROLLPANE_BORDER = 10;
	private static final int PROGRESSBAR_WIDTH = 250, PROGRESSBAR_HEIGHT = 80;
	private static final int PROGRESSBAR_BORDER = 10;

	private String title = "ProgressBar";
	private JProgressBar progressBar;
	private int maximum;

	public ProgressBarExample() {
		defineGUI();
	}

	private void defineGUI() {
		/* Defining the progress bar */
		progressBar = new JProgressBar(ORIENTATION, MINIMUM, DEFAULT_MAXIMUM);
		progressBar.setStringPainted(true);
		progressBar.setPreferredSize(new Dimension(PROGRESSBAR_WIDTH, PROGRESSBAR_HEIGHT));
		Border b1 = BorderFactory.createEmptyBorder(PROGRESSBAR_BORDER, PROGRESSBAR_BORDER, PROGRESSBAR_BORDER,
				PROGRESSBAR_BORDER);
		progressBar.setBorder(BorderFactory.createTitledBorder(b1, "Computing..."));

		/* Each time progress bar changes we check whether */
		/* we have reached the maximum value and if so we */
		/* print a notification and generate a beep() */
		progressBar.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (progressBar.getValue() == maximum) {
					System.out.println("Process has been completed");
					Toolkit.getDefaultToolkit().beep();
					setCursor(null); // turns off cursor
				}
			}
		});

		/* Adding progress bar */
		add(progressBar);

		/* Adding textfield for maximum value */
		add(new JLabel("Max"));
		final JTextField textField = new JTextField("200");
		add(textField);

		/* Adding scroll area */
		final JTextArea textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setPreferredSize(new Dimension(4 * FRAME_WIDTH / 5, FRAME_HEIGHT / 3));
		add(scrollPane);
		scrollPane.setBorder(BorderFactory.createEmptyBorder(SCROLLPANE_BORDER, SCROLLPANE_BORDER, SCROLLPANE_BORDER,
				SCROLLPANE_BORDER));

		/* Adding start button */
		JButton start = new JButton("Start");
		add(start);
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				maximum = Integer.parseInt(textField.getText());
				progressBar.setMaximum(maximum);
				completeTaskInTheBackground(textArea);
			}
		});

		/* Setting the frame */
		JFrame frame = new JFrame(title);
		frame.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		setOpaque(true);
		frame.setContentPane(this); // adds the panel
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	private void completeTaskInTheBackground(final JTextArea textArea) {
		Thread worker = new Thread(new Runnable() {
			public void run() {
				completeTask(textArea);
			}
		});
		worker.start();
	}

	/* Represents the task we are performing. For this */
	/* example we just print the square root numbers */
	private void completeTask(JTextArea textArea) {
		setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR)); // starts waiting cursor
		textArea.append("Square Roots");
		for (int i = 0; i <= maximum; i++) {
			textArea.append("\n[" + i + "]  " + Math.sqrt(i));
			progressBar.setValue(i);
			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ProgressBarExample();
			}
		});
	}
}