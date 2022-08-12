package sysImplementation;



public class Utilities {
	

	public static int linearSearchLast(int[] array, int key)
	{
	   	int index = -1;
	   	
	   	if(array == null)
	   		return index;
	   	
	   	for(int i = 0; i < array.length; i++)
	   	{
	   		if(array[i] == key)
	   		{
	   			index = i;
	   		}
	   	}
		return index;
	}
	
}
