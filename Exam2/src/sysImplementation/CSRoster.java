package sysImplementation;

import java.util.ArrayList;
import java.util.Collections;


public class CSRoster extends Roster {
	private String pLang;
	
	public CSRoster(ArrayList<Integer> ids, int totalSeats, String pLang) throws InvalidListException
	{
		super(ids, totalSeats);
		this.pLang = pLang;
	}
	
	public CSRoster(CSRoster csR) throws InvalidListException
	{
		super(csR);
		this.pLang = new String(csR.pLang);
	}

	@Override
	public String toString() {
		return super.toString() + " in "+pLang;
	}
	
	//overloaded version
	public String toString(boolean full)
	{
		if(full == true)
		{
			return this.toString();
		}
		else
		{
			String result = this.getRoster().toString();
		
			//ArrayList <Integer> ids = this.getRoster();
			
//			for(int i = 0; i < ids.size(); i++)
//			{
//				result += ids.get(i);
//			}
			return result;
		}
		
	}
	
	public static int[] getStudentsinCS(Roster [] rosters, boolean justCS)
	{
		ArrayList <Integer> result = new ArrayList<Integer>();
		
		for(int i=0; i<rosters.length; i++)
		{
			if(!(rosters[i] instanceof CSRoster))
				continue;
			
			ArrayList <Integer> ids = rosters[i].getRoster();
				
				
			
			for(int j=0; j<ids.size(); j++)
			{
				int id  = ids.get(j);
				if(justCS == false && !(result.contains(id)))
				{
					result.add(id);
				}
				else if(justCS == true)
				{
					if(id >= 200 && id <= 299 && !(result.contains(id)))
					{
						result.add(id);
					}
				}
			}
		}
		
		Collections.sort(result);
		
		int[] array = new int[result.size()];
		
		for(int i=0; i<result.size(); i++)
		{
			array[i] = result.get(i);
		}
		
		return array;
		
	}
	
	
	

}
