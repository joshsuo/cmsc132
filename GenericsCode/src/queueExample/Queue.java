package queueExample;

import java.util.NoSuchElementException;

public class Queue<T> {
	@SuppressWarnings("unchecked")
	private T data[] = (T[]) new Object[4];
	private int front = 0, rear = data.length - 1, size = 0;

	public int size() {
		return size;
	}

	public boolean empty() {
		return size() == 0;
	}

	public int length() {
		return data.length;
	}

	public int front() {
		return front;
	}

	public int rear() {
		return rear;
	}

	public T dataAt(int index) {
		return data[index];
	}

	public boolean full() {
		return size() == data.length;
	}

	public T remove() {
		if (empty())
			throw new NoSuchElementException("Queue is empty");
		T result = data[front];
		data[front] = null;
		front++;
		size--;
		if (front == data.length)
			front = 0;

		return result;
	}

	public void add(T t) {
		if (full()) {
			resize();
		}
		size++;
		rear++;
		if (rear == data.length)
			rear = 0;

		data[rear] = t;
	}

	private void resize() {
		T newData[] = (T[]) new Object[data.length * 2];
		
		for (int i = 0; i < size; i++)
			newData[i] = data[(i + front) % data.length];
		front = 0;
		rear = size - 1;
		data = newData;
	}
}