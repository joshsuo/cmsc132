package listClasses;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class BasicLinkedList<T> implements Iterable<T>
{
	protected class Node {
		protected T data;
		protected Node next;

		public Node(T data) {
			this.data = data;
			next = null;
		}
	}
	
	protected Node head;
	protected Node tail;
	protected int size;
	
	public BasicLinkedList()
	{
		this.head = null;
		this.tail = null;
	}
	
	public int getSize()
	{
		return this.size;
	}
	
	public BasicLinkedList<T> addToEnd(T data)
	{
		Node newElement = new Node(data);
		
		if (tail == null) {
			head = newElement;
            tail = newElement;
            size++;
            return this;
        }
        else
        {
        	tail.next = newElement;
        	tail = newElement;
        	tail.next = null;
        	size++;
        	return this;
        }
		
	}
	
	public BasicLinkedList<T> addToFront(T data)
	{
		Node newElement = new Node(data);

        if (head == null) {
            head = newElement;
            size++;
            return this;
        }
        else
        {
        	newElement.next = head;
        	head = newElement;
        	size++;
        	return this;
        }
	}
	
	public T getFirst()
	{
		return head.data;
	}
	
	public T getLast()
	{
		return tail.data;
	}
	
	public T retrieveFirstElement()
	{
		Node result = head;
		head = head.next;
		size--;
		
		return result.data;
	}
	
	public T retrieveLastElement()
	{
		Node prev = null;
		Node curr = head;
		
		while(curr.next != null)
		{
			prev = curr;
			curr = curr.next;
		}
		
		tail = prev;
		tail.next = null;
		
		size--;
		
		return curr.data;
	}
	
	public BasicLinkedList<T> remove(T targetData, Comparator<T> comparator)
	{
		Node prev = null, curr = head;

		while (curr != null) {
			if(comparator.compare(targetData, curr.data) == 0) {
				if (curr == head) {
					head = head.next;
				} else {
					prev.next = curr.next;
				}
				curr = curr.next;
				size--;
				continue;
			}
			prev = curr;
			curr = curr.next;
			
		}
		return this;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>()
		{
			private int pos = 0;
			
			
			@Override
			public boolean hasNext() {
				return pos < size;
			}

			@Override
			public T next() {
				Node curr = head;
				Node prev = null;
				int index = 0;
				
				while(curr != null)
				{
					if(index == pos)
					{
						pos++;
						return curr.data;
					}
					index++;
					prev = curr;
					curr = curr.next;
				}
				return null;
			}
			
			@Override
			public void remove()
			{
				throw new UnsupportedOperationException();
			}
			
		};
	}
	
	//aux method
	private void getReverseArrayList(Node curr, ArrayList<T> array)
	{
		 if (curr != null) {
			 getReverseArrayList(curr.next, array);
			 array.add(curr.data);
		 }
	}
	
	//use recursion
	public ArrayList<T> getReverseArrayList()
	{
		ArrayList<T> list = new ArrayList<T>();
		
		getReverseArrayList(head, list);
		return list;
	}
	
	//aux method
	private void getReverseList(Node curr, BasicLinkedList<T> result)
	{
		if (curr != null) {
			getReverseList(curr.next, result);
			result.addToEnd(curr.data);
		 }
	}
	
	//use recursion
	public BasicLinkedList<T> getReverseList()
	{
		BasicLinkedList<T> list = new BasicLinkedList<T>();
		
		getReverseList(head, list);
		return list;
	}

	
}


