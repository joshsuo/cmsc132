package sysImplementation;

import java.util.Comparator;

public class IDCompare implements Comparator<Student>{


	@Override
	public int compare(Student o1, Student o2) {
		
		if(o1.getId() == o2.getId())
		{
			return 0;
		}
		else if(o1.getId() > o2.getId())
		{
			return 1;
		}
		else
		{
			return -1;
		}

	}



	
	
	
}
