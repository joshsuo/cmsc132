package tests;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

import org.junit.Test;

import junit.framework.TestCase;
import tree.PlaceKeysValuesInArrayLists;
import tree.PolymorphicBST;


public class StudentTests extends TestCase {

	@Test
	public void testSearch1()
	{
		PolymorphicBST<Integer,String> tree = new PolymorphicBST<Integer,String>();
		
		tree.put(2, "two");
		
		assertEquals(tree.get(1), null);
		
	}

	@Test
	public void testSearch2()
	{
		PolymorphicBST<Integer,String> tree = new PolymorphicBST<Integer,String>();
		
		tree.put(2, "two");
		tree.put(3, "three");
		tree.put(4, "four");
		tree.put(5, "five");
		tree.put(4, "Four");
		
		assertEquals(tree.get(4), "Four");
	}
	
	@Test
	public void testInsert1()
	{
		PolymorphicBST<Integer,String> tree = new PolymorphicBST<Integer,String>();
		
		tree.put(2, "two");
		tree.put(3, "three");
		tree.put(4, "four");
		tree.put(5, "five");
		tree.put(4, "Four");
		tree.put(1, "one");
		tree.put(20, "twenty");
		
		assertEquals(tree.get(19), null);
		assertEquals(tree.get(20), "twenty");
	}
	
	@Test
	public void testInsert2()
	{
		PolymorphicBST<String,Integer> tree = new PolymorphicBST<String,Integer>();
		
		tree.put("one", 1);
		tree.put("one", 1111);
		
		assertEquals(tree.get("one"), Integer.valueOf(1111));
		//assertEquals(tree.get("One"), Integer.valueOf(1));
	}
	
	
	//delete only works with root, nothing else
	@Test
	public void testDelete1()
	{
		PolymorphicBST<Integer,String> tree = new PolymorphicBST<Integer,String>();
		
		tree.put(2, "two");
		tree.put(3, "three");
		tree.put(4, "four");
		tree.put(5, "five");
		tree.put(4, "Four");
		tree.put(1, "one");
		tree.put(20, "twenty");
		
		tree.remove(1);
		
		assertEquals(tree.get(1), null);
	}
	
	@Test
	public void testDelete2()
	{
		PolymorphicBST<Integer,String> tree = new PolymorphicBST<Integer,String>();
		
		tree.put(2, "two");
		tree.put(2, "Two");
		tree.put(3, "three");
		
		tree.remove(3);
		
		assertEquals(tree.get(3), null);
	}
	
	@Test
	public void testMax1()
	{
		PolymorphicBST<Integer,String> tree = new PolymorphicBST<Integer,String>();
		
		tree.put(2, "two");
		tree.put(3, "three");
		tree.put(4, "four");
		tree.put(5, "five");
		tree.put(4, "Four");
		tree.put(1, "one");
		tree.put(20, "twenty");
		
		assertEquals(tree.getMax(), Integer.valueOf(20));
	}
	
	@Test
	public void testMax2()
	{
		PolymorphicBST<String,Integer> tree = new PolymorphicBST<String,Integer>();
		
		tree.put("two", 2);
		tree.put("Two", 2);
		tree.put("twO", 2);
		
		assertEquals(tree.getMax(), "two");
	}
	
	//should catch some exception
	@Test
	public void testMax3()
	{
		PolymorphicBST<String,Integer> tree = new PolymorphicBST<String,Integer>();
		
		tree.put("two", 2);
		tree.put("Two", 2);
		tree.put("twO", 2);
		
		assertEquals(tree.getMax(), "two");
	}
	
	@Test
	public void testMin1()
	{
		PolymorphicBST<String,Integer> tree = new PolymorphicBST<String,Integer>();
		
		tree.put("two", 2);
		tree.put("Two", 2);
		tree.put("twO", 2);
		
		assertEquals(tree.getMin(), "Two");
	}
	
