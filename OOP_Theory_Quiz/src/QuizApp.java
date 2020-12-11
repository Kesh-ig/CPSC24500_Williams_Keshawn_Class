import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * @author Keshawn
 *
 */

public class QuizApp { 
	/**
	 * This function does the initial menu of the program 
	 * @param sc the value of what the user wanst to do
	 * @return the choice of the user 
	 */
	public static int showMenu(Scanner sc) {
		
		System.out.println("Here are your choices: ");
		System.out.println("1. Take a Quiz. ");
		System.out.println("2. See questions and answers ");
		System.out.println("3. Exit ");
		System.out.println("Enter the number of your choice: ");
		int determine = sc.nextInt();
		sc.nextLine();
		return determine;
		
	}
	/**
	 * This is the main function that runs the program
	 * @param args the arguments within the main function
	 */
	public static void main(String[] args) {
		int decision;
		String file, response;
		Scanner sc = new Scanner(System.in);
		System.out.println("*     What could possibly be more fun than this  *");
		System.out.println("**************************************************");
		System.out.println("*         OOP Theory and Concept Questions       *");
		System.out.println("**************************************************");
		System.out.println("*   Nothing. Nothing at all. Nope. Nada. Nunca.  *");
		System.out.println();
		System.out.println("Enter the name of the file containing the questions: ");
		file = sc.nextLine();		
		QuestionReader qr = new QuestionReader();
		QuestionPrinter qp = new QuestionPrinter();
		ArrayList<Question> quest=null;
		try {
			file = sc.nextLine();
			quest= qr.readFromJSON(file);
		} catch (Exception ex) {
			System.out.println("It didnt work");
		}
		

		do {
			decision = showMenu(sc);
			if (decision==1) {
				System.out.println("How many questions would you like? ");
				response = sc.nextLine();
				
			}
			else if (decision ==2) {
				System.out.println("Here are the answers: ");
				qp.printQuestions(quest);
			}
		} while(decision != 3); {
			System.out.println("*******************************************");
			System.out.println("*   Thank you for teaching CPSC 24500     *");
			System.out.println("*******************************************");
		}

	}

}
