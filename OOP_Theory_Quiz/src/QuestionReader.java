import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class QuestionReader {
	/**
	 * This function reads the JSON file 
	 * @param fname The file name 
	 * @return returns the read files 
	 */
	public ArrayList<Question> readFromJSON(String fname) {
		try {
			ArrayList<Question> questions = new ArrayList<Question>();
			FileReader reader = new FileReader(new File(fname));
			JSONParser parser = new JSONParser();
			JSONObject all = (JSONObject)parser.parse(reader);
			JSONArray arr = (JSONArray)all.get("Questions");
			Iterator itr = arr.iterator();  // help me step through every entry
			JSONObject questionObject;
			String text, choice1, choice2, choice3, choice4, answer;
			while (itr.hasNext()) {
				questionObject = (JSONObject)itr.next();
				text = questionObject.get("question").toString();
				choice1 = questionObject.get("a").toString();
				choice2 = questionObject.get("b").toString();
				choice3 = questionObject.get("c").toString();
				choice4 = questionObject.get("d").toString();
				answer = questionObject.get("answer").toString();
				questions.add(new Question(text,choice1,choice2,choice3,choice4,answer));
			}
			reader.close();
			return questions;
		} catch (Exception ex) {
			return null;
		}
	}
}
