package listClasses;

import java.util.Comparator;

public class SortedLinkedList<T> extends BasicLinkedList<T>
{
	private Comparator<T> comparator;
	
	public SortedLinkedList(Comparator<T> comparator)
	{
		super();
		this.comparator = comparator;
	}
	
	public SortedLinkedList<T> add(T element)
	{
		Node newElement = new Node(element);
		Node prev = null, curr = head;
		
		while(curr != null)
		{
			int compared = comparator.compare(element, curr.data);
			
			if(compared <= 0)
			{
				newElement.next = curr;
				if(prev == null)
					head = newElement;
				else
				{
					prev.next = newElement;
					prev = newElement;
				}
				size++;
				return this;
			}
			
			prev = curr;
			curr = curr.next;
		}
		super.addToEnd(element);
		
		return this;
	}
	
	public SortedLinkedList<T> remove(T targetData)
	{
		return (SortedLinkedList<T>) super.remove(targetData, this.comparator);
	}
	
	@Override
	public BasicLinkedList<T> addToEnd(T data)
	{
		throw new UnsupportedOperationException("Invalid operation for sorted list.");
	}
	
	@Override
	public BasicLinkedList<T> addToFront(T data)
	{
		throw new UnsupportedOperationException("Invalid operation for sorted list.");
	}
	
	
}