	@Test
	public void testMin2()
	{
		PolymorphicBST<Integer,String> tree = new PolymorphicBST<Integer,String>();
		
		tree.put(2, "two");
		tree.put(3, "three");
		tree.put(4, "four");
		tree.put(5, "five");
		tree.put(4, "Four");
		tree.put(1, "one");
		tree.put(20, "twenty");
		tree.put(-4, "neg four");
		
		assertEquals(tree.getMin(), Integer.valueOf(-4));
	}
	
	//should catch some exception
	@Test
	public void testMin3()
	{
		PolymorphicBST<String,Integer> tree = new PolymorphicBST<String,Integer>();
		
		tree.put("two", 2);
		tree.put("Two", 2);
		tree.put("twO", 2);
		
		assertEquals(tree.getMin(), "Two");
	}
	
	@Test
	public void testSize1()
	{
		PolymorphicBST<Integer,String> tree = new PolymorphicBST<Integer,String>();
		
		tree.put(2, "two");
		tree.put(3, "three");
		tree.put(4, "four");
		tree.put(5, "five");
		tree.put(4, "Four");
		tree.put(1, "one");
		tree.put(20, "twenty");
		tree.put(-4, "neg four");
		
		assertEquals(tree.size(), 7);
	}
	
	@Test
	public void testSize2()
	{
		PolymorphicBST<Integer,String> tree = new PolymorphicBST<Integer,String>();
		
		tree.put(2, "two");
		tree.put(3, "three");
		tree.put(4, "four");
		tree.put(5, "five");
		tree.put(4, "Four");
		tree.put(1, "one");
		tree.put(20, "twenty");
		tree.put(-4, "neg four");
		
		assertEquals(tree.size(), 7);
	}
	
	@Test
	public void testaddKeysToCollection1()
	{
		PolymorphicBST<Integer,String> tree = new PolymorphicBST<Integer,String>();
		
		Set<Integer> keys = null;

		tree.put(2, "two");
		tree.put(3, "three");
		tree.put(4, "four");
		tree.put(5, "five");
		tree.put(4, "Four");
		tree.put(1, "one");
		tree.put(20, "twenty");
		tree.put(-4, "neg four");
		
		keys = tree.keySet();
		
		assertEquals("[1, 2, -4, 3, 4, 20, 5]", keys.toString());
		
		//System.out.println(keys);
		
	}

	@Test
	public void testaddKeysToCollection2()
	{
		PolymorphicBST<Integer,String> tree = new PolymorphicBST<Integer,String>();
		
		Set<Integer> keys = null;

		tree.put(2, "two");
		tree.put(2, "Two");
		tree.put(3, "three");
		
		keys = tree.keySet();
		
		assertEquals(keys.contains(2), true);
		assertEquals(keys.contains(3), true);
		assertEquals(keys.contains(1), false);
	}
	
	@Test
	public void testSubMap1()
	{
		PolymorphicBST<Integer,String> tree = new PolymorphicBST<Integer,String>();
		PolymorphicBST<Integer,String> subTree;

		tree.put(2, "two");
		tree.put(3, "three");
		tree.put(4, "four");
		tree.put(5, "five");
		tree.put(1, "one");
		tree.put(20, "twenty");
		tree.put(-4, "neg four");
		
		subTree = tree.subMap(-4, 2);
		
		//System.out.println(subTree.size());
		
		assertEquals(3, subTree.size());
		assertEquals(true, subTree.keySet().contains(-4));
		assertEquals(false, subTree.keySet().contains(3));
		
	}
	
	@Test
	public void testSubMap2()
	{
		PolymorphicBST<Integer,String> tree = new PolymorphicBST<Integer,String>();
		PolymorphicBST<Integer,String> subTree;

		tree.put(2, "two");
		tree.put(3, "three");
		tree.put(4, "four");
		tree.put(5, "five");
		tree.put(1, "one");
		tree.put(20, "twenty");
		tree.put(-4, "neg four");
		
		subTree = tree.subMap(20, 22);
		
		//System.out.println(subTree.size());
		
		assertEquals(1, subTree.size());
		
	}
	
