package onlineTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;



public class SystemManager implements Manager, Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HashMap<Integer, Exam> exams = new HashMap<Integer, Exam>();
	private HashMap<String, Student> students = new HashMap<String, Student>();
	private String[] letterGrades;
	private double[] cutoffs;
	
	@Override
	public boolean addExam(int examId, String title) {
		Exam exam = new Exam(examId, title);
		
		if(exams.containsKey(examId))
			return false;
		else
		{
			exams.put(examId, exam);
			return true;
		}
	}
	
	private boolean hasExam(int examId)
	{
		return exams.containsKey(examId);
	}
	
	private boolean hasQuesNum(int examId, int questionNumber)
	{
		return exams.get(examId).getQuestions().containsKey(questionNumber);
	}

	@Override
	public void addTrueFalseQuestion(int examId, int questionNumber, String text, double points, boolean answer) {
		
		Question ques = new Question(questionNumber, QuestionType.TrueFalse, text, points, answer);
		
		if(hasExam(examId))
		{
			Exam exam = exams.get(examId);
			if(hasQuesNum(examId, questionNumber) == false)
			{
				exam.getQuestions().put(questionNumber, ques);
			}
		}
	}

	@Override
	public void addMultipleChoiceQuestion(int examId, int questionNumber, String text, double points, String[] answer) {
		Question ques = new Question(questionNumber, QuestionType.MultipleChoice, text, points, answer);
		
		if(hasExam(examId))
		{
			Exam exam = exams.get(examId);
			if(hasQuesNum(examId, questionNumber) == false)
			{
				exam.getQuestions().put(questionNumber, ques);
			}
		}
		
	}

	@Override
	public void addFillInTheBlanksQuestion(int examId, int questionNumber, String text, double points,
			String[] answer) {
		Question ques = new Question(questionNumber, QuestionType.FillBlanks, text, points, answer);
		
		if(hasExam(examId))
		{
			Exam exam = exams.get(examId);
			if(hasQuesNum(examId, questionNumber) == false)
			{
				exam.getQuestions().put(questionNumber, ques);
			}
		}
		
	}

	@Override
	public String getKey(int examId) {
		
		if(!hasExam(examId))
			return "Exam not found";
		
		Exam exam = exams.get(examId);
		
		String result = "";
		HashMap<Integer, Question> array = exam.getQuestions();
		
		for(Question ques : array.values())
		{
			result += "Question Text: " + ques.getText() + "\n";
			result += "Points: " + ques.getPoints() + "\n";
			result += "Correct Answer: ";
			if(ques.getQuestType() == QuestionType.TrueFalse) {
				result += (ques.getAnswer() == true ? "True" : "False") + "\n";
			}
			else {
				Arrays.sort(ques.getAnswers());
				result += Arrays.toString(ques.getAnswers()) + "\n";
			}
				
		}
		
		
		for(String name : students.keySet())
		{
			result += "Exam score for " + name + getExamScore(name, examId) + "\n";
		}
		
		return result;
	}

	@Override
	public boolean addStudent(String name) {
		
		Student student = new Student(name);
		
		if(this.students.containsKey(name))
		{
			return false;
		}
		
		this.students.put(name, student);
		return true;
	}

	@Override
	public void answerTrueFalseQuestion(String studentName, int examId, int questionNumber, boolean answer) {
		
		if(students.containsKey(studentName))
		{
			Student student = this.students.get(studentName);
			student.addAnswer(new Answer(studentName, examId, questionNumber, answer));
		}
		
	}

	@Override
	public void answerMultipleChoiceQuestion(String studentName, int examId, int questionNumber, String[] answer) {
		
		if(students.containsKey(studentName))
		{
			Student student = this.students.get(studentName);
			student.addAnswer(new Answer(studentName, examId, questionNumber, answer));
		}
	}

	@Override
	public void answerFillInTheBlanksQuestion(String studentName, int examId, int questionNumber, String[] answer) {
		
		if(students.containsKey(studentName))
		{
			Student student = this.students.get(studentName);
			student.addAnswer(new Answer(studentName, examId, questionNumber, answer));
		}
	}

	private double checkAnswers(String[] correct, String[] studentAns, Question ques)
	{
		double points = 0;
		
		if (correct == studentAns) {
            return ques.getPoints();
        }
 
        if (correct == null || studentAns == null) {
            return 0;
        }
 
        int n = correct.length;
        if (n < studentAns.length) {
            return 0;
        }
        
        double partial = ques.getPoints() / correct.length;
        double increase = 0;
 
        for(int i = 0; i < studentAns.length; i++)
        {
        	increase = points;
        	for(int j = 0; j < correct.length; j++)
        	{
	            if (correct[j].equals(studentAns[i])) {
	                points += partial;
	            }
        	}
        	if((increase == points || correct.length > studentAns.length) 
        			&& ques.getQuestType() == QuestionType.MultipleChoice)
        		return 0;
        }
 
        return points;
	}
	
	@Override
	public double getExamScore(String studentName, int examId) {
		
		double points = 0;
		ArrayList<Score> scores = getScores(studentName, examId);
		
		for(Score score : scores)
		{
			points += score.getStudentPoints();
		}
		
		return points;
	}

	private ArrayList<Score> getScores(String studentName, int examId)
	{
		double points = 0;
		double totalPoints = 0;
		ArrayList<Score> result = new ArrayList<>();
		Student student = this.students.get(studentName);
		ArrayList<Answer> answers = new ArrayList<>();
		HashMap<Integer, Question> ques = exams.get(examId).getQuestions();
		
		for(Answer ans : student.getAnswers())
		{
			if(ans.getExamId() == examId)
			{
				answers.add(ans);
			}
		}
		
		for(Answer ans : answers)
		{
			points = 0;
			totalPoints = 0;
			if(ques.containsKey(ans.getQuestionNumber()))
			{
				Question question = ques.get(ans.getQuestionNumber());
				
				totalPoints = question.getPoints();
				if(QuestionType.TrueFalse == question.getQuestType())
				{	
					if(question.getAnswer() == ans.getAnswer())
					{
						points = question.getPoints();
					}
				}
				else
				{
					points = checkAnswers(question.getAnswers(), ans.getAnswers(), question);
				}
				result.add(new Score(ans.getQuestionNumber(), totalPoints, points));
			}
		}
		
		return result;
	}
	
	@Override
	public String getGradingReport(String studentName, int examId) {
		
		String result = "";
		ArrayList<Score> scores = getScores(studentName, examId);
		double points = 0;
		double total = 0;
		
		for(Score score : scores)
		{
			result += "Question #" + score.getQuesNum() + " " + score.getStudentPoints()
			+ " points out of " + score.getPoints() + "\n";
			points += score.getStudentPoints();
			total += score.getPoints();
		}
		
		result += "Final Score: " + points + " out of " + total;
		
		return result;
	}

	@Override
	public void setLetterGradesCutoffs(String[] letterGrades, double[] cutoffs) {
		
		this.letterGrades = letterGrades;
		this.cutoffs = cutoffs;
	}

	@Override
	public double getCourseNumericGrade(String studentName) {
		
		ArrayList<Score> scores;
		double testScore;
		double total;
		double numGrade = 0;
		
		for(int examId : exams.keySet())
		{
			testScore = 0;
			total = 0;
			
			scores = getScores(studentName, examId);
			
			for(Score score : scores)
			{
				testScore += score.getStudentPoints();
				total += score.getPoints();
			}
			numGrade += ((testScore/total) * 100);
		}
		
		return numGrade / exams.size();
	}

	@Override
	public String getCourseLetterGrade(String studentName) {
		
		double grade = getCourseNumericGrade(studentName);
		int pos = 0;
		
		for(int i = 0; i < cutoffs.length; i++)
		{
			if(cutoffs[i] <= grade)
			{
				pos = i;
				break;
			}
		}
		
		return letterGrades[pos];
	}

	@Override
	public String getCourseGrades() {
		
		String result = "";
		
		Set<String> names = students.keySet();
		ArrayList<String> array = new ArrayList<>(names);
		Collections.sort(array);
		
		for(String name : array)
		{
			result += name + " " + getCourseNumericGrade(name) + " " + getCourseLetterGrade(name) + "\n";
		}
		
		return result;
	}
	
	@Override
	public double getMaxScore(int examId) {
		
		double score = 0;
		for(String name : students.keySet())
		{
			if(score < getExamScore(name, examId))
				score = getExamScore(name, examId);
		}
		
		return score;
	}

	@Override
	public double getMinScore(int examId) {
		double score = 101;
		for(String name : students.keySet())
		{
			if(score > getExamScore(name, examId))
				score = getExamScore(name, examId);
		}
		
		return score;
	}

	@Override
	public double getAverageScore(int examId) {
		
		double score = 0;
		for(String name : students.keySet())
		{
			score += getExamScore(name, examId);
		}
		
		return score/students.size();
	}

	@Override
	public void saveManager(Manager manager, String fileName) {
		
		try
		{
			File file = new File(fileName);
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));
	
			output.writeObject((SystemManager)manager);
			output.close();
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		
	}

	@Override
	public Manager restoreManager(String fileName) {
		File file = new File(fileName);
		
		try
		{
			if (!file.exists()) {
				return new SystemManager();
			} else {
				ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
				Manager manager = (SystemManager) input.readObject();
				input.close();
				return manager;
			}
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		
		return new SystemManager();
	}

	

}
