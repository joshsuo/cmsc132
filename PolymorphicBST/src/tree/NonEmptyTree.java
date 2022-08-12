package tree;

import java.util.Collection;

/**
 * This class represents a non-empty search tree. An instance of this class
 * should contain:
 * <ul>
 * <li>A key
 * <li>A value (that the key maps to)
 * <li>A reference to a left Tree that contains key:value pairs such that the
 * keys in the left Tree are less than the key stored in this tree node.
 * <li>A reference to a right Tree that contains key:value pairs such that the
 * keys in the right Tree are greater than the key stored in this tree node.
 * </ul>
 *  
 */
 public class NonEmptyTree<K extends Comparable<K>, V> implements Tree<K, V> {

	/* Provide whatever instance variables you need */
	 private K key;
	 private V value;
	 private Tree<K,V> left;
	 private Tree<K,V> right;

	/**
	 * Only constructor we need.
	 * @param key
	 * @param value
	 * @param left
	 * @param right
	 */
	public NonEmptyTree(K key, V value, Tree<K,V> left, Tree<K,V> right) {

		this.key = key;
		this.value = value;
		this.left = left;
		this.right = right;
		
	}

	public V search(K key) {
		
		if(this.key.compareTo(key) == 0)
			return this.value;
		else if(this.key.compareTo(key) > 0)
		{
			return this.left.search(key);
		}
		else
		{
			return this.right.search(key);
		}
		
	}
	
	public NonEmptyTree<K, V> insert(K key, V value) {
		
		if(key == null)
			return this;
		
		if(this.key.compareTo(key) == 0)
		{
			this.value = value;
		}
		else if(this.key.compareTo(key) > 0)
		{
			this.left = this.left.insert(key, value);
		}
		else
		{
			this.right = this.right.insert(key, value);
		}
		return this;
		
	}
	
	public Tree<K, V> delete(K key) {
		
		V val = search(key);
		
		if(val == null)
			return this;
		
		if(this.key.compareTo(key) == 0)
		{
			try {
				K max = this.left.max();
				this.key = max;
				this.value = this.left.search(max);
				this.left = this.left.delete(max);
			}
			catch(TreeIsEmptyException e)
			{
				try {
					K min = this.right.min();
					this.key = min;
					this.value = this.right.search(min);
					this.right = this.right.delete(min);
				}
				catch(TreeIsEmptyException e2)
				{
					return EmptyTree.getInstance();
				}
				
				//return EmptyTree.getInstance();
			}
		}
		else if(this.key.compareTo(key) > 0)
		{
			this.left = this.left.delete(key);
		}
		else
		{
			this.right = this.right.delete(key);
		}
		return this;
	}

	public K max() {
		
		K max;
		
		try {
			max = this.right.max();
		}
		catch(TreeIsEmptyException e)
		{
			max = this.key;
		}
		return max;
	}

	public K min() {
		
		K min;
		
		try {
			min = this.left.min();
		}
		catch(TreeIsEmptyException e)
		{
			min = this.key;
		}
		return min;
		
	}

	public int size() {
		
		return left.size() + right.size() + 1;
		
	}

	public void addKeysToCollection(Collection<K> c) {
		
		c.add(this.key);
		this.left.addKeysToCollection(c);
		this.right.addKeysToCollection(c);
	}
	
	public Tree<K,V> subTree(K fromKey, K toKey) {
		
		if(this.key.compareTo(toKey) > 0)
		{
			return this.left.subTree(fromKey, toKey);
		}
		else if(this.key.compareTo(fromKey) < 0)
		{
			return this.right.subTree(fromKey, toKey);
		}
		else
		{
			return new NonEmptyTree<K,V>(this.key, this.value,
					this.left.subTree(fromKey, toKey), this.right.subTree(fromKey, toKey));
		}
		
	}
	
	public int height() {
		
		int leftHeight = this.left.height();
		int rightHeight = this.right.height();
		
		int height = (leftHeight > rightHeight ? leftHeight : rightHeight) + 1;

		
		return ((leftHeight > rightHeight ? leftHeight : rightHeight) + 1);
	}
	
	public void inorderTraversal(TraversalTask<K,V> p) {
		
		if(p == null)
			return;
		
		this.left.inorderTraversal(p);
		p.performTask(this.key, this.value);
		this.right.inorderTraversal(p);
		
	}
	
	public void rightRootLeftTraversal(TraversalTask<K,V> p) {
		
		if(p == null)
			return;
		
		this.right.rightRootLeftTraversal(p);
		p.performTask(this.key, this.value);
		this.left.rightRootLeftTraversal(p);
		
	}	
}