package queueExample;


import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QueueDemo extends JPanel {
	private static final long serialVersionUID = 1L;

    Queue<String> q = new Queue<String>();
    MyTableModel<String> model = new MyTableModel<String>(q);
	
    int next = 2000;
    public QueueDemo() {
   
        super(new BorderLayout());
       
        final JTable table = new JTable(model );
        table.setPreferredScrollableViewportSize(new Dimension(300, 40));
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
        	public Component getTableCellRendererComponent(JTable table,
					 Object value,
					 boolean isSelected,
					 boolean hasFocus,
					 int row,
					 int column)
{
	super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	setHorizontalAlignment( CENTER );
	return this;
        }});

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);
        
        //Add the scroll pane to this panel.
        add(scrollPane, BorderLayout.CENTER);
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.Y_AXIS));
        add(buttonPane, BorderLayout.EAST);
        buttonPane.add(new JLabel("Add"));
        final JTextField addField = new JTextField(12);
        buttonPane.add(addField);
        addField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				model.add(addField.getText());
				addField.setText("");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(QueueDemo.this,
						    e.getMessage(),
						    "Add error",
						    JOptionPane.ERROR_MESSAGE);
					
				}
			}} );
        buttonPane.add(Box.createRigidArea(new Dimension(10, 10)));
        JButton removeButton = new JButton("remove");
        buttonPane.add(removeButton);
        removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				String t = model.remove();
				System.out.println(t);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(QueueDemo.this,
						    e.getMessage(),
						    "Removal error",
						    JOptionPane.ERROR_MESSAGE);
					
				}
			}} );
        
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        //Create and set up the window.
        JFrame frame = new JFrame("QueueDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        QueueDemo newContentPane = new QueueDemo();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
