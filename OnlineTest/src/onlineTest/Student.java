package onlineTest;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private ArrayList<Answer> answers;
	
	public Student(String name)
	{
		this.name = name;
		this.answers = new ArrayList<Answer>();
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object student)
	{
		if(student == this)
			return true;
		
		if(!(student instanceof Student))
			return false;
		
		
		return this.name == ((Student) student).name;
	}
	
	public ArrayList<Answer> getAnswers()
	{
		return answers;
	}
	
	public void addAnswer(Answer answer)
	{
		answers.add(answer);
	}
	
	public void addAnswer(int examId, int quesNum, boolean answer)
	{
		answers.add(new Answer(name, examId, quesNum, answer));
	}
	
	public void addAnswer(int examId, int quesNum, String[] answer)
	{
		answers.add(new Answer(name, examId, quesNum, answer));
	}
	
	
}
