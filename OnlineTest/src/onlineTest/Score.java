package onlineTest;

import java.io.Serializable;

public class Score implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int quesNum;
	private double points;
	private double studentPoints;
	
	public Score(int quesNum, double points, double studentPoints)
	{
		this.quesNum = quesNum;
		this.points = points;
		this.studentPoints = studentPoints;
	}

	public int getQuesNum() {
		return quesNum;
	}

	public double getPoints() {
		return points;
	}

	public double getStudentPoints() {
		return studentPoints;
	}
	
	
	
}
