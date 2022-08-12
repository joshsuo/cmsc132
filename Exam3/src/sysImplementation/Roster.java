package sysImplementation;

import java.util.Arrays;
import java.util.Iterator;


public class Roster implements Comparable<Roster>, Iterable<Integer>, Cloneable{
	private int [] ids;
	private String name;
	
	
	//assume id is not null and has unique 3 digit ids
	public Roster(int []ids, String name) {
		this.ids = new int[ids.length];
		for (int i =0; i<ids.length; i++)
		{
			this.ids[i] =ids[i];
		}
		this.name = name;
	
	}
	
	//Do not change this method, but you will not use it in your code
	//used only in driver and the tests
	public void badRoster() {
		for (int i =0; i<ids.length; i++)
		{
			ids[i] =-1;
		}

	}
	
	//no changes
	@Override
	public String toString() {
		return "Roster [ids=" + Arrays.toString(ids) + ", name=" + name + "]";
	}

	
	@Override
	public Roster clone()
	{
		Roster cloned;
		try
		{
			cloned = (Roster) super.clone();
			cloned.ids = this.ids.clone();
			return cloned;
		}
		catch(CloneNotSupportedException e)
		{
			e.printStackTrace();
		}
		return null;
	}



	@Override
	public int compareTo(Roster o)
	{
		int CSIds = 0;
		int otherCSIds = 0;
		for(int i = 0; i < this.ids.length; i++)
		{
			if(this.ids[i] >= 200 && this.ids[i] <= 299)
			{
				CSIds++;
			}
		}
			
		for(int j = 0; j < o.ids.length; j++)
		{
			if(o.ids[j] >= 200 && o.ids[j] <= 299)
			{
				otherCSIds++;
			}
		}
		
		if(otherCSIds < CSIds)
		{
			return 1;
		}
		else if(otherCSIds == CSIds)
		{
			return 0;
		}
		else
		{
			return -1;
		}

	}




	@Override
	public Iterator<Integer> iterator()
	{
		return new Iterator<Integer>()
		{
			private int pos = 0;
			private int[] cSList;
			
			//initialization block
			{
				int CSIds = 0;
				for(int i = 0; i < ids.length; i++)
				{
					if(ids[i] >= 200 && ids[i] <= 299)
					{
						CSIds++;
					}
				}
				cSList = new int[CSIds];
				
				int j = 0;
				
				for(int i = 0; i < ids.length; i++)
				{
					if(ids[i] >= 200 && ids[i] <= 299)
					{
						cSList[j++] = ids[i];
					}
				}
				
			}
			
			@Override
			public boolean hasNext()
			{
				return pos < cSList.length;
			}

			@Override
			public Integer next()
			{
				return cSList[pos++];
				
			}
			
		};
		
	
	}

}