	@Test
	public void testHeight1()
	{
		PolymorphicBST<Integer,String> tree = new PolymorphicBST<Integer,String>();
		
		tree.put(1, "one");
		
		assertEquals(tree.height(), 1);
		
	}
	
	@Test
	public void testHeight2()
	{
		PolymorphicBST<Integer,String> tree = new PolymorphicBST<Integer,String>();
		
		tree.put(1, "one");
		tree.put(2, "two");
		tree.put(-1, "neg one");
		tree.put(0, "zero");
		
		assertEquals(tree.height(), 3);
	}
	
	@Test
	public void testHeight3()
	{
		PolymorphicBST<Integer,String> tree = new PolymorphicBST<Integer,String>();
		
		tree.put(1, "one");
		tree.put(2, "two");
//		tree.put(3, "three");
//		tree.put(4, "four");
//		tree.put(5, "five");
		
		assertEquals(tree.height(), 2);
	}
	
	@Test
	public void testinorderTraversal1()
	{
		PolymorphicBST<Integer,String> tree = new PolymorphicBST<Integer,String>();
		
		tree.put(2, "Two");
		tree.put(1, "One");
		tree.put(3, "Three");
		tree.put(4, "Four");
		tree.put(-1, "neg one");
		tree.put(0, "zero");
		
		PlaceKeysValuesInArrayLists<Integer, String> task = new PlaceKeysValuesInArrayLists<Integer, String>();
		tree.inorderTraversal(task);
		
		assertEquals(task.getKeys().toString(), "[-1, 0, 1, 2, 3, 4]");
		assertEquals(task.getValues().toString(), "[neg one, zero, One, Two, Three, Four]");
		
	}
	
	@Test
	public void testinorderTraversal2()
	{
		PolymorphicBST<Integer,String> tree = new PolymorphicBST<Integer,String>();
		
		tree.put(2, "Two");
		tree.put(-1, "neg one");
		tree.put(0, "zero");
		
		PlaceKeysValuesInArrayLists<Integer, String> task = new PlaceKeysValuesInArrayLists<Integer, String>();
		tree.inorderTraversal(task);
		
		assertEquals(task.getKeys().toString(), "[-1, 0, 2]");
		assertEquals(task.getValues().toString(), "[neg one, zero, Two]");
	}
	
	@Test
	public void testrightRootLeftTraversal1()
	{
		PolymorphicBST<Integer,String> tree = new PolymorphicBST<Integer,String>();
		
		tree.put(2, "Two");
		tree.put(1, "One");
		tree.put(3, "Three");
		tree.put(4, "Four");
		tree.put(-1, "neg one");
		tree.put(0, "zero");
		
		PlaceKeysValuesInArrayLists<Integer, String> task = new PlaceKeysValuesInArrayLists<Integer, String>();
		tree.rightRootLeftTraversal(task);
		
		assertEquals(task.getKeys().toString(), "[4, 3, 2, 1, 0, -1]");
		assertEquals(task.getValues().toString(), "[Four, Three, Two, One, zero, neg one]");
	}
	
	@Test
	public void testrightRootLeftTraversal2()
	{
		PolymorphicBST<Integer,String> tree = new PolymorphicBST<Integer,String>();
		
		tree.put(2, "Two");
		tree.put(-1, "neg one");
		tree.put(0, "zero");
		
		PlaceKeysValuesInArrayLists<Integer, String> task = new PlaceKeysValuesInArrayLists<Integer, String>();
		tree.rightRootLeftTraversal(task);
		
		assertEquals(task.getKeys().toString(), "[2, 0, -1]");
		assertEquals(task.getValues().toString(), "[Two, zero, neg one]");
	}
	
	@Test
	public void testClear()
	{
		PolymorphicBST<Integer,String> tree = new PolymorphicBST<Integer,String>();

		tree.put(2, "two");
		tree.put(3, "three");
		tree.put(4, "four");
		tree.put(5, "five");
		tree.put(1, "one");
		tree.put(20, "twenty");
		tree.put(-4, "neg four");
		
		assertEquals(7, tree.size());		
		
		tree.clear();
		
		assertEquals(0, tree.size());
		
	}
}