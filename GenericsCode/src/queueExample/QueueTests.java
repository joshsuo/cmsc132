package queueExample;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueueTests {

	@Test
	public void testAdd4() {
		Queue<Integer> q = new Queue<Integer>();
		assertEquals(0, q.size());
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		assertEquals(4, q.size());
	}

	@Test
	public void testAdd6() {
		Queue<Integer> q = new Queue<Integer>();
		assertEquals(0, q.size());
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		q.add(6);
		assertEquals(6, q.size());
	}

	@Test
	public void testAddAndRemove() {
		Queue<Integer> q = new Queue<Integer>();
		for (int i = 1; i < 5; i++)
			q.add(i);
		for (int i = 1; i < 3; i++)
			assertEquals(i, (int) q.remove());
		assertEquals(2, q.size());
		for (int i = 5; i < 10; i++)
			q.add(i);
		for (int i = 3; i < 10; i++)
			assertEquals(i, (int) q.remove());

		assertEquals(0, q.size());
		q.add(2);
	}
}
