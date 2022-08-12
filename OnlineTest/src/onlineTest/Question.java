package onlineTest;

import java.io.Serializable;

public class Question implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private QuestionType type;
	private int quesNum;
	private String text;
	private double points;
	private boolean answer;
	private String[] answers;
	
	public Question(int quesNum, QuestionType type, String text, double points, boolean answer)
	{
		this.quesNum = quesNum;
		this.type = type;
		this.text = text;
		this.points = points;
		this.answer = answer;
	}
	
	public Question(int quesNum, QuestionType type, String text, double points, String[] answer)
	{
		this.quesNum = quesNum;
		this.type = type;
		this.text = text;
		this.points = points;
		this.answers = answer;
	}
	
	public String getText()
	{
		return this.text;
	}
	
	public double getPoints()
	{
		return this.points;
	}
	
	public boolean getAnswer()
	{
		return this.answer;
	}
	
	public String[] getAnswers()
	{
		return this.answers;
	}
	
	public QuestionType getQuestType()
	{
		return type;
	}
	
}
