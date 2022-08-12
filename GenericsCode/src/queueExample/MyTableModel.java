package queueExample;

import javax.swing.table.AbstractTableModel;

class MyTableModel<T> extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private final Queue<T> queue;

	MyTableModel(Queue<T> queue) {
		this.queue = queue;
	}

	public void add(T t) {
		int length = queue.length();
		queue.add(t);
		if (length == queue.length())
			fireTableDataChanged();
		else {
			fireTableStructureChanged();
		}
	}

	public T remove() {
		T t = queue.remove();
		fireTableDataChanged();
		return t;
	}

	public String getColumnName(int col) {
		return Integer.toString(col);
	}

	public int getRowCount() {
		return 3;
	}

	public int getColumnCount() {
		return queue.length();
	}

	public Object getValueAt(int row, int col) {
		if (row == 0 && col < queue.length())
			return this.queue.dataAt(col);
		if (row == 1 && col == this.queue.front())
			return "front";
		if (row == 2 && col == this.queue.rear())
			return "rear";
		return "";
	}
}