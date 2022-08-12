package onlineTest;

import java.io.Serializable;

public class Answer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String studentName;
	private int examId;
	private int questionNumber;
	private boolean answer;
	private String[] answers;
	
	public Answer(String studentName, int examId, int questionNumber, boolean answer)
	{
		this.studentName = studentName;
		this.examId = examId;
		this.questionNumber = questionNumber;
		this.answer = answer;
	}
	
	public Answer(String studentName, int examId, int questionNumber, String[] ans)
	{
		this.studentName = studentName;
		this.examId = examId;
		this.questionNumber = questionNumber;
		this.answers = ans;
	}
	
	public int getExamId()
	{
		return this.examId;
	}
	
	public int getQuestionNumber()
	{
		return this.questionNumber;
	}
	
	public boolean getAnswer()
	{
		return this.answer;
	}
	
	public String[] getAnswers()
	{
		return this.answers;
	}
	
}
