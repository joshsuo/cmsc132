package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;

import listClasses.BasicLinkedList;
import listClasses.SortedLinkedList;

public class StudentTests {

	@Test
	public void testGetSize() {
		BasicLinkedList<String> list = new BasicLinkedList<String>();
		
		String str = "hi";
		
		list.addToEnd(str);
		list.addToEnd(str);
		list.addToEnd(str);
		list.addToFront(str);
		//list.remove(str, String.CASE_INSENSITIVE_ORDER);
		
		assertEquals(4, list.getSize());
	}
	
	@Test
	public void testAddToEnd() {
		BasicLinkedList<Integer> list = new BasicLinkedList<Integer>();
		
		list.addToEnd(1);
		list.addToEnd(2);
		list.addToEnd(3);
		
		assertEquals((Integer)3, list.getLast());
	}
	
	@Test
	public void testAddToFront() {
		BasicLinkedList<Integer> list = new BasicLinkedList<Integer>();
		
		list.addToFront(1);
		list.addToFront(2);
		list.addToFront(3);
		
		assertEquals((Integer)3, list.getFirst());
	}
	
	@Test
	public void getFirst() {
		BasicLinkedList<Integer> list = new BasicLinkedList<Integer>();
		
		list.addToFront(1);
		list.addToFront(3);
		list.addToEnd(2);
		list.addToFront(5);
		
		assertEquals((Integer)5, list.getFirst());
	}
	
	@Test
	public void getLast() {
		BasicLinkedList<Integer> list = new BasicLinkedList<Integer>();
		
		list.addToEnd(3);
		list.addToFront(3);
		list.addToEnd(2);
		list.addToEnd(7);
		
		assertEquals((Integer)7, list.getLast());
	}
	
	@Test
	public void retrieveFirstElement() {
		BasicLinkedList<Integer> list = new BasicLinkedList<Integer>();
		
		list.addToEnd(3);
		list.addToFront(9);
		list.addToEnd(2);
		list.addToEnd(7);
		
//		Iterator<Integer> iterator = list.iterator();

		 
//		while(iterator.hasNext())
//		{
//			System.out.println(iterator.next());
//		}
		
		assertEquals((Integer)9, list.retrieveFirstElement());
	}
	
	@Test
	public void retrieveLastElement() {
		BasicLinkedList<Integer> list = new BasicLinkedList<Integer>();
		
		list.addToEnd(3);
		list.addToFront(9);
		list.addToEnd(2);
		list.addToEnd(7);
		
//		Iterator<Integer> iterator = list.iterator();
//
//		int num = list.retrieveLastElement();
//		System.out.println(num);
//		 
//		while(iterator.hasNext())
//		{
//			System.out.println(iterator.next());
//		}
		
		assertEquals((Integer)7, list.retrieveLastElement());
	}
	
	@Test
	public void remove() {
		BasicLinkedList<String> list = new BasicLinkedList<String>();
		
		list.addToEnd("Name");
		list.addToFront("SUP");
		list.addToFront("hello");
		list.addToEnd("sup");
		list.addToEnd("Hi");
		list.addToEnd("suP");
		list.remove("sUp", String.CASE_INSENSITIVE_ORDER);
		
		Iterator<String> iterator = list.iterator();
		
		String result = "";
		while(iterator.hasNext())
		{
			result += iterator.next();
		}
		
		assertEquals(result, "helloNameHi");
	}
	
	@Test
	public void iterator() {
		BasicLinkedList<String> list = new BasicLinkedList<String>();
		
		list.addToEnd("Name");
		list.addToFront("hello");
		list.addToEnd("sup");
		list.addToEnd("Hi");
		
		Iterator<String> iterator = list.iterator();
		
		String result = "";
		while(iterator.hasNext())
		{
			result += iterator.next();
		}
		
		assertEquals(result, "helloNamesupHi");
	}
	
	@Test
	public void getReverseArrayList() {
		BasicLinkedList<Integer> list = new BasicLinkedList<Integer>();
		
		list.addToEnd(1);
		list.addToEnd(2);
		list.addToEnd(3);
		
		ArrayList<Integer> array = list.getReverseArrayList();
		String result ="";
		
		for(Integer i : array)
		{
			result += i;
		}
		
		assertEquals(result, "321");
	}
	
	@Test
	public void getReverseArrayList1() {
		BasicLinkedList<Integer> list = new BasicLinkedList<Integer>();
		
		list.addToEnd(1);
		list.addToEnd(1);
		list.addToEnd(1);
		
		ArrayList<Integer> array = list.getReverseArrayList();
		String result ="";
		
		for(Integer i : array)
		{
			result += i;
		}
		
		assertEquals(result, "111");
	}
	
