package sysImplementation;

import java.util.ArrayList;
import java.util.Collections;


public class Roster {
	private ArrayList<Integer> ids;
	private int totalSeats;

	

	//you can assume if ids parameter is not null or empty, it will contain UNIQUE 3 digit id # in range of 100 to 999(inclusive)
	public Roster(ArrayList<Integer> ids, int totalSeats) throws InvalidListException
	{
		if(ids == null || ids.size() > totalSeats || totalSeats <= 0)
		{
			throw new InvalidListException("Error");
		}
		
		this.ids = new ArrayList<Integer>();
		
		this.totalSeats = totalSeats;
		
		for(int i = 0; i < ids.size(); i++)
		{
			this.ids.add(ids.get(i));
		}
		
		Collections.sort(this.ids);
		
	}

	public Roster(Roster roster) throws InvalidListException
	{
		this(roster.ids, roster.totalSeats);
	}
	
	public ArrayList <Integer> getRoster()
	{
		ArrayList <Integer> result = new ArrayList <Integer>();
		
		for(int i = 0; i < this.ids.size(); i++)
		{
			result.add(this.ids.get(i));
		}
		return result;
	}

	public boolean enroll(int id)
	{
		if((this.ids.contains(id)) || (totalSeats <= ids.size()))
		{
			return false;
		}
		
		this.ids.add(id);
		
		Collections.sort(this.ids);
		
		return true;
	}
	
	public boolean remove(int id)
	{
		for(int i = this.ids.size() - 1; i >= 0; i--)
		{
			if(this.ids.get(i) == id)
			{
				this.ids.remove(i);
				return true;
			}
		}
		return false;
	}


	@Override
	public String toString() {
		return "Roster [ids=" + ids + ", totalSeats=" + totalSeats + "]";
	}

	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Roster))
			return false;
		
		Roster roster = (Roster) obj;
		
		if(this.totalSeats == roster.totalSeats && this.ids.size() == roster.ids.size())
		{
			for(int i = 0; i < this.ids.size(); i++)
			{
				if(this.ids.get(i) != roster.ids.get(i))
				{
					return false;
				}
			}
			return true;
		}
		
		return false;
	}



}
