package sysImplementation;

import java.util.HashSet;
import java.util.PriorityQueue;

public class RegisterationSystem {
	
	
	private Student [] pool;

	public RegisterationSystem(Student[] s) {
		
		if(s == null)
			this.pool = null;
		else
			this.pool = s;
		
	}
	
	public void changePool(Student[] s) {
	
		if(s == null)
			this.pool = null;
		else
			this.pool = s;
		
	}

	
	public String registerById(){
		String result = "";
		PriorityQueue<Student> queue = new PriorityQueue<Student>(new IDCompare());
		
		HashSet<Student> newPool = new HashSet<>();
		for(int i = 0; i < this.pool.length; i++)
		{
			newPool.add(this.pool[i]);
		}
			
		
		if(this.pool == null || newPool.size() != this.pool.length)
		{
			return "Invalid Pool";
		}
		else
		{		
			
			for(int i = 0; i < this.pool.length; i++)
			{
				queue.offer(this.pool[i]);
			}
			
			while(!queue.isEmpty())
			{
				result += queue.poll().toString();
			}
		}
		return result;
	}
	
	public String registerByPriority(){
		
		PriorityQueue<Student> queue = new PriorityQueue<Student>();
		
		String result = "";
		HashSet<Student> newPool = new HashSet<>();
		for(int i = 0; i < this.pool.length; i++)
		{
			newPool.add(this.pool[i]);
		}
			
		
		if(this.pool == null || newPool.size() != this.pool.length)
		{
			return "Invalid Pool";
		}
		else
		{
			for(int i = 0; i < this.pool.length; i++)
			{
				queue.offer(this.pool[i]);
			}
			
			while(!queue.isEmpty())
			{
				result += queue.poll().toString();
			}
		}
		
		return result;
	}
	
	public String registerByCsId(){
		String result = "";
		PriorityQueue<Student> queue = new PriorityQueue<Student>(new CSIDCompare());
		
		HashSet<Student> newPool = new HashSet<>();
		for(int i = 0; i < this.pool.length; i++)
		{
			newPool.add(this.pool[i]);
		}
			
		
		if(this.pool == null || newPool.size() != this.pool.length)
		{
			return "Invalid Pool";
		}
		else
		{
			
			for(int i = 0; i < this.pool.length; i++)
			{
				//if(this.pool[i].getId() >= 200 && this.pool[i].getId() <= 299)
					queue.offer(this.pool[i]);
			}	
			
			
			
			while(!queue.isEmpty())
			{
				result += queue.poll().toString();
			}
			
		}
		return result;
	}
	
	
	

}
