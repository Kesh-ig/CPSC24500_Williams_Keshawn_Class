import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class QuestionPrinter {
	/**
	 * This function was supposed to print out the array list of the questions and answers
	 * @param quest The array list of questions and answer
	 */
	public static void printQuestions(ArrayList<Question> quest) {
		for (Question question : quest) {
			question.getText();
		}
	}
}
