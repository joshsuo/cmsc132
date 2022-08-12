package collectionExample;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class Example1 {

	public static void main(String[] args) {
		Collection <Integer> c = new ArrayList<Integer>();
		c.add(5);
		c.add(8);
		c.add(25);
		System.out.println(c.add(54));
		
		Iterator <Integer> iter = c.iterator();
		
		for(Integer i: c)
			System.out.println(i);
		System.out.println("----------");
		
		iter.forEachRemaining(i->System.out.println(i));  //lambda expression on what to do to each element
		
		System.out.println("----------");
		
		iter = c.iterator();
		//iter.remove();  //will throw exception, must call next first
		iter.next(); //returns 5
		iter.next(); //returns  8
		iter.remove();  //removes last thing returned by next
		
		for(Integer i: c)  //8 will not be here
			System.out.println(i);
		System.out.println("----------");
		

		Collection <Integer> c1 = new HashSet <Integer>();  //fast membership test but order not maintained 
		c1.add(5);
		c1.add(81);
		c1.add(25);
		System.out.println(c1.add(25));  //sets don't allow duplicates
		
		for(Integer i: c1)      //will visit all elements but not in order they were added.  Details abstracted out
			System.out.println(i);
		System.out.println("----------");

	}

}
