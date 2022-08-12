package onlineTest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Exam implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int examId;
	private String title;
	
	private HashMap<Integer, Question> questions;
	//private SortedList<> questions;
	
	public Exam(int examId, String title)
	{
		this.examId = examId;
		this.title = title;
		this.questions = new HashMap<Integer, Question>();
	}
	
	public int getExamId()
	{
		return examId;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public HashMap<Integer, Question> getQuestions()
	{
		return questions;
	}
	
}
