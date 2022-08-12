package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import sysImplementation.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) 
public class StudentTests {
	
	@Test
	public void test1()
	{
		int answer = -1;
		
		int result = Utilities.linearSearchLast(null, 8);
		
		assertTrue(answer == result);
	}
	
	@Test
	public void test2()
	{
		int answer = -1;
		
		int result = Utilities.linearSearchLast(new int[] {2,0,0,3,2}, 8);
		
		assertTrue(answer == result);
	}
	
	@Test
	public void test3()
	{
		int answer = 4;
		
		int result = Utilities.linearSearchLast(new int[] {2,0,0,3,8}, 8);
		
		assertTrue(answer == result);
	}
	
	@Test
	public void test4()
	{
		int answer = 5;
		
		int result = Utilities.linearSearchLast(new int[] {8,8,8,8,8,8}, 8);
		
		assertTrue(answer == result);
	}
	
	@Test
	public void test5()
	{
		int answer = 5;
		
		int result = Utilities.linearSearchLast(new int[] {2,0,0,3,2,-4}, -4);
		
		assertTrue(answer == result);
	}
	
}