	@Test
	public void getReverseList() {
		BasicLinkedList<String> list = new BasicLinkedList<String>();
		
		//list.addToEnd("first");
		list.addToEnd("2nd");
		list.addToEnd("3rd");
		
		BasicLinkedList<String> newList = list.getReverseList();
		
		Iterator<String> iterator = newList.iterator();
		
		String result = "";
		while(iterator.hasNext())
		{
			result += iterator.next();
		}
		
		assertEquals(result, "3rd2nd");
	}
	
	@Test
	public void getReverseList1() {
		BasicLinkedList<String> list = new BasicLinkedList<String>();
		
		list.addToEnd("first");
		list.addToEnd("first");
		list.addToEnd("first");
		list.addToEnd("second");
		list.addToEnd("second");
		list.addToEnd("second");
		
		BasicLinkedList<String> newList = list.getReverseList();
		
		Iterator<String> iterator = newList.iterator();
		
		String result = "";
		while(iterator.hasNext())
		{
			result += iterator.next();
		}
		
		assertEquals(result, "secondsecondsecondfirstfirstfirst");
	}
	
	//sorted linked list tests
	@Test
	public void testAdd()
	{
		SortedLinkedList<String> list = new SortedLinkedList<String>
		(String.CASE_INSENSITIVE_ORDER);
		
		list.add("2nd");
		list.add("3rd");
		list.add("1st");
		list.add("3rd");
		list.add("1st");
		
		Iterator<String> iterator = list.iterator();
		
		String result = "";
		while(iterator.hasNext())
		{
			result += iterator.next();
			//System.out.println(result);
		}
		
		assertEquals(result, "1st1st2nd3rd3rd");
	}
	
	@Test
	public void testRemove()
	{
		SortedLinkedList<String> list = new SortedLinkedList<String>
		(String.CASE_INSENSITIVE_ORDER);
		
		list.add("2nd");
		list.add("3rd");
		list.add("2nd");
		list.add("1st");
		list.remove("2nd");
		
		Iterator<String> iterator = list.iterator();
		
		String result = "";
		while(iterator.hasNext())
		{
			result += iterator.next();
			
		}
		
		//System.out.println(result);
		
		assertEquals(result, "1st3rd");
	}
	
	@Test
	public void testRemove1()
	{
		SortedLinkedList<String> list = new SortedLinkedList<String>(String.CASE_INSENSITIVE_ORDER);
		
		list.add("2nd");
		list.add("2nd");
		list.add("2nd");
		list.add("2nd");
		list.remove("2nd");
		
		Iterator<String> iterator = list.iterator();
		
		String result = "";
		while(iterator.hasNext())
		{
			result += iterator.next();
			
		}
		
		//System.out.println(result);
		
		assertEquals(result, "");
	}
	
	@Test//(expected = UnsupportedOperationException.class)
	public void testAddToEnd1()
	{
		SortedLinkedList<String> list = new SortedLinkedList<String>
		(String.CASE_INSENSITIVE_ORDER);
		
		try
		{
			list.addToEnd("hey");
		}
		catch(UnsupportedOperationException e)
		{
			assertEquals("Invalid operation for sorted list.", e.getMessage());
		}

	}
	
	@Test
	public void testAddToFront1()
	{
		SortedLinkedList<String> list = new SortedLinkedList<String>
		(String.CASE_INSENSITIVE_ORDER);
		
		try
		{
			list.addToFront("hey");
		}
		catch(UnsupportedOperationException e)
		{
			assertEquals("Invalid operation for sorted list.", e.getMessage());
		}
		
		
	}
	
	@Test
	public void sampleTest() {
		BasicLinkedList<String> basicList = new BasicLinkedList<String>();

		basicList.addToEnd("Red").addToFront("Yellow").addToFront("Blue");
		System.out.println("First: " + basicList.getFirst());
		System.out.println("Last: " + basicList.getLast());
		System.out.println("Size: " + basicList.getSize());
		System.out.println("Retrieve First: " + basicList.retrieveFirstElement());
		System.out.println("Retrieve Last: " + basicList.retrieveLastElement());
		System.out.println("Removing Red");
		basicList.remove("Red", String.CASE_INSENSITIVE_ORDER);
		System.out.print("Iteration: ");
		for (String entry : basicList) {
			System.out.print(entry + " ");
		}
		
		SortedLinkedList<String> sortedList = new SortedLinkedList<String>(String.CASE_INSENSITIVE_ORDER);
		sortedList.add("Yellow").add("Red");
		System.out.print("\n\nIteration (for sorted list): ");
		for (String entry : sortedList) {
			System.out.print(entry + " ");
		}
		sortedList.remove("Red");
		System.out.print("\nAfter remove in sorted list first is: ");
		System.out.println(sortedList.getFirst());
	}

}
