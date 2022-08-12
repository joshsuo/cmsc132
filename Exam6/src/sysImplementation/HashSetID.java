package sysImplementation;

import java.util.Arrays;

public class HashSetID {
	
	private int[] hashTable;
	private int size;
	private int capacity;
	
	
	
	public HashSetID(int capacity) {
		if (capacity <= 0 )
			throw new IllegalArgumentException("capacity must be positive");
		this.capacity = capacity;
		this.hashTable = new int[capacity];
		this.size = 0;
	}

	public int getSize() {
		return size;
	}

	public int getCapacity() {
		return capacity;
	}
	
	/*
	 * Do not modify this method, otherwise you will not pass release/secret tests
	 */
	public String showMeTable()
	{
		return Arrays.toString(hashTable);
	}
	
	/*
	 * Do not modify this method, otherwise you will not pass release/secret tests
	 */
	//gives hash index of the id
	
	 private int hashFunction(int id) {
		id += ~(id << 9);
		id ^= (id >>> 14);
		id += (id << 4);
		id ^= (id >>> 10);
		return Math.abs(id % capacity);
	}
	
	 private boolean validID(int id) {
		   if (id>=100 && id <=999)
			   return true;
			return false;
	}
		
	
	 
	
	//returns true if id is in the hashset
	//false if not or invalid id
	 
	public boolean contains(int id) {	
		 
		int hashIndex = hashFunction(id);
		
		if(this.hashTable[hashIndex] == id)
		{
			return true;
		}
		else
		{
			int first = hashIndex;
			hashIndex += 1;
			hashIndex %= capacity;
			while(this.hashTable[hashIndex] != id && first != hashIndex)
			{
				hashIndex++;
				hashIndex %= capacity;
			}
			return (first != hashIndex ? true : false);
		}
		//return false;
	}
	
		
	public boolean insert (int id) {
		
		if(this.size == this.capacity || validID(id) == false || contains(id))
			return false;
		
		int hashIndex = hashFunction(id);
		
		if(this.hashTable[hashIndex] <= 0)
		{
			this.hashTable[hashIndex] = id;
			size++;
		}
		else
		{
			while(this.hashTable[hashIndex] > 0)
			{
				hashIndex++;
				hashIndex %= this.capacity;
			}
			this.hashTable[hashIndex] = id;
			size++;
		}
		return true;
	}

	 public boolean remove (int id) {
		
		 if(validID(id) == false || contains(id) == false)
			 return false;
		 
		 int hashIndex = hashFunction(id);
		 
		 if(hashTable[hashIndex] == id)
		 {
			 hashTable[hashIndex] = -1;
			 size--;
		 }
		 else
		 {
			 while(hashTable[hashIndex] != id)
			 {
				 hashIndex++;
				 hashIndex %= this.capacity;
			 }
			 hashTable[hashIndex] = -1;
			 size--;
		 }
		 return true;
		
	}
	
	public double loadFactor(){
		
		return (double) size/capacity;
		
	}
	
	


}
