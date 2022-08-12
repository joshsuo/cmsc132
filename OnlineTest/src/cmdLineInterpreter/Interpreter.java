package cmdLineInterpreter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import onlineTest.Manager;
import onlineTest.SystemManager;

/**
 * 
 * By running the main method of this class we will be able to
 * execute commands associated with the SystemManager.  This command
 * interpreter is text based. 
 *
 */
public class Interpreter {

	private static final String fileName = "File.info";
	
	public static void main(String[] args) throws Exception{


		SystemManager manager = initSystemManager();

		Scanner input = new Scanner(System.in);
		int choice = 0;

		String menu = "Enter 1: Add a student\n";
		menu += "Enter 2: Add an exam\n";
		menu += "Enter 3: Add a true/false question\n";
		menu += "Enter 4: Answer a true/false question\n";
		menu += "Enter 5: Get the exam score for a student\n";
		menu += "Enter 6 : Quit";
		
		double points = 0;
		boolean answer;
		String ques;
		int quesNum;
		
		do {
			
			System.out.println(menu);
			
			try
			{
				choice = input.nextInt(); 
			}
			catch(Exception e)
			{
				System.out.println("Try again with a number on the menu.");
				input.next();
				continue;
			}
			

			switch (choice) {
			case 1:
				String student = enterValue("Enter student name (last,first): ");
				
				manager.addStudent(student);
				break;
			case 2:
				int examId = Integer.parseInt(enterValue("Enter examId: "));
				String title = enterValue("Enter exam title: ");
				
				manager.addExam(examId, title);
				break;
			case 3:
				ques = enterValue("Enter a True/False Question: ");
				quesNum = Integer.parseInt(enterValue("Enter the question number: "));
				examId = Integer.parseInt(enterValue("Enter the examId for the question: "));
				points = Double.parseDouble(enterValue("Enter the points for the question: "));
				answer = Boolean.parseBoolean(enterValue("Enter the correct answer (True/False): "));
				
				manager.addTrueFalseQuestion(examId, quesNum, ques, points, answer);
				break;
			case 4:
				student = enterValue("Enter student who is answering the question (last,first): ");
				examId = Integer.parseInt(enterValue("Enter the examId for the question: "));
				quesNum = Integer.parseInt(enterValue("Enter the question number: "));
				answer = Boolean.parseBoolean(enterValue("Enter your answer (True/False): "));
				
				manager.answerTrueFalseQuestion(student, examId, quesNum, answer);
				break;
			case 5:
				student = enterValue("Enter student who wants exam score (last,first): ");
				examId = Integer.parseInt(enterValue("Enter the examId for the question: "));
				
				System.out.println(manager.getExamScore(student, examId));
				break;
			case 6:
				break;
			default:
				System.out.println("Invalid choice. Try Again");
			}
		} while (choice != 6);

		saveSystemManager(manager);
	}

	private static SystemManager initSystemManager() throws Exception {
		File file = new File(fileName);

		if (!file.exists()) {
			return new SystemManager();
		} else {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
			SystemManager manager = (SystemManager) input.readObject();
			input.close();
			
			return manager;
		}
	}

	private static void saveSystemManager(SystemManager manager) throws Exception {
		File file = new File(fileName);
		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));

		output.writeObject(manager);
		output.close();
	}
	
	private static String enterValue(String message)
	{
		String result = "";
		System.out.println(message);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try
		{
			result = reader.readLine();
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		
		return result;
	}
		
}
