package sysImplementation;

import java.util.ArrayList;
import java.util.Collections;

public class Roster {
	
	private class Node {
		private int id;
		private Node next;

		private Node(int id) {
			this.id = id;
			next = null; 
		}
	}
	
	
	/* List tail pointer */
	private Node tail;
	private String name;
	private int size;
	
	
	//assume 3 digit id
	public Roster(String name, int id) {
		this.name = name;
		tail = new Node(id);
		tail.next = tail;
		size = 1;
	
	}
	
	// just forms a string with all ids 
	private String ids() {
		Node temp = tail.next;
		String idStr ="";
		int counter =1;
		while(counter <=size)
		{
			idStr+=temp.id+" ";
			counter++;
			temp = temp.next;
		}
		return idStr;
	}
	
	@Override
	public String toString() {
		return "Roster [ids=" + ids() + ", name=" + name + "]";
	}


	public int getFirstId() {
		return tail.next.id;
	}
	
	public int getLastId() {
		return tail.id;
	}
	
	//assume unique 3 digit id will be passed in
	public void add(int id) {
		Node newNode = new Node(id);
		
		if(id >= 200 && id <=299)
		{
			newNode.next = tail.next;
			
			tail.next = newNode;
		}
		else
		{
			newNode.next = tail.next;
			
			tail.next = newNode;
			tail = newNode;
		}
		size++;
	}
	
	public ArrayList<Integer> getCSIds() {
		
		ArrayList<Integer> CSIds = new ArrayList<Integer>();
		
		getCSIdsAux(tail.next, CSIds);
		
		Collections.sort(CSIds);
	
		return CSIds;
	}
	
	//Write your own private RECURSIVE getCSIdsAux
	private void getCSIdsAux(Node node, ArrayList<Integer> CSIds)
	{
		if(node.id >= 200 && node.id <= 299)
		{
			CSIds.add(node.id);
		}
		
		if(node != tail)
		{
			getCSIdsAux(node.next, CSIds);
		}
	}


}
