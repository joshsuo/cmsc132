package sysImplementation;



public class ListOfCoordinates {
	
	private int [][]list;
	private int size;
	private int capacity;
	
	
	
	
	public ListOfCoordinates()
	{
		this.list = new int[3][2];
		this.size = 0;
		this.capacity = 3;
	}
	
	public void add(int x, int y)
	{
		if(size < list.length)
		{
			list[size][0] = x;
			list[size][1] = y;
			size += 1;
		}
		else
		{
			int [][] newList = new int[size+1][2];
			
			for(int j = 0; j < list.length; j++)
			{
				for(int k = 0; k < 2; k++)
				{
					newList[j][k] = list[j][k];
				}
			}
			
			newList[size][0] = x;
			newList[size][1] = y;
			
			size += 1;
			if(size > capacity)
				capacity += 1;
			
			this.list = newList;
			
		}
		
	}
	
	
	public boolean remove(int index)
	{
		if(index >= size || index < 0|| size == 0)
		{
			return false;
		}
		else
		{
			int[][] newList = new int [size-1][2];
			
			
			for(int i = 0; i < index; i++)
			{
				newList[i][0] = list[i][0];
				newList[i][1] = list[i][1];
			}
			for(int i = index+1; i <= size-1; i++)
			{
				newList[i-1][0] = list[i][0];
				newList[i-1][1] = list[i][1];
			}
			
			size -= 1;
			this.list = newList;
			
			return true;
		}
	}
	

	
	@Override
	public String toString()
	{
		if (size==0)
			return "EMPTY LIST";
		
		else {
			String s = "";
			for(int i =0; i <size;i++)
			{
				s+="(" + list[i][0] + "," + list[i][1] + ")  ";
			}
			return s;
			
		}
		
	}

	public int getSize()
	{
		return this.size;
	}

	public int getCapacity()
	{
		return this.capacity;
	}
	
	public boolean changeY(int index, int newY)
	{
		if(index >= list.length || index < 0)
			return false;
		
		list[index][1] = newY;
		return true;
	}





	
	

}
